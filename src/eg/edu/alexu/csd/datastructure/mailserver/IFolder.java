package eg.edu.alexu.csd.datastructure.mailserver;

import java.io.FileNotFoundException;

import eg.edu.alexu.csd.datastructure.linkedlist.doublelinkedlist;
import eg.edu.alexu.csd.datastructure.linkedlist.singlelinkedlist;

public interface IFolder {
	
	public String getdir() ;
	public void setdir(String dir1) ;
	public doublelinkedlist loadindexfile(String dir); 
	//public singlelinkedlist loadindexfile(String dir); 
	public doublelinkedlist loadfromsub(String sub[],String from) throws FileNotFoundException;

}
