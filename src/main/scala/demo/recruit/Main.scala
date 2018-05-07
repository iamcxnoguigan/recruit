package demo.recruit


import akka.actor.ActorSystem
import akka.actor.Props

object Main extends App {
  val system = ActorSystem("Recruit")
  system.actorOf(Props[Tenant],name = "Tenant")



}