package com.example

import distage.config.ConfigModuleDef
import distage.plugins.PluginDef
import distage.{Producer as _, *}
import io.opentracing.Tracer
import izumi.distage.roles.model.definition.RoleModuleDef
import sttp.capabilities.WebSockets
import sttp.capabilities.zio.ZioStreams
import sttp.client3.SttpBackend
import sttp.client3.SttpBackendOptions.connectionTimeout
import sttp.client3.asynchttpclient.zio.AsyncHttpClientZioBackend
import zio.telemetry.opentracing.OpenTracing
import zio.{Has, IO, Task}

import scala.concurrent.duration.{FiniteDuration, SECONDS}

object MyPlugin extends PluginDef with RoleModuleDef with ConfigModuleDef {
  include(api[IO])

  def api[F[+_, +_] : TagKK]: ModuleDef = new ModuleDef {
    make[MyEndpoints[F]].from[MyEndpoints.Impl[F]]
  }

  make[OpenTracing.Service].fromHas(OpenTracing.live(_: Tracer))
  make[MyPublisher].fromHas(MyPublisher.make)
  make[SttpBackend[Task, ZioStreams with WebSockets]].fromResource(
    AsyncHttpClientZioBackend.managed(connectionTimeout(FiniteDuration(5, SECONDS))),
  )
  make[MyClient].fromHas[OpenTracing with Has[MyPublisher] with Has[SttpBackend[Task, ZioStreams with WebSockets]] with Has[MyEndpoints[IO]], Nothing, MyClient](MyClient.make)
}
