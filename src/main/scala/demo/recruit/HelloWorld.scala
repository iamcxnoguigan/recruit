package demo.recruit

import akka.Done
import akka.actor.{AbstractActor, Actor, ActorRef,Props}
import akka.cluster.Cluster
import akka.cluster.ddata.Replicator.{Update, UpdateResponse, WriteLocal}
import akka.cluster.ddata.{DistributedData, LWWMap, LWWMapKey}
import akka.cluster.sharding.ShardRegion
import akka.event.Logging
import akka.persistence.{PersistentActor, RecoveryCompleted}
import com.typesafe.config.ConfigFactory


class HelloWorld extends Actor {

  override def preStart(): Unit = {
    // create the greeter actor
    val greeter = context.actorOf(Props[Greeter], "greeter")
    // tell it to perform the greeting
    greeter ! Greeter.Greet
  }

  def receive = {
    // when the greeter is done, stop this actor and with it the application
    case Greeter.Done => context.stop(self)
  }
}
