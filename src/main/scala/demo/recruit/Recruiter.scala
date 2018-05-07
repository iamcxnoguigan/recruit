package demo.recruit

import akka.actor.{Actor, ActorLogging, Props}
import akka.pattern.ask
import akka.persistence.PersistentActor

class Recruiter extends Actor with ActorLogging {
  override def receive: Receive = {
    case "find candidate" =>{
      val ChildCandidate = context.actorOf(Props[Candidate],name = "Candidate")
      ChildCandidate ! "make cv"
      log.info("find candidate")
    }
    case "recruiter check Cv" =>{
      context.actorSelection("/user/Tenant/Manager") ! "Manager check Cv"
      log.info("Recruiter check Cv")
    }
    case "connect candidate"=>{
      context.actorSelection("/user/Tenant/Recruiter/Candidate") ! "interview"
      val ChildInterview = context.actorOf(Props[Interview],name = "Interview")
      ChildInterview ! "interview"
    }
  }
}
