package jdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TryWithResources {
	public static void test()
	{//put the try statement in the try () brackects so that if every
		//time connection will be closed upon successfull completion,
		//and unsuccessfull completion 
		
		try(Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/courseappdb","root","tiger");){
			
	
			Statement statement = connection.createStatement();
			ResultSet rset=statement.executeQuery("select * from course");
			
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
	public static void main(String[] args) {
		test();
	}

}
