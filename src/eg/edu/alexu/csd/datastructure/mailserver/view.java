package eg.edu.alexu.csd.datastructure.mailserver;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import eg.edu.alexu.csd.datastructure.linkedlist.doublelinkedlist;

public class view {
	
	public view(String sender,String where) throws FileNotFoundException {
		JFrame f=new JFrame(where);
		JPanel p=new JPanel(new GridBagLayout());
		JButton delete=new JButton("delete");
		JButton movetodraft=new JButton("move to draft");
		JButton sort=new JButton("sort");
		JButton search=new JButton("search");
		JButton filter=new JButton("filter");
		JButton open=new JButton("open");
		JButton refreash=new JButton("refreash");
		JButton back=new JButton("back");
		JButton next=new JButton(">");
		JButton prev=new JButton("<");
		JButton pagenum=new JButton("ok");
		
		JTextField searchfor =new JTextField (10);
		JTextField filterfor = new JTextField(10);
		JTextArea page = new JTextArea(30,40);
		JLabel l1 = new JLabel("OPTIONS : ");

		String[] itemssort= {"none","sender","date","sub","recievers","content","Attachments"};
		String[] itemsfilter= {"none","sender","sub"};
		JComboBox sort1 = new JComboBox(itemssort);
		JComboBox filrer1 = new JComboBox(itemsfilter);
		
		String deri="D:\\assignment 8\\parent\\" +sender+"\\"+where; 
		
        IFolder fol=new Folder();
        doublelinkedlist mess=fol.loadindexfile(deri);
		IApp A=new App();
		IFilter filt =new Filter();
		filt.Filtering(mess, "none", "", deri);
		ISort sort2=new Sort();
		sort2.Sorting("none", mess, deri);
		A.setViewingOptions(fol, filt, sort2);
		
		JList list=new JList(/*A.listEmails(1)*/ itemssort);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        int size=mess.size();
        
		 
		 f.setVisible(true);
			f.setSize(600, 400);
			f.setDefaultCloseOperation(JFrame .EXIT_ON_CLOSE);
			
			p.setBackground(Color.LIGHT_GRAY);
			GridBagConstraints g=new GridBagConstraints();
			g.insets=new Insets(10,10,10,10);
			g.gridx=0;
			g.gridy=0;
			p.add(back,g);
			
			g.gridx=-1;
			g.gridy=3;
			list.setPreferredSize(new Dimension(500, 500));
			p.add(list,g);
			g.gridx=-1;
			g.gridy=11;
			//p.add(next,g);
			g.gridx=5;
			g.gridy=11;
			//p.add(prev,g);
			g.gridx=8;
			g.gridy=3;
			p.add(l1,g);
			g.gridx=5;
			g.gridy=5;
			//p.add(delete,g);
			g.gridx=5;
			g.gridy=6;
			//p.add(movetodraft,g);
			g.gridx=5;
			g.gridy=7;
			//p.add(sort,g);
			g.gridx=5;
			g.gridy=8;
			//p.add(search,g);
			g.gridx=5;
			g.gridy=9;
			//p.add(filter,g);
			g.gridx=5;
			g.gridy=10;
			//p.add(open,g);
			g.gridx=5;
			g.gridy=11;
			//p.add(refreash,g);
			
			
			f.add(p);
			
			delete.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
				}
            });
	}

}
