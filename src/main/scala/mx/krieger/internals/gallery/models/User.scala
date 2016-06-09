package mx.krieger.internals.gallery.models

import javax.persistence.Entity

import scala.beans.BeanProperty


@Entity
class User {
  @BeanProperty
  var name: String = _

  @BeanProperty
  var age: Integer = _
}
