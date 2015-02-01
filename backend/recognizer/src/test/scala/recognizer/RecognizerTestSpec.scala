package recognizer

import org.scalatest.{Matchers, WordSpecLike, WordSpec}
import pl.billimizer.common.Bill
import pl.billimizer.recognizer.{DefaultConfig, TesseractRecognizer}
import pl.billimizer.recognizer.models.Image

class RecognizerTestSpec extends WordSpecLike with Matchers {

  "Tesseract Recognizer" should {

    "find any bill" in {
      val found = new TesseractRecognizer(DefaultConfig).recognize(ExampleImages.`4`.mid)
      found should be('defined)
    }
  }

}
