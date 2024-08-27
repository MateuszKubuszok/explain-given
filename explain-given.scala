package com.kubuszok.explain_given

object ExplainGiven {

  transparent inline def apply[A](using inline a: A) = $ {implementation('a, printHint = true, printRuntime = true)}

  transparent inline def withHint[A](using inline a: A) = $ {implementation('a, printHint = true, printRuntime = false)}

  transparent inline def withPrintln[A](using inline a: A) = $ {implementation('a, printHint = false, printRuntime = true)}

  import scala.quoted.* 

  def implementation[A: Type](a: Expr[A], printHint: Boolean, printRuntime: Boolean)(using q: Quotes): Expr[A] = {
    import q.*, q.reflect.*

    val msg = s"given of type ${TypeRepr.of[A].show(using Printer.TypeReprAnsiCode)} resolved to:\n${a.asTerm.show(using Printer.TreeAnsiCode)}"

    if (printHint) {
      report.info(msg, a)
    }

    if (printRuntime) {
      '{
        println(${ Expr(msg) })
        ${ a }
      }
    } else a
  }
}
