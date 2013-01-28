import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "multiproj"
  val appVersion      = "1.0-SNAPSHOT"

  val adminDeps = Seq(
    // Add your project dependencies here,
    jdbc,
    anorm
  )
  
  val mainDeps = Seq()

  // admin module
  lazy val admin = play.Project(appName + "-admin", appVersion, adminDeps, path = file("modules/admin"))

  // main module
  lazy  val main = play.Project(appName, appVersion, mainDeps).settings(
      // Add your own project settings here      
    ).dependsOn(admin).aggregate(admin)

}
