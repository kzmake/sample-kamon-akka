package com.github.kzmkae.sample.kamon.akka

import akka.actor.{Actor, ActorRef, Props}

class HelloWorld extends Actor {
  val greeter: ActorRef = context.actorOf(Props[Greeter], "greeter")

  override def preStart(): Unit = {
    greeter ! Greeter.Greet
  }

  def receive = {
    case Greeter.Done => {
      Thread.sleep(1000)
      greeter ! Greeter.Greet
    }
  }
}