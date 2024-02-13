package atais.empty

import com.github.atais.empty._

object MacroMain extends App {

  // caching case class' Empty instances
  import MacroEmptyInstances._
  {

    // now I can reuse Empty instance, resolving to emptyFoo/Bar
    println(implicitly[Empty[Foo0]].value)
    println(implicitly[Empty[Foo1]].value)
    println(implicitly[Empty[Foo2]].value)
    println(implicitly[Empty[Foo3]].value)
    println(implicitly[Empty[Foo30]].value)
  }

}
