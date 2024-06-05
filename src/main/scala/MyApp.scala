import zio._

object MyApp extends zio.ZIOAppDefault {

  val ready: Ref[Boolean] = Unsafe.unsafe(implicit u =>
    Runtime.default.unsafe.run(Ref.make(false)).getOrThrowFiberFailure()
  )

  override def run: ZIO[Environment with ZIOAppArgs with Scope, Any, Any] = {
    (for {
      _ <- ready.set(true)
    } yield ())
      .zipPar(ZIO.never)
  }
}
