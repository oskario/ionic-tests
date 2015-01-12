package api

import akka.actor.ActorRef
import akka.util.Timeout
import spray.routing.Directives

import scala.concurrent.ExecutionContext

class HealthCheckService(healthCheckActor: ActorRef)(implicit executionContext: ExecutionContext)
  extends Directives with DefaultJsonFormats {

  import akka.pattern.ask
  import scala.concurrent.duration._
  import core.HealthCheckActor._

  implicit val timeout = Timeout(2.seconds)

   val route =
     path("health") {
       get {
         complete {
           (healthCheckActor ? Ping).map {
             case Pong => "{\"status\":\"OK\"}"
             case _ => "{\"status\":\"Not OK\"}"
           }
         }
       }
     }

}