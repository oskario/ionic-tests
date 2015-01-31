package pl.billimizer.recognizer

import pl.billimizer.recognizer.models.Image

import pl.billimizer.common.Bill

trait Recognizer {

  /**
   * Finds a bill on a given image.
   * @param img image to look at
   * @return bill found
   */
  def recognize(img: Image): Option[Bill]
}
