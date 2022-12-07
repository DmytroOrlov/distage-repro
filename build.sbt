fork := true

ThisBuild / scalaVersion := "3.2.1"
// ThisBuild / scalaVersion := "2.13.10"
ThisBuild / scalacOptions ++= Seq(
  // "-Xsource:3",
  // "-P:kind-projector:underscore-placeholders",
  "-Yretain-trees",
  "-language:3.2",
  "-Ykind-projector:underscores",
  "-no-indent",
)
ThisBuild / libraryDependencySchemes += "io.circe" %% "circe-core" % VersionScheme.Always

val V = new {
  val catsEffect = "3.4.1"
  val zio = "1.0.14"
  val zioInteropCats = "3.2.9.1"
  val zioInteropReactivestreams = "1.3.12"
  val zioKafka = "0.17.7"
  val distage = "1.1.0-SNAPSHOT"
  val tapir = "1.2.3"
  val sttp = "3.8.3"
  val http4s = "0.23.12"
  val http4sServer = "0.23.16"
  val circe = "0.14.3"
  val avro = "1.11.1"
  val kafkaSchemaSerde = "7.2.2"

  val dataDog = "1.1.1"
  val zioOpentracing = "1.0.0"
  val jaeger = "1.8.1"
  val zipkin = "2.16.3"

  val scalacheck = "1.17.0"

  val betterMonadicFor = "0.3.1"
  val kindProjector = "0.13.2"
}

val Deps = new {
  val catsEffect = "org.typelevel" %% "cats-effect" % V.catsEffect
  val zioInteropCats = "dev.zio" %% "zio-interop-cats" % V.zioInteropCats
  val zioInteropReactivestreams = "dev.zio" %% "zio-interop-reactivestreams" % V.zioInteropReactivestreams
  val zio = "dev.zio" %% "zio" % V.zio
  val zioStreams = "dev.zio" %% "zio-streams" % V.zio
  val zioKafka = "dev.zio" %% "zio-kafka" % V.zioKafka
  val distageFramework = "io.7mind.izumi" %% "distage-framework" % V.distage
  val distageFrameworkDocker = "io.7mind.izumi" %% "distage-framework-docker" % V.distage
  val distageTestkitScalatest = "io.7mind.izumi" %% "distage-testkit-scalatest" % V.distage
  val logstageAdapterSlf4J = "io.7mind.izumi" %% "logstage-adapter-slf4j" % V.distage
  val apacheAvro = "org.apache.avro" % "avro" % V.avro
  val kafkaSchemaSerializer = "io.confluent" % "kafka-schema-serializer" % V.kafkaSchemaSerde
  val kafkaAvroSerde = "io.confluent" % "kafka-streams-avro-serde" % V.kafkaSchemaSerde

  val tapirJsonCirce = "com.softwaremill.sttp.tapir" %% "tapir-json-circe" % V.tapir
  val tapirHttp4sServer = "com.softwaremill.sttp.tapir" %% "tapir-http4s-server" % V.tapir
  val tapirOpenapiDocs = "com.softwaremill.sttp.tapir" %% "tapir-openapi-docs" % V.tapir
  val tapirSwaggerUiHttp4s = "com.softwaremill.sttp.tapir" %% "tapir-swagger-ui-bundle" % V.tapir
  val tapirSttpClient = "com.softwaremill.sttp.tapir" %% "tapir-sttp-client" % V.tapir
  val sttpClientCirce = "com.softwaremill.sttp.client3" %% "circe" % V.sttp
  val circeGeneric = "io.circe" %% "circe-generic" % V.circe
  val circeLiteral = "io.circe" %% "circe-literal" % V.circe

  val asyncHttpClientBackendZio =
    "com.softwaremill.sttp.client3" %% "async-http-client-backend-zio1" % V.sttp excludeAll ExclusionRule(organization =
      "dev.zio",
    )

  val http4sBlazeServer = "org.http4s" %% "http4s-blaze-server" % V.http4s
  val http4sDsl = "org.http4s" %% "http4s-dsl" % V.http4sServer
  val http4sServer = "org.http4s" %% "http4s-server" % V.http4sServer

  val zioOpentracing = "dev.zio" %% "zio-opentracing" % V.zioOpentracing
  val ddTraceApi = "com.datadoghq" % "dd-trace-api" % V.dataDog
  val jaegerZipkin = "io.jaegertracing" % "jaeger-zipkin" % V.jaeger
  val zipkinReporter = "io.zipkin.reporter2" % "zipkin-reporter" % V.zipkin
  val zipkinSenderOkhttp3 = "io.zipkin.reporter2" % "zipkin-sender-okhttp3" % V.zipkin

  val scalacheck = "org.scalacheck" %% "scalacheck" % V.scalacheck
  val scalatestScalacheck = "org.scalatestplus" %% "scalacheck-1-16" % "3.2.14.0"

  val betterMonadicFor = "com.olegpy" %% "better-monadic-for" % V.betterMonadicFor
  val kindProjector = "org.typelevel" %% "kind-projector" % V.kindProjector cross CrossVersion.full
}

