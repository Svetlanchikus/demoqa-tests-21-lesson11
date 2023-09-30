package guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;


public class LambdaStepTest {
    private static final String REPOSITORY = "Svetlanchikus/lesson1-demoqa-tests-21";
    private static final String HEADING = "Welcome to issues!";

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open the GitHub homepage", () -> {
            open("https://github.com");
        });

        step("Search repository by name" + REPOSITORY, () -> {
            $(".search-input").click();
            $("#query-builder-test").sendKeys(REPOSITORY);
            $("#query-builder-test").pressEnter();
        });

        step("Click on the link of the found repository" + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Open the Issues tab", () -> {
            $("#issues-tab").click();
        });

        step("We check the presence of the title on the Issue pag" + HEADING, () -> {
            $(withText(HEADING)).should(exist);
        });
    }
}
