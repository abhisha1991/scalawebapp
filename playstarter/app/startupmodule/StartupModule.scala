package com.microsoft.eager
import com.google.inject.AbstractModule
import com.google.inject.name.Names

class StartupModule extends AbstractModule {
  override def configure() = {
    bind(classOf[StartUpService]).asEagerSingleton
  }
}

