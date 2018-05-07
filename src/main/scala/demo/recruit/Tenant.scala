package demo.recruit
import akka.Done
import akka.actor.{AbstractActor, Actor, ActorLogging, ActorRef, Props}
import akka.cluster.Cluster
import akka.cluster.ddata.Replicator.{Update, UpdateResponse, WriteLocal}
import akka.cluster.ddata.{DistributedData, LWWMap, LWWMapKey}
import akka.cluster.sharding.ShardRegion
import akka.event.Logging
import akka.persistence.{PersistentActor, RecoveryCompleted}
import com.typesafe.config.ConfigFactory

class Tenant extends Actor{
  override def receive: Receive = {
    case _ =>
  }


  override def preStart(): Unit = {
   val ChildClient = context.actorOf(Props[Client],name = "Client")
    val ChildRecruiter = context.actorOf(Props[Recruiter],name = "Recruiter")
    val ChildManager = context.actorOf(Props[Manager],name = "Manager")
    ChildClient ! ChildManager
    /*ChildManager ! ChildRecruiter
    ChildRecruiter ! Tenant.RecuiterHello*/
  }
}

object Tenant{
  case object ClientHello
  case object RecuiterHello
  case object ManagerHello
}
