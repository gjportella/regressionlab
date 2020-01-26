package br.unb.cic.laico.regressionlab;

import java.util.Arrays;

import br.unb.cic.laico.regressionlab.data.ExponentialDataGenerator;
import br.unb.cic.laico.regressionlab.data.LogarithmDataGenerator;
import br.unb.cic.laico.regressionlab.data.PolynomialDataGenerator;
import br.unb.cic.laico.regressionlab.regression.linear.MultiLinearRegression;
import br.unb.cic.laico.regressionlab.regression.linear.SimpleLinearRegression;
import br.unb.cic.laico.regressionlab.regression.nonlinear.PolynomialRegression;

public class OldApp {

	private static void playSimpleRegressionExample() {

		System.out.println("Simple Linear Regression Example");
		
		double[] x = new double[] { 82, 92.5, 83.2, 97.7, 131.9, 141.3, 165.4, 140, 126.7, 97.8, 86.2, 99.6, 87, 97.5, 88.2, 102.7, 123, 146.3, 160, 145, 131.7, 118, 91.2, 104.6 };
		double[] y = new double[] { 15, 25, 17, 28, 41, 47, 50, 46, 37, 22, 20, 30, 14, 27, 14, 30, 43, 49, 49, 44, 39, 36, 20, 32 };
		
		SimpleLinearRegression r = new SimpleLinearRegression();
		r.setSampleData(x, y);
		
		double[] coefficients = r.getCoefficients();
		System.out.println("Coefficients: " + Arrays.toString(coefficients));
		System.out.println("R2 = " + Double.toString(r.getRSquared()));

		double newX = 200;
		System.out.println("f(x=" + Double.toString(newX) + ") = " + Double.toString(r.predict(newX)));
	}

	private static void playMultiLinearRegressionExample() {

		System.out.println("Multi Linear Regression Example");

		double[] y = new double[] { 0.12, 0.239, 0.479, 0.958, 2.394, 0.067, 0.133, 0.266, 0.532, 0.105, 0.209, 0.419,
				0.838, 1.675, 0.105, 0.21, 0.42, 0.84, 1.68 };

		double[][] x = new double[19][];
		x[0] = new double[] { 2, 8, 6.5 };
		x[1] = new double[] { 4, 16, 13 };
		x[2] = new double[] { 8, 32, 26 };
		x[3] = new double[] { 16, 64, 53.5 };
		x[4] = new double[] { 40, 160, 124.5 };
		x[5] = new double[] { 1, 3.75, 3 };
		x[6] = new double[] { 2, 7.5, 6.5 };
		x[7] = new double[] { 4, 15, 13 };
		x[8] = new double[] { 8, 30, 26 };
		x[9] = new double[] { 2, 3.75, 8 };
		x[10] = new double[] { 4, 7.5, 16 };
		x[11] = new double[] { 8, 15, 31 };
		x[12] = new double[] { 16, 30, 62 };
		x[13] = new double[] { 36, 60, 132 };
		x[14] = new double[] { 2, 3.75, 7 };
		x[15] = new double[] { 4, 7.5, 14 };
		x[16] = new double[] { 8, 15, 28 };
		x[17] = new double[] { 16, 30, 55 };
		x[18] = new double[] { 32, 60, 108 };
		
		MultiLinearRegression r = new MultiLinearRegression();
		r.setSampleData(y, x);
		
		double[] coefficients = r.getCoefficients();
		System.out.println("Coefficients: " + Arrays.toString(coefficients));
		System.out.println("R2 = " + Double.toString(r.getRSquared()));
		
		double[] newX = new double[] {32, 60, 108};
		double newY = r.predict(newX);
		System.out.println("f(x="
				+ Double.toString(newX[0]) + ","
				+ Double.toString(newX[1]) + ","
				+ Double.toString(newX[2]) + ") = "
				+ Double.toString(newY));
	}
	
	private static void playPolynomialRegressionExample() {
		
		System.out.println("Polynomial Regression Example");
		
		double[] x = new double[] { 82, 92.5, 83.2, 97.7, 131.9, 141.3, 165.4, 140, 126.7, 97.8, 86.2, 99.6, 87, 97.5, 88.2, 102.7, 123, 146.3, 160, 145, 131.7, 118, 91.2, 104.6 };
		double[] y = new double[] { 15, 25, 17, 28, 41, 47, 50, 46, 37, 22, 20, 30, 14, 27, 14, 30, 43, 49, 49, 44, 39, 36, 20, 32 };
		
		PolynomialRegression r = new PolynomialRegression(1);
		r.setSampleData(x, y);
		
		double[] coefficients = r.getCoefficients();
		System.out.println("Coefficients: " + Arrays.toString(coefficients));
		System.out.println("R2 = " + Double.toString(r.getRSquared()));

		double newX = 200;
		System.out.println("f(x=" + Double.toString(newX) + ") = " + Double.toString(r.predict(newX)));		
	}
	
	private static void playExponentialDataGenerator() {
		
		System.out.println("Exponential Data Generator");
		
		double base = 2;
		double constant = 0;
		double error = 0.5;
		double[] xSamples = new double[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		ExponentialDataGenerator edg = new ExponentialDataGenerator(base, constant, error);
		edg.setXSamples(xSamples);
		edg.processSamples();
		double[] ySamples = edg.getYSamples();
		double[] errorSamples = edg.getErrorSamples();
		
		System.out.println("Base: " + Double.toString(base));
		System.out.println("Constant: " + Double.toString(constant));
		System.out.println("Error: " + Double.toString(error));
		System.out.println("X Samples: " + Arrays.toString(xSamples));
		System.out.println("Y Samples: " + Arrays.toString(ySamples));
		System.out.println("Error Samples: " + Arrays.toString(errorSamples));
	}
	
	private static void playLogDataGenerator() {
		
		System.out.println("Logarithm Data Generator");
		
		double constant = 0;
		double error = 0.5;
		double[] xSamples = new double[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		LogarithmDataGenerator ldg = new LogarithmDataGenerator(constant, error);
		ldg.setXSamples(xSamples);
		ldg.processSamples();
		double[] ySamples = ldg.getYSamples();
		double[] errorSamples = ldg.getErrorSamples();
		
		System.out.println("Constant: " + Double.toString(constant));
		System.out.println("Error: " + Double.toString(error));
		System.out.println("X Samples: " + Arrays.toString(xSamples));
		System.out.println("Y Samples: " + Arrays.toString(ySamples));
		System.out.println("Error Samples: " + Arrays.toString(errorSamples));
	}
	
	private static void playPolyDataGenerator() {
		
		System.out.println("Polynomial Data Generator");
		
		int degree = 2;
		double constant = 0;
		double error = 0;
		double[] xSamples = new double[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		PolynomialDataGenerator pdg = new PolynomialDataGenerator(degree, constant, error);
		pdg.setXSamples(xSamples);
		pdg.processSamples();
		double[] ySamples = pdg.getYSamples();
		double[] errorSamples = pdg.getErrorSamples();
		
		System.out.println("Degree: " + Integer.toString(degree));
		System.out.println("Constant: " + Double.toString(constant));
		System.out.println("Error: " + Double.toString(error));
		System.out.println("X Samples: " + Arrays.toString(xSamples));
		System.out.println("Y Samples: " + Arrays.toString(ySamples));
		System.out.println("Error Samples: " + Arrays.toString(errorSamples));
	}
	
	public static void main(String[] args) {

		playSimpleRegressionExample();
		playMultiLinearRegressionExample();
		playPolynomialRegressionExample();
		playExponentialDataGenerator();
		playLogDataGenerator();
		playPolyDataGenerator();
	}
}
