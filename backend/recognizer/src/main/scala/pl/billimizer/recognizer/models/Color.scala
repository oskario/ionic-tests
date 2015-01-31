package pl.billimizer.recognizer.models

object Color {
  val Black = Color(0, 0, 0)
  val White = Color(255, 255, 255)
  val Red = Color(255, 0, 0)
  val Green = Color(0, 255, 0)
  val Blue = Color(0, 0, 255)

  def apply(r: Double, g: Double, b: Double): Color = {
    Color(r.toShort, g.toShort, b.toShort)
  }
}

case class Color(r: Short, g: Short, b: Short) {

  lazy val average: Short = ((r + g + b) / 3).toShort

  def toArray = Array[Short](b, g, r)
}
