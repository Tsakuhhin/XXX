package ee.ut.math.tvt.XXX;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import sun.misc.IOUtils;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class IntroUI extends Application {
	private String sfNr;

	public static void main(String[] args) {
		launch(args);
	}

	public void start(final Stage primaryStage) throws IOException {
		BorderPane bp = new BorderPane();

		GridPane gp = new GridPane();
		gp.setStyle("-fx-border-insets: 23; -fx-background-insets: 23;-fx-background-radius: 6;-fx-border-radius: 6;-fx-border-color: gray;-fx-border-style: solid;-fx-border-width: 1;-fx-effect: dropshadow(three-pass-box, rgba(100, 100, 100, 1), 24, 0.5, 0, 0);");

		// read data from file named "application.properties"
		String line = "";
		File vfile = new File("application.properties");
		FileReader vfileReader = new FileReader(vfile);
		BufferedReader vbufferedReader = new BufferedReader(vfileReader);
		StringBuffer vstringBuffer = new StringBuffer();
		int i = 0;
		while ((line = vbufferedReader.readLine()) != null) {
			Label data = new Label(line + "\n");
			gp.add(data, 0, i);
			i++;
		}
		vfileReader.close();
        
		// Into windows background logo
		Image img = new Image("file:resources/xxx.jpg");
		ImageView iv = new ImageView(img);
		iv.setFitWidth(500);
		iv.setFitHeight(120);
		
		// get  build.number from "version.properties"
		sfNr = null; 
		File file = new File("version.properties");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		StringBuffer stringBuffer = new StringBuffer();
		
		// get software version number parts
		String buildRevNum = "";
		String buildMinNum = "";
		String buildMajNum = "";
		while ((line = bufferedReader.readLine()) != null) {
			String[] split = line.split("=");
			if (split[0].equalsIgnoreCase("build.revision.number")) {
				buildRevNum = split[1];
			} else if (split[0].equalsIgnoreCase("build.minor.number")) {
				buildMinNum = split[1];
			} else if (split[0].equalsIgnoreCase("build.major.number")) {
				buildMajNum = split[1];
			}
			sfNr = buildMajNum + "." + buildMinNum + "." + buildRevNum;
		}
		fileReader.close();		
		
		Label sNr = new Label("Software version number: " + sfNr);
		Button close = new Button("close");
		close.setStyle("-fx-text-fill: #242d35;-fx-font-size: 10px;-fx-background-insets: 0 0 0 0,0,0;");

		// Window close action
		close.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				primaryStage.close();
			}
		});
		
		// window properties
		gp.add(iv, 0, 0);
		gp.add(sNr, 0, 5);
		bp.setCenter(gp);
		bp.setTop(close);
		BorderPane.setAlignment(close, Pos.TOP_RIGHT);

		Scene scene = new Scene(bp, 550, 270);
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.setTitle("Intro");
		primaryStage.show();
	}
	

	
}
