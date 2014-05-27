package textSTAT;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import corpus.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Controller implements javafx.fxml.Initializable{
	FileChooser fileChooser;
	CorpusProject corpusProject;
	ObservableList<String> corpusPaths=FXCollections.observableArrayList();
	List<String> corpusList;
	List<Sentence> sentenceList;
	String[] arr;
	
	@FXML
	ListView<String> corpusListView;
	@FXML
	TableView<?> concordanceTable;
	@FXML
	TableColumn<ObservableValue, String> left2, left1, foundword, right1, right2;

	@Override
	public void initialize(URL url, ResourceBundle rscb) {
		// TODO Auto-generated method stub
		fileChooser=new FileChooser();
		fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
		corpusProject=CorpusProject.getCorpusProject();
		sentenceList=new LinkedList<Sentence>();
	}
	public void openTextFile() throws IOException{
		Window window=new Stage();
		window.centerOnScreen();
		fileChooser.setTitle("Choose txt File");
		File text=fileChooser.showOpenDialog(window);
		TextCorpus textCorpus=new TextCorpus(text.getPath());
		System.out.println(text.getPath());
		textCorpus.makeCorpus(textCorpus.getCorpus());
		corpusProject.addCorpus(textCorpus.getCorpus());
		textCorpus.makeSentence(textCorpus.getCorpus());
		corpusPaths.add(text.getPath());
		corpusListView.setItems(corpusPaths);
		List<Sentence> sentenceInText=textCorpus.getSentenceList();
		Iterator<Sentence> itr=sentenceInText.iterator();
		while(itr.hasNext()){
			Sentence sentence=itr.next();
			sentenceList.add(sentence);
		}
	}
}
