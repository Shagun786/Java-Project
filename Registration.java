import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Connection;

class Registration extends Frame implements ActionListener
{
  TextField n,p;
  Label l1,l2 ;
  Button submit,signup;
  Button save, clear , ok;
  TextField txtName, txtPassword, txtConPassword;
  Label lblReg, lblName, lblPassword, lblConPassword, lblGender, lblCourse, lblHobbies;
  Checkbox chkMale, chkFemale, chkHobby1, chkHobby2, chkHobby3, chkHobby4;
  CheckboxGroup cbgGender;
  Choice chCourse;
  String Name, Password, hobby="", Gender, Course , regcourse,reggender,reghobby,regname,regpassword;
  Registration()
   {
     setLayout(null);
     Label name = new Label("Name", Label.CENTER);
     Label pass= new Label("Password", Label.CENTER);
     l1= new Label("Welcome");
     l2= new Label("Invalid ID password");

     n= new TextField(20);

     p= new TextField(20);
     p.setEchoChar('*');

     submit= new Button("Login");

     submit.addActionListener(this);

     signup= new Button("SignUp");

	 signup.addActionListener(this);

     name.setBounds(80,95,60,50);
     pass.setBounds(80,145,60,50);
     n.setBounds(150,110,80,20);
     p.setBounds(150,160,80,20);
     submit.setBounds(120,200,60,30);
     signup.setBounds(200,200,60,30);
     l1.setBounds(150,250,100,100);
     l2.setBounds(150,250,120,100);

     add(name);
     add(pass);
     add(n);
     add(p);
     add(submit);
     add(signup);


   }


