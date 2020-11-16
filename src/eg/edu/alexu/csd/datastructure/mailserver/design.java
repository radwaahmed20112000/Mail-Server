package eg.edu.alexu.csd.datastructure.mailserver;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import eg.edu.alexu.csd.datastructure.linkedlist.doublelinkedlist;
import eg.edu.alexu.csd.datastructure.linkedlist.singlelinkedlist;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import eg.edu.alexu.csd.datastructure.linkedlist.ILinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;

public class design extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	 JList list1 = new JList();
	 int currentpage=1;
    int numpages1;
    String []mails;
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					design frame = new design("adel1001010@","Drafts");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 */
	public design(String sender,String where) throws FileNotFoundException {
		JFrame f=new JFrame(where);
		f.setVisible(true);
		f.setSize(600, 400);
		f.setDefaultCloseOperation(JFrame .EXIT_ON_CLOSE);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(552, 72, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("move to draft");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(536, 119, 122, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("sort");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(552, 163, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("search");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(552, 213, 85, 21);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("filter");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_4.setBounds(536, 274, 85, 21);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("open");
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_5.setBounds(552, 329, 85, 21);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("refresh");
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_6.setBounds(552, 397, 85, 21);
		contentPane.add(btnNewButton_6);
		
		JLabel lblNewLabel = new JLabel("options");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(547, 31, 73, 21);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(667, 216, 111, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		String[] itemssort= {"none","sender","date","sub","recievers","content","Attachments"};
		String[] itemsfilter= {"none","sender","sub"};
		
		JComboBox filter = new JComboBox(itemsfilter);
		filter.setBounds(631, 276, 59, 21);
		contentPane.add(filter);
		
		JComboBox sort = new JComboBox(itemssort);
		sort.setModel(new DefaultComboBoxModel(new String[] {"none", "sender", "date", "sub", "receivers", "content", "Attachments"}));
		sort.setBounds(647, 165, 81, 21);
		contentPane.add(sort);
		
		textField_1 = new JTextField();
		textField_1.setBounds(692, 277, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_7 = new JButton("reset");
		btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_7.setBounds(797, 276, 85, 21);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("back");
		btnNewButton_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_8.setBounds(100, 31, 85, 21);
		contentPane.add(btnNewButton_8);
		
		
		JButton btnNewButton_9 = new JButton("<");
		btnNewButton_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_9.setBounds(100, 467, 61, 21);
		contentPane.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton(">");
		btnNewButton_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_10.setBounds(283, 467, 53, 21);
		contentPane.add(btnNewButton_10);
		
		
		
		JButton btnNewButton_11 = new JButton("view");
		btnNewButton_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_11.setBounds(251, 34, 85, 21);
		contentPane.add(btnNewButton_11);
        
		 JList list = new JList();
			list.setBounds(20, 60, 475, 376);
			contentPane.add(list);
			list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
		
		
		
		btnNewButton_11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String deri="D:\\assignment 8\\parent\\" +sender+"\\"+where; 
				
		        IFolder fol=new Folder();
		        doublelinkedlist mess=fol.loadindexfile(deri);
		        try {
		        	mess.isEmpty();
		        
				IApp A=new App();
				IFilter filt =new Filter();
				try {
					filt.Filtering(mess, "none", "", deri);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ISort sort2=new Sort();
				try {
					sort2.Sorting("none", mess, deri);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				A.setViewingOptions(fol, filt, sort2);
				
				//JList list=new JList(/*A.listEmails(1)*/ itemssort);
		        int size=mess.size();
		        int numpages=size/10;
		        if(size%10!=0)
		        	numpages++;
		   
		     numpages1=numpages;
		      //singlelinkedlist W=new singlelinkedlist();
		        IMail[] toview=A.listEmails(1);
		        mails=new String [toview.length];
		        for(int i=0;i<toview.length;i++) {
		        	IMail s=toview[i];
		        	mails[i]=s.getsub()+"...."+s.getfrom()+"...."+s.getdate();

		        }
		       // W.add(mails); 
		        
		       
					list.setListData(mails);
		        }
		        catch(NullPointerException P){
		        	JOptionPane.showMessageDialog(null, "NO MAILS TO SHOW");
		        }
			}
        });
		 btnNewButton_9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				currentpage--;
				if(currentpage<1) {
					currentpage=1;
					JOptionPane.showMessageDialog(null, "there is no prev");
				}
				else {
					String deri="D:\\assignment 8\\parent\\" +sender+"\\"+where; 
					
			        IFolder fol=new Folder();
			        doublelinkedlist mess=fol.loadindexfile(deri);
					IApp A=new App();
					IFilter filt =new Filter();
					try {
						filt.Filtering(mess, filter.getSelectedItem().toString(), textField_1.getText(), deri);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						
						JOptionPane.showMessageDialog(null, "filter not found");
					}
					ISort sort2=new Sort();
					try {
						sort2.Sorting(sort.getSelectedItem().toString(), mess, deri);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					A.setViewingOptions(fol, filt, sort2);
			        
			        IMail[] toview=A.listEmails(currentpage);
			        mails=new String [toview.length];
			        for(int i=0;i<toview.length;i++) {
			        	IMail s=toview[i];
			        	mails[i]=s.getsub()+"...."+s.getfrom()+"...."+s.getdate();

			        }
			        list.setListData(mails);
				}
			}
        });
        
		 btnNewButton_10.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					currentpage++;
					if(currentpage>numpages1) {
						currentpage=numpages1;
						JOptionPane.showMessageDialog(null, "there is no next");
					}
					else {
						String deri="D:\\assignment 8\\parent\\" +sender+"\\"+where; 
						
				        IFolder fol=new Folder();
				        doublelinkedlist mess=fol.loadindexfile(deri);
						IApp A=new App();
						IFilter filt =new Filter();
						try {
							filt.Filtering(mess, filter.getSelectedItem().toString(), textField_1.getText(), deri);
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							
							JOptionPane.showMessageDialog(null, "filter not found");
						}
						ISort sort2=new Sort();
						try {
							sort2.Sorting(sort.getSelectedItem().toString(), mess, deri);
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						A.setViewingOptions(fol, filt, sort2);
				        
				        IMail[] toview=A.listEmails(currentpage);
				        mails=new String [toview.length];
				        for(int i=0;i<toview.length;i++) {
				        	IMail s=toview[i];
				        	mails[i]=s.getsub()+"...."+s.getfrom()+"...."+s.getdate();

				        }
				       
				        list.setListData(mails);
					}
				}
	        });
        
		 f.add(contentPane);
		 btnNewButton_1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String deri="D:\\assignment 8\\parent\\" +sender+"\\"+where; 
			        IFolder fol=new Folder();
			        doublelinkedlist mess=fol.loadindexfile(deri);
			        IApp A=new App();
					Object index1[]=list.getSelectedValues();
					if(index1.length==0) {
						JOptionPane.showMessageDialog(null, "please select first ");
					}
					String index[]=new String[index1.length];
					for(int i=0;i<index.length;i++) {
						index[i]=(String)index1[i];
					}
					String[]subj=new String [index.length];
					for(int i=0;i<index.length;i++) {
						int V=index[i].indexOf('.');
						subj[i]=(String) index[i].subSequence(0, V);	
					}
					IFolder fofo=new Folder();
					String tto="D:\\assignment 8\\parent\\"+sender+"\\"+where;
					doublelinkedlist frfr=new doublelinkedlist();
					try {
						frfr = fofo.loadfromsub(subj, tto);
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					ILinkedList tosend=new singlelinkedlist();
					tosend.add(deri);
					for(int p=0;p<index.length;p++) {
						tosend.add(frfr.get(p));
					}
					String distination="D:\\assignment 8\\parent\\" +sender+"\\Drafts";
					IFolder r=new Folder();
					r.setdir(distination);
					A.moveEmails(tosend, r);
					
			        mess=fol.loadindexfile(deri);
			        try {
			        	mess.isEmpty();
			        
						
					IFilter filt =new Filter();
					try {
						filt.Filtering(mess, filter.getSelectedItem().toString(), textField_1.getText(), deri);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						
						JOptionPane.showMessageDialog(null, "filter not found");
					}
					ISort sort2=new Sort();
					try {
						sort2.Sorting(sort.getSelectedItem().toString(), mess, deri);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					A.setViewingOptions(fol, filt, sort2);
			        
			        IMail[] toview=A.listEmails(currentpage);
			        mails=new String [toview.length];
			        for(int i=0;i<toview.length;i++) {
			        	IMail s=toview[i];
			        	mails[i]=s.getsub()+"...."+s.getfrom()+"...."+s.getdate();

			        }
			       
			        list.setListData(mails);
			        }
			        catch(NullPointerException P){
			        	JOptionPane.showMessageDialog(null, "NO MAILS TO SHOW");
			        }
				}
         });
        
		 btnNewButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String deri="D:\\assignment 8\\parent\\" +sender+"\\"+where; 
			        IFolder fol=new Folder();
			        doublelinkedlist mess=fol.loadindexfile(deri);
			        IApp A=new App();
					Object index1[]=list.getSelectedValues();
					if(index1.length==0) {
						JOptionPane.showMessageDialog(null, "please select first ");
					}
					String index[]=new String[index1.length];
					for(int i=0;i<index.length;i++) {
						index[i]=(String)index1[i];
					}
					String[]subj=new String [index.length];
					for(int i=0;i<index.length;i++) {
						int V=index[i].indexOf('.');
						subj[i]=(String) index[i].subSequence(0, V);	
					}
					IFolder fofo=new Folder();
					String tto="D:\\assignment 8\\parent\\"+sender+"\\"+where;
					doublelinkedlist frfr=new doublelinkedlist();
					try {
						frfr = fofo.loadfromsub(subj, tto);
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					ILinkedList tosend=new singlelinkedlist();
					tosend.add(sender);
					tosend.add(deri);
					for(int p=0;p<index.length;p++) {
						tosend.add(frfr.get(p));
					}
					A.deleteEmails(tosend);
					mess=fol.loadindexfile(deri);
					try {
			        	mess.isEmpty();
			       
					IFilter filt =new Filter();
					try {
						filt.Filtering(mess, filter.getSelectedItem().toString(), textField_1.getText(), deri);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						
						JOptionPane.showMessageDialog(null, "filter not found");
					}
					ISort sort2=new Sort();
					try {
						sort2.Sorting(sort.getSelectedItem().toString(), mess, deri);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					A.setViewingOptions(fol, filt, sort2);
			        
			        IMail[] toview=A.listEmails(currentpage);
			        mails=new String [toview.length];
			        for(int i=0;i<toview.length;i++) {
			        	IMail s=toview[i];
			        	mails[i]=s.getsub()+"...."+s.getfrom()+"...."+s.getdate();

			        }
			       
			        list.setListData(mails);
					 }
			        catch(NullPointerException P){
			        	JOptionPane.showMessageDialog(null, "NO MAILS TO SHOW");
			        }
				}
      });
		 btnNewButton_2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String deri="D:\\assignment 8\\parent\\" +sender+"\\"+where; 
			        IFolder fol=new Folder();
			        doublelinkedlist mess=fol.loadindexfile(deri);
			        try {
			        	mess.isEmpty();
			        
			        IApp A=new App();
					IFilter filt =new Filter();
					try {
						filt.Filtering(mess, filter.getSelectedItem().toString(), textField_1.getText(), deri);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						
						JOptionPane.showMessageDialog(null, "filter not found");
					}
					ISort sort2=new Sort();
					try {
						sort2.Sorting(sort.getSelectedItem().toString(), mess, deri);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					A.setViewingOptions(fol, filt, sort2);
			        
			        IMail[] toview=A.listEmails(currentpage);
			        mails=new String [toview.length];
			        for(int i=0;i<toview.length;i++) {
			        	IMail s=toview[i];
			        	mails[i]=s.getsub()+"...."+s.getfrom()+"...."+s.getdate();

			        }
			       
			        list.setListData(mails);
			        }
			        catch(NullPointerException P){
			        	JOptionPane.showMessageDialog(null, "NO MAILS TO SHOW");
			        }
				}
         });
		 
		 btnNewButton_4.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String deri="D:\\assignment 8\\parent\\" +sender+"\\"+where; 
			        IFolder fol=new Folder();
			        doublelinkedlist mess=fol.loadindexfile(deri);
			        try {
			        	mess.isEmpty();
			        
			        IApp A=new App();
					IFilter filt =new Filter();
					try {
						filt.Filtering(mess, filter.getSelectedItem().toString(), textField_1.getText(), deri);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						
						JOptionPane.showMessageDialog(null, "filter not found");
					}
					ISort sort2=new Sort();
					try {
						sort2.Sorting(sort.getSelectedItem().toString(), mess, deri);
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					A.setViewingOptions(fol, filt, sort2);
			        
			        IMail[] toview=A.listEmails(currentpage);
			        mails=new String [toview.length];
			        for(int i=0;i<toview.length;i++) {
			        	IMail s=toview[i];
			        	mails[i]=s.getsub()+"...."+s.getfrom()+"...."+s.getdate();

			        }
			       
			        list.setListData(mails);
			        }
			        catch(NullPointerException P){
			        	JOptionPane.showMessageDialog(null, "NO MAILS TO SHOW");
			        }
				}
      });
		 
		 btnNewButton_3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String deri="D:\\assignment 8\\parent\\" +sender+"\\"+where; 
			        IFolder fol=new Folder();
			        doublelinkedlist mess=fol.loadindexfile(deri);
			        try {
			        	mess.isEmpty();
			        
					ISearch ser=new Search();
					doublelinkedlist fromsearch=ser.search(mess, textField.getText());
					String [] mails=new String [fromsearch.size()];
				        for(int i=0;i<fromsearch.size();i++) {
				        	IMail s=(IMail)fromsearch.get(i);
				        	mails[i]=s.getsub()+"...."+s.getfrom()+"...."+s.getdate();
				        }
				       
				        list.setListData(mails);
			        }
			        catch(NullPointerException P){
			        	JOptionPane.showMessageDialog(null, "NO MAILS TO SHOW");
			        	
			        }
				}
         });
        
		 
		 btnNewButton_6.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						design g=new design (sender,where);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
         });
		 
		 btnNewButton_8.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					loging j=new loging();
					j.setsender(sender);
					j.homepage();
				}
         });
		 
		 btnNewButton_5.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String deri="D:\\assignment 8\\parent\\" +sender+"\\"+where; 
			        IFolder fol=new Folder();
			        doublelinkedlist mess=fol.loadindexfile(deri);
			        IApp A=new App();
					Object index1[]=list.getSelectedValues();
					if(index1.length==1) {
						
					String index[]=new String[index1.length];
					for(int i=0;i<index.length;i++) {
						index[i]=(String)index1[i];
					}
					String[]subj=new String [index.length];
					for(int i=0;i<index.length;i++) {
						int V=index[i].indexOf('.');
						subj[i]=(String) index[i].subSequence(0, V);	
					}
					String opendirectroy="D:\\assignment 8\\parent\\" +sender+"\\"+where;
					doublelinkedlist toopen=new doublelinkedlist();
					try {
						 toopen=fol.loadfromsub(subj, opendirectroy);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					Openmessage j=new Openmessage ((IMail)toopen.get(0));}
					
					else {
						JOptionPane.showMessageDialog(null, "please select only one message ");
					
					}
					
				}
         });
	}
}
