package com.github.kzmkae.sample.kamon.akka

import akka.actor.Actor

object Greeter {
  case object Greet
  case object Done
}

class Greeter extends Actor {
  def receive = {
    case Greeter.Greet =>
      println("Hello, World!")

      sender() ! Greeter.Done
  }
}