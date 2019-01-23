package com.microsoft.eager;
import java.io._
import sys.process._
import java.net.URL
import java.io.File

class StartUpService {
    // we must start the service by invoking the index page (or any other page than the mleap model page)
    val file: List[String] = List("test-diamond.zip", "test-news.zip")

    // need to add validations for existence of urls and folder paths
    for (f <- file) {
      val url = "https://abhishastorage.blob.core.windows.net/abhishacon/".concat(f)
      val fi = "C:/webapp/modelzips/".concat(f)
      new URL(url) #> new File(fi) !!
    }

}