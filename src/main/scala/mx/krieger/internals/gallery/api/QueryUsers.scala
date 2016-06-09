package mx.krieger.internals.gallery.api

import java.util

import com.google.api.server.spi.config.{Api, ApiMethod, AuthLevel}
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
  def sortByParent(): util.List[RegisterUserProfile] =
    RegisterUserProfile.fact { query =>
      val list = query.order("lastname").list

      list match {
        case list: util.List[RegisterUserProfile @unchecked] => list
        case _ => new util.ArrayList[RegisterUserProfile]()
      }
    }

}
