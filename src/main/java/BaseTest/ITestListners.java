package BaseTest;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListners implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getTestContext().getName()+ "_" +result.getMethod().getMethodName());
		
		ITestListener.super.onTestFailure(result);
	}
	
	
	

}
