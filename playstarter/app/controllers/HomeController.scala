package controllers

import javax.inject._
import scala.collection.mutable
import play.api.libs.functional.syntax._
import play.api.libs.json._
import play.api.mvc._
import azsml.mleap.MleapModel

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def azsml() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.azsml())
  }

  def modelFunc = Action(BodyParsers.parse.json) { request =>
    val model = new MleapModel()
    // request.body has type "class play.api.libs.json.JsObject"
    val result = model.mleapModelPredict(request.body)

    Ok(result)
  }
}
