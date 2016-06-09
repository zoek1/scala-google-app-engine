package mx.krieger.internals.gallery.models

import javax.servlet.{ServletContextEvent, ServletContextListener}

import com.googlecode.objectify.ObjectifyService


class DatastoreRegisterEntities extends ServletContextListener {
  override def contextDestroyed(servletContextEvent: ServletContextEvent): Unit = {
  }

  override def contextInitialized(servletContextEvent: ServletContextEvent): Unit = {
    val t = new RegisterUserProfile()
    ObjectifyService.register(t.getClass)
  }
}
