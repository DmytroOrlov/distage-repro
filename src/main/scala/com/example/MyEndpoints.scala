package com.example

import cats.*
import izumi.functional.bio.{Applicative2, F}
import sttp.model.StatusCode
import sttp.tapir.*

trait MyEndpoints[F[_, _]] {
  def endp: F[⊥, Endpoint[Unit, String, (String, StatusCode), (String, StatusCode), Any]]
}

object MyEndpoints {

  final class Impl[F[+_, +_] : Applicative2] extends MyEndpoints[F] {
    val endp = F.pure(endpImpl)
  }

  val endpImpl: Endpoint[Unit, String, (String, StatusCode), (String, StatusCode), Any] = ???
}
