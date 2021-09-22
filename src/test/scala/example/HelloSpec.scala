package example

import com.codeborne.selenide.CollectionCondition.sizeGreaterThan
import com.codeborne.selenide.Condition.{text, visible}
import com.codeborne.selenide.Selenide._
import org.openqa.selenium.By
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class HelloSpec extends AnyFlatSpec with Matchers {
  "The Hello object" should "say hello" in {
    //Hello.greeting shouldEqual "hello"

    open("https://duckduckgo.com")
    $(By.name("q")).`val`("selenide").pressEnter()
    $$(".results .result").shouldHave(sizeGreaterThan(1))
    $(".results .result").shouldBe(visible).shouldHave(
      text("Selenide: concise UI tests in Java"),
      text("selenide.org"))
  }
}
