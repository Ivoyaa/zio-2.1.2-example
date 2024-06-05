import zio.test.{Spec, TestEnvironment, assertTrue}
import zio.{Scope, ZIO}

object HappyPathSpec extends MySpecBase {

  override def spec: Spec[TestEnvironment with Scope, Any] =
    suite("Happy path")(
      test("success") {
        for {
          _ <- ZIO.unit
        } yield assertTrue(true)
      }
    )
}
