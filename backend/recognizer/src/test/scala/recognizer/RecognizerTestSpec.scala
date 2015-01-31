package recognizer

import org.scalatest.{Matchers, WordSpecLike, WordSpec}
import pl.billimizer.common.Bill
import pl.billimizer.recognizer.TesseractRecognizer
import pl.billimizer.recognizer.models.Image

class RecognizerTestSpec extends WordSpecLike with Matchers {

  "Tesseract Recognizer" should {

    "find any bill" in {
      val found = new TesseractRecognizer().recognize(ExampleImages.`1`)
      found should be('defined)
    }
  }

}
