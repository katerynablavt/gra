package application;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Function;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.LineChart;

import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;

public class MainAppController implements Initializable {

	@FXML
	private LineChart<Double, Double> lineGraph;

	@FXML
	private AreaChart<Double, Double> areaGraph;

	@FXML
	private Button lineGraphButton;

	@FXML
	private Button areaGraphButton;

	@FXML
	private Button xyButton;

//	@FXML
//	private Button xyButton2;
//
//	@FXML
//	private Button squaredButton;
//
//	@FXML
//	private Button squaredButton2;
//
//	@FXML
//	private Button cubedButton;
//
//	@FXML
//	private Button cubedButton2;

	@FXML
	private Button clearButton;
	
	@FXML
	private Button saveButton;
	
	private MyGraph mathsGraph;
	private MyGraph areaMathsGraph;

	public void initialize(final URL url, final ResourceBundle rb) {
		mathsGraph = new MyGraph(lineGraph);
		areaMathsGraph = new MyGraph(areaGraph);
	}
	@FXML
	private void handleLineGraphButtonAction(final ActionEvent event) {
		lineGraph.setVisible(true);
		areaGraph.setVisible(false);
	}

	@FXML
	private void handleAreaGraphButtonAction(final ActionEvent event) {
		areaGraph.setVisible(true);
		lineGraph.setVisible(false);
	}

	@FXML
	private void handleXYButtonAction(final ActionEvent event) {

		plotLineL(x->0.25*(3+ Math.sqrt(-16*Math.pow(x, 2)-16*x+1)),0.5,0.5);
		plotLineR(x->0.25*(3+ Math.sqrt(-16*Math.pow(x, 2)+16*x+1)),0.5,0.5);
		plotLineL(x->-0.8*x-1,0.25,0.25);
		plotLineR(x->0.8*x-1,0.25,0.25);
		plotLineL(x->-x-1.1,0.05,0.55);
		plotLineR(x->x-1.1,0.05,0.55);
		plotLineL(x->-1.25*x-1.25,0.2,0.8);
		plotLineR(x->1.25*x-1.25,0.2,0.8);
		
		plotLineR(x->-5*x+6,0.05,1.05);
		plotLineR(x->5*x-5,0.05,1.05);
		plotLineL(x->-5*x-5,0.05,1.05);
		plotLineL(x->5*x+6,0.05,1.05);
	}

	
	private void plotLineL(Function<Double, Double> function, double range, double vidstup) {
		if (lineGraph.isVisible()) {
			mathsGraph.plotLineL(function,range,vidstup);
		} else {
			areaMathsGraph.plotLineL(function,range, vidstup);
		}
	}
	private void plotLineR(Function<Double, Double> function, double range, double  vidstup) {
		if (lineGraph.isVisible()) {
			mathsGraph.plotLineR(function,range, vidstup);
		} else {
			areaMathsGraph.plotLineR(function,range, vidstup);
		}
	}

//	@FXML
//	private void handleXYButton2Action(final ActionEvent event) {
//		plotLine(x -> x - 3);
//	}
//
//	@FXML
//	private void handleSquaredButtonAction(final ActionEvent event) {
//		plotLine(x -> Math.pow(x, 2));
//	}
//
//	@FXML
//	private void handleSquaredButton2Action(final ActionEvent event) {
//		plotLine(x -> Math.pow(x, 2) + 2);
//	}
//
//	@FXML
//	private void handleCubedButtonAction(final ActionEvent event) {
//		plotLine(x -> Math.pow(x, 3));
//	}
//
//	@FXML
//	private void handleCubedButton2Action(final ActionEvent event) {
//		plotLine(x -> Math.pow(x - 3, 3) - 1);
//	}

	@FXML
	private void handleClearButtonAction(final ActionEvent event) {
		clear();
	}
	
	@FXML
	private void handleSaveButtonAction(final ActionEvent event) {
		
		WritableImage image = areaGraph.snapshot(new SnapshotParameters(), null);
	     File file = new File("C:\\Users\\Owner\\Desktop\\snapshot.jpg");

	    try {
	        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "jpg", file);
	    } catch (IOException e) {
	    	System.out.println("snapshot eror! " );
	    }
	
	        System.out.println("snapshot saved:) on the desktop " );
		    System.exit(0);
	}

	private void clear() {
		if (lineGraph.isVisible()) {
			mathsGraph.clear();
		} else {
			areaMathsGraph.clear();
		}
	}


	
}
