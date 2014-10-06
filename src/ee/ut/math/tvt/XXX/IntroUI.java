package ee.ut.math.tvt.XXX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class IntroUI extends Application{

	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage){
		GridPane gp=new GridPane();
		Label tName=new Label("Team name: XXX");
		Label tLeader=new Label("Team leader: Allan Tsakuhhin");
		String email=("allan.tsakuhhin@gmail.com");
		Label tEmail= new Label("Team leader email: "+ email);
		String members=("Allan Tsakuhhin,"+" Ingvar-Jörgen Kurruk,"+" Dmitri Janis");
		Label tMembers= new Label("Team members: "+ members);
		Image img=new Image("http://www.seguinsheep.com/Triple_20X_1_.jpg");
		ImageView iv=new ImageView(img);
		iv.setFitWidth(500);
		iv.setFitHeight(200);
		String sfNr=("");
		Label sNr=new Label("Software version number: "+sfNr);
		
		gp.add(tName,0,0);
		gp.add(tLeader,0,1);
		gp.add(tEmail, 0, 2);
		gp.add(tMembers,0,3);
		gp.add(iv,0,4);
		gp.add(sNr,0,5);
		
		Scene scene=new Scene(gp,500,320);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Intro");
		primaryStage.show();
		
	}
}
