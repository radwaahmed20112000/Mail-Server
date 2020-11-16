package eg.edu.alexu.csd.datastructure.mailserver;
 
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Scanner;

import eg.edu.alexu.csd.datastructure.linkedlist.doublelinkedlist;
import eg.edu.alexu.csd.datastructure.linkedlist.singlelinkedlist;
import eg.edu.alexu.csd.datastructure.linkedlist.ILinkedList;
import eg.edu.alexu.csd.datastructure.queue.linkedlistimp;
import eg.edu.alexu.csd.datastructure.stack.stackimplementation;

public class main {

	public static void main(String[] args) throws IOException {
		/*IContact h=new Contact();
		h.setname("3atyaat");
		h.setpassword("1254");
		h.setmail("nonaso909@");
		App a=new App();
		//System.out.println(a.signup(h));
		System.out.println(a.signin("nonaso909@","1254"));*/
		
		//loging g=new loging();
		
		/*String s1="10";
		String s2="2";
		System.out.println(s1.compareTo(s2));*/
		
        /*String name[]= {"ahmed","zyad","saad","ahmed ali","esmail","farida","radwa"};
		String A[]= {"school","colage","work","office","arabic","zoo","weekend"};
		ISort S=new Sort();
		
	   String res[]=S.Quicksort(name,A);

			System.out.println("");

		 for(int i=0;i<res.length;i++) {
				System.out.print(res[i]);
				System.out.print("\t");
			}
		
			App A=new App();
			IMail email=new Mail();
			linkedlistimp Q=new linkedlistimp();
			Q.enqueue("fere100100@");
			Q.enqueue("monah100100@");
			Q.enqueue("fagr100100@");
            
			singlelinkedlist Attachments=new singlelinkedlist();
			Attachments.add("C://");
			Attachments.add("D://");
			Attachments.add("C://");
			
			email.set("adel100100@", Q, "tooooooootooooo", "30/11/2020", "I hope to be in Dahab doing all my lovely adventures", Attachments);

			System.out.println( A.compose(email));
		//loging h=new loging();
		
	   /* ILinkedList mail=new singlelinkedlist();
	    IMail mess=null;
		mail.add( mess);
		singlelinkedlist roo=((singlelinkedlist) mail.get(0)).getAttachments();
		roo.show();*/
		 //s13=s13.append("D:\\assignment 8\\parent\\").append(contactmail).append("\\").append("Inbox");
		 //s33=s33.append("D:\\assignment 8\\parent\\").append(contactmail).append("\\").append("Inboxmails.txt");
          String s="D:\\assignment 8\\parent\\adel100100@\\Sent";
          /*StringBuilder s2=new StringBuilder();
          s2.append(s).append("mails.txt");
          //System.out.println(s2);
          Scanner s1=new Scanner (new File(s2.toString()));
			int ctr=0;
			while(s1.hasNextLine()) {
			ctr++;
			s1.nextLine();
		}
			
			System.out.println(ctr);*/
          
          /*IFolder f=new Folder();
        doublelinkedlist res=  f.loadindexfile(s);
       IMail roo=(IMail) res.get(0);
       System.out.println(roo.getfrom());*/
          
       /*String from="D:\\assignment 8\\parent\\adel100100@\\sent\\SUMMERGOALS";
	   String to="D:\\assignment 8\\parent\\fere100100@\\Inbox";
		//to=to+"\\SUMMERGOALS.txt";
		
		//File f=new File (to);
		//.mkdir();
		
		File f1=new File(from);
		File f2= new File (to+"\\SUMMERGOALS");
		// FileUtils.copyDirectory(f1, f2);
		//Files.copy( new File(from).toPath(),   new File(to).toPath());
		copyFolder(f1,f2);*/
          
          /*File f=new File("D:\\assignment 8\\parent\\monah100100@\\Inboxmails.txt");

        Desktop.getDesktop().open(f);*/
          App A=new App();
         /*IMail email=new Mail();
			linkedlistimp Q=new linkedlistimp();
			Q.enqueue("fere100100@");
			Q.enqueue("monah100100@");
			Q.enqueue("fagr100100@");
          
			singlelinkedlist Attachments=new singlelinkedlist();
			Attachments.add("C://");
			Attachments.add("D://");
			Attachments.add("C://");
			
			email.set("adel100100@", Q, "foryou", "30/11/2020", "I hope to be in Dahab doing all my lovely adventures", Attachments);
            IMail email2=new Mail();
            linkedlistimp Q1=new linkedlistimp();
			Q1.enqueue("1@");
			Q1.enqueue("2@");
			Q1.enqueue("fagr100100@");
          
			singlelinkedlist Attachments1=new singlelinkedlist();
			Attachments1.add("C://");
			Attachments1.add("D://");
			Attachments1.add("C://");
			email2.set("adel100100@", Q1, "weekend", "30/11/2020", "I hope to be in Dahab doing all my lovely adventures", Attachments1);
			
			ILinkedList mess=new singlelinkedlist();
			mess.add("adel100100@");
			mess.add("sent");
			mess.add(email);
			mess.add(email2);*/
			
		IFolder des=new Folder();
			des.setdir("D:\\assignment 8\\parent\\2@\\Inbox");
			
			//A.moveEmails(mess, des);
			IFolder mm=new Folder();
			singlelinkedlist m=new singlelinkedlist();
			//m=mm.loadindexfile("D:\\assignment 8\\parent\\2@\\trash");
			//m.add(0,"D:\\assignment 8\\parent\\2@\\trash");
			//m.add(1,"Inbox");
			/*singlelinkedlist m2=new singlelinkedlist();
			m2.add("fere100100@");
			m2.add("sent");
			for(int i=0;i<m.size();i++) {
				m2.add(m.get(i));
			}*/
			
			//A.moveEmails(m, des);
			//A.clear("D:\\assignment 8\\parent\\1@\\Inbox");
         /*File de=new File("D:\\assignment 8\\delete me.txt");
          de.delete();*/
			//A.clear("D:\\assignment 8\\parent\\fere100100@\\sent\\computer science");
			//File de=new File("D:\\assignment 8\\parent\\adel100100@\\trash\\fromhome\\content.txt");
	         // de.delete();
          App A1=new App();
          IMail m1 =new Mail();
			linkedlistimp Q=new linkedlistimp();
			Q.enqueue("1@");
			Q.enqueue("2@");
        
			singlelinkedlist Attachments11=new singlelinkedlist();
			Attachments11.add("d:\\file.txt");
			Attachments11.add("d:\\dictionary.txt");
			
			
			m1.set("fere100100@", Q, "ooooooooooooooooooooof", "30/11/2020", "attachments error", Attachments11);
          IMail m2=new Mail();
          linkedlistimp quq=new linkedlistimp();
          quq.enqueue("1@");
          quq.enqueue("2@");
			
        
			singlelinkedlist Attachments111=new singlelinkedlist();
			Attachments111.add("d:\\file.txt");
			Attachments111.add("d:\\dictionary.txt");
			m2.set("adel100100@", quq, "opennnn", "30/11/2020", "donot callme up", Attachments111);
			
			 IMail m3 =new Mail();
				linkedlistimp W=new linkedlistimp();
				W.enqueue("fere100100@");
				
	        
				singlelinkedlist Attachment=new singlelinkedlist();
				Attachment.add("d:\\file.txt");
				Attachment.add("d:\\dictionary.txt");
				
				
				m3.set("fere100100@", W, "monday", "30/11/2020", "attachments error", Attachment);
			
			IFolder des2=new Folder();
			des2.setdir("D:\\assignment 8\\parent\\2@\\Drafts");
			
			//A.moveEmails(mess, des);
			IFolder k=new Folder();
			//singlelinkedlist h=new singlelinkedlist();
			//h=k.loadindexfile("D:\\assignment 8\\parent\\2@\\Inbox");
			//System.out.println(h.size());
			//h.add(0,"D:\\assignment 8\\parent\\2@\\Inbox");
			//A1.moveEmails(h, des2);
			//ILinkedList mess=new singlelinkedlist();
			//mess.add("2@");
			//mess.add("D:\\assignment 8\\parent\\3@\\Inbox");
			//mess.add(m1);
			//mess.add(m3);
			IFolder des1=new Folder();
			des1.setdir("D:\\assignment 8\\parent\\3@\\Drafts");
			//A1.deleteEmails(mess);
			//A1.moveEmails(mess, des1);
			
			
			/*singlelinkedlist mails=new singlelinkedlist();
			mails.add(m2);
			mails.add(m1);
			ISort j=new Sort();
			//System.out.println(mails.size());
			String [] sub1=new String[mails.size()];
			String [] from1=new String[mails.size()];
			String [] content1=new String[mails.size()];
			String [] Attachments2=new String[mails.size()];
			String [] receivers1=new String[mails.size()];*/
		
			/*for(int i=0;i<mails.size();i++) {
				IMail s1=new Mail();
				s1=(Mail)mails.get(i);
				from1[i]=s1.getfrom();
				sub1[i]=s1.getsub();
				content1[i]=s1.getcontent();
				Attachments2[i]=s1.getAttachments().get(0).toString();
				linkedlistimp Q2= s1.getreceivers();
				receivers1[i]=Q2.dequeue().toString();
			}*/
			//singlelinkedlist res=j.Sorting("from",mails, "D:\\assignment 8\\parent\\2@\\Inbox");
			/*for(int i=0;i<res.size();i++) {
				IMail d=new Mail();
				d=(IMail)res.get(i);
				System.out.println(d.getfrom());
			}*/
			/*doublelinkedlist fi1=new doublelinkedlist();
			IFolder fi=new Folder();
			fi1=fi.loadindexfile("D:\\assignment 8\\parent\\2@\\Drafts");
			IFilter fii=new Filter();
			doublelinkedlist fi2=new doublelinkedlist();
			//System.out.println(fi1.size());
			fi2=fii.Filtering(fi1, "sub", "sunday","D:\\assignment 8\\parent\\2@\\Drafts" );
			System.out.println(fi2.size());
			for(int i=0;i<fi2.size();i++) {
				IMail B=new Mail();
				B=(IMail)fi2.get(i);
				System.out.println(B.getsub());
			}*/
			doublelinkedlist fi1=new doublelinkedlist();
			doublelinkedlist fi2=new doublelinkedlist();
			IFolder fi=new Folder();
			/*fi1=fi.loadindexfile("D:\\assignment 8\\parent\\2@\\Drafts");
			//System.out.println(fi1.size());
			ISearch F=new Search();
			fi2= F.search(fi1, "fere100100@");
			for(int i=0;i<fi2.size();i++) {
				IMail B=new Mail();
				B=(IMail)fi2.get(i);
				System.out.println(B.getsub());
			}*/
			
		/*	for(int i =0;i<fi1.size();i++) {
				
				IMail s1 = (IMail) fi1.get(i) ;
				
				
				
				
				//Search in receivers
				linkedlistimp Q32=new linkedlistimp();
				Q32=s1.getreceivers();
				singlelinkedlist r=new singlelinkedlist();
				int u=0;
				System.out.println(Q32.size());
				while(!Q32.isEmpty()) {
					r.add(Q.dequeue());
				}

				for(int y=0;y<r.size();y++) {
					Q32.enqueue(r.get(y));
				}
				r.show();
			}*/
		//	design I=new design("4@","sent");
			//design M=new design("4@","sent");
			loging h=new loging();
			/*String deri="D:\\assignment 8\\parent\\" +"adel100100@"+"\\"+"Drafts"; 
			
	       
			
	        
			
			/*String index[]= {"sunday..1@","monday..2@","tuesday...3@"};
			String[]subj=new String [index.length];
			for(int i=0;i<index.length;i++) {
				int V=index[i].indexOf('.');
				
				subj[i]=(String) index[i].subSequence(0, V);
				
			}
			
			for(int r=0;r<index.length;r++) {
				 System.out.println(subj[r]);
			}*/
			
			
			/*IMail fagr=new Mail();
			fagr.set("fere100100@", Q, "ooooooooooooooooooooof", "30/11/2020", "attachments error", Attachments11);
			Openmessage l=new Openmessage(fagr);*/
			
			
			
			/*try{IFolder ft=new Folder();
			doublelinkedlist gigi=ft.loadindexfile("D:\\assignment 8\\parent\\fere100100@\\Inbox");
			gigi.isEmpty();}
			catch(NullPointerException P){
				System.out.println("Empty Folder");
				
			}*/
			
			
			
			
			
			
			
			
			
			
			
			
			
	}
}