package ee.ut.math.tvt.XXX;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.Properties;

import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;

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
	static Logger log = Logger.getLogger(IntroUI.class.getName());

	private String buildNumber;


	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		
		// setup properties for log4j logger
		Properties props = new Properties();
		props.load(new FileInputStream("lib/log4j.properties"));
		PropertyConfigurator.configure(props);
		log.info("Launching IntroUI.");
		launch(args);
	}

	public void start(final Stage primaryStage) throws IOException {
		BorderPane bp = new BorderPane();
		GridPane gp = new GridPane();
		gp.setStyle("-fx-border-insets: 23; -fx-background-insets: 23;-fx-background-radius: 6;-fx-border-radius: 6;-fx-border-color: gray;-fx-border-style: solid;-fx-border-width: 1;-fx-effect: dropshadow(three-pass-box, rgba(100, 100, 100, 1), 24, 0.5, 0, 0);");

		// Intro windows logo
		Image img = new Image("file:resources/xxx.jpg");
		ImageView iv = new ImageView(img);
		iv.setFitWidth(500);
		iv.setFitHeight(120);
		
		// get  build.number from "version.properties"
		buildNumber = buildNumber(); 
		File file = new File("version.properties");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		StringBuffer stringBuffer = new StringBuffer();
		
		Label sNr = new Label("Software version number: " + buildNumber);
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
		gp.add(introData(), 0, 1);
		gp.add(sNr, 0, 2);
		bp.setCenter(gp);
		bp.setTop(close);
		BorderPane.setAlignment(close, Pos.TOP_RIGHT);

		Scene scene = new Scene(bp, 550, 270);
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.setTitle("Intro");
		primaryStage.show();
	}

	// get build nr
	private String buildNumber() throws IOException {
		String line = "";
		String buildRevNum = "";
		String buildMinNum = "";
		String buildMajNum = "";
		File file = new File("version.properties");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

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
		return sfNr;
	}

	// get data from application.prop
	private GridPane introData() throws IOException {
		GridPane iGP = new GridPane();
		String line = "";
		File vfile = new File("application.properties");
		FileReader vfileReader = new FileReader(vfile);
		BufferedReader vbufferedReader = new BufferedReader(vfileReader);
		int i = 0;
		while ((line = vbufferedReader.readLine()) != null) {
			Label data = new Label(line + "\n");
			iGP.add(data, 0, i);
			i++;
		}
		vfileReader.close();

		return iGP;
	}

}
