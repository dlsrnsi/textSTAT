package corpus;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class CorpusProject {
	private static CorpusProject corpusProject;
	Set<File> corpusSet;
	private CorpusProject(){
		corpusSet=new HashSet<File>();
	}
	public static CorpusProject getCorpusProject(){
		if(corpusProject==null){
			corpusProject=new CorpusProject();
			
		}
		return corpusProject;
	}
	public void addCorpus(File corpus){
		corpusSet.add(corpus);
	}

}
