package mx.krieger.internals.gallery.models

import com.googlecode.objectify.annotation.Entity
import com.googlecode.objectify.annotation.Id
import com.googlecode.objectify.annotation.Index

import mx.krieger.internals.gallery.wrappers.RegisterRequest


@Entity
class RegisterUserProfile {
  import mx.krieger.internals.gallery.utils.Indexes._
  import mx.krieger.internals.gallery.data.placeholders.Images._

  @Id
  private var id: String = _
  private var  firstname: String = _
  @Index
  private var lastname: String = _
  private var age: Integer = _
  private var urlPhoto: String = URL_PROFILE

  def this(registerRequest: RegisterRequest) {
    this()
    this.id = generateIndex(registerRequest.firstname)
    this.firstname = registerRequest.getFirstname
    this.lastname = registerRequest.getLastname
    this.age = registerRequest.age

    if (registerRequest.getUrl != null)
      this.urlPhoto = registerRequest.getUrl
  }

}

