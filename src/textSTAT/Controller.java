package textSTAT;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import corpus.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

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
	File[] corpus;
	List<String> corpusList;// List of path of corpus
	List<List> corpusTextList;//List of SentenceList
	List<Sentence> sentenceList;//List of Sentence
	ArrayList<String> wordList;//List of word of All Sentence
	
	@FXML
	TextField find;
	@FXML
	ListView<String> corpusListView;
	@FXML
	TableView<?> concordanceTable;
	@FXML
	TableColumn<?, String> left2, left1, foundword, right1, right2;

	@Override
	public void initialize(URL url, ResourceBundle rscb) {
		// TODO Auto-generated method stub
		fileChooser=new FileChooser();
		fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
		corpusProject=CorpusProject.getCorpusProject();
		sentenceList=new LinkedList<Sentence>();
		corpusTextList=new LinkedList<List>();
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
		corpusTextList.add(sentenceList);
	}
	public void callCorpus(){
		corpusProject.clearCorpus();
		corpusProject=CorpusProject.getCorpusProject();
	}
	public void getWords(){
		wordList=new ArrayList<String>();
		Iterator<List> itr=corpusTextList.iterator();
		for(int i=0; i<corpusTextList.size();i++){
			List<Sentence> currentSentenceList=itr.next();
			Iterator<Sentence> itr2=currentSentenceList.iterator();
			for(int j=0;j<currentSentenceList.size();j++){
				Sentence currentSentence=itr2.next();
				currentSentence.tokenizing(currentSentence.sentence);
				for(int k=0;k<currentSentence.word.length;k++){
					wordList.add(currentSentence.word[k]);
					System.out.println(currentSentence.word[k]);
				}
			}
		}
	}
	public void findWord(){
		getWords();
		String findword=find.getText();
		System.out.println(findword);
		Iterator<String> itr=wordList.iterator();
	}
}
