package com.example

import zio.*

trait MyPublisher {
  def publish(ofs: List[String]): Task[Unit]
}

object MyPublisher {
  val make =
    for {
      _ <- IO.unit
    } yield new MyPublisher {
      def publish(ofs: List[String]) = ???
    }
}
