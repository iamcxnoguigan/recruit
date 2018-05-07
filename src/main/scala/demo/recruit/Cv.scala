package demo.recruit

import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Props, Status}
import akka.persistence.{PersistentActor, RecoveryCompleted}

class Cv extends Actor with ActorLogging {
  override def receive: Receive = {
    case "confirm Cv" =>{
      context.actorSelection("/user/Tenant/Recruiter") ! "recruiter check Cv"
      log.info("Cv finish")
    }
  }
}
