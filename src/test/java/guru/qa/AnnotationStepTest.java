package guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.WebFormStep.GitHubFormStep;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class AnnotationStepTest {
    private static final String REPOSITORY = "Svetlanchikus/lesson1-demoqa-tests-21";
    private static final String HEADING = "Welcome to issues!";

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        GitHubFormStep steps = new GitHubFormStep();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.checkPresenceTitle(HEADING);
    }
}
