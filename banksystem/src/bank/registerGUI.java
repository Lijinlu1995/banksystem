package bank;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class registerGUI extends JFrame{
	  JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12;
	  JButton button1,button2,button3,button4,button5;
	  JFrame frame,frame1,frame2;
	  JTextField textfield1,textfield2,textfield3,textfield4,textfield5,textfield6;
	  String selection;
	  Customer customer;
	  JComboBox nameJComboBox;
	  ImageIcon bg = new ImageIcon("background.jpg");
	  JLabel label = new JLabel(bg);
	  ImageIcon f = new ImageIcon("sss.jpg");
	  JPanel imagePanel;
	  JLabel g=new JLabel(f);
    public registerGUI(){
		  cao();
	}
	public void cao(){
		button1=new JButton("确认");
		button2=new JButton("返回");
		button3=new JButton("退出");
		label1=new JLabel("姓名");
		label2=new JLabel("地址");
		label3=new JLabel("生日");
		label4=new JLabel("类型");
		label5=new JLabel("请输入账户号");
		label6=new JLabel("请再次输入账户号");
		label7=new JLabel("生日格式yyyy-MM-dd");
		textfield1=new JTextField(5);
		textfield2=new JTextField(5);
		textfield3=new JTextField(5);
		textfield4=new JTextField(5);
		textfield5=new JTextField(5);
        nameJComboBox = new JComboBox();
        nameJComboBox.addItem( "savor" );
        nameJComboBox.addItem( "junior" );
        nameJComboBox.addItem( "current" );
        
        setLayout(null);  
		add(label1);
		add(textfield1);
		add(label2);
		add(textfield2);
		add(label3);
		add(textfield3);
		add(label4);
		add(label7);
		add(nameJComboBox);
		add(button1);
		add(button2);
		add(button3);
		button1.setBounds(250,450,100,50);
		button2.setBounds(350,450,100,50);
		button3.setBounds(450,450,100,50);
		label1.setBounds(250,50,80,50);
		label2.setBounds(250,150,80,50);
		label3.setBounds(250,250,80,50);
		label4.setBounds(250,350,80,50);
		label1.setFont(new Font("楷体",Font.BOLD, 31));
		label2.setFont(new Font("楷体",Font.BOLD, 31));
		label1.setForeground(Color.blue);
		label2.setForeground(Color.blue);
		label3.setFont(new Font("楷体",Font.BOLD, 31));
		label4.setFont(new Font("楷体",Font.BOLD, 31));
		label3.setForeground(Color.blue);
		label4.setForeground(Color.blue);
		label7.setBounds(0,0,200,80);
		label7.setFont(new Font("楷体",Font.BOLD, 20));
		label7.setForeground(Color.blue);
		textfield1.setBounds(330,50,220,50);
		textfield2.setBounds(330,150,220,50);
		textfield3.setBounds(330,250,220,50);
		nameJComboBox.setBounds(330,350,220,50);
		label.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight());
		 imagePanel = (JPanel) this.getContentPane();  
        imagePanel.setOpaque(false);
		getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setVisible(true);
		setLocationRelativeTo(null);
		
button1.addActionListener(new ActionListener(){
	  public void actionPerformed(ActionEvent e) {
		  
	         selection= nameJComboBox.getSelectedItem().toString();
	         System.out.println(textfield3.getText());
	         String ai[]=textfield3.getText().split("-");
	         int bi=Integer.parseInt(ai[0]); 
	         if (bi<1999&&selection.equals("junior")) {
	        	 label7.setText("你的年龄不符合Junior账户");
	         }
	         SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
	         Date date = null;
			try {
				date = sdf.parse(textfield3.getText());
			} catch (ParseException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
	         Calendar calendar = Calendar.getInstance();
	         calendar.setTime(date);
	         customer=new Customer(textfield1.getText(),textfield2.getText(),calendar);
	         
	         System.out.print(textfield1.getText());
	         
	         frame=new JFrame("账户号");
	         
	        
	         
	 		
	 		frame.add(label5);
	         
	 		 textfield4=new JTextField(5);
	         frame.add(textfield4);
	         frame.add(label6);
	         textfield5=new JTextField(5);
	         frame.add(textfield5);
	         button4=new JButton("确认");
	         frame.add(button4);
	         button2=new JButton("返回");
	         frame.add(button2);
	         button4.addActionListener(new ActionListener(){
	       	  public void actionPerformed(ActionEvent e) {
	       		System.out.print(textfield4.getText().equals(textfield5.getText()));
	       		     if(textfield4.getText().equals(textfield5.getText())){
	       		     int num= Integer.parseInt(textfield4.getText());
	       		     account account= new account(num,selection,customer);	 
	       		     file file =new file();
	       		     file.cunru(account);
	       		     frame1=new JFrame("注册成功");
	       		     frame1.setLayout(new FlowLayout());    	
	 			     frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 			     frame1.setSize(300,220);
	 			     frame1.setVisible(true);frame.setLocationRelativeTo(null);
	 			     button1=new JButton("返回");
	 			     label1=new JLabel("恭喜您！注册成功");
	 			     label3=new JLabel("姓名");
	 			     label4=new JLabel("地址");
	 			     label5=new JLabel("生日");
	 			     label6=new JLabel("类型");
	 			     label7=new JLabel("PIN");
	 			     label8=new JLabel(customer.getname());
	 			     label9=new JLabel(customer.getaddress());
	 			     label10=new JLabel(textfield3.getText());
	 			     label11=new JLabel(selection);
	 			     String s=String.valueOf(account.getPin());
	 			     label12=new JLabel(s);
	 			     frame1.add(label1);
	 			     frame1.add(label3);
	 			   frame1.add(label8);
	 			 frame1.add(label4);
	 			frame1.add(label9);
	 			frame1.add(label5);
	 			frame1.add(label10);
	 			frame1.add(label6);
	 			frame1.add(label11);
	 			frame1.add(label7);
	 			frame1.add(label12);
	 			     frame1.add(button1);
	 			     button1.addActionListener(new ActionListener(){
	 			 	  public void actionPerformed(ActionEvent e) {
	 			 		  frame1.dispose();
		       		      new startGUI();
	 			 			  }
	 			 				});
	 			     
	       		     
	       		     }
	       		     else{
	       		    	frame1=new JFrame("");
		       		     frame1.setLayout(new FlowLayout());    	
		 			     frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 			     frame1.setSize(300,220);
		 			     frame1.setVisible(true);frame1.setLocationRelativeTo(null);
		 			    label1=new JLabel("两次输入的账户不同！");
		 			    button1=new JButton("返回");
		 			    frame1.add(label1);
		 			    frame1.add(button1);
		 			    button1.addActionListener(new ActionListener(){
			 			 	  public void actionPerformed(ActionEvent e) {
			 			 		  frame1.dispose();
				       		      textfield4.setText("");
				       		      textfield5.setText("");
				       		      
			 			 			  }
			 			 				});
		 			    
	       		     }
	       			  }
	       				});
	         button2.addActionListener(new ActionListener(){
		       	  public void actionPerformed(ActionEvent e) {
		       		 frame.dispose();
		       			  }
		       				});
	 		 frame.setLayout(new FlowLayout());    	
			 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 frame.setSize(200,150);
			 frame.setVisible(true);frame.setLocationRelativeTo(null);
			 		  }
						});
button2.addActionListener(new ActionListener(){
	  public void actionPerformed(ActionEvent e) {
	          new startGUI();
	          dispose();	          
			  }
				});
button3.addActionListener(new ActionListener(){
	  public void actionPerformed(ActionEvent e) {
		     System.exit(0);
			  }
				});
    }
}
