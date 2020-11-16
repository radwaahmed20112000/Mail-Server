package eg.edu.alexu.csd.datastructure.mailserver;

import eg.edu.alexu.csd.datastructure.linkedlist.doublelinkedlist;

public interface ISearch {

	public int BinarySearch(String[] A, String x) ;
	public doublelinkedlist search(doublelinkedlist mails,String x);
	public String[] convertSentance(String sentance ) ;
	public doublelinkedlist get() ;
}
