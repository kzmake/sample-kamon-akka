package com.github.kzmkae.sample.kamon.akka

import kamon.Kamon

object Main {

  def main(args: Array[String]): Unit = {
    Kamon.start()
    akka.Main.main(Array(classOf[HelloWorld].getName))
  }
}