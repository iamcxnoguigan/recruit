package demo.recruit

import akka.actor.{Actor, ActorLogging, Props}
import akka.pattern.ask
import akka.persistence.PersistentActor

class Interview extends Actor with ActorLogging {
  override def receive: Receive = {
    case "interview" => {
      log.info("when where how")
    }
  }
}
