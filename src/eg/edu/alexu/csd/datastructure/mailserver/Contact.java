package eg.edu.alexu.csd.datastructure.mailserver;

import eg.edu.alexu.csd.datastructure.linkedlist.singlelinkedlist;

public class Contact implements IContact{
	String name;
    String password;
    singlelinkedlist mail = new singlelinkedlist();
    //singlelinkedlist contacts=new  singlelinkedlist(); //read files from the folder contacts and list it in singlelinked list

   /* int signup=0;
    class Contact(String n,String p ,singlelinkedlist m ,int x ){
        name=n
        password=p;
        for (int i=0;i<m.size() ;i++ ){
            mail.add(m.get(i));
        } 
        //singlelinkedlist contacts=new  singlelinkedlist();
        //Priority
        signup=x;
        
    }*/
  /* public  Contact() {
	   System.out.println("hi");
	   }
    
    public void  usercontact(String n,String p,singlelinkedlist m) {
    	this.name=n;
    	this.password=p;
    	this.mail=m;
    	App s=new App();
    	s.signup(this);
    	
    }*/
    public String getname() {
		return this.name;
    	
    }
    public String getpass() {
		return this. password;
    	
    }
    public String getmail() {
		return this.mail.get(0).toString();	
    }
    
    public void setname(String name) {
    	this.name=name;
    }
    public void setpassword(String p) {
    	this.password=p;
    }
    public void setmail(String m) {
    	this.mail.add(m);
    	
    }
    

}
    


