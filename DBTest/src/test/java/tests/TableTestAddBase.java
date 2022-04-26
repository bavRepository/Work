package tests;

import aquality.selenium.core.logging.Logger;
import model.Author;
import model.Project;
import model.Session;
import model.Test;
import model.dbquery.AuthorTable;
import model.dbquery.ProjectTable;
import model.dbquery.SessionTable;
import model.dbquery.TestTable;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Config;
import utils.TestData;

import java.util.Date;

public class TableTestAddBase extends BaseWrapper {

    Session session;

    @BeforeMethod()
    public void setUp() {

        Logger.getInstance().info("If our Author and Project exist get them");
        author = AuthorTable.get(TestData.AUTHOR_LOGIN);
        project = ProjectTable.get(TestData.CURRENT_PROJECT_NAME);
        session = SessionTable.get();
        dateBeforeTest = new Date();

        if (author == null) {
            Logger.getInstance().info("Our author does not exist. Create author in db");
            author = Author.setAndGetAuthor();
        }

        if (project == null) {
            Logger.getInstance().info("Our project does not exist. Create project in db");
            project = Project.setAndGetProject();
        }
    }

    @AfterMethod()
    public void tearDown(ITestResult result, ITestContext testContext) {
        Logger.getInstance().info("Create our 'Test' model");
        Test ourTest = new Test(testContext.getName(), result.getStatus(), result.getMethod().getMethodName(),
                project.getId(), session.getId(), df.format(dateBeforeTest), df.format(new Date()), Config.SYSTEM_USER_NAME, Config.BROWSER_NAME, author.getId());
        Logger.getInstance().info("Add our Test object in db");
        Assert.assertTrue(TestTable.add(ourTest), "Insert new line into table 'Test' is fail");
    }
}
