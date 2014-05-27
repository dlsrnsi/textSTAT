package corpus;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class TextCorpus implements Corpus{
	private File corpus;
	List<Sentence> sentenceList;
	public TextCorpus(String dir){
		setCorpus(new File(dir));
		sentenceList=new LinkedList<Sentence>();
	}
	@Override
	public void makeCorpus(File text) throws IOException{
		FileWriter fw=new FileWriter(text.getName().replace(".txt", "")+"_textCorpus.txt");
		BufferedWriter out=new BufferedWriter(fw);
		BufferedReader bin=new BufferedReader(new FileReader(text));
		String Line;
		int sNum=0;
		while((Line=bin.readLine())!=null){//which remove new line command		
			System.out.println(Line);
			out.write(Line);
			out.write(" ");
		}
		out.close();
	}
	@Override
	public void makeSentence(File text) throws IOException {
		BufferedWriter out=new BufferedWriter(new FileWriter(text.getName().replace(".txt", "")+"_textCorpusS.txt"));
		System.out.println(text.getPath().replace(".txt", "")+"_textCorpus.txt");
		File readFile=new File(text.getPath().replace(".txt", "")+"_textCorpus.txt");
		BufferedReader bin=new BufferedReader(new FileReader(readFile));
		int sNum=0;
		String Line;
		while((Line=bin.readLine())!=null){
			String[] sentenced=Line.split(regex);
			for(int i=0; i<sentenced.length;i++){
				out.write(sentenced[i]);
				out.newLine();
				Sentence sentence=new Sentence(sentenced[i],sNum);
				sNum++;
				System.out.println(sentenced[i]);
				sentenceList.add(sentence);
			}
		}
		out.close();
	}
	public File getCorpus() {
		return corpus;
	}
	public void setCorpus(File corpus) {
		this.corpus = corpus;
	}
}
