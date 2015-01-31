package recognizer

import pl.billimizer.recognizer.models.Image

object ExampleImages {

  private def getImagePath(image: String): String = {
    getClass.getResource(s"/images/$image").toURI.getPath
  }

  val `1` = Image(getImagePath("4.mid.jpg"))

  object `4` {
    val mid = Image(getImagePath("4.mid.jpg"))
  }
}
