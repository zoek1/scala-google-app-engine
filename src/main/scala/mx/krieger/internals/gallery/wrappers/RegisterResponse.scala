package mx.krieger.internals.gallery.wrappers

import scala.beans.BeanProperty

class StatusResponse(code: Int, res: String) {
  @BeanProperty var responseCode: Int = code
  @BeanProperty var reason: String = res
}


class RegisterRequest {
  @BeanProperty var firstname: String = _
  @BeanProperty var lastname: String = _
  @BeanProperty var age: Int = _
  @BeanProperty var url: String = _

  def this(firstname: String, lastname: String, age : Int) {
    this()
    this.firstname = firstname
    this.lastname  = lastname
    this.age = age
  }
}