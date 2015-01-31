package pl.billimizer.recognizer.models

object Pixel {

  def apply(x: Int, y: Int, r: Short, g: Short, b: Short): Pixel = {
    Pixel(Position(x, y), Color(r, g, b))
  }

  def apply(x: Int, y: Int, color: Array[Double]): Pixel = {
    Pixel(Position(x, y), Color(color(2), color(1), color(0)))
  }
}

case class Pixel(position: Position, color: Color) {

  lazy val x = position.x

  lazy val y = position.y

  lazy val averageColor: Color = {
    Color(color.average, color.average, color.average)
  }
}

case class Position(x: Int, y: Int)
