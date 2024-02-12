package com.github.atais.empty

import shapeless.{::, Generic, HList, HNil}

trait ShapelessInstances {

  implicit val hNilEmpty: Empty[HNil] =
    Empty(HNil)

  implicit def hListEmpty[H, T <: HList](implicit
      h: Empty[H],
      t: Empty[T]
  ): Empty[H :: T] =
    Empty(h.value :: t.value)

  def genericEmpty[A, R](implicit
      gen: Generic.Aux[A, R],
      r: Empty[R]
  ): Empty[A] =
    Empty(gen.from(r.value))

}
