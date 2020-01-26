package br.unb.cic.laico.regressionlab.data;

import br.unb.cic.laico.regressionlab.data.base.RandomDataGenerator;

public class PowerDataGenerator extends RandomDataGenerator {

	private static final int DEFAULT_DEGREE = 1;

	private int degree;

	public PowerDataGenerator(double constant, double maxAbsError) {
		this(DEFAULT_DEGREE, constant, maxAbsError);
	}

	/**
	 * y = x ^ degree + constant + error
	 * 
	 * @param degree
	 * @param constant
	 * @param maxAbsError
	 */
	public PowerDataGenerator(int degree, double constant, double maxAbsError) {
		super(constant, maxAbsError);
		if (degree < 0) {
			throw new IllegalArgumentException("Degree must be an integer non negative value.");
		}
		this.degree = degree;
	}

	public void processSamples() {

		if (xSamples == null) {
			throw new IllegalStateException("Vector xSamples must be previously set.");
		}

		errorSamples = new double[xSamples.length];
		ySamples = new double[xSamples.length];
		for (int i = 0; i < xSamples.length; i++) {

			errorSamples[i] = generateRandomError();
			ySamples[i] = Math.pow(xSamples[i], degree) + constant + errorSamples[i];
		}
	}
}
