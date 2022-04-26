package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TableTestAdd extends TableTestAddBase {

    @Test()
    public void addDataPassed() throws InterruptedException {

        Thread.sleep(1200);
        Assert.assertTrue(true);
    }

    @Test()
    public void addDataFail() throws InterruptedException {

        Thread.sleep(1200);
        Assert.assertTrue(false);
    }
}
