package mx.krieger.internals.gallery

import com.google.api.server.spi.config._
import mx.krieger.internals.gallery.wrappers.{RegisterRequest, StatusResponse}


@Api(name = "registerService",
  version = "v1",
  description = "Services for register users",
  authLevel = AuthLevel.NONE)
class App {

  @ApiMethod(name = "register",
    httpMethod = "POST",
    authLevel = AuthLevel.NONE)
  def register(req: RegisterRequest): StatusResponse =
    new StatusResponse(200, "All is ok, save information is pending")

}

