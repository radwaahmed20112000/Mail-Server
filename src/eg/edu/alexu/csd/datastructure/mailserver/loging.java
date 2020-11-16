
package eg.edu.alexu.csd.datastructure.mailserver;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.awt.Desktop;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import eg.edu.alexu.csd.datastructure.linkedlist.ILinkedList;
import eg.edu.alexu.csd.datastructure.linkedlist.singlelinkedlist;
import eg.edu.alexu.csd.datastructure.queue.linkedlistimp;

public class loging {
	
	String Sender;
	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    int i=0;
    int count=0;
    public void setsender(String S) {
    	Sender=S;
    }
	///////////////////////////////////////////////////////////signup&&signin/////////////////////////////////////////////////////////

	JFrame f=new JFrame("LOGING");
	JPanel p=new JPanel(new GridBagLayout());
	JButton b2=new JButton("SIGN IN");
	JButton b1=new JButton("SIGN UP");
	
	
	public loging() {
		log();
	}
   public void log() {
	 
	   f.setVisible(true);
		f.setSize(600, 400);
		f.setDefaultCloseOperation(JFrame .EXIT_ON_CLOSE);
		
		
		
		p.setBackground(Color.black);
		GridBagConstraints g=new GridBagConstraints();
		g.insets=new Insets(10,10,10,10);
		g.gridx=0;
		g.gridy=4;
		p.add(b1,g);
		g.gridx=0;
		g.gridy=5;
		p.add(b2,g);
		
		b1.setBackground(Color.gray);
		b2.setBackground(Color.gray);
		b1.setForeground(Color.WHITE);
		b2.setForeground(Color.WHITE);
		f.add(p);
		////////////////////////////////signup///////////////////////////signup////////////////////////////////////
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFrame f1=new JFrame("SIGN UP");
				JPanel p1=new JPanel(new GridBagLayout());
				JButton b11=new JButton("SIGN UP");
				JLabel l1=new JLabel("ENTER THE Name");
				JLabel l2=new JLabel("ENTER THE PASSWORD");
				JLabel l3=new JLabel("ENTER THE MAIL");
				JTextField t1=new JTextField (20);
				JPasswordField t2=new JPasswordField (10);
				JTextField t3=new JTextField (20);
				  b11.setBackground(Color.black);
				   b11.setForeground(Color.WHITE);
				    f1.setVisible(true);
					f1.setSize(600, 400);
					f1.setDefaultCloseOperation(JFrame .EXIT_ON_CLOSE);
					
					p1.setBackground(Color.gray);
					GridBagConstraints g=new GridBagConstraints();
					g.insets=new Insets(10,10,10,10);

					g.gridx=0;
					g.gridy=4;
					p1.add(l1,g);
					g.gridx=0;
					g.gridy=5;
					p1.add(l2,g);
					g.gridx=0;
					g.gridy=6;
					p1.add(l3,g);
					g.gridx=4;
					g.gridy=4;
					p1.add(t1,g);
					g.gridx=4;
					g.gridy=5;
					p1.add(t2,g);
					g.gridx=4;
					g.gridy=6;
					p1.add(t3,g);
					g.gridx=2;
					g.gridy=7;
					p1.add(b11,g);
					
					f1.add(p1);
					 
					b11.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							IContact h=new Contact();
							h.setname(t1.getText());
							h.setpassword(t2.getText());
							h.setmail(t3.getText());
							Sender=t3.getText();
							App a=new App();
							Boolean message=a.signup(h);
			                  
							System.out.println(t1.getText());
							
							if((t1.getText().equals(""))&&(t2.getText().equals(""))&&(t3.getText().equals(""))) {
								JOptionPane.showMessageDialog(null, "YOU DIDNOT ENTER ANY THING");}
							
							else if( message==true) {
								homepage();}
				
					       else if( message==false) {
						        JOptionPane.showMessageDialog(null, "the account Already exists");}
					
						}
                    });
			}
		});
		
		////////////////////////////////signin///////////////////////////signin////////////////////////////////////
		
		
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFrame f2=new JFrame("SIGN IN");
				JPanel p2=new JPanel(new GridBagLayout());
				JButton b12=new JButton("SIGN IN");
				JLabel l12=new JLabel("ENTER THE MAIL");
				JLabel l22=new JLabel("ENTER THE PASSWORD");
				JTextField t12=new JTextField (20);
				JPasswordField t22=new JPasswordField (10);
				  b12.setBackground(Color.black);
				   b12.setForeground(Color.WHITE);
				    f2.setVisible(true);
					f2.setSize(600, 400);
					f2.setDefaultCloseOperation(JFrame .EXIT_ON_CLOSE);
					
					p2.setBackground(Color.gray);
					GridBagConstraints g=new GridBagConstraints();
					g.insets=new Insets(10,10,10,10);

					g.gridx=0;
					g.gridy=4;
					p2.add(l12,g);
					g.gridx=0;
					g.gridy=5;
					p2.add(l22,g);
					g.gridx=4;
					g.gridy=4;
					p2.add(t12,g);
					g.gridx=4;
					g.gridy=5;
					p2.add(t22,g);
					g.gridx=2;
					g.gridy=7;
					p2.add(b12,g);
					f2.add(p2);
					 
					b12.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							
							App a=new App();
							Sender=t12.getText();
							Boolean message=a.signin(t12.getText(),t22.getText());
			                   
							if((t12.getText().equals(""))&&(t22.getText().equals(""))) {
								JOptionPane.showMessageDialog(null, "YOU DIDNOT ENTER ANY THING");}
						    else if( message==true) {
						    	homepage();}	
					        else if(message==false) {
						       JOptionPane.showMessageDialog(null, "the account doesnot exist");}
					
						}
            });
	     }
       });
   }
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
		
		public void homepage() {
			JFrame f3=new JFrame("HOME");
			JPanel p3=new JPanel(new GridBagLayout());
			JButton b13=new JButton("HOME");
			JButton b23=new JButton("INBOX");
			JButton b33=new JButton("SENT");
			JButton b43=new JButton("TRASH");
			JButton b53=new JButton("DRAFT");
			JButton b63=new JButton("CONTACTS");
			JButton b73=new JButton("SEND NEW MESSAGE");

			b13.setBackground(Color.black);
			b13.setForeground(Color.WHITE);
			b23.setBackground(Color.black);
			b23.setForeground(Color.WHITE);
			b33.setBackground(Color.black);
			b33.setForeground(Color.WHITE);
			b43.setBackground(Color.black);
			b43.setForeground(Color.WHITE);
			b53.setBackground(Color.black);
			b53.setForeground(Color.WHITE);
			b63.setBackground(Color.black);
			b63.setForeground(Color.WHITE);
			b73.setBackground(Color.black);
			b73.setForeground(Color.WHITE);
			    f3.setVisible(true);
				f3.setSize(600, 400);
				f3.setDefaultCloseOperation(JFrame .EXIT_ON_CLOSE);
				
				p3.setBackground(Color.gray);
				GridBagConstraints g=new GridBagConstraints();
				g.insets=new Insets(10,10,10,10);

				g.gridx=2;
				g.gridy=0;
				p3.add(b13,g);
				g.gridx=0;
				g.gridy=1;
				p3.add(b23,g);
				g.gridx=0;
				g.gridy=2;
				p3.add(b33,g);
				g.gridx=0;
				g.gridy=3;
				p3.add(b43,g);
				g.gridx=0;
				g.gridy=4;
				p3.add(b53,g);
				g.gridx=0;
				g.gridy=5;
				p3.add(b63,g);
				g.gridx=4;
				g.gridy=3;
				//b73.setPreferredSize(new Dimension(80, 80));
				p3.add(b73,g);
				f3.add(p3);
				 
				b13.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
		             }	
                     });
				b23.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							design I=new design(Sender,"Inbox");
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		             }	
                     });
				b33.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							design I=new design(Sender,"sent");
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		             }	
                     });
				b43.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							design I=new design(Sender,"trash");
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		             }	
                     });
				b53.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							design I=new design(Sender,"Drafts");
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		             }	
                     });
				b63.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
		             }	
                     });
				b73.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						singlelinkedlist attach = new singlelinkedlist();
						linkedlistimp recievers = new linkedlistimp();
						JFrame sent = new JFrame("Send New Email");
						sent.setVisible(true);
						sent.setSize(600,400);
						sent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						JPanel p = new JPanel(new GridBagLayout());
						p.setBackground(Color.gray);
						JTextField Subject =new JTextField (20);
						JTextField To = new JTextField(20);
						JTextArea Content = new JTextArea(30,40);
						JButton Send = new JButton("Send");
						JButton addr = new JButton("+");
						JButton attachment = new JButton("Add Attachments");
						JButton open=new JButton ("open selscted Attachment");
						GridBagConstraints c = new GridBagConstraints();
						JLabel l1 = new JLabel("Subject : ");
						JLabel l2 = new JLabel("To :");
						JLabel l3 = new JLabel("Content :");
						JComboBox comboBox = new JComboBox();
						JComboBox comboBox2 = new JComboBox();
						
						comboBox.setBackground(Color.LIGHT_GRAY);
						comboBox2.setBackground(Color.LIGHT_GRAY);
						
						Send.setBackground(Color.black);
						Send.setForeground(Color.WHITE);
						addr.setBackground(Color.black);
						addr.setForeground(Color.WHITE);
						attachment.setBackground(Color.black);
						attachment.setForeground(Color.WHITE);
						open.setBackground(Color.black);
						open.setForeground(Color.WHITE);
						
						
						c.insets = new Insets(10,10,10,10);
						c.gridx=0;
						c.gridy=4;
						p.add(l1,c);
						c.gridx=0;
						c.gridy=5;
						p.add(l2,c);
						c.gridx=0;
						c.gridy=7;
						p.add(l3,c);
						c.gridx=4;
						c.gridy=4;
						p.add(Subject,c);
						c.gridx=4;
						c.gridy=5;
						p.add(To,c);
						c.gridx=4;
						c.gridy=7;
						//Content.setPreferredSize(new Dimension(300, 400));
						//Content.setBounds(240, 170, 400,300);
						p.add(Content,c);
						c.gridx=4;
						c.gridy=10;
						p.add(Send,c);
						c.gridx = 8;
						c.gridy = 8;
						p.add(attachment,c);
						c.gridx = 7;
						c.gridy = 8;
						p.add(comboBox2,c);
						c.gridx = 7;
						c.gridy = 5;
						p.add(addr,c);
						sent.add(p);
						c.gridx=4;
						c.gridy=6;
						p.add(comboBox,c);
						JButton remove = new JButton("remove choosen mail");
						remove.setBackground(Color.black);
						remove.setForeground(Color.WHITE);
						
						c.gridx=7;
						c.gridy=6;
						p.add(remove,c);
						JButton removea = new JButton("remove choosen attachment");
						removea .setBackground(Color.black);
						removea .setForeground(Color.WHITE);
						
						c.gridx=8;
						c.gridy=9;
						p.add(removea,c);
						c.gridx=8;
						c.gridy=10;
						p.add(open,c);
						
						addr.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								
								comboBox.insertItemAt(To.getText(), i);
								i++;
								To.setText("");
								
							}
						});
						attachment.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								
								JFileChooser j = new JFileChooser("d:");
								j.showOpenDialog(null); 
								File file= j.getSelectedFile();
								String filepath=file.getAbsolutePath();
								comboBox2.insertItemAt(filepath, count);
								count++;
							}
						});
						remove.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								String y =(String) comboBox.getSelectedItem();
								comboBox.removeItem(comboBox.getSelectedItem());
								To.setText(y);
								i--;
							}
							
						});
						removea.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								String y =(String) comboBox2.getSelectedItem();
								comboBox2.removeItem(comboBox2.getSelectedItem()); 
								count--;
							}
							
						});
						
						open.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								String y =(String) comboBox2.getSelectedItem();
								File f=new File(y);
								   try {
									Desktop.getDesktop().open(f);
								} catch (IOException e1) {
									e1.printStackTrace();
								}
								
							}
						});
				Send.addActionListener(new ActionListener() {
				   @Override
				  public void actionPerformed(ActionEvent e) {
								
				    if(Content.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Content is Empty");
					}else if (Subject.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Subject is Empty");
					}else if (To.getText().equals("") && comboBox.getItemCount()==0) {
						JOptionPane.showMessageDialog(null, "You didn't enter any recievers");
					}else {
						String Con = Content.getText();
						String Sub = Subject.getText();
						/*if(!To.getText().equals("") || !To.getText().equals(" ")) {
						recievers.enqueue(To.getText());
						  }*/
					for(int i =0 ;i<comboBox.getItemCount();i++) {
					  recievers.enqueue(comboBox.getItemAt(i));
									}
					for(int i =0 ;i<comboBox2.getItemCount();i++) {
					    String attachments=comboBox2.getItemAt(i).toString();
						//attachments=attachments.replaceAll("\", "\\");
						//File f=new File (attachments);		
						attach.add(attachments);
							}
						IMail mail = new Mail();
					    LocalDateTime now = LocalDateTime.now();
						String date1 = dtf.format(now);
									        
						mail.set(Sender, recievers, Sub, date1, Con, attach);
						
						IApp x =new App();
									
									i=0; count=0;
							if(!x.compose(mail)) {
								JOptionPane.showMessageDialog(null,"Error! .. Check your Messege again");
										
							}else {
								JOptionPane.showMessageDialog(null,"Your Message has been sent successfully");
				                      homepage();
										
									}
								}
								
							}
							
						});
					
					}
                     });
		             }
		
}
