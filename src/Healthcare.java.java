import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;





public class Home {
    static Connection connection = null;
    static String databaseName = "";
    static String url = "jdbc:mysql://localhost:3306/"+ databaseName;
    static String username = "root";
    static String password = "najmafatimas786@";
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection =  DriverManager.getConnection(url,username,password);
        Scanner in = new Scanner(System.in);
        
        login();
	}
	static void login() throws SQLException {
		Scanner in = new Scanner(System.in);
        	  System.out.println("LOGIN:");
        	  System.out.println("enter user name:");
        	  String username1 = in.nextLine();
        	  System.out.println("enter the password");
        	  String password1 = in.nextLine();
        	  
        	
         
         Statement st = connection.createStatement();
         ResultSet rs = st.executeQuery("select * from healthcaremangement.register where Username='" + username1 + "' and Passwordl='" + password1 + "' ");
         if(rs.next()){
        	 System.out.println("login success");
        	 mainu();
         }
         else {
        	System.out.println("Please Register");
        	register();
         }
         
        
        

         
        
	}
	static void mainu() throws SQLException {
		Scanner in = new Scanner(System.in);
		
		int num = 1;
		while(true) {
			System.out.println("\t \t \t \t  MAIN MENU \t \t \t \t");
			System.out.println("");
			System.out.println("1.PATIENT \t 2.DOCTOR \t 3.MEDICAL \t 4.LAB \t 5.FACILITY \t 6.STAFF \t");
			System.out.println("Select any one");
			int choice = in.nextInt();
			switch(choice)
			{
			case 1:System.out.println("PATIENT");
			       int case1=1;
			       System.out.println("\t 1.New Entry \t 2.Patient List \t 3.Delete");
			       int c1 = in.nextInt();
			       switch(c1) {
			       case 1:addpatient();break;
			       case 2:displaypatient();break;
			       case 3:patdelete();break;
			       }
			       break;
			case 2:System.out.println("DOCTOR");
			       int case2 = 1;
			       System.out.println("\t 1.New Entry \t 2.Doctor List \t 3.Update \t 4.Delete");
			       int c2 = in.nextInt();
			       switch(c2) {
			       case 1: adddoctor();break;
			       case 2: displaydoctor();break;
			       case 3: System.out.println("\t 1.Timings \t 2.Room No");
			               int u2 = in.nextInt();
			               switch(u2) {
			               case 1:updatetime();break;
			               case 2:updateroom();break;
			               
			               }
			               break;
			       case 4:docdelete();break;
			       }
			       break;
			case 3:System.out.println("MEDICAL");
			       int case3 = 1;
			       System.out.println("\t 1.New Medicine \t 2.Medicine List \t 3.Search Medicine \t 4.Update \t 5.Delete");
			       int c3 = in.nextInt();
			       switch(c3) {
			       case 1: addmedicine();break;
			       case 2: displaymedicine();break;
			       case 3: searchmedicine();break;
			       case 4: System.out.println("\t 1.Medicine Cost \t 2.Count");
			               int u3 = in.nextInt();
			               switch(u3) {
			               case 1:updatemedi();break;
			               case 2:updatecount();break;
			               }
			               break;
			       case 5:meddelete();break;
			       }
			       break;
			case 4:System.out.println("LAB");
			       System.out.println("\t 1.Test List \t 2.Update Cost");
			       int c4 = in.nextInt();
			       int case4 = 1;
			       switch(c4) {
			       case 1:lab();break;
			       case 2:updatelab();break;
			       
			       }
			       
			       break;
			case 5:System.out.println("FACILITY AVAILABLE");
			       int case5 = 1;
			       facility();
			       break;
			case 6:System.out.println("STAFF");
			       int case6 = 1;
			       System.out.println("\t 1.New Entry \t 2.Staff List \t 3.Update Salary \t 4.Delete");
			       int c6 = in.nextInt();
			       switch(c6) {
			       case 1:addstaff();break;
			       case 2:displaystaff();break;
			       case 3:updatesal();break;
			       case 4:stafdelete();break;
			       }
			       break;
			}
			System.out.println("Go again?enter (y/n):");
			String goAgain = in.next();
			if(!goAgain.equals("y")) {
				break;
			}
			
			
		}
	}
	
	static void register() throws SQLException {
		Scanner in = new Scanner(System.in);
		
		System.out.println("enter the username:");
		String username2 = in.nextLine();
		Statement s = connection.createStatement();
		ResultSet r = s.executeQuery("select * from healthcaremangement.register where Username='"+username2 +"' ");
		if(r.next()) {
			System.out.println("Username already exist");
			register();
		}
		else {
		System.out.println("enter the password:");
		String password2 = in.nextLine();
		System.out.println("enter the gender");
		String gender = in.nextLine();
		System.out.println("enter the phone");
	    long  phone = in.nextLong();
		System.out.println("enter the DOB");
		String dob = in.next();
	    String sql = "insert into healthcaremangement.register value('"+ username2 +"' , '" + password2 + "' , '" + gender + "' ,'" + phone + "' , '" + dob + "')";
	    PreparedStatement st1 = connection.prepareStatement(sql);
	    int status = st1.executeUpdate();
	    if(status!=0) {
	    System.out.println("Registered Successfully");
	    
	    login();
	    }
		}
	}
	static void addpatient() throws SQLException {
		Scanner in = new Scanner(System.in);
		System.out.println("enter Patient ID:");
		int pid = in.nextInt();
		System.out.println("enter Patient Name:");
		String pname = in.next();
		System.out.println("enter Disease:");
		String disease = in.next();
		System.out.println("enter Gender:");
		String gender1 = in.next();
		System.out.println("Admit status:");
		String admit = in.next();
		
		System.out.println("enter age");
		int age = in.nextInt();
		String sql1 = "insert into healthcaremangement.patient value('"+ pid +"' , '" + pname + "' , '" + disease + "' , '" + gender1 + "' , '" + admit + "' ,'" + age + "')";
	    PreparedStatement st2 = connection.prepareStatement(sql1);
	    int status1 = st2.executeUpdate();
	    if(status1!=0) {
	    	System.out.println("Entered Successfully");
	    }
	    
	}
	
	static void displaypatient() throws SQLException {
		System.out.println("\t \t \t PATIENT LIST \t \t \t");
		Statement sta = connection.createStatement();
		ResultSet rst = sta.executeQuery("select * from healthcaremangement.patient");
		System.out.println("");
		System.out.println("PatientID\t" +"PatientName\t" +"Disease\t" +"Gender\t" +"AdmitStatus\t" + "Age\t");
		while(rst.next()) {
			System.out.println(rst.getInt(1) + "\t\t" + rst.getString(2)+ "\t\t" + rst.getString(3) + " \t " + rst.getString(4) + "\t\t" + rst.getString(5) + " \t " +rst.getInt(6));
		}
	}
	static void adddoctor() throws SQLException {
		Scanner in = new Scanner(System.in);
		System.out.println("enter Doctor ID:");
		int did = in.nextInt();
		System.out.println("enter Doctor Name:");
		String dname = in.next();
		System.out.println("enter Gender:");
		String gender2 = in.next();
		System.out.println("enter Specialist:");
		String specialist = in.next();
		System.out.println("enter Timing:");
		String timing = in.next();
		System.out.println("Qualification:");
		String quali = in.next();
		
		System.out.println("enter Room no");
		int rmno = in.nextInt();
		String sql2 = "insert into healthcaremangement.doctor value('"+ did +"' , '" + dname + "' , '" + gender2 + "' , '" + specialist + "' , '" + timing + "' ,'" + quali + "', '" + rmno + "')";
	    PreparedStatement st3 = connection.prepareStatement(sql2);
	    int status2 = st3.executeUpdate();
	    if(status2!=0) {
	    	System.out.println("Entered Successfully");
	    }
		
	}
	static void displaydoctor() throws SQLException {
		System.out.println("\t \t \t DOCTOR LIST \t \t \t");
		Statement sta1 = connection.createStatement();
		ResultSet rst1 = sta1.executeQuery("select * from healthcaremangement.doctor");
		System.out.println("");
		System.out.println("DoctorID" +" \t"+ "DoctorName" +"\t "+ "Gender" +"\t "+"Specialist" +"\t"+"Timing" +"\t "+ "Qualification" +" \t"+"RoomNo");
		while(rst1.next()) {
			System.out.println(rst1.getInt(1) + "\t\t " + rst1.getString(2)+ " \t" + rst1.getString(3) + "\t " + rst1.getString(4) + " \t\t" + rst1.getString(5) + "\t " + rst1.getString(6)+ "\t" + rst1.getInt(7));
		}
	}
	static void addmedicine() throws SQLException {
		Scanner in = new Scanner(System.in);
		System.out.println("enter Medicine Name:");
		String med_name = in.next();
		System.out.println("enter Medicine company:");
		String med_comp = in.next();
		System.out.println("enter Expiry-Date:");
		String exp_date = in.next();
		System.out.println("enter Medicine Cost:");
		int cost  = in.nextInt();
		System.out.println("enter number of medicine:");
		int  count = in.nextInt();
		
		
		String sql3 = "insert into healthcaremangement.medical value('"+ med_name +"' , '" + med_comp+ "' , '" + exp_date + "' , '" + cost + "' , '" + count + "')";
	    PreparedStatement st4 = connection.prepareStatement(sql3);
	    int status3 = st4.executeUpdate();
	    if(status3!=0) {
	    	System.out.println("Entered Successfully");
	    }
	    
		
	}
	static void displaymedicine() throws SQLException {
		System.out.println("\t \t \t MEDICINE LIST \t \t \t");
		Statement sta2 = connection.createStatement();
		ResultSet rst2 = sta2.executeQuery("select * from healthcaremangement.medical");
		System.out.println("");
		System.out.println("MedicineName" +" \t"+ "MedicineCompany" +"\t "+ "Expiry-Date" +"\t "+"MedicineCost" +"\t"+"Count");
		while(rst2.next()) {
			System.out.println(rst2.getString(1) + "\t\t " + rst2.getString(2)+ " \t" + rst2.getString(3) + "\t " + rst2.getInt(4) + " \t\t" + rst2.getInt(5));
		}
		
	}
	static void searchmedicine() throws SQLException {
		Scanner in = new Scanner(System.in);
		System.out.println("enter Medicine Name");
		String search = in.next();
		Statement sta3 = connection.createStatement();
		ResultSet rst3 = sta3.executeQuery("select * from healthcaremangement.medical where Med_Name='" + search + "'");
		
		if(rst3.next()) {
			System.out.println("MedicineName" +" \t"+ "MedicineCompany" +"\t "+ "Expiry-Date" +"\t "+"MedicineCost" +"\t"+"Count");
			System.out.println(rst3.getString(1) + "\t\t " + rst3.getString(2)+ " \t" + rst3.getString(3) + "\t " + rst3.getInt(4) + " \t\t" + rst3.getInt(5));
		}
		else {
			System.out.println("Sorry Medicine not found");
		}
		
	}
	static void lab() throws SQLException {
		Statement sta4 = connection.createStatement();
		ResultSet rst4 = sta4.executeQuery("select * from healthcaremangement.lab");
		System.out.println("TestName" + "\t\t" + "Cost");
		while(rst4.next()) {
			
			System.out.println(rst4.getString(1) + "\t\t\t " + rst4.getInt(2));
			
		}
	}
	static void facility() throws SQLException {
		Statement sta5 = connection.createStatement();
		ResultSet rst5 = sta5.executeQuery("select * from healthcaremangement.facility");
		System.out.println("Name");
		while(rst5.next()) {
			
			System.out.println(rst5.getString(1));
			
		}
		
	}
	static void addstaff() throws SQLException {
		Scanner in = new Scanner(System.in);
		System.out.println("Staff Id:");
		String sid= in.next();
		System.out.println("Staff Name:");
		String sname = in.next();
		System.out.println("Designation:");
		String designation = in.next();
		System.out.println("Gender:");
		String gender3  = in.next();
		System.out.println("Salary");
		int salary = in.nextInt();
		String sql4 = "insert into healthcaremangement.staff value('"+ sid +"' , '" + sname+ "' , '" + designation + "' , '" + gender3+ "' , '" + salary + "')";
	    PreparedStatement st5 = connection.prepareStatement(sql4);
	    int status4 = st5.executeUpdate();
	    if(status4!=0) {
	    	System.out.println("Entered Successfully");
	    }
		
		
		
	}
	static void displaystaff() throws SQLException {
		System.out.println("\t \t \t STAFF LIST \t \t \t");
		Statement sta6 = connection.createStatement();
		ResultSet rst6 = sta6.executeQuery("select * from healthcaremangement.staff");
		System.out.println("");
		System.out.println("StaffId" +"\t"+ "StaffName" +"\t"+ "Designation" +"\t"+"Gender" +"\t"+"Salary");
		while(rst6.next()) {
			System.out.println(rst6.getInt(1) + "\t " + rst6.getString(2)+ "\t\t" + rst6.getString(3) + "\t\t" + rst6.getString(4) + "\t" + rst6.getInt(5));
		}
		
	}
	static void updatetime() throws SQLException {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the Doctor Id and new Timings");
		int Doid = in.nextInt();
		String Time = in.next();
		String sql5 = "update healthcaremangement.doctor set Timing ='"+Time+"' where Did='"+Doid+"'";
		PreparedStatement st6 = connection.prepareStatement(sql5);
		int status5 = st6.executeUpdate();
		if(status5!=0) {
			System.out.println("Updated Successfully");
		}
		
		
	}
	static void updateroom() throws SQLException {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the Doctor Id and new Room no");
		int Docid = in.nextInt();
		int Room = in.nextInt();
		String sql6 = "update healthcaremangement.doctor set RoomNo ='"+Room+"' where Did='"+Docid+"'";
		PreparedStatement st7 = connection.prepareStatement(sql6);
		int status6 = st7.executeUpdate();
		if(status6!=0) {
			System.out.println("Updated Successfully");
		}
		
	}
	static void updatemedi() throws SQLException {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the Medicine Name and new Cost");
		String Mediname = in.next();
		int Cost = in.nextInt();
		String sql7 = "update healthcaremangement.medical set Med_cost ='"+Cost+"' where Med_Name='"+Mediname+"'";
		PreparedStatement st8 = connection.prepareStatement(sql7);
		int status7 = st8.executeUpdate();
		if(status7!=0) {
			System.out.println("Updated Successfully");
		}
		
	}
	static void updatecount() throws SQLException {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the Medicine Name and new Count");
		String Mediname = in.next();
		int Count = in.nextInt();
		String sql8 = "update healthcaremangement.medical set Count ='"+Count+"' where Med_Name='"+Mediname+"'";
		PreparedStatement st9 = connection.prepareStatement(sql8);
		int status8 = st9.executeUpdate();
		if(status8!=0) {
			System.out.println("Updated Successfully");
		}
	}
	static void updatelab() throws SQLException {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the Test name and new Cost");
		String Testname = in.next();
		int labcost = in.nextInt();
		String sql9 = "update healthcaremangement.lab set Test_Cost ='"+labcost+"' where Test_Name='"+Testname+"'";
		PreparedStatement st10 = connection.prepareStatement(sql9);
		int status9 = st10.executeUpdate();
		if(status9!=0) {
			System.out.println("Updated Successfully");
		}
		
		
	}
	static void updatesal() throws SQLException {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the Staff Id and new Salary");
		int Staid = in.nextInt();
		int sal = in.nextInt();
		String sql10 = "update healthcaremangement.staff set Salary ='"+sal+"' where Sid='"+Staid+"'";
		PreparedStatement st11 = connection.prepareStatement(sql10);
		int status10 = st11.executeUpdate();
		if(status10!=0) {
			System.out.println("Updated Successfully");
		}
		
		
	}
	static void stafdelete() throws SQLException {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter staff Id");
		int Stafid = in.nextInt();
		String sql11 = "delete from healthcaremangement.staff where Sid ='"+Stafid+"'";
		PreparedStatement st12 = connection.prepareStatement(sql11);
		int status11 = st12.executeUpdate();
		if(status11!=0) {
			System.out.println("Deleted Successfully");
		}
		
	}
	static void meddelete() throws SQLException {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Medicine name");
		String Medicinename = in.next();
		String sql12 = "delete from healthcaremangement.medical where Med_Name ='"+Medicinename+"'";
		PreparedStatement st13 = connection.prepareStatement(sql12);
		int status12 = st13.executeUpdate();
		if(status12!=0) {
			System.out.println("Deleted Successfully");
		}
		
	}
	static void docdelete() throws SQLException {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Doctor Id");
		int Doctid = in.nextInt();
		String sql13 = "delete from healthcaremangement.doctor where Did ='"+Doctid+"'";
		PreparedStatement st14 = connection.prepareStatement(sql13);
		int status13 = st14.executeUpdate();
		if(status13!=0) {
			System.out.println("Deleted Successfully");
		}
		
	}
	static void patdelete() throws SQLException {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Patient Id");
		int Pattid = in.nextInt();
		String sql14 = "delete from healthcaremangement.patient where Pid ='"+Pattid+"'";
		PreparedStatement st15 = connection.prepareStatement(sql14);
		int status14 = st15.executeUpdate();
		if(status14!=0) {
			System.out.println("Deleted Successfully");
		}
		
	}
}