   public void actionPerformed(ActionEvent e)
   {
    if (e.getSource()==submit)
	{
    String id= n.getText();
    String pass= p.getText();
    Frame f = new Frame("Profile");
	try{
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demodb","root","shagun@123");
	Statement s= con.createStatement();
	String query="select * from siso where name='"+id+"'and password='"+pass+"'";
	ResultSet rs= s.executeQuery(query);
	while(rs.next())
	{
        
	 regname=rs.getString("Name");
	 regpassword=rs.getString("Password");
	 reggender=rs.getString("Gender");
	 regcourse=rs.getString("Course");
	 reghobby=rs.getString("hobby");
	 //System.out.println(name +" "+password+" " +gender+" " +course+" " +hobby);
			  	
	}
	}
	catch(SQLException ex)
	{
		System.out.println(ex);
	}
			  
     if(pass.equals(regpassword) && id.equals(regname))
      {
		f.setLayout(null);
        Label pName, pGender, pHobby, pCourse;
		Label VName, VGender, VHobby, VCourse;
		
		pName= new Label("Name");
		pGender= new Label("Gender");
		pCourse= new Label("Course");
		pHobby= new Label("Hobbies");
		
		VName= new Label(regname);
		VGender= new Label(reggender);
		VHobby= new Label(reghobby);
		VCourse= new Label(regcourse);
		
		pName.setBounds(50,70,50,30);
		pGender.setBounds(50,110,50,30);
		pCourse.setBounds(50,150,50,30);
		pHobby.setBounds(50,190,50,30);
		
		VName.setBounds(150,70,100,30);
		VGender.setBounds(150,110,80,30);
		VCourse.setBounds(150,150,80,30);
		VHobby.setBounds(150,190,150,30);
		
		
        f.setVisible(true);
        f.setSize(400,400);
        setVisible(false);
        f.add(pCourse);
		f.add(pGender);
		f.add(pHobby);
		f.add(pName);
		f.add(VCourse);
		f.add(VGender);
		f.add(VHobby);
		f.add(VName);
      }
      else
       {
        add(l2);
       }
	}

	else if(e.getSource()==signup)
	{
		Frame sp= new Frame("Signup");


        sp.setSize(1530,820);
        sp.setLayout(null);
        sp.setVisible(true);
        Color formColor= new Color(53,59,72);
        sp.setBackground(formColor);

        Font titleFont= new Font("Arial", Font.BOLD, 25);
        Font labelFont= new Font("Arial", Font.PLAIN, 18);
        Font textFont= new Font("Arial", Font.PLAIN, 15);

        lblReg= new Label("Registration Form");
        lblReg.setForeground(Color.YELLOW);
        lblReg.setFont(titleFont);

        lblName= new Label("Name");
        lblName.setFont(labelFont);
	    lblName.setForeground(Color.WHITE);

        lblPassword= new Label("Password");
        lblPassword.setFont(labelFont);
	    lblPassword.setForeground(Color.WHITE);

        lblConPassword= new Label("Confirm Password");
        lblConPassword.setFont(labelFont);
	    lblConPassword.setForeground(Color.WHITE);

        lblGender= new Label("Gender");
        lblGender.setFont(labelFont);
	    lblGender.setForeground(Color.WHITE);

        lblCourse= new Label("Course");
        lblCourse.setFont(labelFont);
	    lblCourse.setForeground(Color.WHITE);

        lblHobbies= new Label("Hobbies");
        lblHobbies.setFont(labelFont);
	    lblHobbies.setForeground(Color.WHITE);

        
	    txtName=new TextField("");
	    txtName.setFont(textFont);

	    txtPassword=new TextField("");
	    txtPassword.setFont(textFont);

	    txtConPassword= new TextField("");
	    txtConPassword.setFont(textFont);
	    txtConPassword.setEchoChar('*');

	    cbgGender= new CheckboxGroup();

        chkMale= new Checkbox("Male",cbgGender,true);
	    chkMale.setForeground(Color.WHITE);
	    chkMale.setFont(labelFont);

	    chkFemale=new Checkbox("Female",cbgGender,false);
	    chkFemale.setFont(labelFont);
	    chkFemale.setForeground(Color.WHITE);

	    chCourse= new Choice();
	    chCourse.setFont(labelFont);
	    chCourse.add("JAVA");
	    chCourse.add("Python");
	    chCourse.add("C++");
	    chCourse.add("C");
	    chCourse.add("C#");

	    chkHobby1= new Checkbox("Drawing");
	    chkHobby1.setFont(labelFont);
	    chkHobby1.setForeground(Color.WHITE);

	    chkHobby2= new Checkbox("Singing");
	    chkHobby2.setFont(labelFont);
	    chkHobby2.setForeground(Color.WHITE);

	    chkHobby3= new Checkbox("Music");
	    chkHobby3.setFont(labelFont);
	    chkHobby3.setForeground(Color.WHITE);

	    chkHobby4= new Checkbox("Other");
	    chkHobby4.setFont(labelFont);
	    chkHobby4.setForeground(Color.WHITE);

	    

	    save= new Button("Save Details");
	    save.setFont(labelFont);
	    save.setBackground(Color.BLUE);
	    save.addActionListener(this);

	    clear= new Button("Clear All");
	    clear.setFont(labelFont);
	    clear.setBackground(Color.RED);
	    clear.addActionListener(this);

	    lblReg.setBounds(450,40,400,50);

	    lblName.setBounds(450,100,50,70);
	    txtName.setBounds(620,115,400,30);

	    lblPassword.setBounds(450,190,100,70);
	    txtPassword.setBounds(620,205,400,30);

	    lblConPassword.setBounds(450,270,150,70);
	    txtConPassword.setBounds(620,285,400,30);

	    lblGender.setBounds(450,340,70,70);
	    chkMale.setBounds(620,360,60,30);
	    chkFemale.setBounds(700,360,80,30);

	    lblCourse.setBounds(450,410,70,70);
	    chCourse.setBounds(620,430,400,30);

	    lblHobbies.setBounds(450,490,70,70);
	    chkHobby1.setBounds(620,505,80,30);
	    chkHobby2.setBounds(730,505,80,30);
	    chkHobby3.setBounds(830,505,80,30);
	    chkHobby4.setBounds(910,505,80,30);

	    
	    save.setBounds(620,600,150,30);
	    clear.setBounds(780,600,150,30);


	    sp.add(lblReg);

	    sp.add(lblName);
	    sp.add(txtName);

	    sp.add(lblPassword);
	    sp.add(txtPassword);

	    sp.add(lblConPassword);
	    sp.add(txtConPassword);

	    sp.add(lblGender);
	    sp.add(chkMale);
	    sp.add(chkFemale);


	    sp.add(lblCourse);
	    sp.add(chCourse);

	    sp.add(lblHobbies);
	    sp.add(chkHobby1);
	    sp.add(chkHobby2);
	    sp.add(chkHobby3);
	    sp.add(chkHobby4);


	    sp.add(save);
	    sp.add(clear);

		this.setVisible(false);


   }
   else if(e.getSource()==clear)
	   {
		   txtName.setText("");
		   txtPassword.setText("");
		   txtConPassword.setText("");
		   
	   }
	else if (e.getSource()==save)
	   {
		   if(txtPassword.getText().equals(txtConPassword.getText()))
		   {

			    Name=txtName.getText();
			    Password=txtPassword.getText();
				Course=chCourse.getSelectedItem();
				if(chkMale.getState())
		         {
			      Gender="Male";
				  if (chkHobby1.getState())
		        {
			      hobby=hobby+"Drawing";
			      if(chkHobby2.getState())
			      {
				    hobby=hobby+", Singing";
				    if(chkHobby3.getState())
				     {
					   hobby=hobby+", Music";
				     }
			      }
		        }
		        else if(chkHobby2.getState())
			       {
				     hobby=hobby+"Singing";
				     if(chkHobby3.getState())
				     {
					   hobby=hobby+", Music";
				     }
			       }
			    else if(chkHobby3.getState())
			    {
				   hobby=hobby+"Music";
			    }
		        else if(chkHobby4.getState())
		        {
			      hobby=hobby+"Other";
		        }
			     }
		        else if(chkFemale.getState())
		        {
			     Gender="Female";
				 if (chkHobby1.getState())
		        {
			      hobby=hobby+"Drawing";
			      if(chkHobby2.getState())
			      {
				    hobby=hobby+", Singing";
				    if(chkHobby3.getState())
				     {
					   hobby=hobby+", Music";
				     }
			      }
		        }
		        else if(chkHobby2.getState())
			       {
				     hobby=hobby+"Singing";
				     if(chkHobby3.getState())
				     {
					   hobby=hobby+", Music";
				     }
			       }
			    else if(chkHobby3.getState())
			    {
				   hobby=hobby+"Music";
			    }
		        else if(chkHobby4.getState())
		        {
			      hobby=hobby+"Other";
		        }
		        }
				Frame success= new Frame("Succesful");
				setLayout(null);
				Label lab= new Label("You have succesfully Signed up!!");
				ok= new Button("Okay");
				ok.addActionListener(this);
				lab.setBounds(50,50,200,50);
				ok.setBounds(100,300,50,50);
				success.add(lab);
				success.add(ok);
				success.setVisible(true);
				success.setSize(400,400);
				setVisible(false);
		        
		   
	        }
				try
				{
			    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/demodb","root","shagun@123");
	            String q="insert into siso values('"+Name+"','"+Password+"','"+Gender+"','"+hobby+"','"+Course+"')";
                PreparedStatement ps= con.prepareStatement(q);
	            ps.executeUpdate();
	            }
				catch(SQLException sq)
			{
				System.out.println(sq);
			}
		}


    
		   else
		   {
			   Frame a= new Frame("Error");
			   a.setLayout(null);
			   a.setVisible(true);
			   a.setSize(300,300);
			   Label l= new Label("Password and Confirm Password do not match");
			   l.setBounds(50,50,200,50);
			   a.add(l);
		   }
   }   

  public static void main(String args[])
  {
    Registration awt= new Registration();
    awt.setSize(400,400);
    awt.setVisible(true);
  }
}

