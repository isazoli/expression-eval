import dsl.Expression

package object validator {

  type ValidateExpression = Expression => Boolean

  val validate: ValidateExpression = { expression =>
    //TODO
    ???
  }

}
