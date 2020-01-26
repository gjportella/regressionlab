package br.unb.cic.laico.regressionlab.data.base;

import java.util.Random;

public abstract class RandomDataGenerator implements DataGenerator {

	protected double[] xSamples;
	protected double[] ySamples;
	protected double[] errorSamples;
	protected double constant;
	protected double maxAbsError;
	private Random random;

	protected RandomDataGenerator(double constant, double maxAbsError) {
		this.constant = constant;
		this.maxAbsError = maxAbsError;
		this.random = new Random(System.currentTimeMillis());
	}

	protected double generateRandomError() {
		double randomError = Math.abs(maxAbsError) * random.nextDouble();
		int remainder = ((int) (random.nextDouble() * 10D)) % 2;
		if (remainder == 0) {
			randomError = (-1D) * randomError;
		}
		return randomError;
	}

	public void setXSamples(double[] xSamples) {
		this.xSamples = xSamples;
	}

	public double[] getYSamples() {
		return ySamples;
	}

	public double[] getErrorSamples() {
		return errorSamples;
	}

	public abstract void processSamples();
}
