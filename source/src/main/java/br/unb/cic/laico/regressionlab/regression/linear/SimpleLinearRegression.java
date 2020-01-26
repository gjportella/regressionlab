package br.unb.cic.laico.regressionlab.regression.linear;

import org.apache.commons.math3.stat.regression.SimpleRegression;

public class SimpleLinearRegression {

	private SimpleRegression regression;

	public SimpleLinearRegression() {
		this.regression = new SimpleRegression();
	}

	public void setSampleData(double[] x, double[] y) throws IllegalArgumentException {

		if (x == null || y == null || x.length != y.length) {
			throw new IllegalArgumentException("Invalid sample data.");
		}

		for (int i = 0; i < x.length; i++) {
			regression.addData(x[i], y[i]);
		}
	}

	public double[] getCoefficients() {

		double[] coefficients = new double[2];
		coefficients[0] = regression.getIntercept();
		coefficients[1] = regression.getSlope();
		return coefficients;
	}

	public double getIntercept() {
		return regression.getIntercept();
	}

	public double getSlope() {
		return regression.getSlope();
	}

	public double getRSquared() {
		return regression.getRSquare();
	}

	public double predict(double x) {
		return regression.predict(x);
	}

	public String toString() {
		return "x = " + Double.toString(regression.getSlope()) + " * y + "
				+ Double.toString(regression.getIntercept());
	}
}
