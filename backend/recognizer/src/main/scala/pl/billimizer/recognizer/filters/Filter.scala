package pl.billimizer.recognizer.filters

import pl.billimizer.recognizer.models.Image

trait Filter {

  /**
   * Applies filter on a given image.
   * @param input input image
   * @return output image
   */
  def run(input: Image): Image
}
