package br.unb.cic.laico.regressionlab.data;

import br.unb.cic.laico.regressionlab.data.base.RandomDataGenerator;

public class LogarithmDataGenerator extends RandomDataGenerator {

	/**
	 * y = ln(x) + constant + error
	 * 
	 * @param constant
	 * @param maxAbsError
	 */
	public LogarithmDataGenerator(double constant, double maxAbsError) {
		super(constant, maxAbsError);
	}

	public void processSamples() {

		if (xSamples == null) {
			throw new IllegalStateException("Vector xSamples must be previously set.");
		}

		errorSamples = new double[xSamples.length];
		ySamples = new double[xSamples.length];
		for (int i = 0; i < xSamples.length; i++) {
			errorSamples[i] = generateRandomError();
			ySamples[i] = Math.log(xSamples[i]) + constant + errorSamples[i];
		}
	}

}
