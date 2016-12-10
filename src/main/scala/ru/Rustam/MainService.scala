package ru.Rustam

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

/**
  * Created by Rustam on 10.12.2016.
  */
object MainService extends WebService{


  override def route: Route = pathEndOrSingleSlash {
    complete("Welcome to websocket server")
  }

}
