import ApplicationForE2E.RunningApp
import org.scalatest.matchers.should.Matchers
import zio.test.ZIOSpec

trait MySpecBase extends ZIOSpec[RunningApp.type] with Matchers {

  override val bootstrap = ApplicationForE2E.live
}
