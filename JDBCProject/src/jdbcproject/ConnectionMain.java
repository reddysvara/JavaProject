package jdbcproject;
import java.sql.*;

/*1.connection creation
2.create statement 
3.execute statement
4.get the result set and iterate and look at the result
5.stmt Vs preparedStatement--prepared statemet will compile only only once
so that execution plan is created once and so that it will not will be 
6.sql injection is not posible with the prepare statement
7.we can parametrize the input the sql statement.

//executeQuery()--> it will excecute the qurey and returns the results
 executeUpdate()--> int-> insert ,update ,delete it will returns the number 
   of rows  effected upon perticular operation.
execute-->boolean--> both executeQurey and executeUpdate operations can be performed
*/
	
public class ConnectionMain {
	
	public static void test(int num)
	{
		try{
			Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/courseappdb","root","tiger");
	
			Statement statement = connection.createStatement();
			ResultSet rset=statement.executeQuery("select * from course where courseId="+num);
			
			//PreparedStatement pst=connection.prepareStatement("select * from course where courseId=3");
//pst.setString(1, "num");
		
			while(rset.next())
			{
				System.out.println(rset.getInt(1));
				System.out.println(rset.getString("title"));
				System.out.println(rset.getString(3));
				System.out.println();
			}
			connection.close();
		
		}
		catch(SQLException e)
		{
			//e.printStackTrace();
			System.out.println(e.getSQLState());
			System.out.println(e.getErrorCode());
			System.out.println(e.getMessage());
		}
	}

	public static void prepstmt(String courseName)
	{
		try{
			Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/courseappdb","root","tiger");
	
			PreparedStatement pstmt = connection.prepareStatement("select * from course where title=?");
			pstmt.setString(1, courseName);
			ResultSet rset=pstmt.executeQuery();
			while(rset.next())
			{
				System.out.println(rset.getInt(1));
				System.out.println(rset.getString("title"));
				System.out.println(rset.getString(3));
				System.out.println();
			}
			connection.close();
		
		}
		catch(SQLException e)
		{
			//e.printStackTrace();
			System.out.println(e.getSQLState());
			System.out.println(e.getErrorCode());
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public static void main(String[] args) {
		
		
		prepstmt("JAVA");
			test(4);
		
		
		
		
		
		/*try{
			Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/courseappdb","root","tiger");
		Statement statement = connection.createStatement();
			ResultSet rset=statement.executeQuery("select * from course");
			while(rset.next())
			{
				//System.out.println(rset.getInt("courseId"));
				System.out.println(rset.getString("title"));
				System.out.println(rset.getString("author"));
				System.out.println();
			}
			connection.close();
		}
	*/
		
			
	
	}
	
}
