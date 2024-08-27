package com.kubuszok.test

import com.kubuszok.explain_given.ExplainGiven
import io.circe.*, io.circe.generic.auto.*, io.circe.syntax.*

class ExampleGivenTest extends munit.FunSuite {

  test("should print result") {
    case class Foo(a: Int, b: String)
    case class Bar(list: List[Foo])

    // both compile time hint as well as runtime println
    Bar(List(Foo(10, "test"))).asJson(ExplainGiven.apply)
    // compile time hint only
    Bar(List(Foo(10, "test"))).asJson(ExplainGiven.withHint)
    // println hint only (runtime)
    Bar(List(Foo(10, "test"))).asJson(ExplainGiven.withPrintln)
  }
}