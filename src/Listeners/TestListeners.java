package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Utility.Utility;

public class TestListeners extends Utility implements ITestListener{
	long startTime;
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Execution started for Test cases "+result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		try {
			TakeScreenShot(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			TakeScreenShot(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		startTime=System.currentTimeMillis();
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Execution time taken = "+((System.currentTimeMillis()-startTime)/1000)+" Seconds");
	}

}
