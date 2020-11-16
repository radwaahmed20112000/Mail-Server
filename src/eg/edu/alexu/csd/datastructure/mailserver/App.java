package eg.edu.alexu.csd.datastructure.mailserver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

import eg.edu.alexu.csd.datastructure.linkedlist.ILinkedList;
import eg.edu.alexu.csd.datastructure.linkedlist.doublelinkedlist;
import eg.edu.alexu.csd.datastructure.linkedlist.singlelinkedlist;
import eg.edu.alexu.csd.datastructure.queue.linkedlistimp;


public class App implements IApp {
	
	doublelinkedlist mailstoview=new doublelinkedlist();
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public boolean contactexists(String contactname,String contactpass,String contactmail,int signup) {
		
	
		if((signup==1)&&(contactname.equals(""))&&(contactpass.equals(""))&&(contactmail.equals(""))){ 
			return false;}                                                                  //check if the user did not enter any thing
		else if((signup==0)&&(contactpass.equals(""))&&(contactmail.equals(""))) {
			return false;}
		
		int ctr=0;
		int exists=0;
		try{
			Scanner s1=new Scanner (new File("D:\\assignment 8\\parent\\accounts.txt"));
			
			while(s1.hasNextLine()) {
			ctr++;
			s1.nextLine();
		}
			
			
		Scanner s2=new Scanner (new File("D:\\assignment 8\\parent\\accounts.txt"));
		String[][]useraccounts=new String[ctr/3][3];
		for(int i=0;i<(ctr/3);i++) {
			useraccounts[i][0]=(s2.nextLine().toString());
			useraccounts[i][1]=(s2.nextLine().toString());
			useraccounts[i][2]=(s2.nextLine().toString());
			  
		}
		
		
		for(int i=0;i<ctr/3;i++) {exists=0;
			//if((signup==1)&&(contactname.equals(useraccounts[i][0]))&&(contactpass.equals(useraccounts[i][1]))&&(contactmail.equals(useraccounts[i][2]))) {
		if((signup==1)&&((contactname.equals(useraccounts[i][0]))||(contactmail.equals(useraccounts[i][2])))) {
	 
				return false;
		   }
			else if((signup==0)&&(contactpass.equals(useraccounts[i][1]))&&(contactmail.equals(useraccounts[i][2]))) {
				return true;
			}
			}
		if(signup==1)
			return true;
		else 
			return false;
		
		}
		
		catch(FileNotFoundException e){
		   return false;}
		
		
	}
	///////////////////////////////////////////////////////////////////////////////////////////////
	public boolean signup(IContact contact) {
		String contactname=contact.getname();
		String contactpass=contact.getpass();
		String contactmail=contact.getmail();
		
		Boolean contactexist=contactexists(contactname,contactpass,contactmail,1);
		if(contactexist==false) {
			return false;}
		else {
        	  PrintWriter pw = null;
        	  try{
        		   pw=new PrintWriter(new FileWriter ("D:\\assignment 8\\parent\\accounts.txt",true));
        		  
        	      pw.println(contactname);
        	      pw.println(contactpass);
        	      pw.println(contactmail);

        	      pw.close();
        	      
        	  }
        	  catch (Exception e) {
      			e.printStackTrace();
      		} finally {
      			try {
      				if (pw != null) {
      					pw.close();
      				}
      			} catch (Exception e) {
      				e.printStackTrace();
      			}
      		}
      	
          ////////////////////////////////////////////////////
        try { StringBuilder s11 =new StringBuilder();
        		 s11=s11.append("D:\\assignment 8\\parent\\").append(contactmail);
         
         File f1=new File(s11.toString());
			f1.mkdir();
			//////////////////////////////////////////
			StringBuilder s12 =new StringBuilder();
   		     s12=s12.append("D:\\assignment 8\\parent\\").append(contactmail).append("\\").append("sent");
        File f2=new File(s12.toString());
		f2.mkdir();
		
		StringBuilder s22 =new StringBuilder();
       s22=s22.append("D:\\assignment 8\\parent\\").append(contactmail).append("\\").append("sentmails.txt");
      File f22=new File(s22.toString());
	  f22.createNewFile();
		
		
		////////////////////////////////////////////////
		StringBuilder s13 =new StringBuilder();
		 s13=s13.append("D:\\assignment 8\\parent\\").append(contactmail).append("\\").append("Inbox");
    
       File f3=new File(s13.toString());
	    f3.mkdir();
	    
	    StringBuilder s33 =new StringBuilder();
	    s33=s33.append("D:\\assignment 8\\parent\\").append(contactmail).append("\\").append("Inboxmails.txt");
	    File f33=new File(s33.toString());
		f33.createNewFile();
/////////////////////////////////////////////////////
	StringBuilder s14 =new StringBuilder();
	 s14=s14.append("D:\\assignment 8\\parent\\").append(contactmail).append("\\").append("trash");

     File f4=new File(s14.toString());
     f4.mkdir();
     
        StringBuilder s44 =new StringBuilder();
	    s44=s44.append("D:\\assignment 8\\parent\\").append(contactmail).append("\\").append("trashmails.txt");
	    File f44=new File(s44.toString());
		f44.createNewFile();
     ////////////////////////////////////////
     StringBuilder s15 =new StringBuilder();
	 s15=s15.append("D:\\assignment 8\\parent\\").append(contactmail).append("\\").append("Drafts");

      File f5=new File(s15.toString());
      f5.mkdir();
      
        StringBuilder s55 =new StringBuilder();
	    s55=s55.append("D:\\assignment 8\\parent\\").append(contactmail).append("\\").append("Draftsmails.txt");
	    File f55=new File(s55.toString());
		f55.createNewFile();
     //////////////////////////////////////////
     StringBuilder s16 =new StringBuilder();
	 s16=s16.append("D:\\assignment 8\\parent\\").append(contactmail).append("\\").append("contacts");

     File f6=new File(s16.toString());
     f6.mkdir();
     
        StringBuilder s66 =new StringBuilder();
	    s66=s66.append("D:\\assignment 8\\parent\\").append(contactmail).append("\\").append("contactsmails.txt");
	    File f66=new File(s66.toString());
		f66.createNewFile();
		/////////////////////////////////////////////////
		return true;}
		
		catch (IOException e) {
			//e.printStackTrace();
			return false;}  }

}
		//////////////////////////////////////////////////////////////////////////////////////
	public boolean signin(String email, String password) {
		
		return contactexists("",password,email,0);
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public boolean compose(IMail email) {
		//////////////////////////////////////////GLOBAL VARIABLES/////////////////////////////
		String from =email.getfrom();
		linkedlistimp queueTo=email.getreceivers();
		String sub=email.getsub();
		String date=email.getdate();
		String content=email.getcontent();
		singlelinkedlist Attachments=email.getAttachments();
		///////////////////////////////////////////////////////////TRANSFER THE QUEUE TO LINKEDLIST////////////////////////////
		/*singlelinkedlist To=new singlelinkedlist();
		while(!queueTo.isEmpty()) {
			To.add(queueTo.dequeue().toString());
		}
		for(int i=0;i<To.size();i++) {
			queueTo.enqueue(To.get(i).toString());
		}*/
		String[]Too=new String[queueTo.size()];
		int u=0;
		while(!queueTo.isEmpty()) {
			Too[u]=queueTo.dequeue().toString();
			u++;
		}
		//System.out.println(u);
		//System.out.println("to emails");
		
		for(int j=0;j<u;j++) {
			//System.out.println(Too[j]);
			queueTo.enqueue(Too[j]);
		}
		
		
		
			//System.out.println("the Attachments");
		   // Attachments.show();
		/////////////////////////////////////////////////////////////SCANNING THE CONTACTS FILE////////////////////
		int ctr=0;
		
		try{
			Scanner s1=new Scanner (new File("D:\\assignment 8\\parent\\accounts.txt"));
			
			while(s1.hasNextLine()) {
			ctr++;
			s1.nextLine();
		}
			
		Scanner s2=new Scanner (new File("D:\\assignment 8\\parent\\accounts.txt"));
		String[][]useraccounts=new String[ctr/3][3];
		for(int i=0;i<(ctr/3);i++) {
			useraccounts[i][0]=(s2.nextLine().toString());
			useraccounts[i][1]=(s2.nextLine().toString());
			useraccounts[i][2]=(s2.nextLine().toString());  
		}
		/////////////////////////////////////////////////////SEARCH IF ONE OF THE RECEIVERS DOESNOT EXISTS ////////////////////////////////
		for(int i=0;i<queueTo.size();i++) {
		    int exists=0;
		for(int j=0;j<ctr/3;j++) {
			if(Too[i].equalsIgnoreCase(useraccounts[j][2]))
				exists++;
		}
		if(exists==0) {
			return false;
		}
	}
		/////////////////////////////////////////IF ALL THE RECEIVERS EXISTS MAKE A MESSAGE FOLDER IN THE SENDER FOLDER///////////////////////////
		 StringBuilder s11 =new StringBuilder();
		 s11=s11.append("D:\\assignment 8\\parent\\").append(from).append("\\sent\\").append(sub);
         File f1=new File(s11.toString());
	     f1.mkdir();
	     
	  
	          StringBuilder s12 =new StringBuilder();
		      s12=s12.append("D:\\assignment 8\\parent\\").append(from).append("\\sent\\").append(sub).append("\\").append("content.txt");
              File f2=new File(s12.toString());
	          f2.createNewFile();
	          
	          StringBuilder s13 =new StringBuilder();
		      s13=s13.append("D:\\assignment 8\\parent\\").append(from).append("\\sent\\").append(sub).append("\\").append("Attachments.txt");
              File f3=new File(s13.toString());
	          f3.createNewFile();
	          
	          StringBuilder s14 =new StringBuilder();
		      s14=s14.append("D:\\assignment 8\\parent\\").append(from).append("\\sent\\").append(sub).append("\\").append("Index.txt");
              File f4=new File(s14.toString());
	          f4.createNewFile();
	    	//////////////////////////////////WRITING IN THE FILES THE MESSAGE////////////////////////////////////////////////
	          PrintWriter pw1 = null;
	          PrintWriter pw2 = null;
	          PrintWriter pw3 = null;
	          PrintWriter pw4 = null;

        	  try{
        		   pw1=new PrintWriter(new FileWriter (s12.toString(),true));
        	       pw1.println(content);
        	       pw1.close();
        	       
        	       pw2=new PrintWriter(new FileWriter (s13.toString(),true));
        	       for(int i=0;i<Attachments.size();i++) {
        	       pw2.println(Attachments.get(i).toString());}
        	       pw2.close();
        	       
        	       pw3=new PrintWriter(new FileWriter (s14.toString(),true));
        	       pw3.println(from);
        	       pw3.println(sub);
        	       pw3.println(date);
        	       for(int i=0;i<queueTo.size();i++) {
        	    	   pw3.println(Too[i].toString());
        	       }
        	       pw3.close();
        	       
        	       StringBuilder S=new StringBuilder();
        	       S=S.append("D:\\assignment 8\\parent\\").append(from).append("\\").append("sentmails.txt");
        	       pw4=new PrintWriter(new FileWriter (S.toString(),true));
        	       pw4.println(sub);
        	       pw4.close();
        	       

        	  }
        	  catch (Exception e) {
      			e.printStackTrace();
      		} finally {
      			try {
      				if (pw1 != null) {
      					pw1.close();}
      				
      				if (pw2 != null) {
      					pw2.close();}
      				
      				if (pw3 != null) {
      					pw3.close();}
      				
      				if (pw4 != null) {
      					pw4.close();}
      				
      			} catch (Exception e) {
      				e.printStackTrace();
      			}
	          
      		}
      ///////////////////////////////////////////////////////MOVE THE MESSAGE FROM THE SENDERFOLDER TO THE RECIEVER FOLDER///////////////////
        	  ILinkedList move =new singlelinkedlist(); //make alinked list of mails to be sent from the user
        	  move.add(email);
        	  IFolder dis=new Folder();   //new folder of the directory of the receiver inbox folder
        	  for(int i=0;i<queueTo.size();i++) {   //if it was multible recivers to send them 
        		  StringBuilder dire =new StringBuilder();
        		  StringBuilder diremail =new StringBuilder();
        		  dire=dire.append("D:\\assignment 8\\parent\\").append(/*queueTo.dequeue().toString()*/Too[i]).append("\\Inbox");
        		  dis.setdir(dire.toString());
        		  diremail=diremail.append(dire.toString()).append("mails.txt");
        		  
        		  PrintWriter pw11 = null;  //to write in the inboxmails file of the receivers 

            	  try{
            		   pw11=new PrintWriter(new FileWriter (diremail.toString(),true));
            	       pw11.println(email.getsub());
            	       pw11.close();
        	  }
            	  catch (Exception e) {
            			e.printStackTrace();
            		} finally {
            			try {
            				if (pw11 != null) {
            					pw11.close();}
            			} catch (Exception e) {
            				e.printStackTrace();
            			}
            		}
            	  sendEmails(move,dis);
        	  }
        	  
	         return true;}
           
   catch(FileNotFoundException e){
	   return false;} 
		catch (IOException e) {
	e.printStackTrace();
	return false;
        }
		}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void sendEmails(ILinkedList mails, IFolder des) {            //from sender to receiver
		
	  for(int i=0;i<mails.size();i++) {
			StringBuilder from=new StringBuilder();
			IMail s=(IMail)mails.get(i);
			from=from.append("D:\\assignment 8\\parent\\").append(s.getfrom()).append("\\sent\\").append(s.getsub());   
			String to=des.getdir()+"\\"+s.getsub();
			File f1=new File(from.toString());
			File f2= new File (to);
			copyFolder(f1,f2);}
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public  void copyFolder(File source, File destination)
	{
	    if (source.isDirectory())
	    {
	        if (!destination.exists())
	        {
	            destination.mkdirs();
	        }

	        String files[] = source.list();

	        for (String file : files)
	        {
	            File srcFile = new File(source, file);
	            File destFile = new File(destination, file);

	            copyFolder(srcFile, destFile);
	        }
	    }
	    else
	    {
	        InputStream in = null;
	        OutputStream out = null;

	        try
	        {
	            in = new FileInputStream(source);
	            out = new FileOutputStream(destination);

	            byte[] buffer = new byte[1024];

	            int length;
	            while ((length = in.read(buffer)) > 0)
	            {
	                out.write(buffer, 0, length);
	            }
	        }
	        catch (Exception e)
	        {
	            try
	            {
	                in.close();
	            }
	            catch (IOException e1)
	            {
	                e1.printStackTrace();
	            }

	            try
	            {
	                out.close();
	            }
	            catch (IOException e1)
	            {
	                e1.printStackTrace();
	            }
	        }
	    }
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
    public void moveEmails(ILinkedList mails, IFolder des) {            
    	
    	String fromfirst=mails.get(0).toString();
        String Indexf=mails.get(0).toString()+"mails.txt";
        mails.remove(0);
  	  for(int i=0;i<mails.size();i++) {
  		StringBuilder from=new StringBuilder();
			IMail s=(IMail)mails.get(i);
			from=from.append(fromfirst).append("\\").append(s.getsub());
			 PrintWriter pw11 = null;       

		   	  try{                                                       /////////////////writing in the file.mail that we move the mails to 
		   		  String filemail=des.getdir().toString()+"mails.txt";
		   		   pw11=new PrintWriter(new FileWriter (filemail,true));
		   	   	   pw11.println(s.getsub());
		   	       pw11.close();}
			  
		   	catch (Exception e) {
   			e.printStackTrace();
   		} finally {
   			try {
   				if (pw11 != null) {
   					pw11.close();}
   			} catch (Exception e) {
   				e.printStackTrace();
   			}
   		}
		   	
  		/////////////////////////////// //////////////////////Deleting the message from the current place//////////////////////
  			
		   	String c = from .toString();
			File f = new File(c);
			String[] paths = f.list();
			for(int r = 0 ; r < paths.length ; r++) {
				try {
					FileWriter fw = new FileWriter(c+ "\\"+ paths[r]);
					fw.write("");
					fw.close();
					File p = new File(c +"\\"+paths[r]);
					p.delete();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			f.delete();
			////////////////////////////////////////////////////////////////////////////////////
			try {
                BufferedReader file = new BufferedReader(new FileReader(Indexf));
                String line;
                String input = "";
                while ((line = file.readLine()) != null) 
                {
                    if (line.equalsIgnoreCase(s.getsub()))
                    {
                        line = "";
                        
                    }else {
	                    input += line + '\r'+ '\n' ;
                    }
                }
                FileOutputStream File = new FileOutputStream(Indexf);
                File.write(input.getBytes());
                file.close();
                File.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
  			
		//////////////////////////////////////////////////////////////copying the message to the wanted distenation /////////////
			File to=new File(des.getdir()+"\\"+s.getsub());
  			to.mkdir();
  			File f1=new File(des.getdir()+"\\"+s.getsub()+"\\content.txt");
  			File f2=new File(des.getdir()+"\\"+s.getsub()+"\\Index.txt");
  			File f3=new File(des.getdir()+"\\"+s.getsub()+"\\Attachments.txt");
  			try{
  		    f1.createNewFile();
  			f2.createNewFile();
  			f3.createNewFile();}
  			
  			catch (IOException e) {
  				e.printStackTrace();}
  		  PrintWriter pw1 = null;
          PrintWriter pw2 = null;
          PrintWriter pw3 = null;
          

    	  try{
    		   pw1=new PrintWriter(new FileWriter (des.getdir()+"\\"+s.getsub()+"\\content.txt",true));
    	       pw1.println(s.getcontent());
    	       pw1.close();
    	       
    	       pw2=new PrintWriter(new FileWriter (des.getdir()+"\\"+s.getsub()+"\\Attachments.txt",true));
    	       singlelinkedlist Attachments=s.getAttachments();
    	       for(int k=0;k<Attachments.size();k++) {
    	       pw2.println(Attachments.get(k).toString());}
    	       pw2.close();
    	       
    	       pw3=new PrintWriter(new FileWriter (des.getdir()+"\\"+s.getsub()+"\\Index.txt",true));
    	       pw3.println(s.getfrom());
    	       pw3.println(s.getsub());
    	       pw3.println(s.getdate());
    	       linkedlistimp Q=s.getreceivers();
    	       String[] too=new String[Q.size()];
    	       int u=0;
    	       for(u=0;u<=Q.size();u++) {
    	          too[u]=Q.dequeue().toString();
    	       }
    	       for(int y=0;y<u;y++) {
    	    	  Q.enqueue(too[y]); 
    	    	  pw3.println(too[y]);
    	       }
    	       pw3.close();
    	        

    	  }
    	  catch (Exception e) {
  			e.printStackTrace();
  		} finally {
  			try {
  				if (pw1 != null) {
  					pw1.close();}
  				
  				if (pw2 != null) {
  					pw2.close();}
  				
  				if (pw3 != null) {
  					pw3.close();}
  				
  				
  			} catch (Exception e) {
  				e.printStackTrace();
  			}
  			
  			} 
    	  
  			
  	}}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void deleteEmails(ILinkedList mails) {     //Ishould have node 0= Sender
    	IFolder des=new Folder();
    	String to="D:\\assignment 8\\parent\\"+mails.get(0).toString()+"\\trash";
    	des.setdir(to);
    	mails.remove(0);
    	moveEmails( mails,des);
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public IMail[] listEmails(int page) {
    	IMail[] toview=new IMail[10];
    	int i=0;    int u=0;
    	
    	int numpages=mailstoview.size()/10;
        if(mailstoview.size()%10!=0)
        	numpages++;
        if(page==numpages) {
        	int y=mailstoview.size()-(page-1)*10;
        	IMail[] toview1=new IMail[y];
        	 for(i=(page-1)*10,u=0;i<mailstoview.size();u++,i++) {
         		toview1[u]=(IMail)mailstoview.get(i);
         	
         	}
        	 
         	return toview1;
        }
        for(i=(page-1)*10,u=0;u<10;u++,i++) {
    		toview[u]=(IMail)mailstoview.get(i);
    	}
    	return toview;
    }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void setViewingOptions(IFolder folder, IFilter filter, ISort sort) {
    	String where=folder.getdir();
    	 mailstoview =folder.loadindexfile(where);
    	
    	mailstoview=sort.get();
    	String s=filter.casefilter();
    	if(s.equalsIgnoreCase("none")==false)
    	   mailstoview=filter.get();
    	
    }
}
