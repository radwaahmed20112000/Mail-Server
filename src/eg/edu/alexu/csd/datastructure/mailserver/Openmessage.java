package eg.edu.alexu.csd.datastructure.mailserver;

import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import eg.edu.alexu.csd.datastructure.linkedlist.singlelinkedlist;
import eg.edu.alexu.csd.datastructure.queue.linkedlistimp;

public class Openmessage {
	

	singlelinkedlist attach=new singlelinkedlist() ;
	String subject;
	String sender;
	String content;
	singlelinkedlist r=new singlelinkedlist();
	JFrame f = new JFrame("Mail");
	JPanel p1 = new JPanel(new GridBagLayout());
	
	
	public Openmessage(IMail x) {
		attach = x.getAttachments();
		sender = x.getfrom();
		subject = x.getsub();
		content = x.getcontent();
		gui();
		linkedlistimp Q=new linkedlistimp();
		Q=x.getreceivers();
		
		int u=0;
		
		while(!Q.isEmpty()) {
			r.add(Q.dequeue());
		}

		for(int y=0;y<r.size();y++) {
			Q.enqueue(r.get(y));
		}
	}

	public void gui() {
		
		f.setVisible(true);
		f.setSize(600,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10,10,10,10);
      
		JTextArea Subject = new JTextArea();
		JTextArea Sender = new JTextArea();
		JTextArea Content = new JTextArea();
		Subject.setText(subject);
		Content.setText(content);
		Sender.setText(sender);
	    Subject.setEditable(false); 
	    Content.setEditable(false); 
	    Sender.setEditable(false); 
		
		JButton open = new JButton("Open choosen attachment");
		JLabel l1 = new JLabel("Subject : ");
		JLabel l2 = new JLabel("To : ");
		JLabel l3 = new JLabel("Content : ");
		
		JComboBox<String> comboBox = new JComboBox<String>();
		for(int i =0 ;i< attach.size();i++) {
			comboBox.insertItemAt(attach.get(i).toString(), i);
		}
		c.gridx=0;
		c.gridy=4;
		p1.add(l1,c);
		c.gridx=0;
		c.gridy=5;
		p1.add(l2,c);
		c.gridx=0;
		c.gridy=7;
		p1.add(l3,c);
		c.gridx=4;
		c.gridy=4;
		p1.add(Subject,c);
		c.gridx=4;
		c.gridy=5;
		p1.add(Sender,c);
		c.gridx=4;
		c.gridy=7;
		p1.add(Content,c);
		c.gridx=8;
		c.gridy=8;
		p1.add(open,c);
		c.gridx = 7;
		c.gridy = 8;
		p1.add(comboBox,c);
		f.add(p1);

		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String y =(String) comboBox.getSelectedItem();
				File f=new File(y);
				try {
					Desktop.getDesktop().open(f);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});

	
	
	}
}
