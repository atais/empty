package com.github.atais.empty

trait PrimitiveInstances {

  implicit val stringEmpty: Empty[String] = Empty("")
  implicit val booleanEmpty: Empty[Boolean] = Empty(false)
  implicit val intEmpty: Empty[Int] = Empty(0)
  implicit val longEmpty: Empty[Long] = Empty(0L)

  implicit def seqEmpty[A]: Empty[Seq[A]] = Empty(Seq.empty[A])

  implicit def optionEmpty[A]: Empty[Option[A]] = Empty(None)

}
