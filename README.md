# expression-eval

## My solution startegy was
* use Scala Parser Combinators [https://github.com/scala/scala-parser-combinators]
* "inspiration" and code snippets from [http://labun.com/fh/ma.pdf]

## How to build the project
* the project is an Scala sbt project. 

## How to run the console
* simply use `sbt run` and exit with `CTRL + C` 

## Known limitations
* plus operator handling is implemented, but plus/positive sign handling is not (the negative sign is working).
* Console: only validates on `enter`, not on every keystroke 
* RAND is not yet implemented

## Notes on testing
* use ScalaTest property-based testing [http://www.scalatest.org/user_guide/table_driven_property_checks]. Which unfortunately not as sofisticated as JUnit5 property-based testing solution.
