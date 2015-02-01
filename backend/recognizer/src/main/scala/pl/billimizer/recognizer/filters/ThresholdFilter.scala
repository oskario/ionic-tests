package pl.billimizer.recognizer.filters

import org.slf4j.LoggerFactory
import pl.billimizer.recognizer.models.{Color, Image}

class ThresholdFilter(value: Double) extends Filter {
  val logger = LoggerFactory.getLogger(classOf[ThresholdFilter])

  def findMinMax(histogram: Map[Short, Int]) = {
    histogram.foldLeft((histogram.size, 0)) { case ((min, max), (color, count)) =>
      val newMin = if (count != 0) Math.min(min, color) else min
      val newMax = if (count != 0) Math.max(max, color) else max
      (newMin, newMax)
    }
  }

  def targetValue(input: Image): Short = {
    val histogram = input.histogram
    val (min, max) = findMinMax(histogram)
    (min + ((max - min) * value)).toShort
  }

  override def run(input: Image): Image = {
    val output = input.copied
    
    val target = targetValue(input)
    logger.debug(s"Threshold value set to: $target")
    
    for {
      x <- input.x
      y <- input.y
      pixel = input.pixel(x, y)
    } {
      if (pixel.color.average > target)
        output.update(pixel.copy(color = Color.White))
      else
        output.update(pixel.copy(color = Color.Black))
    }
    output
  }
}
