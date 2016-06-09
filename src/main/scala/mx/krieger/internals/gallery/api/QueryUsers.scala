package mx.krieger.internals.gallery.api

import java.util
import scala.collection.JavaConversions._

import com.google.api.server.spi.config.{Api, ApiMethod, AuthLevel}
import com.googlecode.objectify.ObjectifyService
import com.googlecode.objectify.ObjectifyService._
import mx.krieger.internals.gallery.models.RegisterUserProfile

@Api(name =  "queryService",
  version = "v1",
  description = "Services for querying users",
  authLevel = AuthLevel.NONE)
class QueryUsers {
  @ApiMethod(name = "sortByLastName",
    path="sortByParent",
    httpMethod = "GET",
    authLevel = AuthLevel.NONE)
  def sortByParent(): util.ArrayList[RegisterUserProfile] = {

    val reg = new RegisterUserProfile()
    val l = new util.ArrayList[RegisterUserProfile]()
    ObjectifyService.register(reg.getClass)

    val list = ofy()
      .load
      .`type`( new RegisterUserProfile().getClass )
      .order("lastname")
      .list.toList

    for (element <- list) {
      l.add(element)
    }

    l
  }
}
