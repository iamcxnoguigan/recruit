package demo.recruit

import akka.actor.{Actor, ActorLogging, ActorRef, Props}
import akka.persistence.PersistentActor

/*class Client extends PersistentActor with ActorLogging{
  //val ClientId : Int = self.path.name.toInt

  override def receiveRecover: Receive = ??? //如何使用快照暂时没懂

  override def receiveCommand: Receive = {
    case Tenant.ClientHello => {
      /*val ChildJD = context.actorOf(Props[Postion])
          ChildJD ! Client.NewJD
          log.info("Cilent creat a new job discription ")*/

    }
  }

  override def persistenceId: String = ??? //s"Client-${self.path.name}"
}*/
class Client extends Actor with  ActorLogging {
  override def receive: Receive = {
    case ll:ActorRef =>{
      val ChildJD = context.actorOf(Props[Position])
          ChildJD ! ll
      log.info("Client send a new position")
    }
    case "new postion seted" =>{
      log.info("new postion seted")

    }
    case "Cilent check Cv" =>{
      log.info("Client check Cv")
      context.actorSelection("/user/Tenant/Manager") ! "Client agree"

    }

  }
}
 object Client{

   case object NewJD
 }

