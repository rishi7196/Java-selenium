package retryAnalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	
	public int retryCount=0;
	public static final int maxRetryCount=3;
	

	@Override
	public boolean retry(ITestResult result) {
		if(retryCount<maxRetryCount)
		{
			retryCount++;
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
