package com.kubuszok.test

import io.circe._, io.circe.generic.auto._, io.circe.syntax._

class ExampleGivenTest extends munit.FunSuite {

  test("should print result") {
    case class Foo(a: Int, b: String)
    case class Bar(list: List[Foo])

    Bar(List(Foo(10, "test"))).asJson(com.kubuszok.explain_given.ExplainGiven.apply)
  }
}