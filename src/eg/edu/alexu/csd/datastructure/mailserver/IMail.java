package eg.edu.alexu.csd.datastructure.mailserver;

import eg.edu.alexu.csd.datastructure.linkedlist.ILinkedList;
import eg.edu.alexu.csd.datastructure.linkedlist.singlelinkedlist;
import eg.edu.alexu.csd.datastructure.queue.linkedlistimp;

public interface IMail {
	public void set(String from1,linkedlistimp queueTo1,String sub1,String content1,String date1,singlelinkedlist attach); 
    public String getfrom() ;
    public String getsub() ;
    public String getdate() ;
   	public String getcontent() ;
    public singlelinkedlist getAttachments() ;
    public linkedlistimp getreceivers() ;
   	

}
