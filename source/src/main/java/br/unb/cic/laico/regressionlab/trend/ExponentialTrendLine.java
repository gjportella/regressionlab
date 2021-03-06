package br.unb.cic.laico.regressionlab.trend;

import br.unb.cic.laico.regressionlab.trend.base.OLSTrendLine;

public class ExponentialTrendLine extends OLSTrendLine {

	@Override
	protected double[] xVector(double x) {
		return new double[] { 1, x };
	}

	@Override
	protected boolean logY() {
		return true;
	}
}
