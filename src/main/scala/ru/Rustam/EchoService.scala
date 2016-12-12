package ru.Rustam

import akka.http.scaladsl.model.ws.{Message, TextMessage}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.directives.Credentials
import akka.stream.scaladsl.Flow
import ru.Rustam.ComHandler.handler

/**
  * Created by Rustam on 10.12.2016.
  */
object EchoService extends WebService {
  override def route: Route = path("chat") {
    get {
      handleWebSocketMessages(echoService)

    }
  }


  def echoService: Flow[Message, Message, Any] = Flow[Message].map {
    case TextMessage.Strict(txt) => handler(txt)
//    case TextMessage.Strict(txt) => TextMessage("Hello, it's echo. "+txt)::Nil
    //    case tm:TextMessage => TextMessage(handler(tm.textStream))::Nil
    case _ => TextMessage("Message type unsupported")
  }


}