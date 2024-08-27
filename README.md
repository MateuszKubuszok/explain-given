# Explain given

Prints the `given` that was resolved in a method which expects `using`.

```scala
//> using scala 3.3.3
//> using dep com.kubuszok.explain_given.ExplainGiven
//> using dep io.circe::circe-generic::0.14.9

case class Foo(a: Int, b: String)
case class Bar(list: List[Foo])

import com.kubuszok.explain_given.ExplainGiven
import io.circe.*, io.circe.generic.auto.*, io.circe.syntax.*

// both compile time hint as well as runtime println
Bar(List(Foo(10, "test"))).asJson(ExplainGiven.apply)
// compile time hint only
Bar(List(Foo(10, "test"))).asJson(ExplainGiven.withHint)
// println only (runtime)
Bar(List(Foo(10, "test"))).asJson(ExplainGiven.withPrintln)
```
