package ru.Rustam


import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer

import scala.io.StdIn

/**
  * Created by Rustam on 03.12.2016.
  */
object Server extends App {
  implicit val actorSystem       = ActorSystem("akka-system")
  implicit val flowMaterializer = ActorMaterializer()

  val interface = "localhost"
  val port = 8080

  import akka.http.scaladsl.server.Directives._

  val route = MainService.route ~
    EchoService.route

  val binding = Http().bindAndHandle(route, interface, port)
  println(s"Server is now online at http://$interface:$port\nPress RETURN to stop...")
  StdIn.readLine()


  import actorSystem.dispatcher

  binding.flatMap(_.unbind()).onComplete(_=>actorSystem.terminate())
  println("Server is down...")



}
