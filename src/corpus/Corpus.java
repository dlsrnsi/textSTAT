package corpus;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public interface Corpus {
	final String regex="(\\.|!|\\?)+\"?\\s+";//which split whole text as sentence
	final String regex2="<.*>.*</.*>";// which remove XML 
	final String regex3="\\s*"; //which remove empty sentence 
	LinkedList<Sentence> sentencestore=new LinkedList<Sentence>();
	public void makeCorpus(File corpus) throws IOException;
	public void makeSentence(File corpus) throws IOException;
	

}
