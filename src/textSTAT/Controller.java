package textSTAT;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import corpus.TextCorpus;

import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Controller implements javafx.fxml.Initializable{
	FileChooser fileChooser;
	@FXML
	ListView<String> corpusList;

	@Override
	public void initialize(URL url, ResourceBundle rscb) {
		// TODO Auto-generated method stub
		
	}
	public void openTextFile() throws IOException{
		
		Window window=new Stage();
		fileChooser=new FileChooser();
		fileChooser.setTitle("Choose txt File");
		File text=fileChooser.showOpenDialog(window);
		TextCorpus textCorpus=new TextCorpus(text.getPath());
		System.out.println(text.getPath());
		textCorpus.makeSentence(text);
	}

}
