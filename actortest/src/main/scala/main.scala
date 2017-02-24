import akka.actor._
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._
import scala.concurrent.{Await, ExecutionContext, Future}

case class Msg(str:String) 

class Printer extends Actor {
	def receive = {
		case m:Msg =>
			println(m.str) 
	}
}

class Adder extends Actor {
	def receive = {
		case i:Int =>
			Thread.sleep(2000)
			sender ! (i+1)
	}
}

object AkkaActors {
	def main(args: Array[String]){

		val system = ActorSystem("SimpleSystem")
		
		// Hello World example
		val printer = system.actorOf(Props[Printer], name = "Printer")
		
		// use ! (bang) to send the message to the actor
		printer ! Msg("Hello world")
		
		val adder = system.actorOf(Props[Adder], name = "Adder")
		implicit val timeout = Timeout(5 seconds)
		val future = adder ? 1
		val result = Await.result(future, timeout.duration)
		println(result)
		system shutdown
	}
}