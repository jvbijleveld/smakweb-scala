package models

import play.api.libs.json._


case class Ingredient(id: Long, instructionId: Long, name: String, ammount: String)

object Ingredient {
  implicit val print = Json.format[Ingredient]
}