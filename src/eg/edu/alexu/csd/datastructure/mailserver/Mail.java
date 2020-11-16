package eg.edu.alexu.csd.datastructure.mailserver;

import eg.edu.alexu.csd.datastructure.linkedlist.ILinkedList;
import eg.edu.alexu.csd.datastructure.linkedlist.singlelinkedlist;
import eg.edu.alexu.csd.datastructure.queue.linkedlistimp;

public class Mail implements IMail {
	
	public String from;
	public linkedlistimp queueTo=new linkedlistimp();
	public String sub;
	public String date;
	public String content;
	public singlelinkedlist Attachments=new singlelinkedlist();
	
	
	public void set(String from1,linkedlistimp queueTo1,String sub1,String date1,String content1,singlelinkedlist Attachments1) {
		 from= from1 ;
		 sub=sub1;
	     date=date1;
		 content=content1;
		 queueTo=queueTo1;
		 Attachments=Attachments1;
	}
	public String getfrom() {
		return from;}
		
    public String getsub() {
	    return sub;}
		
    public String getdate() {
    	return date;}

    public String getcontent() {
    	return content;}
   
    public singlelinkedlist getAttachments() {
    	return Attachments;}
    
    public linkedlistimp getreceivers() {
    	return queueTo;}
    

}
