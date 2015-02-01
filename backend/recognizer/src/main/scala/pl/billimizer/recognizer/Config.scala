package pl.billimizer.recognizer

import com.typesafe.config.ConfigFactory


object DefaultConfig extends Config {
  private val config = ConfigFactory.load()

  override val medianValue: Int = config.getInt("filters.median.value")
  override val thresholdValue: Double = config.getDouble("filters.threshold.value")
  override val tempfile: String = config.getString("tempfile")
}

trait Config {
  val medianValue: Int
  val thresholdValue: Double
  val tempfile: String

  override def toString: String = {
    s"medianValue: $medianValue, thresholdValue: $thresholdValue, tempfile: $tempfile"
  }
}
