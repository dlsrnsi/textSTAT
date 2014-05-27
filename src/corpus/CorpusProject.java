package corpus;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class CorpusProject {
	private static CorpusProject corpusProject;
	private List<File> corpusList;
	private CorpusProject(){
		corpusList=new LinkedList<File>();
	}
	public static CorpusProject getCorpusProject(){
		if(corpusProject==null){
			corpusProject=new CorpusProject();
			
		}
		return corpusProject;
	}
	public void addCorpus(File corpus){
		corpusList.add(corpus);
	}
	public List<File> getCorpusList(){
		return corpusList;
	}


}
