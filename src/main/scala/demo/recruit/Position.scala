package demo.recruit

import akka.actor.{Actor,ActorLogging, ActorRef}
import akka.persistence.PersistentActor
import akka.pattern.ask

/*class Postion extends PersistentActor {
  val PostionId : Int = self.path.name.toInt
  override def receiveRecover: Receive = ???

  override def receiveCommand: Receive = {
    case Client.NewJD=>{
      context.actorSelection("/user/Tenant/Manager") ! Postion.JD
      println("sdsd")

    }

  }

  override def persistenceId: String =s"Postion-${self.path.name}"
}*/
class Position extends Actor with ActorLogging {
  override def receive: Receive = {
    case lc : ActorRef=>{
      log.info("new position ")
      context.actorSelection("/user/Tenant/Manager") ! "new position seted"

    }
  }
}
object Position{
  case object JD
}