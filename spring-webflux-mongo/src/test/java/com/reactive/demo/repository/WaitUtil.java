package com.reactive.demo.repository;

public class WaitUtil {
	

	public static void sleep(long ms) {
		try
		{
			Thread.sleep(ms);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}