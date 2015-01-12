package core

import akka.actor.Actor

object RecognizerActor {

  case class Recognize(image: String)

}

class RecognizerActor extends Actor{
  import RecognizerActor._

  def receive: Receive = {
    case Recognize(image) =>
  }

}
