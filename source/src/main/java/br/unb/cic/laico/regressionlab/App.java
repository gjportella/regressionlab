package br.unb.cic.laico.regressionlab;

import br.unb.cic.laico.regressionlab.data.ExponentialDataGenerator;
import br.unb.cic.laico.regressionlab.data.LogarithmDataGenerator;
import br.unb.cic.laico.regressionlab.data.PolynomialDataGenerator;
import br.unb.cic.laico.regressionlab.data.PowerDataGenerator;
import br.unb.cic.laico.regressionlab.trend.ExponentialTrendLine;
import br.unb.cic.laico.regressionlab.trend.LogarithmTrendLine;
import br.unb.cic.laico.regressionlab.trend.PolynomialTrendLine;
import br.unb.cic.laico.regressionlab.trend.PowerTrendLine;

public class App {

	private double constant;
	private double maxAbsError;
	private double[] xSamples;

	public App() {
		this(0.0, 0.05, new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
	}

	public App(double constant, double maxAbsError, double[] xSamples) {
		this.constant = constant;
		this.maxAbsError = maxAbsError;
		this.xSamples = xSamples;
	}

	private double[] generateExponentialSamples() {

		ExponentialDataGenerator dataGenerator = new ExponentialDataGenerator(constant, maxAbsError);
		dataGenerator.setXSamples(xSamples);
		dataGenerator.processSamples();
		return dataGenerator.getYSamples();
	}

	private double[] generateLogarithmSamples() {

		LogarithmDataGenerator dataGenerator = new LogarithmDataGenerator(constant, maxAbsError);
		dataGenerator.setXSamples(xSamples);
		dataGenerator.processSamples();
		return dataGenerator.getYSamples();
	}

	private double[] generatePolynomialSamples(int degree) {

		PolynomialDataGenerator dataGenerator = new PolynomialDataGenerator(degree, constant, maxAbsError);
		dataGenerator.setXSamples(xSamples);
		dataGenerator.processSamples();
		return dataGenerator.getYSamples();
	}
	
	private double[] generatePowerSamples() {

		PowerDataGenerator dataGenerator = new PowerDataGenerator(constant, maxAbsError);
		dataGenerator.setXSamples(xSamples);
		dataGenerator.processSamples();
		return dataGenerator.getYSamples();
	}

	public double getExponentialExampleR2() {

		// Step 1: generating exponential samples
		double[] ySamples = generateExponentialSamples();

		// Step 2: running trend line and getting R2
		ExponentialTrendLine etl = new ExponentialTrendLine();
		etl.setValues(ySamples, xSamples);
		return etl.getRSquared();
	}

	public double getLogExampleR2() {

		// Step 1: generating exponential samples
		double[] ySamples = generateLogarithmSamples();

		// Step 2: running trend line and getting R2
		LogarithmTrendLine etl = new LogarithmTrendLine();
		etl.setValues(ySamples, xSamples);
		return etl.getRSquared();
	}

	public double getPolynomialExampleR2() {

		// Specific parameters
		int degree = 2;

		// Step 1: generating exponential samples
		double[] ySamples = generatePolynomialSamples(degree);

		// Step 2: running trend line and getting R2
		PolynomialTrendLine etl = new PolynomialTrendLine(degree);
		etl.setValues(ySamples, xSamples);
		return etl.getRSquared();
	}
	
	public double getPowerExampleR2() {

		// Step 1: generating exponential samples
		double[] ySamples = generatePowerSamples();

		// Step 2: running trend line and getting R2
		PowerTrendLine etl = new PowerTrendLine();
		etl.setValues(ySamples, xSamples);
		return etl.getRSquared();
	}
	
	public double getPolynomialExampleStandardErrorOfEstimate() {

		// Specific parameters
		int degree = 2;

		// Step 1: generating exponential samples
		double[] ySamples = generatePolynomialSamples(degree);

		// Step 2: running trend line and getting R2
		PolynomialTrendLine etl = new PolynomialTrendLine(degree);
		etl.setValues(ySamples, xSamples);
		return etl.getStandardErrorOfEstimate();
	}
}
