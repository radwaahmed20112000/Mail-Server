package eg.edu.alexu.csd.datastructure.mailserver;

import java.io.FileNotFoundException;

import eg.edu.alexu.csd.datastructure.linkedlist.doublelinkedlist;
import eg.edu.alexu.csd.datastructure.linkedlist.singlelinkedlist;
import eg.edu.alexu.csd.datastructure.stack.stackimplementation;

public class Filter implements IFilter{
	String s;
	doublelinkedlist f1=new doublelinkedlist();
	
	public doublelinkedlist get() {
		return f1;
	}
	public String casefilter() {
		return s;
	}
	
	public doublelinkedlist Filtering(doublelinkedlist mails,String accordingTo,String x,String dir) throws FileNotFoundException {
		s=accordingTo;
		if(accordingTo.equalsIgnoreCase("none")) {
			f1=mails;
			return f1;
		}
		
		String[]sub=new String [mails.size()];
		String[]sender= new String[mails.size()];
		String[]subsender= new String[mails.size()];
		String[]sub1=new String [mails.size()];
		String[]sender1= new String[mails.size()];
		String[]sub2=new String [mails.size()];
		
		
		doublelinkedlist exists= new doublelinkedlist();
		

		for(int i=0;i<mails.size();i++) {
			IMail s=(IMail)mails.get(i);
			sub[i]=s.getsub();
			sender[i]=s.getfrom();
			sub1[i]=s.getsub();
			sender1[i]=s.getfrom();
			sub2[i]=s.getsub();
			
		}
		
		ISort S= new Sort();
		sub=S.Quicksort1(sub);
		sender=S.Quicksort1(sender);
		subsender=S.Quicksort(sub1, sender1);
		sub2=S.Quicksort1(sub2);
		
		
		
		if(accordingTo.equalsIgnoreCase("sub")) {
			exists=BinarySearch(sub,mails.size(),x,1);
			if(exists.isEmpty()) {
				doublelinkedlist res= new doublelinkedlist();
				f1=res;
				return f1;
			}
			else 
			{     //load files from ifolder
				String[] res= new String[exists.size()];
				for(int j=0;j<exists.size();j++) {
					 int index=(int)exists.get(j);
					res[j]=sub2[index];
				}
				
				
				IFolder f=new Folder();
				//doublelinkedlist f1=new doublelinkedlist();
				f1=f.loadfromsub(res, dir);
				//return f1;
			}
		}
		else if(accordingTo.equalsIgnoreCase("sender")) {
			exists=BinarySearch(sender,mails.size(), x,0);
			
			if(exists.isEmpty()) {
				doublelinkedlist res= new doublelinkedlist();
				f1=res;
				return f1;
			}
			else 
			{     //load files from ifolder
				String[] res= new String[exists.size()];
				for(int j=0;j<exists.size();j++) {
					 int index=(int)exists.get(j);
					res[j]=subsender[index];
					
				}
				IFolder f=new Folder();
				//doublelinkedlist f1=new doublelinkedlist();
				f1=f.loadfromsub(res, dir);
				
				//return f1;
			}
		}
		return f1;
		
		
	}
	
	
	public doublelinkedlist BinarySearch(String[] A,int n,String x,int y) {
		doublelinkedlist Index= new doublelinkedlist();   
		stackimplementation Stack=new stackimplementation();
		Stack.push(0);
		Stack.push(n-1);
		int start; int end;  int mid; 
		while(!Stack.isEmpty()) {
			end=(int)Stack.pop();
			start=(int)Stack.pop();
			if(start>end==false) {
				mid=(start+end)/2;
				
				if(A[mid].equalsIgnoreCase(x)&&(y==0))
				{
					Index.add(mid);
					A[mid]="";
					Stack.push(mid+1);
					Stack.push(end);
					Stack.push(start);
					Stack.push(mid-1);
				}
				else if((A[mid].contains(x)==true)&&(y==1)) 
				{
					Index.add(mid);
					A[mid]="";
					Stack.push(mid+1);
					Stack.push(end);
					Stack.push(start);
					Stack.push(mid-1);
				}
				else if(x.compareToIgnoreCase(A[mid])<0)
				{
					Stack.push(0);
					Stack.push(mid-1);
				}
				else if(x.compareToIgnoreCase(A[mid])>0) 
				{
					Stack.push(mid+1);
					Stack.push(end);
				}
			}
			
		}
		return Index;
		
	}
	
	
	

}
