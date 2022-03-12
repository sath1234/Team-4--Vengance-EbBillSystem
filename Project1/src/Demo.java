impot java.sql.*;

public class Demo {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/ebill";
		String uname = "root";
		String pass = "root123";
		System.out.println("\n ----------TAMILNADU E-bill-----------\n\n\t1. New Customer\n\t2.  Print Bill\n\t3.  Payment Integration\n\t4.Exit");
		System.out.println("Enter your option : ");
		int c = sc.nextInt();
	
		    switch(c){
	        case 1:
	            System.out.println("-----New User Register----------");
	            register(url,uname,pass);
	            break;
	       case 2:
           printbill(url,uname,pass);
	           break;
	       
	       case 3:
	           System.out.println("3");
	           break;
	       case 4:
	           break;
	    }   
		

	

	}
	static void register(String url,String uname,String pass) throws ClassNotFoundException, SQLException{
	      @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
	      
	      int min = 10;  
	      int max = 90;
	      int id = (int)(Math.random()*(max-min+1)+min);  
	      
		    System.out.println("Enter your name : ");
		    String name = sc.next();
		    System.out.println("Your id is"+id);
		    System.out.println("Enter your phone number : ");
		    int num = sc.nextInt();
		    System.out.println("Enter you address : ");
		    String adr = sc.next();
		    System.out.println("Enter your previous Month Reading : ");
		    int prev = sc.nextInt();
		    System.out.println("Enter your Current Month Reading : ");
		    int curr = sc.nextInt();
		    System.out.println("Enter your Type :");
		    String type = sc.next();
		    System.out.println("-------Thank You for registering-------");
		    
		    String query = "insert into student values("+id+",'"+name+"',"+"'"+type+"',"+prev+","+curr+")";
		    Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uname,pass);
			
			Statement st = con.createStatement();
			@SuppressWarnings("unused")
			int count = st.executeUpdate(query);
			st.close();
			con.close();
	}
	static void printbill(String url,String uname,String pass) throws ClassNotFoundException, SQLException{
		Scanner sc = new Scanner(System.in);
		String query = "select * from student";
	    Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		Statement st = con.createStatement();
		ResultSet rs =st.executeQuery(query);
		System.out.println("Enter name to print bill :");
		String sname = sc.next();
		
		while(rs.next()) {
			String userdata = rs.getString(2);
			  if(sname.equals(userdata)) {
				  System.out.println("Name :  "+rs.getString(2)+"\n");
				    System.out.println("Customer ID : "+rs.getInt(1)+"\n");
				    System.out.println("Connection Type :"+rs.getString(3)+"\n");
				    int unt1 = rs.getInt(4);
				    int unt2 = rs.getInt(5);
				    System.out.println("Units Consumed : "+(unt1-unt2)+"\n");
				    System.out.println("----------------------");
				    System.out.println("Total amount to be paid : \n");
				    break;
			  }else {
				  System.out.println("Customer not present");
			  break;
			  }
			    	
			
		}
		
	}
}
		
	          
	

	
		    
		 
			 
