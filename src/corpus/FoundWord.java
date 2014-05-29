package corpus;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FoundWord {
	private StringProperty left2Word;
	private StringProperty left1Word;
	private StringProperty foundWord;
	private StringProperty right1Word;
	private StringProperty right2Word;
	
	public FoundWord(String left2, String left1, String word, String right1, String right2){
		this.left2Word= new SimpleStringProperty(left2);
		this.left1Word= new SimpleStringProperty(left1);
		this.foundWord= new SimpleStringProperty(word);
		this.right1Word= new SimpleStringProperty(right1);
		this.right2Word= new SimpleStringProperty(right2);
	}
	public StringProperty left2WordProperty(){
		return left2Word;
	}
	public StringProperty left1WordProperty(){
		return left1Word;
	}
	public StringProperty foundWordProperty(){
		return foundWord;
	}
	public StringProperty right1WordProperty(){
		return right1Word;
	}
	public StringProperty right2WordProperty(){
		return right2Word;
	}
}
