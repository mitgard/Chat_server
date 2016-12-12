package ru.Rustam

import akka.http.scaladsl.server.Route

/**
  * Created by Rustam on 10.12.2016.
  */
trait WebService {
  def route: Route
}
