package pl.billimizer.recognizer

import java.io.File

import net.sourceforge.tess4j.{Tesseract, TesseractException, Tesseract1}
import org.opencv.core.Core
import org.slf4j.LoggerFactory
import pl.billimizer.common.Bill
import pl.billimizer.recognizer.filters.{ThresholdFilter, MedianFilter, Filter, GreyscaleFilter}
import pl.billimizer.recognizer.models.Image

class TesseractRecognizer(config: Config) extends Recognizer {
  val logger = LoggerFactory.getLogger(classOf[TesseractRecognizer])

  logger.debug(s"Loading native library: ${Core.NATIVE_LIBRARY_NAME}")
  System.loadLibrary(Core.NATIVE_LIBRARY_NAME)

  logger.debug(s"Using configuration: $config")

  logger.debug(s"Initializing Tesseract")
  val instance = new Tesseract1()
//  val instance = Tesseract.getInstance()
  instance.setLanguage("pol")

  val filters = Seq(
    new GreyscaleFilter(),
    //    new MedianFilter(config.medianValue),
    new ThresholdFilter(config.thresholdValue)
  )

  override def recognize(input: Image): Option[Bill] = {
    logger.debug("Recognizing started")

    val image = Filter.run(input, filters)
    image.toFile(config.tempfile)

    ocr(config.tempfile).flatMap(parse)
  }

  def ocr(filename: String): Option[String] = {
    try {
      Some(instance.doOCR(new File(filename)))
    } catch {
      case e: TesseractException =>
        logger.error("Critical error occurred while doing OCR: ", e)
        None
    }
  }

  def parse(value: String): Option[Bill] = {
    logger.debug(s"Parsing: recognized string")
//    logger.debug(s"Parsing: ${value.take(10)}...")

    val totals = value.split("\n").flatMap(findTotal)

    if (totals.size > 1) logger.warn(s"Found more than one total value: $totals")

    totals.headOption.map(Bill(_))
  }
  
  def findTotal(line: String): Option[BigDecimal] = {
    val prepared = line.toLowerCase.replace(" ", "")
    if (prepared.indexOf("suma") != -1) {
      val number = prepared.filter(c => c.isDigit || c == '.' || c == ',').replace(",", ".")
      Some(BigDecimal(number))
    } else {
      None
    }
  }
}
