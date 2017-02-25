package jdbcproject;
import java.sql.*;
public class JDBCDemo {
public static void main(String[] args)
{
	try
	{
	
		//Clonnnig demo and use this as refernce
		
		Connection myconn= DriverManager.getConnection("jdbc:mysql://localhost:3306/MyTestDB","root","tiger");
	
	Statement mystmt=myconn.createStatement();
	/*String sql= "insert into Students"
				+ "(Sid,Sname,Course) "
				+ "values (5678,'Buddy','Mtech') ";
	mystmt.executeUpdate(sql);
	*//*String sql1= "update Students"
				+ " set Sname='CSE' "
				+ " where Sid=2345 ";
	*/
	String sql= "delete from Students"
			+ " where Sname='Buddy' ";
	mystmt.executeUpdate(sql);
	
	
	ResultSet myres=mystmt.executeQuery("select * from Students");
	while(myres.next())
	{
		System.out.println(myres.getString("Sid")+" ,"+ myres.getString("Sname"));
	}
	myconn.close();
	}
	
	catch(Exception e)
	{
		System.out.println(e);
	}

}
}
