package com.github.atais

import com.github.atais.empty.Empty

object Main extends App {

  // caching case class' Empty instances
  {
    import com.github.atais.empty.EmptyInstances._

    // now I can reuse Empty instance, resolving to emptyFoo/Bar
    println(implicitly[Empty[Foo0]].value)
    println(implicitly[Empty[Foo30]].value)
  }

}
