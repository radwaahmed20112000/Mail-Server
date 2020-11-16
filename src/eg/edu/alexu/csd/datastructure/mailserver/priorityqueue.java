package eg.edu.alexu.csd.datastructure.mailserver;

import eg.edu.alexu.csd.datastructure.mailserver.priorityqueue.Node;

public class priorityqueue implements IPriorityQueue {
	static class Node {
		Object data;
		int key;
		Node next;
	}

	Node head;
	int size;
	 public void newnode(Object item, int key) {
		 Node n=new Node();
		   n.data=item;
		   n.key=key;
		   n.next=null;
		if(size==0) {
			head=n;
		}
		else {
			Node n1=head;
			while(n1.next!=null) {
				n1=n1.next;
			}
			n1.next=n;
		}
		   size++;
		   
	 }
	public void insert(Object item, int key) {
		int i;
		newnode( item, key);
		   if(size!=1) {  
		for( i=size-2;i>=0;i--) {
			if(key<this.getkey(i)) {
				set(i+1,this.get(i),this.getkey(i));
				
			}
			
			else {
				break;
			}
		}
		
			this.set(i+1,item,key);
		
		   }}
	

	
	public Object removeMin() {
		if(size ==0) {
			return null;
		}else {
		Object removed=this.get(0);
		head=head.next;
		size--;
		return removed;
	}}

	
	public Object min() {
		
		return this.get(0);
	}

	
	public boolean isEmpty() {
		
		return size==0;
	}

	
	public int size() {
		
		return size;
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public Object get (int index ) {
	   if (index>size||(index<0)) {
		   throw new RuntimeException ("out of size ");}
	   else {
		   Node n=head;
		  for(int i=0;i<index;i++) {
			  n=n.next;
		  }
		 return n.data;  
	   }}
	   
   public void set(int index,Object item,int key) {
	   if (index>size||(index<0)) {
		   throw new RuntimeException ("out of size ");}
	   else {
		   Node n=head;
		  for(int i=0;i<index;i++) {
			  n=n.next;
		  }
		  n.data=item;
		  n.key=key;}
   }
   public void  show() {
	   if(this.isEmpty()) {
		   System.out.println("the priority queue is empty");
	   }
	   else {
		   for(int i=0;i<size;i++) {
			   System.out.println(this.get(i));
		   }}
   }
	   
   
   public int getkey (int index ) {
	   if (index>size||(index<0)) {
		   throw new RuntimeException ("out of size ");}
	   else {
		   Node n=head;
		  for(int i=0;i<index;i++) {
			  n=n.next;
		  }
		 return n.key;  
	   }}
   


}
