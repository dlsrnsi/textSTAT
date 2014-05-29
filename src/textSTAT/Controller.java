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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Controller implements javafx.fxml.Initializable{
	FileChooser fileChooser;
	CorpusProject corpusProject;
	ObservableList<String> corpusPaths=FXCollections.observableArrayList();
	File[] corpus;
	List<String> corpusList;// List of path of corpus
	List<Sentence> sentenceList;//List of Sentence
	ArrayList<String> wordList;//List of word of All Sentence
	ObservableList<FoundWord> tableContent = FXCollections.observableArrayList();
	FoundWord concordance;
	
	@FXML
	TextField find;
	@FXML
	ListView<String> corpusListView;
	@FXML
	TableView<FoundWord> concordanceTable;
	@FXML
	TableColumn<FoundWord, String> left2, left1, foundword, right1, right2;

	@Override
	public void initialize(URL url, ResourceBundle rscb) {
		// TODO Auto-generated method stub
		fileChooser=new FileChooser();
		fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
		corpusProject=CorpusProject.getCorpusProject();
		sentenceList=new LinkedList<Sentence>();
		concordanceTable.setItems(tableContent);
		wordList=new ArrayList<String>();
		left2.setCellValueFactory(new PropertyValueFactory("left2Word"));
		left1.setCellValueFactory(new PropertyValueFactory("left1Word"));
		foundword.setCellValueFactory(new PropertyValueFactory("foundWord"));
		right1.setCellValueFactory(new PropertyValueFactory("right1Word"));
		right2.setCellValueFactory(new PropertyValueFactory("right2Word"));
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
			System.out.println(sentence.sentence);
			sentenceList.add(sentence);
		}
	}
	public void callCorpus(){
		corpusProject.clearCorpus();
		corpusProject=CorpusProject.getCorpusProject();
	}
	public void getWords(){
		wordList.clear();
		Iterator<Sentence> itr2=sentenceList.iterator();
		for(int j=0;j<sentenceList.size();j++){
			Sentence currentSentence=itr2.next();
			currentSentence.tokenizing(currentSentence.sentence);
			for(int k=0;k<currentSentence.word.length;k++){
				wordList.add(currentSentence.word[k]);
			}
		}
	}
	public void findWord(){
		tableContent.clear();
		String left2Word, left1Word,word,right1Word,right2Word;
		getWords();
		String wordToFind=find.getText();
		Iterator<String> worditr=wordList.listIterator();
		int indexNumber=0;
		int foundNumber=0;
		while(worditr.hasNext()){
			String currentWord=worditr.next();
			if(currentWord.contains(wordToFind)){
				word=wordList.get(indexNumber);
				left1Word=wordList.get(indexNumber-1);
				left2Word=wordList.get(indexNumber-2);
				right2Word=wordList.get(indexNumber+1);
				right1Word=wordList.get(indexNumber+2);
				concordance=new FoundWord(left2Word,left1Word,word,right1Word,right2Word);
				tableContent.add(concordance);
				foundNumber++;
			}
			indexNumber++;
		}
		System.out.println(foundNumber);
		//add FindNumber
		
	}
}
