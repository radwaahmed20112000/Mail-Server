package eg.edu.alexu.csd.datastructure.mailserver;

import java.io.FileNotFoundException;

import eg.edu.alexu.csd.datastructure.linkedlist.doublelinkedlist;

public interface IFilter {
 
	public doublelinkedlist Filtering(doublelinkedlist mails,String accordingTo,String x,String dir) throws FileNotFoundException ;
	
	public doublelinkedlist BinarySearch(String[]A,int n,String x,int y) ;
	public doublelinkedlist get() ;
	public String casefilter() ;
}
