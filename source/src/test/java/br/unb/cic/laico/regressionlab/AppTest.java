package br.unb.cic.laico.regressionlab;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Exponential example R2 precision test.
	 */
	public void testExponentialR2() {
		
		App app = new App();
		double r2 = app.getExponentialExampleR2();
		assertTrue(r2 > 0.99);
	}
	
	/**
	 * Exponential example R2 precision test.
	 */
	public void testLogR2() {
		
		App app = new App();
		double r2 = app.getLogExampleR2();
		assertTrue(r2 > 0.99);
	}
	
	/**
	 * Polynomial example R2 precision test.
	 */
	public void testPolyR2() {
		
		App app = new App();
		double r2 = app.getPolynomialExampleR2();
		assertTrue(r2 > 0.99);
	}
	
	/**
	 * Power example R2 precision test.
	 */
	public void testPowerR2() {
		
		App app = new App();
		double r2 = app.getPowerExampleR2();
		assertTrue(r2 > 0.99);
	}
	
	/**
	 * Polynomial example R2 precision test.
	 */
	public void testPolyStandardErrorOfEstimate() {
		
		App app = new App();
		double stdError = app.getPolynomialExampleStandardErrorOfEstimate();
		assertTrue(stdError < 0.1);
	}
}
