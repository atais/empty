package com.github.atais

import com.github.atais.empty.Empty

object MacroMain extends App {

  // caching case class' Empty instances
  {
    import com.github.atais.empty.MacroEmptyInstances._

    // now I can reuse Empty instance, resolving to emptyFoo/Bar
    println(implicitly[Empty[Foo0]].value)
    println(implicitly[Empty[Foo1]].value)
    println(implicitly[Empty[Foo2]].value)
    println(implicitly[Empty[Foo3]].value)
    println(implicitly[Empty[Foo30]].value)
  }

}
