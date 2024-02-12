package com.github.atais.empty

object Empty {
  def apply[A](x: A): Empty[A] = new Empty[A] {
    override val value: A = x
  }
}

trait Empty[A] {
  val value: A
}
