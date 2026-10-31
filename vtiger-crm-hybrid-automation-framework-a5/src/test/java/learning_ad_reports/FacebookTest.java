package learning_ad_reports;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class FacebookTest {
	@Test
	public void login() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./advance/rep.html");
		spark.config().setDocumentTitle("dummy fb title");
		spark.config().setReportName("dummy report name");
		spark.config().setTheme(Theme.DARK);

		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("broswer", "chrome");
		report.setSystemInfo("safari", "mac");

		ExtentTest test = report.createTest("login");
		test.log(Status.PASS, "This is passed");
		test.log(Status.FAIL, "This is failed");
		test.log(Status.WARNING, "This is status");
		test.log(Status.SKIP, "This is skip");

		report.flush();
	}
}
