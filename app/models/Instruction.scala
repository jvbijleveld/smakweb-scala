package models

import play.api.libs.json._

case class Instruction(id: Long, recipeId: Long, instruction: String)

object Instruction {
  implicit val ptint = Json.format[Instruction]
}