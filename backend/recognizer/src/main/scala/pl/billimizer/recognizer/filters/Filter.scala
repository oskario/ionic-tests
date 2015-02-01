package pl.billimizer.recognizer.filters

import pl.billimizer.recognizer.models.Image

object Filter {

  def run(input: Image, filters: Seq[Filter]) = {
    filters.foldLeft(input) { case (image, filter) =>
      filter.run(image)
    }
  }
}

trait Filter {

  /**
   * Applies filter on a given image.
   * @param input input image
   * @return output image
   */
  def run(input: Image): Image
}
