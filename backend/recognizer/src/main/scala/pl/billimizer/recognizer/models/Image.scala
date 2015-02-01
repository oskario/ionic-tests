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

  def pixelOpt(x: Int, y: Int): Option[Pixel] = {
    if (x < height && x >= 0 && y < width && y >= 0) Some(pixel(x, y))
    else None
  }

  def update(pixel: Pixel) = {
    mat.put(pixel.x, pixel.y, pixel.color.b, pixel.color.g, pixel.color.r)
  }

  def update(x: Int, y: Int, color: Color) = {
    mat.put(x, y, color.b, color.g, color.r)
  }

  def neighbors(x: Int, y: Int, r: Int): Seq[Pixel] = {
    val result = for {
      a <- (x-r) to (x+r)
      b <- (y-r) to (y+r)
    } yield pixelOpt(a, b)
    result.flatten
  }

  def histogram: Map[Short, Int] = {
    val colors = for {
      a <- x
      b <- y
    } yield (pixel(a, b).color.average, 1)
    val start = (0 to 255).map(_.toShort -> 0).toMap
    colors.foldLeft(start) { case (map, entry) =>
      map.updated(entry._1, map(entry._1) + 1)
    }
  }

  def toFile(path: String): Image = {
    Highgui.imwrite(path, mat)
    this
  }
}
