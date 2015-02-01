package pl.billimizer.recognizer.filters

import pl.billimizer.recognizer.models.Image

class MedianFilter(value: Int) extends Filter {

  override def run(input: Image): Image = {
    val output = input.copied
    for {
      x <- input.x
      y <- input.y
    } {
      val neighbors = input.neighbors(x, y, value).sortBy(_.color.average)
      val pixel = neighbors(neighbors.size / 2)
      output.update(x, y, pixel.color)
    }
    output
  }
}
