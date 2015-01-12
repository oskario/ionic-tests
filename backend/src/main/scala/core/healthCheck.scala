package core

import akka.actor.Actor

object HealthCheckActor {

  case object Ping
  case object Pong

}

class HealthCheckActor extends Actor{
  import HealthCheckActor._

  def receive: Receive = {
    case Ping => sender ! Pong
  }

}
