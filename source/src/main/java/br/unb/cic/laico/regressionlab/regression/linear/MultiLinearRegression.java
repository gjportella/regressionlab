package br.unb.cic.laico.regressionlab.regression.linear;

import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;

public class MultiLinearRegression {

	private OLSMultipleLinearRegression regression;
	
	public MultiLinearRegression() {
		this.regression = new OLSMultipleLinearRegression(); 
	}
	
	public void setSampleData(double[] y, double[][] x) {
		regression.newSampleData(y, x);
	}
	
	public double getRSquared() {
		return regression.calculateRSquared();
	}
	
	public double[] getCoefficients() {
		return regression.estimateRegressionParameters();
	}
	
	public double predict(double x[]) {
		double[] c = getCoefficients();
		double y = c[0];
		for (int i=1; i<c.length; i++) {
			y += c[i]*x[i-1];
		}
		return y;
	}
}
