package ee.ut.math.tvt.xxx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class IntroUI extends Application {

	@Override
	public void start(Stage PrimaryStage) throws Exception {
		PrimaryStage.setTitle("Lab 3");
		PrimaryStage.setWidth(400);
	    PrimaryStage.setHeight(230);
		
		GridPane gp=new GridPane();
		Label tName=new Label("Team name: XXX");
		Label tLeader=new Label("Team leader: Allan Tsakuhhin");
		Label tLeadermail=new Label("Team leader email: allan.tsakuhhin@gmail.com");
		Label tMembers=new Label("Team members: Allan Tsakuhhin, Ingvar-Jörgen Kurruk, Dmitri Janis");
		Image img=new Image("http://www.seguinsheep.com/Triple_20X_1_.jpg",400,100,false,false);
		ImageView iv=new ImageView();
		iv.setImage(img);
		String nr=("");
		Label tSWVN=new Label("Software version nr: "+ nr);
		
		Group root = new Group();
		Scene scene=new Scene(root);
		gp.add(tName, 0, 0);
		gp.add(tLeader,0,1);
		gp.add(tLeadermail,0,2);
		gp.add(tMembers,0,3);
		gp.add(iv,0,4);
		gp.add(tSWVN,0,5);
		root.getChildren().add(gp);
		PrimaryStage.setScene(scene);
		PrimaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	
	
}
