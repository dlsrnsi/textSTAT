package corpus;
import java.util.StringTokenizer; 


public class Sentence {
	String name=" ";
	public String sentence;
	public String[] word;
	public int sNum;
	public Sentence(String sentence, int sNum){
		this.sentence=sentence;
		this.sNum=sNum;
		}
	public void tokenizing(String sent){
		StringTokenizer st = new StringTokenizer(sent," ");
		word=new String[st.countTokens()];
		int i=0;
		while(st.hasMoreTokens()){
			word[i]=st.nextToken();
			i++;
		}
		
	}

}
