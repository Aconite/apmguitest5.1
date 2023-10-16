package com.aconite.apm.gui.automation.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "html:reports/cucumber-html-report.html",
                "json:reports/cucumber.json"
               },
        tags = "",
        features = {
                "src/test/resources/"
        },
        glue = {"com.aconite.apm.gui.automation.bindings"},
        monochrome = true
)



public class TestRunner
{

}