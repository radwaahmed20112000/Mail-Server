package eg.edu.alexu.csd.datastructure.mailserver;

import java.io.FileNotFoundException;

import eg.edu.alexu.csd.datastructure.linkedlist.doublelinkedlist;
import eg.edu.alexu.csd.datastructure.linkedlist.singlelinkedlist;

public interface ISort {
	
	public doublelinkedlist Sorting (String A,doublelinkedlist mmm,String directory) throws FileNotFoundException ;//according to .....\\mails...........\\current directory..........

	public String[] Quicksort(String[]name,String[]A) ;
	public int partitioning(int start,int end,String[]A,String []sub );
	public String[] Quicksort1(String[]A) ;
	public int partitioning1(int start,int end,String[]A );
	public doublelinkedlist get() ;

}