val undeclaredCompileDependencies = Seq(
  "com.chuusai" %% "shapeless" % "2.3.10",
  "com.github.pureconfig" %% "pureconfig-core" % "0.17.1",
  "com.github.pureconfig" %% "pureconfig-generic-base" % "0.17.1",
  "com.github.pureconfig" %% "pureconfig-magnolia" % "0.17.1",
  "com.propensive" %% "magnolia" % "0.17.0",
  "com.softwaremill.magnolia1_2" %% "magnolia" % "1.1.2",
  "com.softwaremill.sttp.apispec" %% "openapi-model" % "0.3.1",
  "com.softwaremill.sttp.client3" %% "core" % "3.8.3",
  "com.softwaremill.sttp.model" %% "core" % "1.5.3",
  "com.softwaremill.sttp.shared" %% "core" % "1.3.12",
  "com.softwaremill.sttp.shared" %% "fs2" % "1.3.12",
  "com.softwaremill.sttp.shared" %% "zio1" % "1.3.12" excludeAll ExclusionRule(organization = "dev.zio"),
  "com.softwaremill.sttp.tapir" %% "tapir-core" % "1.2.3",
  "com.softwaremill.sttp.tapir" %% "tapir-swagger-ui" % "1.2.3",
  "dev.zio" %% "izumi-reflect" % "2.2.2",
  "io.7mind.izumi" %% "distage-core" % "1.1.0-M10",
  "io.7mind.izumi" %% "distage-core-api" % "1.1.0-M10",
  "io.7mind.izumi" %% "distage-extension-config" % "1.1.0-M10",
  "io.7mind.izumi" %% "distage-extension-plugins" % "1.1.0-M10",
  "io.7mind.izumi" %% "distage-framework-api" % "1.1.0-M10",
  "io.7mind.izumi" %% "fundamentals-bio" % "1.1.0-M10",
  "io.7mind.izumi" %% "fundamentals-collections" % "1.1.0-M10",
  "io.7mind.izumi" %% "fundamentals-language" % "1.1.0-M10",
  "io.7mind.izumi" %% "fundamentals-orphans" % "1.1.0-M10",
  "io.7mind.izumi" %% "fundamentals-platform" % "1.1.0-M10",
  "io.7mind.izumi" %% "fundamentals-reflection" % "1.1.0-M10",
  "io.7mind.izumi" %% "logstage-core" % "1.1.0-M10",
  "io.circe" %% "circe-core" % "0.14.3",
  "io.circe" %% "circe-parser" % "0.14.3",
  "io.circe" %% "circe-yaml" % "0.14.2",
  "io.confluent" % "kafka-avro-serializer" % "7.2.2",
  "io.github.vigoo" %% "zio-aws-core" % "3.17.100.3",
  "io.github.vigoo" %% "zio-aws-netty" % "3.17.100.3",
  "io.github.vigoo" %% "zio-aws-sqs" % "3.17.100.3",
  "io.jaegertracing" % "jaeger-core" % "1.8.1",
  "io.opentracing" % "opentracing-api" % "0.33.0",
  "io.opentracing" % "opentracing-util" % "0.33.0",
  "io.zipkin.zipkin2" % "zipkin" % "2.23.19",
  "org.apache.httpcomponents" % "httpclient" % "4.5.14",
  "org.apache.kafka" % "kafka-clients" % "7.2.2-ccs",
  "org.http4s" %% "http4s-core" % "0.23.16",
  "org.typelevel" %% "case-insensitive" % "1.3.0",
  "org.typelevel" %% "cats-core" % "2.9.0",
  "org.typelevel" %% "cats-effect-kernel" % "3.4.2",
)

lazy val `my-app` = (project in file("."))
  .settings(
    resolvers ++= Seq(
      "Confluent Maven Repository" at "https://packages.confluent.io/maven/",
      "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
    ),
    libraryDependencies ++= Seq(
      Deps.catsEffect,
      Deps.zio,
      Deps.zioInteropCats,
      Deps.zioInteropReactivestreams,
      Deps.logstageAdapterSlf4J,
      Deps.distageFramework,
      Deps.distageFrameworkDocker,
      Deps.zioStreams,
      Deps.zioKafka,
      Deps.kafkaSchemaSerializer,
      Deps.kafkaAvroSerde,
      Deps.distageTestkitScalatest % Test,
      Deps.scalatestScalacheck % Test,
      Deps.scalacheck % Test,
      Deps.apacheAvro,
      Deps.asyncHttpClientBackendZio,
      Deps.tapirJsonCirce,
      Deps.tapirHttp4sServer,
      Deps.tapirOpenapiDocs,
      Deps.tapirSwaggerUiHttp4s,
      Deps.tapirSttpClient,
      Deps.sttpClientCirce % Test,
      Deps.circeGeneric,
      Deps.circeLiteral,
      Deps.http4sBlazeServer,
      Deps.http4sDsl,
      Deps.http4sServer,
      Deps.zioOpentracing,
      Deps.ddTraceApi,
      Deps.jaegerZipkin,
      Deps.zipkinReporter,
      Deps.zipkinSenderOkhttp3,
    ),
    // addCompilerPlugin(Deps.betterMonadicFor),
    // addCompilerPlugin(Deps.kindProjector),
    scalacOptions ++= Seq(
      s"-Xmacro-settings:product-name=${name.value}",
      s"-Xmacro-settings:product-version=${version.value}",
      s"-Xmacro-settings:product-group=${organization.value}",
      s"-Xmacro-settings:scala-version=${scalaVersion.value}",
      s"-Xmacro-settings:scala-versions=${crossScalaVersions.value.mkString(":")}",
      s"-Xmacro-settings:sbt-version=${sbtVersion.value}",
      s"-Xmacro-settings:git-repo-clean=${git.gitUncommittedChanges.value}",
      s"-Xmacro-settings:git-branch=${git.gitCurrentBranch.value}",
      s"-Xmacro-settings:git-described-version=${git.gitDescribedVersion.value.getOrElse("")}",
      s"-Xmacro-settings:git-head-commit=${git.gitHeadCommit.value.getOrElse("")}",
    ),
  )
