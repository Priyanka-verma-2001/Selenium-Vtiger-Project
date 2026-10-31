package testng_extra;

import org.testng.annotations.Test;

public class ThreadPoolOrgTest {
	
	@Test(invocationCount = 3, threadPoolSize=3)
	public void createThreadPoolOrgTest()
	{
		System.out.println("created Thread Pool size of Org Test");
	}
	
	@Test(invocationCount = 2)
	public void modifiedThreadPoolOrgTest()
	{
		System.out.println("modified Thread Pool size of Org Test");
	}
	
	@Test(invocationCount=1)
	public void deletedThreadPoolOrgTest()
	{
		System.out.println("deleted Thread Pool size of Org Test");
	}

}
