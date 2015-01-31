package controllers

import org.slf4j.LoggerFactory
import play.api.mvc._

object Application extends Controller {
  val logger = LoggerFactory.getLogger(getClass())

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def start = Action {
//    /opt/activator/activator -jvm-debug 9999 run
    // sudo apt-get install tesseract-ocr
    // sudo apt-get install tesseract-ocr-pol
    // export LC_NUMERIC="C"
    // http://tess4j.sourceforge.net/tutorial/
    // http://stackoverflow.com/questions/11464397/image-preprocessing-for-text-recognition

//    logger.info("Recognizing started")
//    val imageFile = new File("examples/8c.jpg")
//
////    val instance = Tesseract.getInstance(); // JNA Interface Mapping
//        val instance = new Tesseract1(); // JNA Direct Mapping
//
//    instance.setLanguage("pol")
//
//    try {
//      val result = instance.doOCR(imageFile)
      Ok("OK")
//    } catch {
//      case e: TesseractException =>
//        logger.error("Critical error occurred while processing: ", e)
//        Ok("Error occurred :( " + e.getMessage)
//    }
  }

  def transform = Action {
//    logger.error("Transforming image")
//
//    val in = new File("examples/8.jpg")
//    logger.error("1")
//    val out1 = new File("examples/out/30.jpg")
//    logger.error("2")
//    val out2 = new File("examples/out/50.jpg")
//    logger.error("3")
//    val out3 = new File("examples/out/90.jpg")
//    logger.error("4")
//    val out4 = new File("examples/out/127.jpg")
//    val out5 = new File("examples/out/150.jpg")
//    val out6 = new File("examples/out/180.jpg")
//    val out7 = new File("examples/out/210.jpg")
//    Image(in).filter(ThresholdFilter(30)).write(out1, Format.JPEG)
//    Image(in).filter(ThresholdFilter(50)).write(out2, Format.JPEG)
//    Image(in).filter(ThresholdFilter(90)).write(out3, Format.JPEG)
//    Image(in).filter(ThresholdFilter(127)).write(out4, Format.JPEG)
//    Image(in).filter(ThresholdFilter(150)).write(out5, Format.JPEG)
//    Image(in).filter(ThresholdFilter(180)).write(out6, Format.JPEG)
//    Image(in).filter(ThresholdFilter(210)).write(out7, Format.JPEG)

    Ok("Done")
  }

//  def transform = Action {

//    logger.info("Transforming image")
//    val imageFile = new File("examples/1.jpg")
//    val outputFile = new File("examples/1_b.jpg")

//    val image: IplImage = cvLoadImage(imageFile.getAbsolutePath)
//    if (image != null) {
//      val imageBW = cvCreateImage(cvGetSize(image), IPL_DEPTH_8U, 1)
//      cvCvtColor(image, imageBW, CV_BGR2GRAY)
//      cvSmooth(image, image)
//      cvTranspose(image, image)
//      cvFlip(image, image, 1)
//      cvEqualizeHist(imageBW, imageBW)
//      cvFindContours(imageBw, )
      //      cvSaveImage(outputFile.getAbsolutePath, image)
//      cvEqualizeHist(image, image)
//      cvSaveImage(outputFile.getAbsolutePath, imageBW)
//      cvReleaseImage(image)
//    }

//    Ok("Done")
//  }

//  def makeBw(input: IplImage): IplImage = {
//
//  }

}
