package ManagerApplication;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class findHelper {

    public final appManager app = new appManager();

    @BeforeMethod
    public void setUp(){
        app.init();
    }

    @AfterMethod
    public void tearDown(){
        app.stop();
    }

}
