package tests;

import aquality.selenium.core.logging.Logger;
import model.Status;
import model.Test;
import model.dbquery.AuthorTable;
import model.dbquery.ProjectTable;
import model.dbquery.StatusTable;
import model.dbquery.TestTable;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import utils.DataMathWork;
import utils.TestData;

import java.util.Date;
import java.util.List;

public class TableTestCopyUpdateDeleteBase extends BaseWrapper {

    protected List<Test> idMatch;
    protected List<Test> forUpdateAndDel;

    @BeforeMethod()
    public void setUp(ITestResult result) {

        dateBeforeTest = new Date();
        author = AuthorTable.get(TestData.AUTHOR_LOGIN);
        project = ProjectTable.get(TestData.CURRENT_PROJECT_NAME);
        Status status = StatusTable.get();

        Logger.getInstance().info("Get tests list that have duplicate digits in 'ID' number");
        idMatch = TestTable.getTestsIdMatch(DataMathWork.getRandomValue(TestData.MAX_TEST_ID, TestData.MIN_TEST_ID));

        Logger.getInstance().info("Add and update properties our Test objects model then INSERT new tests into db");
        for (int i = 0; i < idMatch.size(); i++) {

            idMatch.get(i).setProject_id(project.getId());
            idMatch.get(i).setAuthor_id(author.getId());

            if (idMatch.get(i).getStatus_id() == 0) {
                idMatch.get(i).setStatus_id(status.getId());
            }
            if (idMatch.get(i).getEnd_time() == null) {
                idMatch.get(i).setEnd_time(df.format(dateBeforeTest));
            }
            TestTable.add(idMatch.get(i));
       }
    }

    @AfterMethod()
    public void tearDown(ITestResult result) {
        SoftAssert softAssertion= new SoftAssert();
        Logger.getInstance().info("Delete renew tests in db");
        for(int i = 0; i < forUpdateAndDel.size(); i ++) {
            softAssertion.assertTrue(TestTable.delete(forUpdateAndDel.get(i)), "Delete tests fail");
            softAssertion.assertAll();
        }

    }
}
