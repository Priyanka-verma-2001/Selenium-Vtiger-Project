package testng_extra;

import org.testng.annotations.Test;

public class EnabledOrgTest {
	
	@Test(enabled = false)
	public void createThreadPoolOrgTest()
	{
		System.out.println("created Thread Pool size of Org Test");
	}
	
	@Test(invocationCount = 2)
	public void modifiedThreadPoolOrgTest()
	{
		System.out.println("modified Thread Pool size of Org Test");
	}
	
	@Test(dependsOnMethods="modifiedThreadPoolOrgTest",invocationCount=1, alwaysRun =true)
	public void deletedThreadPoolOrgTest()
	{
		System.out.println("deleted Thread Pool size of Org Test");
	}

}
