package mx.krieger.internals.gallery.models

import com.googlecode.objectify.annotation.Entity
import com.googlecode.objectify.annotation.Id
import com.googlecode.objectify.annotation.Index
import mx.krieger.internals.gallery.wrappers.RegisterRequest

import scala.beans.BeanProperty


@Entity
class RegisterUserProfile {
  import mx.krieger.internals.gallery.utils.Indexes._
  import mx.krieger.internals.gallery.data.placeholders.Images._


  @BeanProperty @Id
  var id: String = generateIndex()
  @BeanProperty
  var  firstname: String = _
  @BeanProperty @Index
  var lastname: String = _
  @BeanProperty
  var age: Integer = _
  @BeanProperty
  var urlPhoto: String = URL_PROFILE

  def this(registerRequest: RegisterRequest) {
    this()
    this.firstname = registerRequest.getFirstname
    this.lastname = registerRequest.getLastname
    this.age = registerRequest.age

    if (registerRequest.getUrl != null)
      this.urlPhoto = registerRequest.getUrl
  }

}

