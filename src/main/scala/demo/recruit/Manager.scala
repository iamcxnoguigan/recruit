package demo.recruit

import akka.actor.{Actor, ActorLogging}
import akka.persistence.PersistentActor
import akka.remote.ContainerFormats.ActorRef
import demo.recruit.Manager.RecruiterAcotrRef

/*class Manager extends PersistentActor {
  override def receiveRecover: Receive = ???

  override def receiveCommand: Receive = {
    case Postion.JD=>{
      println("ssss")
    }


  }

  override def persistenceId: String =s"Manager-${self.path.name}"
}*/

class Manager extends Actor with ActorLogging {
  override def receive: Receive = {
    case "new position seted"=>{
      log.info("send jd to recuriter")
      context.actorSelection("/user/Tenant/Recruiter") ! "find candidate"
    }
    case "Manager check Cv" =>{
      log.info("Manager check Cv")
      context.actorSelection("/user/Tenant/Client") ! "Cilent check Cv"
    }
    case "Client agree"=>{
      log.info("Client agree")
      context.actorSelection("/user/Tenant/Recruiter") ! "connect candidate"
    }
  }


}

object Manager{
  case class RecruiterAcotrRef (actorRef: ActorRef)
}
