// Ignore scala-xml version conflict between scoverage where `coursier` requires scala-xml v2
// and scoverage requires scala-xml v1 on Scala 2.12,
libraryDependencySchemes += "org.scala-lang.modules" %% "scala-xml" % VersionScheme.Always
