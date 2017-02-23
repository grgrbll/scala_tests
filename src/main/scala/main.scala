import akka.actor._

case class Msg(str:String) 

class Printer extends Actor {
	def receive = {
		case m:Msg =>
			println(m.str) 
	}
}

object AkkaActors {
	def main(args: Array[String]){

		val system = ActorSystem("SimpleSystem")
		val printer = system.actorOf(Props[Printer], name = "Printer")
		
		// use ! (bang) to send the message to the actor
		printer ! Msg("Hello world")
	}
}