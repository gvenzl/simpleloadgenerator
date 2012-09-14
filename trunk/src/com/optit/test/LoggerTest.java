package com.optit.test;

import junit.framework.TestCase;

import org.junit.Test;

import com.optit.logger.Logger;

/**
 * @author gvenzl
 *
 */
public class LoggerTest extends TestCase
{
	@Test
	public void test_logEmpty() throws Exception
	{
		System.out.println("Test logger new line");
		Logger.log();
	}
	
	@Test
	public void test_logNotEmpty() throws Exception
	{
		System.out.println("Test logger output");
		Logger.log("Testline test test test");
	}
	
	@Test
	public void test_logErr() throws Exception
	{
		System.out.println("Test logger to error output");
		Logger.logErr("Testline error error error");
	}
	
	@Test
	public void test_logTimed() throws Exception
	{
		System.out.println("Test logger with timing output");
		Logger.logTimed("Testline test test test");
		Logger.logTimed("Second test line test test test");
	}
	
	@Test
	public void test_setDebug() throws Exception
	{
		Logger.setDebug(true);
	}
	
	@Test
	public void test_logDebug() throws Exception
	{
		Logger.setDebug(true);
		Logger.logDebug("This is a DEBUG OUTPUT!");
	}
}
