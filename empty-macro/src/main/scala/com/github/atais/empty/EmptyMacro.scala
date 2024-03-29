package com.github.atais.empty

import scala.language.experimental.macros
import scala.reflect.macros.blackbox

object EmptyMacro {

  def deriveEmpty[A]: Empty[A] = macro deriveEmptyImpl[A]

  def deriveEmptyImpl[A: c.WeakTypeTag](
      c: blackbox.Context
  ): c.Expr[Empty[A]] = {
    import c.universe._

    val aType = weakTypeOf[A]

    if (!aType.typeSymbol.asClass.isCaseClass) {
      c.abort(c.enclosingPosition, s"$aType is not a case class")
    }

    val values = aType.decls
      .collect {
        case m: MethodSymbol if m.isCaseAccessor => m
      }
      .map(_.returnType)
      .map { fieldType =>
        val empty = tq"Empty[$fieldType]"
        val t = c.typecheck(empty, c.TYPEmode)
        val i = c.inferImplicitValue(t.tpe)
        val q = q"$i.value"
        q
      }

    c.Expr[Empty[A]] {
      q"""new Empty[$aType](new $aType(..$values))"""
    }
  }

}
