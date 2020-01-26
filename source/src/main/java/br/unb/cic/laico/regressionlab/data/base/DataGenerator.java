package br.unb.cic.laico.regressionlab.data.base;

public interface DataGenerator {

	void setXSamples(double[] xSamples);

	double[] getYSamples();

	void processSamples();
}
