package eg.edu.alexu.csd.datastructure.mailserver;

import java.io.FileNotFoundException;

import eg.edu.alexu.csd.datastructure.linkedlist.doublelinkedlist;
import eg.edu.alexu.csd.datastructure.linkedlist.singlelinkedlist;
import eg.edu.alexu.csd.datastructure.queue.linkedlistimp;
import eg.edu.alexu.csd.datastructure.stack.stackimplementation;

public class Sort implements ISort {
	
	String [] sub;
	String [] from;
	String [] content;
	String [] Attachments;
	String [] receivers;
	doublelinkedlist files =new doublelinkedlist();
	
	
	public doublelinkedlist get() {
		return files;
	}
	public doublelinkedlist Sorting (String A,doublelinkedlist mails,String directory) throws FileNotFoundException {//according to .....\\mails...........\\current directory..........
		if(A.equals("none")) {
			files=mails;
			return files;
		}
		
		sub=new String[mails.size()];
		 from=new String[mails.size()];
		 content=new String[mails.size()];
		Attachments=new String[mails.size()];
		 receivers=new String[mails.size()];
		 
		for(int i=0;i<mails.size();i++) {
			IMail s=new Mail();
			s=(Mail)mails.get(i);
			from[i]=s.getfrom();
			sub[i]=s.getsub();
			content[i]=s.getcontent();
			Attachments[i]=s.getAttachments().get(0).toString();
			linkedlistimp Q= s.getreceivers();
			singlelinkedlist L=new singlelinkedlist();
			for(int w=0;w<Q.size();w++) {
				L.add(Q.dequeue());
			}
			for(int e=0;e<L.size();e++) {
				Q.enqueue(L.get(e));
			}
			receivers[i]=L.get(0).toString();
		}
		String []res=null;
		if(A.equals("sub")) {
			res=Quicksort1(sub);
		}
		if(A.equals("sender")) {
			res=Quicksort(sub,from);
			
		}
		if(A.equals("content")) {
			res=Quicksort(sub,content);
		}
		if(A.equals("Attachments")) {
			res=Quicksort(sub,Attachments);
		}
		if(A.equals("receivers")) {
			res=Quicksort(sub,receivers);
		}
		if(A.equals("date")) {
			res=sub;
		}
		
		IFolder so=new Folder();
		 files =so.loadfromsub(res, directory);
		
		return files;
		
	}
	
		public String[] Quicksort(String[]sub,String[]A) {
		stackimplementation stack=new stackimplementation();
		stack.push(0);
		stack.push(A.length-1);
		while(!stack.isEmpty()) {
			int end=(int)stack.pop();
			int start=(int)stack.pop();
           // if(end-start<2) {
			if(start<end) {
			
			int pindex=partitioning(start,end,A,sub);
            stack.push(start);
            stack.push(pindex-1);
            stack.push(pindex+1);
            stack.push(end);}
		}
		/*for(int i=0;i<A.length;i++) {
			System.out.print(A[i]);
			System.out.print("\t");
		}*/
		return sub;
	}

	
	
	public int partitioning(int start,int end,String[]A,String []sub ) {
		String pivot=A[end];
		String pivot2=sub[end];
		int pindex= start;
		for(int i=start;i<=end-1;i++) {
			if((A[i].compareToIgnoreCase(pivot))<=0) {
				String temp=A[pindex];
				A[pindex]=A[i];
				A[i]=temp;
				////////////////////////
				 temp=sub[pindex];
				sub[pindex]=sub[i];
				sub[i]=temp;
				pindex++;
			}
		} 
		/////////////////////
		String temp=A[pindex];
		A[pindex]=A[end];
		A[end]=temp;
		//////////////////////////////////
		 temp=sub[pindex];
		sub[pindex]=sub[end];
		sub[end]=temp;
		return pindex;
		
	}
	
	public String[] Quicksort1(String[]A) {
		stackimplementation stack=new stackimplementation();
		stack.push(0);
		stack.push(A.length-1);
		while(!stack.isEmpty()) {
			int end=(int)stack.pop();
			int start=(int)stack.pop();
           // if(end-start<2) {
			if(start<end) {
			
			int pindex=partitioning1(start,end,A);
            stack.push(start);
            stack.push(pindex-1);
            stack.push(pindex+1);
            stack.push(end);}
		}
		/*for(int i=0;i<A.length;i++) {
			System.out.print(A[i]);
			System.out.print("\t");
		}*/
		return A;
	}

	
	
	public int partitioning1(int start,int end,String[]A ) {
		String pivot=A[end];
		
		int pindex= start;
		for(int i=start;i<=end-1;i++) {
			if((A[i].compareToIgnoreCase(pivot))<=0) {
				String temp=A[pindex];
				A[pindex]=A[i];
				A[i]=temp;
				pindex++;
				////////////////////////
				
			}
		} 
		/////////////////////
		String temp=A[pindex];
		A[pindex]=A[end];
		A[end]=temp;
		//////////////////////////////////
		 
		return pindex;
		
	}
	
	

}
