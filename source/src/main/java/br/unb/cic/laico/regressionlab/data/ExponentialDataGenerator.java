package br.unb.cic.laico.regressionlab.data;

import br.unb.cic.laico.regressionlab.data.base.RandomDataGenerator;

public class ExponentialDataGenerator extends RandomDataGenerator {

	private double base;

	public ExponentialDataGenerator(double constant, double maxAbsError) {
		this(Math.E, constant, maxAbsError);
	}

	/**
	 * y = base ^ x + constant + error
	 * 
	 * @param base
	 * @param constant
	 * @param maxAbsError
	 */
	public ExponentialDataGenerator(double base, double constant, double maxAbsError) {
		super(constant, maxAbsError);
		if (base < 0) {
			throw new IllegalArgumentException("Base must be a double non negative value.");
		}
		this.base = base;
	}

	public void processSamples() {

		if (xSamples == null) {
			throw new IllegalStateException("Vector xSamples must be previously set.");
		}

		errorSamples = new double[xSamples.length];
		ySamples = new double[xSamples.length];
		for (int i = 0; i < xSamples.length; i++) {
			errorSamples[i] = generateRandomError();
			ySamples[i] = Math.pow(base, xSamples[i]) + constant + errorSamples[i];
		}
	}
}
