import zio._

object ApplicationForE2E {

  case object RunningApp

  lazy val live: ZLayer[Any, Any, RunningApp.type] = ZLayer(startApp)

  private lazy val startApp: RIO[Any, RunningApp.type] = {

    for {
      _ <- ZIO.attempt(MyApp.main(Array())).forkDaemon
      _ <- MyApp.ready.get.repeatUntil(ready => ready)
    } yield RunningApp
  }
}
