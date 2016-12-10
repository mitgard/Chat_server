package ru.Rustam

import akka.http.scaladsl.model.ws.{Message, TextMessage}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.scaladsl.Flow


/**
  * Created by Rustam on 10.12.2016.
  */
object EchoService extends WebService {
  override def route: Route = path("ws-echo"){
    get{
      handleWebSocketMessages(echoService)
    }
  }

  val echoService: Flow[Message, Message, _] = Flow[Message].map {
    case TextMessage.Strict(txt) => TextMessage("ECHO:" + txt)
    case _ => TextMessage("Message type unsupported")
  }
}