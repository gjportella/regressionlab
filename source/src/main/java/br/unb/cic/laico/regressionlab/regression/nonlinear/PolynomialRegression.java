package br.unb.cic.laico.regressionlab.regression.nonlinear;

import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class PolynomialRegression {

	private PolynomialCurveFitter fitter;
	private double[] x;
	private double[] y;
	private double[] coeff;

	public PolynomialRegression(int order) {
		this.fitter = PolynomialCurveFitter.create(order);
	}

	public void setSampleData(double[] x, double[] y) throws IllegalArgumentException {

		if (x == null || y == null || x.length != y.length) {
			throw new IllegalArgumentException("Invalid sample data.");
		}

		this.x = x;
		this.y = y;

		WeightedObservedPoints obs = new WeightedObservedPoints();
		for (int i = 0; i < y.length; i++) {
			obs.add(x[i], y[i]);
		}
		coeff = fitter.fit(obs.toList());
	}

	public double[] getCoefficients() {
		return this.coeff;
	}

	public double getRSquared() {

		double[] predictedValues = new double[x.length];
		double residualSumOfSquares = 0d;
		DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();

		for (int i = 0; i < x.length; i++) {
			predictedValues[i] = predict(x[i]);
			residualSumOfSquares += Math.pow((predictedValues[i] - y[i]), 2);
			descriptiveStatistics.addValue(y[i]);
		}

		final double avgActualValues = descriptiveStatistics.getMean();
		double totalSumOfSquares = 0d;
		for (int i = 0; i < x.length; i++) {
			totalSumOfSquares += Math.pow((predictedValues[i] - avgActualValues), 2);
		}
		return 1.0 - (residualSumOfSquares / totalSumOfSquares);
	}

	public double predict(double x) {
		double y = 0;
		for (int i = 0; i < coeff.length; i++) {
			y += coeff[i] * Math.pow(x, i);
		}
		return y;
	}
}
