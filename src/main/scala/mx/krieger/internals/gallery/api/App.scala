package mx.krieger.internals.gallery.api

import java.util

import com.google.api.server.spi.config._
import com.googlecode.objectify.ObjectifyService
import com.googlecode.objectify.ObjectifyService.ofy
import mx.krieger.internals.gallery.models.RegisterUserProfile
import mx.krieger.internals.gallery.wrappers.{RegisterRequest, StatusResponse}

import collection.JavaConversions._

@Api(name =  "registerService",
  version = "v1",
  description = "Services for register users",
  authLevel = AuthLevel.NONE)
class App {

  @ApiMethod(name = "register",
    path="register",
    httpMethod = "POST",
    authLevel = AuthLevel.NONE)
  def register(req: RegisterRequest): StatusResponse = {
    val reg = new RegisterUserProfile(req)

    ObjectifyService.register(reg.getClass)

    ofy().save().entity(reg).now()

    new StatusResponse(200, "All is ok, save information is pending")
  }

}

