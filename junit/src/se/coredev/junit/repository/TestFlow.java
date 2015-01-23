package se.coredev.junit.repository;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestFlow
{
	private Collection<String> stringValues;

	@BeforeClass
	public static void setupClass()
	{
		System.out.println("BeforeClass");
	}
	
	@AfterClass
	public static void teardownClass()
	{
		System.out.println("AfterClass");
	}
	
	@Before
	public void setup()
	{
		System.out.println("Before");
		stringValues = new ArrayList<>();
		stringValues.add("one");
		stringValues.add("two");
		stringValues.add("three");
	}

	@After
	public void teardown()
	{
		System.out.println("After");
		stringValues = null;
	}
	
	@Test
	public void test1()
	{
		System.out.println("test1 method");
	}

	@Test
	public void test2()
	{
		System.out.println("test2 method");
	}

}
