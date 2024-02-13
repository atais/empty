package empty

import com.github.atais.empty._

object ShapelessMain extends App {

  // caching case class' Empty instances
  import ShapelessEmptyInstances._
  {

    // now I can reuse Empty instance, resolving to emptyFoo/Bar
    println(implicitly[Empty[Foo0]].value)
    println(implicitly[Empty[Foo30]].value)
  }

}
