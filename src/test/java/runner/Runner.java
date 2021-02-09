package runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import Utilities.FileReaderManager;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features="Features",
tags="@tag",
glue="com.wahooFitness.stepDefinations",
dryRun=false,
monochrome=true,
plugin= {"pretty","html:target/myreport","com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
)

public class Runner {

	
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
	}
	
}















