package api

import akka.actor.ActorRef
import akka.util.Timeout
import spray.routing.Directives
import spray.routing.directives.DetachMagnet

import scala.concurrent.ExecutionContext

class RecognizerService(recognizerActor: ActorRef)(implicit executionContext: ExecutionContext)
  extends Directives with DefaultJsonFormats {

  import akka.pattern.ask
  import scala.concurrent.duration._

  implicit val timeout = Timeout(2.seconds)

  case class RecognizeImageRequest(image: String)

  implicit val recognizeImageRequestFormat = jsonFormat1(RecognizeImageRequest)

   val route =
     path("recognize" / "image") {
       post {
         entity(as[RecognizeImageRequest]) { request =>
            detach(executionContext) {
              complete {
                "OK" + request.image
              }
            }
         }
       }
     }

}