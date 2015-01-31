package pl.billimizer.recognizer.models

import org.opencv.core.Mat
import org.opencv.highgui.Highgui

object Image {

  def fromFile(path: String): Image = Image(path)

  def apply(path: String): Image = {
    val mat = Highgui.imread(path)
    Image(mat)
  }
}

case class Image(mat: Mat) {

  def copied = this.copy(mat = this.mat)

  val width = mat.cols()
  val height = mat.rows()

  val x = 0 until (height - 1)
  val y = 0 until (width - 1)

  def pixel(x: Int, y: Int): Pixel = Pixel(x, y, mat.get(x, y))

  def update(pixel: Pixel) = {
    mat.put(pixel.x, pixel.y, pixel.color.b, pixel.color.g, pixel.color.r)
  }

  def toFile(path: String): Image = {
    Highgui.imwrite(path, mat)
    this
  }
}
