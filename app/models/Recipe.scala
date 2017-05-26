package models

import play.api.libs.json._

case class Recipe(id: Long, name : String, description: String, course: String, owner: String)

object Recipe {
  
  implicit val print = Json.format[Recipe]
}

