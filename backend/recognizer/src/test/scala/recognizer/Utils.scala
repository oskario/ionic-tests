package recognizer

import org.joda.time.DateTime
import org.opencv.core.Core

object WithTime {

  def withTime[T](f: => T): Long = {
    val startTime = DateTime.now.getMillis
    f
    val endTime = DateTime.now.getMillis
    endTime - startTime
  }
}

trait OpenCvLibrary {
  System.loadLibrary(Core.NATIVE_LIBRARY_NAME)
}