package cucumber.steps;

import org.junit.jupiter.api.BeforeAll;
import org.testfx.framework.junit5.ApplicationTest;

public abstract class TestFxSteps extends ApplicationTest
{
    static
    {
        if (Boolean.getBoolean("headless"))
        {
            System.setProperty("testfx.robot", "glass");
            System.setProperty("testfx.headless", "true");
            System.setProperty("prism.order", "sw");
            System.setProperty("prism.text", "t2k");
        }
    }
}
