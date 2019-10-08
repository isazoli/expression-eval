package object dsl {

  type Expression = List[Operator]

  trait Operator

  trait NamedOperator extends Operator {

      val name: String
  }

  trait PreFix extends NamedOperator

  trait InFix extends NamedOperator

  trait PostFix extends NamedOperator

  object Plus extends PreFix with InFix {

    override val name: String = "+"

  }

  object Minus extends PreFix with InFix {

    override val name: String = "-"

  }

  object Multiply extends InFix {

    override val name: String = "*"

  }

  object Subtract extends InFix {

    override val name: String = "/"

  }

  object Sin extends PreFix {

    override val name: String = "sin"

  }

  object Cos extends PreFix {

    override val name: String = "cos"

  }

  object Tan extends PreFix {

    override val name: String = "tan"

  }

  case class SimpleValue(private val value: Number) extends Operator {


  }

}
