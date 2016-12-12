package ru.Rustam

import akka.http.scaladsl.model.ws.TextMessage
import org.json4s.DefaultFormats
import org.json4s.jackson.Serialization.read

/**
  * Created by Rustam on 12.12.2016.
  */
object ComHandler {

    def handler(comMessage:String)={
      implicit val formats = DefaultFormats
      val msgData = read[InputMessage](comMessage)
      msgData.cmd match {
        case "auth" => TextMessage("Your token tokentoken")
        case "allmsg" => TextMessage("Message for all user from" + msgData.id +"\n Message: " +msgData.msg)

        case _ => TextMessage("You are in the ComHandler")

      }


    }
}


case class InputMessage(
                       id:String,
                       cmd:String,
                       msg:String
                       )