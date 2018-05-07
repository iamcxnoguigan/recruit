package demo.recruit

import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Props, Status}
import akka.persistence.{PersistentActor, RecoveryCompleted}

class Candidate extends Actor with ActorLogging{
  override def receive: Receive = {
    case "make cv" =>{
      log.info("make cv")
      val ChildCv = context.actorOf(Props[Cv],name = "Cv")
      ChildCv ! "confirm Cv"
    }
  }
}
