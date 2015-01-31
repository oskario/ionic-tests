package recognizer.filters

import org.scalatest.{Matchers, WordSpecLike}
import pl.billimizer.recognizer.filters.GreyscaleFilter
import recognizer.{OpenCvLibrary, ExampleImages}
import recognizer.WithTime.withTime

class GreyscaleFilterSpec extends WordSpecLike with Matchers with OpenCvLibrary {

  val maxTime = 1000L

  "Greyscale filter" should {

    s"perform the whole operation under $maxTime milliseconds" in {
      withTime {
        val filtered = new GreyscaleFilter().run(ExampleImages.`4`.mid)
      } should be < maxTime
    }

    "make all pixels grayscale" in {
      ExampleImages.`4`.mid.toFile("out2.jpg")
      val filtered = new GreyscaleFilter().run(ExampleImages.`1`)
      for {
        x <- filtered.x
        y <- filtered.y
        pixel = filtered.pixel(x, y)
      } {
        pixel.color.r shouldEqual pixel.color.g
        pixel.color.g shouldEqual pixel.color.b
      }
      filtered.toFile("output.jpg")
    }
  }
}
