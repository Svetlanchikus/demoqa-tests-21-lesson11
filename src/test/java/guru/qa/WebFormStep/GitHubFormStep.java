package guru.qa.WebFormStep;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;


public class GitHubFormStep {
    @Step("Open the GitHub homepage")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Search repository by name {repo}")
    public void searchForRepository(String repo) {
        $(".search-input").click();
        $("#query-builder-test").sendKeys(repo);
        $("#query-builder-test").pressEnter();
    }

    @Step("Click on the link of the found repository {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Open the Issues tab")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("check the presence of the title on the Issue pag {heading}")
    public void checkPresenceTitle(String heading) {
        $(withText(heading)).should(exist);
    }
}
