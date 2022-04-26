package tests;

import aquality.selenium.core.logging.Logger;
import model.dbquery.TestTable;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Config;
import utils.DataMathWork;
import utils.TestData;
import java.util.Date;

public class TableTestCopyUpdateDelete extends TableTestCopyUpdateDeleteBase {

    @Test()
    public void copyUpdateDelete() throws InterruptedException {

        dateBeforeTest = new Date();
        Thread.sleep(1000);
        Logger.getInstance().info("Get renew test from db as Test objects model");
        forUpdateAndDel = TestTable.getTestsIdRange(idMatch.size());

        Logger.getInstance().info("Update objects properties then update DB tests");
        for (int i = 0; i < forUpdateAndDel.size(); i++) {
            forUpdateAndDel.get(i).setStatus_id(DataMathWork.getRandomValue(TestData.MAX_STATUS_ID, TestData.MIN_STATUS_ID));
            forUpdateAndDel.get(i).setStart_time(df.format(dateBeforeTest));
            forUpdateAndDel.get(i).setEnd_time(df.format(new Date()));
            forUpdateAndDel.get(i).setEnv(Config.SYSTEM_USER_NAME);
            forUpdateAndDel.get(i).setBrowser(Config.BROWSER_NAME);
            Assert.assertTrue(TestTable.update(forUpdateAndDel.get(i)), "Tests update fail in 'Test' table");
        }
    }
}
