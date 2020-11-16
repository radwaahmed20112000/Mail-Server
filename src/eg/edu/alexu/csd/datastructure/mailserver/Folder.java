package eg.edu.alexu.csd.datastructure.mailserver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.nio.file.Files;
import java.util.Scanner;

import eg.edu.alexu.csd.datastructure.linkedlist.doublelinkedlist;
import eg.edu.alexu.csd.datastructure.linkedlist.singlelinkedlist;
import eg.edu.alexu.csd.datastructure.queue.linkedlistimp;

public class Folder implements IFolder {
	
	String dir;
	
	public String getdir() {
		return dir;
	}
	
	public void setdir(String dir1) {
		dir=dir1;
	}
	
	/*boolean Isexists (String s) {       //the directroy of the folder to be searched for its existance 
		Path p=new path(s);
		return(Files.exists(p));
		
	}*/
	
	public doublelinkedlist loadindexfile(String dir) {        //you will give it the dir of folder(sent) it will load its files in a double linked list 
		doublelinkedlist files=new doublelinkedlist();
		doublelinkedlist m=new doublelinkedlist();
		//singlelinkedlist files=new singlelinkedlist();
		StringBuilder s=new StringBuilder();
		s=s.append(dir).append("mails.txt");
		
		try {
	          Scanner s1=new Scanner (new File(s.toString()));
				int ctrtotal=0;
				while(s1.hasNextLine()) {
					ctrtotal++;
				s1.nextLine();}
			
				if(ctrtotal==0) 
					return null;
	           else {
					String[] sub=new String[ctrtotal];
					Scanner s2=new Scanner (new File(s.toString()));
					
					for(int i=0;i<(ctrtotal);i++) {
						sub[i]=(s2.nextLine().toString());}
					
					for(int i=0;i<(ctrtotal);i++) {
						IMail message=new Mail();
						StringBuilder ss=new StringBuilder();
						StringBuilder ss1=new StringBuilder();
						StringBuilder ss2=new StringBuilder();
						ss=ss.append(dir).append("\\").append(sub[i]).append("\\Attachments.txt");
						ss1=ss1.append(dir).append("\\").append(sub[i]).append("\\content.txt");
						ss2=ss2.append(dir).append("\\").append(sub[i]).append("\\Index.txt");
						
						Scanner s11=new Scanner (new File(ss2.toString())); //counting the lines in the index file
						 int ctr=0;
						while(s11.hasNextLine()) {
						ctr++;
						s11.nextLine();}
						s11.close();
					  Scanner s22=new Scanner (new File(ss2.toString()));  //reading index file in the message 
							String from =(s22.nextLine().toString());
							String sub1=(s22.nextLine().toString());
							String date=(s22.nextLine().toString());
							linkedlistimp Q=new linkedlistimp();
							for(int j=4;j<=ctr;j++) {	
								Q.enqueue(s22.nextLine().toString());}
							s22.close();
							
				     Scanner s33=new Scanner (new File(ss.toString()));
			          singlelinkedlist Attachment=new singlelinkedlist();
			          ctr=0;
					  while(s33.hasNextLine()) {   //counting the number of the Attachments 
						ctr++;
						s33.nextLine();}
					  s33.close();
					  
					  Scanner s44=new Scanner (new File(ss.toString()));    //reading the Attachments
					  for(int r=0;r<ctr;r++) {    
						  Attachment.add(s44.nextLine().toString());}
					  s44.close();
					   Scanner s55=new Scanner (new File(ss1.toString()));
					   ctr=0;
					   while(s55.hasNextLine()) {
						ctr++;
						s55.nextLine();}
					   s55.close();
					   Scanner s66=new Scanner (new File(ss1.toString()));
					   StringBuilder content =new StringBuilder();
					   for(int u=0;u<ctr;u++) {
						   content=content.append(s66.nextLine().toString());}
					   s66.close();
						message.set(from, Q, sub1, date, content.toString(), Attachment);
						m.add(message);
					}}
				
				for(int w=m.size()-1;w>=0;w--) {
		    		files.add(m.get(w));
		    	}
				
				    return files;}
		     catch(FileNotFoundException e){
			       return null;}
		
				}
	
	
	
	//fun take array of subjects and return doublelinked list of it 
	public doublelinkedlist loadfromsub(String sub[],String from) throws FileNotFoundException {
		doublelinkedlist files=new doublelinkedlist() ;
	for(int i=0;i<sub.length;i++) {
		String s1=from+"\\"+sub[i]+"\\content.txt";
		String s2=from+"\\"+sub[i]+"\\Attachments.txt";
		String s3=from+"\\"+sub[i]+"\\Index.txt";
		
		Scanner s11=new Scanner (new File(s3)); //counting the lines in the index file
		 int ctr=0;
		while(s11.hasNextLine()) {
		ctr++;
		s11.nextLine();}
		s11.close();
	  Scanner s22=new Scanner (new File(s3));  //reading index file in the message 
			String from1 =(s22.nextLine().toString());
			String sub1=(s22.nextLine().toString());
			String date=(s22.nextLine().toString());
			linkedlistimp Q=new linkedlistimp();
			for(int j=4;j<=ctr;j++) {	
				Q.enqueue(s22.nextLine().toString());}
			s22.close();
			
			
    Scanner s33=new Scanner (new File(s2));
     singlelinkedlist Attachment=new singlelinkedlist();
     ctr=0;
	  while(s33.hasNextLine()) {   //counting the number of the Attachments 
		ctr++;
		s33.nextLine();}
	  s33.close();
	  Scanner s44=new Scanner (new File(s2));    //reading the Attachments
	  for(int r=0;r<ctr;r++) {    
		  Attachment.add(s44.nextLine().toString());}
	  s44.close();
	   Scanner s55=new Scanner (new File(s1));
	   ctr=0;
	   while(s55.hasNextLine()) {
		ctr++;
		s55.nextLine();}
	   s55.close();
	   Scanner s66=new Scanner (new File(s1));
	   StringBuilder content =new StringBuilder();
	   for(int u=0;u<ctr;u++) {
		   content=content.append(s66.nextLine().toString());}
	   s66.close();
	   IMail message=new Mail();
		message.set(from1, Q, sub1, date, content.toString(), Attachment);
		files.add(message);
	}
   return files;}
    



	

}
