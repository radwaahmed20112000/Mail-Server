package eg.edu.alexu.csd.datastructure.mailserver;

import eg.edu.alexu.csd.datastructure.linkedlist.doublelinkedlist;
import eg.edu.alexu.csd.datastructure.linkedlist.singlelinkedlist;
import eg.edu.alexu.csd.datastructure.queue.linkedlistimp;
import eg.edu.alexu.csd.datastructure.stack.stackimplementation;

public class Search implements ISearch {
	ISort s = new Sort();
	stackimplementation index = new stackimplementation();
	doublelinkedlist result = new doublelinkedlist(); 
	
	public doublelinkedlist get() {
		return result;
	}
	public int BinarySearch(String[] A, String x) {
		String[] sortedA = s.Quicksort1(A);
		index.push(0);
		index.push(A.length-1);
		while(!index.isEmpty()) {
			int end = (int) index.pop();
			int start = (int) index.pop();
			if(end >= start) {
				int mid = (start + end )/2;
				if(sortedA[mid].compareToIgnoreCase(x) == 0 ) {
					return mid;
				}else if(x.compareToIgnoreCase(sortedA[mid]) >= 1 ) {
					index.push(mid+1);
					index.push(end);
				}else if (x.compareToIgnoreCase(sortedA[mid]) <= -1 ) {
					index.push(0);
					index.push(mid-1);
				}
			}else {
				break;
			}
			
		}
		return -1;
	}
	
	public doublelinkedlist search(doublelinkedlist mails,String x) {
		
		for(int i =0;i< mails.size();i++) {
			
			IMail s = (IMail) mails.get(i) ;
			
			//Search in Senders, Subjects, contents and dates
			String[] subject = convertSentance(s.getsub());
			String[] content = convertSentance(s.getcontent());
			String[] date = s.getdate().split("\\s+");

			if(s.getfrom().contains(x) ||BinarySearch(subject,x) != -1 ||BinarySearch(content,x) != -1 ||BinarySearch(date,x) != -1) {
				result.add(mails.get(i));
				continue;
			}
			
			//Search in attachments
			singlelinkedlist attach = ((IMail) mails.get(i)).getAttachments();
			for(int j=0;j< attach.size();j++) {
				if(attach.get(j).toString().contains(x)) {
					result.add(mails.get(i));
					continue;
				}
			}
			//Search in receivers
			linkedlistimp Q=new linkedlistimp();
			Q=s.getreceivers();
			singlelinkedlist r=new singlelinkedlist();
			int u=0;
			
			while(!Q.isEmpty()) {
				r.add(Q.dequeue());
			}

			for(int y=0;y<r.size();y++) {
				Q.enqueue(r.get(y));
			}
			 
			for(int j=0;j< r.size();j++) {
				if(r.get(j).toString().contains(x)) {
					result.add(mails.get(i));
					continue;
				}
			}
			
		}
		return result;
		
	}

	public String[] convertSentance(String sentance ) {
		String[] words = sentance.split("\\s+");
		for (int i = 0; i < words.length; i++) {
		    words[i] = words[i].replaceAll("[^\\w]", "");
		}
		return words;
	}
	

}
