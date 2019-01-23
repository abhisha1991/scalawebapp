package azsml.mleap

import ml.combust.mleap.runtime.frame.Transformer
import ml.combust.mleap.runtime.serialization.FrameReader
import java.net.{InetAddress, InetSocketAddress, ServerSocket}
import java.util.concurrent.Executors
import com.sun.net.httpserver.{HttpExchange, HttpHandler, HttpServer}
import org.apache.commons.io.IOUtils
import ml.combust.mleap.core.types._
import ml.combust.mleap.runtime.frame.{DefaultLeapFrame, Row}
import ml.combust.bundle.BundleFile
import ml.combust.mleap.runtime.MleapSupport._
import resource._
import play.api.libs.json._
import ml.combust.mleap.runtime.serialization.FrameReader
import ml.combust.mleap.runtime.frame.Transformer

class MleapModel extends App {

  def mleapModelPredict(frameJson: play.api.libs.json.JsValue) : String = {
    // println(frameJson.toString)

    // All models are in this folder: C:\webapp\modelzips
    val zipBundleM = (for(bundle <- managed(BundleFile("jar:file:/C:/webapp/modelzips/test-news.zip"))) yield {
        bundle.loadMleapBundle().get
        }).opt.get

    val mleapPipeline = zipBundleM.root
    val bytes = Json.toBytes(frameJson)
    val mleapframe = FrameReader("ml.combust.mleap.json").fromBytes(bytes).get

    val response = mleapPipeline.asInstanceOf[Transformer].transform(mleapframe).get.collect().map(_.toString()).mkString(",")
    println("The response is")
    println(response)
    return response
  }

}
