package com.example

import logstage.LogZIO
import sttp.capabilities.WebSockets
import sttp.capabilities.zio.ZioStreams
import sttp.client3.*
import zio.*
import zio.telemetry.opentracing.*

trait MyClient {
  def req(req: String): ZIO[LogZIO, Throwable, Int]
}

object MyClient {
  def make: URIO[
    OpenTracing with Has[MyPublisher] with Has[SttpBackend[Task, ZioStreams with WebSockets]] with Has[MyEndpoints[IO]],
    MyClient,
  ] = ???
}
