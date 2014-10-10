package ee.ut.math.tvt.XXX;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.Scanner;

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

	public void start(Stage primaryStage) throws IOException {
		BorderPane bp = new BorderPane();

		GridPane gp = new GridPane();
		gp.setStyle("-fx-border-insets: 23; -fx-background-insets: 23;-fx-background-radius: 6;-fx-border-radius: 6;-fx-border-color: gray;-fx-border-style: solid;-fx-border-width: 1;-fx-effect: dropshadow(three-pass-box, rgba(100, 100, 100, 1), 24, 0.5, 0, 0);");

		/*
		Label tName = new Label("Team name: XXX");
		Label tLeader = new Label("Team leader: Allan Tsakuhhin");
		String email = ("allan.tsakuhhin@gmail.com");
		Label tEmail = new Label("Team leader email: " + email);
		String members = ("Allan Tsakuhhin," + " Ingvar-Jorgen Kurruk,"
				+ " Dmitri Janis");
		Label tMembers = new Label("Team members: " + members);
		*/
		
		// failist application.properties andmete lugemine
		BufferedReader reader = new BufferedReader (new FileReader("application.properties"));
		StringBuilder out = new StringBuilder();
		String line = reader.readLine();
		while (line != null){
			int i = 1;
			out.append(line);
			out.append(System.lineSeparator());
			Label data = new Label(out.toString());
			gp.add(data, 0, i);
			line = reader.readLine();
			i = i+1;	
		}
        reader.close();
		
        
		Image img = new Image("file:resources/xxx.jpg");
		ImageView iv = new ImageView(img);
		iv.setFitWidth(500);

		iv.setFitHeight(120);
		sfNr = (""); // get from file
		Label sNr = new Label("Software version number: " + sfNr);
		Button close = new Button("close");
		close.setStyle("-fx-text-fill: #242d35;-fx-font-size: 10px;-fx-background-insets: 0 0 0 0,0,0;");

		/*
		close.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.close();
			}
		});
		/*
		 
		
		/*
		gp.add(info, 0, 1);
		gp.add(tLeader, 0, 2);
		gp.add(tEmail, 0, 3);
		gp.add(tMembers, 0, 4);
		*/
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
