package com.github.atais.empty

object Empty {
  def apply[A](x: A): Empty[A] = new Empty[A](x)
}

class Empty[A](val value: A) extends AnyVal
