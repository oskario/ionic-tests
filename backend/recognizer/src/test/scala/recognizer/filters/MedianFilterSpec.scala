package recognizer.filters

import org.scalatest.{Matchers, WordSpecLike}
import pl.billimizer.recognizer.filters.{MedianFilter, GreyscaleFilter}
import recognizer.WithTime.withTime
import recognizer.{ExampleImages, OpenCvLibrary}

class MedianFilterSpec extends WordSpecLike with Matchers with OpenCvLibrary {

  val maxTime = 1000L

  "Median filter" should {

    s"perform the whole operation under $maxTime milliseconds" in {
      withTime {
        val filtered = new MedianFilter(1).run(ExampleImages.`4`.mid)
        filtered.toFile("out3.jpg")
      } should be < maxTime
    }
  }
}
