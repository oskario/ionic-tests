package pl.billimizer.recognizer.filters

import pl.billimizer.recognizer.models.Image

class GreyscaleFilter() extends Filter {

  override def run(input: Image): Image = {
    val output = input.copied
    for {
      x <- input.x
      y <- input.y
    } {
      val pixel = input.pixel(x, y)
      output.update(pixel.copy(color = pixel.averageColor))
    }
    output
  }
}
