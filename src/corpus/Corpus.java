package corpus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Corpus {
	File corpus;
	final String regex="(\\.|!|\\?)+\"?(?=\\s))";
	final String regex2="<.*>.*</.*>";
	final String regex3="\\s*";
	LinkedList<Sentence> sentencestore=new LinkedList<Sentence>();
	public void makeSentence(File corpus) throws IOException{
		BufferedWriter out=new BufferedWriter(new FileWriter("String.txt"));
		BufferedReader bin=new BufferedReader(new FileReader(corpus));
		String Line;
		int sNum=0;
		while((Line=bin.readLine())!=null){
			Line.replaceAll(System.getProperty("line.seperator")," ");		
			System.out.println(Line);
			out.write(Line);
		}
		out.close();
		
	}
	

}
