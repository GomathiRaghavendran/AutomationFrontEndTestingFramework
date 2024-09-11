package utilities.extentreports;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ExtentReports {
        private com.relevantcodes.extentreports.ExtentReports extent;

    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
                               String outputDirectory) {

        String  jobName = System.getProperty("jobName");

        // String  buildNumber = System.getProperty("buildNumber");
        String buildID = System.getProperty("buildID");

        if(jobName == null )
            //outputDirectory = "C:/JancyReport";
            outputDirectory = "/Users/balajivijayakumar/Keerthi/Hybrid/reportfromIDE";
        else
            //outputDirectory = "C:/JenkinsTestExecution/"+jobName+"/"+buildNumber;
            outputDirectory = "/Users/balajivijayakumar/Keerthi/Hybrid/reportfromJenkins/"+jobName+"/"+buildID;

        extent = new com.relevantcodes.extentreports.ExtentReports(outputDirectory + File.separator
                + "report.html", false);

        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();

            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();

                buildTestNodes(context.getPassedTests(), LogStatus.PASS);
                buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
                buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
            }
        }

        extent.flush();
        extent.close();
    }

    private void buildTestNodes(IResultMap tests, LogStatus status) {
        ExtentTest test;

        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                test = extent.startTest(result.getMethod().getMethodName());

                test.setStartedTime(getTime(result.getStartMillis()));
                test.setEndedTime(getTime(result.getEndMillis()));

                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);

                if (result.getThrowable() != null) {
                    test.log(status, result.getThrowable());
                } else {
                    test.log(status, "Test " + status.toString().toLowerCase()
                            + "ed");
                }

                extent.endTest(test);
            }
        }
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
}