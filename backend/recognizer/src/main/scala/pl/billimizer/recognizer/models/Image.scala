package pl.billimizer.recognizer.models

import org.opencv.core.Mat
import org.opencv.highgui.Highgui

object Image {

  def apply(path: String): Image = {
    val mat = Highgui.imread(path)
    Image(mat)
  }
}

case class Image(mat: Mat) {

  val width = mat.cols()
  val height = mat.rows()

  val pixels: Seq[Pixel] = {
    for {
      x <- 0 until width - 1
      y <- 0 until height - 1
    } yield Pixel(x, y, mat.get(x, y))
  }

  def pixel(x: Int, y: Int): Pixel = Pixel(x, y, mat.get(x, y))

}

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
}

case class Position(x: Int, y: Int)
