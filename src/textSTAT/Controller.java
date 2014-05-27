package textSTAT;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import corpus.*;

import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Controller implements javafx.fxml.Initializable{
	FileChooser fileChooser;
	CorpusProject corpusProject;
	
	@FXML
	ListView<String> corpusListView;

	@Override
	public void initialize(URL url, ResourceBundle rscb) {
		// TODO Auto-generated method stub
		fileChooser=new FileChooser();
		fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
		corpusProject=CorpusProject.getCorpusProject();
	}
	public void openTextFile() throws IOException{
		Window window=new Stage();
		fileChooser.setTitle("Choose txt File");
		File text=fileChooser.showOpenDialog(window);
		fileChooser.setInitialDirectory(text);
		TextCorpus textCorpus=new TextCorpus(text.getPath());
		System.out.println(text.getPath());
		textCorpus.makeCorpus(textCorpus.getCorpus());
		corpusProject.addCorpus(textCorpus.getCorpus());
		textCorpus.makeSentence(textCorpus.getCorpus());
		
	}

}
