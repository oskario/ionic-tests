package pl.billimizer.recognizer

import org.opencv.core.Core
import org.slf4j.LoggerFactory
import pl.billimizer.common.Bill
import pl.billimizer.recognizer.models.Image

class TesseractRecognizer extends Recognizer {
  val logger = LoggerFactory.getLogger(classOf[TesseractRecognizer])

  logger.debug(s"Loading native library: ${Core.NATIVE_LIBRARY_NAME}")
  System.loadLibrary(Core.NATIVE_LIBRARY_NAME)

  // TODO: Implement this method
  override def recognize(img: Image): Option[Bill] = Some(Bill(1.0, List()))
}
