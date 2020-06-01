package application;

import java.util.function.Function;

import javafx.scene.chart.XYChart;

public class MyGraph {

	private XYChart<Double, Double> graph;

	public MyGraph(final XYChart<Double, Double> graph) {
		this.graph = graph;
	}

	public void plotLineL(final Function<Double, Double> function, double rangex,double vidstup) {
		final XYChart.Series<Double, Double> series = new XYChart.Series<Double, Double>();
		for (double x = -vidstup-rangex; x <= -vidstup+rangex; x = x + 0.01) {
			plotPoint(x, function.apply(x), series);
		}
		graph.getData().add(series);
	}
	public void plotLineR(final Function<Double, Double> function, double rangex,double vidstup) {
		final XYChart.Series<Double, Double> series = new XYChart.Series<Double, Double>();
		for (double x = vidstup-rangex; x <= vidstup+rangex; x = x + 0.01) {
			plotPoint(x, function.apply(x), series);
		}
		graph.getData().add(series);
	}
	
	private void plotPoint(final double x, final double y,
			final XYChart.Series<Double, Double> series) {
		series.getData().add(new XYChart.Data<Double, Double>(x, y));
	}

	public void clear() {
		graph.getData().clear();
	}
}