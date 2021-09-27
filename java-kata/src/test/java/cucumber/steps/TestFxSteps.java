package cucumber.steps;

import org.testfx.framework.junit5.ApplicationTest;

public abstract class TestFxSteps extends ApplicationTest
{
    static
    {
        if (Boolean.getBoolean("headless"))
        {
            System.setProperty("testfx.headless", "true");
        }
    }
}
