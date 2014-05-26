package corpus;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextCorpus extends Corpus{
	File text;
	public TextCorpus(String dir){
		super.corpus=new File(dir);
	}
	@Override
	public void makeSentence(File corpus) throws IOException{
		BufferedReader bin=new BufferedReader(new FileReader(corpus));
		String line, line2;
		int sNum=0;
		while((line=bin.readLine())!=null){
			line.replaceAll("\\n", "");
			System.out.println(line);
		}
		
	}
}
