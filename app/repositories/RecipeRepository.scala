package repositories

import javax.inject.{ Inject, Singleton }
import play.api.db.slick.DatabaseConfigProvider
import slick.driver.JdbcProfile

import models.Recipe

import scala.concurrent.{ Future, ExecutionContext }

/**
 * A repository for recipes.
 *
 * @param dbConfigProvider The Play db config provider. Play will inject this for you.
 */

@Singleton
class RecipeRepository @Inject()(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext){
  
  private val dbConfig = dbConfigProvider.get[JdbcProfile]
  
  import dbConfig._
  import driver.api._
  
  
  private class RecipeTable(tag: Tag) extends Table[Recipe](tag, "recipe"){
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    
    def name = column[String]("name")
    def description = column[String]("description")
    def course = column[String]("course")
    def owner = column[String]("owner")
    
    def * = (id, name, description, course, owner)<> ((Recipe.apply _).tuppled, Recipe.unapply)
    
  }
  
  private val recipes = TableQuery[RecipeTable]
  
  def create(name:String, description: String, course: String): Future[Recipe] = db.run {
    (recipes.map(p=>(p.name, p.description, p.course, p.owner))
    returning recipe.map(_.id)
    into((newRecipe, id) => Recipe(id, newRecipe._1, newRecipe._2, newRecipe._3, newRecipe._4))
    ) += (name, description, course, owner)
  }
  
  def list(): Future[Seq[Recipe]] = db.run {
    recipes.result
  }
  
  
}