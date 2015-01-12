package core

import java.io.File
import java.nio.file.Files

import akka.actor.Actor

object RecognizerActor {
  import RecognizerActor.ImageTypes.ImageType

  case class Recognize(imageType: ImageType, imageData: String)
  case class Recognized(text: String)

  object ImageTypes {
    case object PNG extends ImageType(".png")
    case object JPEG extends ImageType(".jpg")
    sealed case class ImageType(extension: String)
  }
}


class RecognizerActor extends Actor{
  import RecognizerActor._
  import RecognizerActor.ImageTypes.ImageType


  def receive: Receive = {
    case Recognize(imageType, imageData) =>
      recognize(imageType, imageData)
  }

  def recognize(imageType: ImageType, imageData: String): Recognized = {
    val imageFile = dropToDisk("imageRecognizer", imageType.extension, imageData)
    Recognized("OK")
  }

  def dropToDisk(prefix: String, suffix: String, data: String): File = {
    val file = File.createTempFile(prefix, suffix)
    file
  }

}
