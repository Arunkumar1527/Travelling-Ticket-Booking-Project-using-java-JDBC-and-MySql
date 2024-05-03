import java.sql.*;
import java.util.Scanner;

public class main 
{
	int T_ID,TICKET_COST;
	long PHONE_NO;
	String B_NAME,T_FROM,T_TO,T_DATE,ID_PROOF,ID_PROOF_NO;
	Scanner s = new Scanner(System.in);
	void add()
	{
		try
		{
			System.out.println("Enter The ID No : ");
			T_ID = s.nextInt();	
			System.out.println("Enter the User Name : ");
			B_NAME = s.next();
			System.out.println("Enter the From : ");
			T_FROM = s.next();
			System.out.println("Enter the To : ");
			T_TO = s.next();
			System.out.println("Enter the Travel Date : ");
			T_DATE = s.next();
			System.out.println("Enter the Phone No : ");
			PHONE_NO = s.nextLong();
			System.out.println("Enter the IT Proof : ");
			ID_PROOF = s.next();
			System.out.println("Enter the IT Proof No : ");
			ID_PROOF_NO = s.next();
			System.out.println("Enter the Ticket Cost : ");
			TICKET_COST = s.nextInt();
			
		
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/project","root","Arunkumar@5");
			PreparedStatement p = con.prepareStatement("insert into userdata values(?,?,?,?,?,?,?,?,?)");
			p.setInt(1,T_ID);
			p.setString(2,B_NAME);
			p.setString(3, T_FROM);
			p.setString(4, T_TO);
			p.setString(5, T_DATE);
			p.setLong(6,PHONE_NO);
			p.setString(7, ID_PROOF);
			p.setString(8, ID_PROOF_NO);
			p.setInt(9, TICKET_COST);
			p.executeUpdate();
			con.close();
			System.out.println("Data Saved...");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void modify()
	{
		try
		{
			System.out.println("Enter The ID No : ");
			T_ID = s.nextInt();	
			System.out.println("Enter the Phone No : ");
			PHONE_NO = s.nextLong();
		
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/project","root","Arunkumar@5");
			PreparedStatement p = con.prepareStatement("update userdata set PHONE_NO =? where T_ID =?");
			p.setLong(1, PHONE_NO);
			p.setInt(2,T_ID);
			int r = p.executeUpdate();
			con.close();
			System.out.println((r!=0) ? "Data Updated" : "Invalid name");
		}
			catch(Exception e)
		{
				System.out.println(e);
		}
	}
	void delete()
	{
		try
		{
			System.out.println("Enter the From : ");
			T_FROM = s.next();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/project","root","Arunkumar@5");
			PreparedStatement p = con.prepareStatement("delete from userdata where T_FROM = ?");
			p.setString(1,T_FROM);
			int r = p.executeUpdate();
			con.close();
			System.out.println((r!=0) ? "Data delete" : "Invalid name");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void find()
	{
		try
		{
			System.out.println("Enter the Ticket Cost : ");
			TICKET_COST = s.nextInt();
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/project","root","Arunkumar@5");
			PreparedStatement p = con.prepareStatement("select * from userdata where TICKET_COST = ?");
			p.setInt(1,TICKET_COST);
			ResultSet r = p.executeQuery();
			int c=0;
			while(r.next())
			{
				System.out.println("The ID No : "+r.getInt(1));
				System.out.println("The User Name : "+r.getString(2));
				System.out.println("The User From : "+r.getString(3));
				System.out.println("The User To : "+r.getString(4));
				System.out.println("The User Travel Date : "+r.getString(5));
				System.out.println("The User Phone No : "+r.getLong(6));
				System.out.println("The User IT Proof : "+r.getString(7));
				System.out.println("The User IT Proof No : "+r.getString(8));
				System.out.println("The User Ticket Cost : "+r.getInt(9));
				System.out.println("..............................");
				c++;
			}
			con.close();
			if(c==0)
			{
				System.out.println("Invalid Name");
			}
		}
		catch(Exception e)
		{
				System.out.println(e);
		}
	}
	public static void main(String[] args) 
	{
		main p=new main();
		String un="Arun";
		String ps="Arun@5";
		String User_Name="";
		String Password="";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter User Name: ");
		User_Name=sc.nextLine();
		System.out.println("Enter Password: ");
		Password=sc.nextLine();
		if(un.equals(User_Name) && ps.equals(Password))
		{
	        System.out.println("Login Success..");
			while(true)
	       {
	           System.out.println("1.Add\n2.Modify\n3.Delete\n4.Find\n5.Exit\nSelect any 1:");
	           int ch = sc.nextInt();
	           if(ch==1)
	           {
	               p.add();
	           }
	           else if(ch==2)
	           {
	               p.modify();
	           }
	           else if(ch==3)
	           {
	               p.delete();
	           }
	           else if(ch==4)
	           {
	               p.find();
	           }
	           else if(ch==5)
	           {
	               System.out.println("Thank you....");
	               break;
	           }
	           else
	           {
	               System.out.println("Invalid choice...");
	           }
	       }
		}
		else
		{
			System.out.println("Invalid User Namd & Password");
		}
	}
}
