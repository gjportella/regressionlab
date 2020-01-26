package br.unb.cic.laico.regressionlab;

import java.util.Arrays;

import br.unb.cic.laico.regressionlab.trend.ExponentialTrendLine;
import br.unb.cic.laico.regressionlab.trend.LogarithmTrendLine;
import br.unb.cic.laico.regressionlab.trend.PolynomialTrendLine;
import br.unb.cic.laico.regressionlab.trend.PowerTrendLine;

public class TrendDummyApp {

	private static void playPolynomial() {
		
		/* Polynomial example: y = 7 + 3*x + x^2 */
		int degree = 2;
		double[] xSamples = new double[] { 1,  2,  3,  4,  5,  6,  7,  8,    9 };
		double[] ySamples = new double[] { 11, 17, 25, 35, 47, 61, 77, 95, 115 };

		PolynomialTrendLine p = new PolynomialTrendLine(degree);
		p.setValues(ySamples, xSamples);
		double[] coefs = p.getCoefs();
		
		/* Should print coefficients: 7, 3 and 1. */
		System.out.println("Polynomial: y = 7 + 3*x + x^2");
		System.out.println("Coefficients: " + Arrays.toString(coefs));
	}
	
	private static void playExponential() {
		
		/* Exponential example: y = e^(3 + x) */
		double[] xSamples = new double[] {  1.000,   2.000,   3.000,    4.000,    5.000,    6.000,     7.000,     8.000,      9.000 };
		double[] ySamples = new double[] { 54.598, 148.413, 403.429, 1096.633, 2980.958, 8103.084, 22026.466, 59874.142, 162754.791 };

		ExponentialTrendLine p = new ExponentialTrendLine();
		p.setValues(ySamples, xSamples);
		double[] coefs = p.getCoefs();
		
		/* Should print coefficients: 3 and 1. */
		System.out.println("Exponential: y = e^(3 + x)");
		System.out.println("Coefficients: " + Arrays.toString(coefs));
	}
	
	private static void playLogarithm() {
		
		/* Logarithm example: y = 3 + 2*ln(x) */
		double[] xSamples = new double[] { 1.000, 2.000, 3.000, 4.000, 5.000, 6.000, 7.000, 8.000, 9.000 };
		double[] ySamples = new double[] { 3.000, 4.386, 5.197, 5.773, 6.219, 6.584, 6.892, 7.159, 7.394 };

		LogarithmTrendLine p = new LogarithmTrendLine();
		p.setValues(ySamples, xSamples);
		double[] coefs = p.getCoefs();
		
		/* Should print coefficients: 3 and 2. */
		System.out.println("Logarithm: y = 3 + 2*ln(x)");
		System.out.println("Coefficients: " + Arrays.toString(coefs));
	}

	private static void playPower() {
		
		/* Power example: y = 7*x^3 */
		double[] xSamples = new double[] { 1,  2,   3,   4,   5,    6,    7,    8,    9 };
		double[] ySamples = new double[] { 7, 56, 189, 448, 875, 1512, 2401, 3584, 5103 };

		PowerTrendLine p = new PowerTrendLine();
		p.setValues(ySamples, xSamples);
		double[] coefs = p.getCoefs();
		
		/* Should print coefficients: 7 and 3. */
		System.out.println("Power: y = 7*x^3");
		System.out.println("Coefficients: " + Arrays.toString(coefs));
	}
	
	public static void main(String[] args) {

		playPolynomial();
		playExponential();
		playLogarithm();
		playPower();
	}
}
