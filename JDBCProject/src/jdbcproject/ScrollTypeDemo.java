package jdbcproject;

import java.sql.*;

public class ScrollTypeDemo {
	
	public static void main(String[] args)
	{
		
	try{
		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/courseappdb","root","tiger");

		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rset=statement.executeQuery("select * from course");
		
		rset.next();
		//boolean execute=true;
		//while(rset.next())
		//{
			System.out.println(rset.getInt("courseId"));
			System.out.println(rset.getString("title"));
			System.out.println(rset.getString("author"));
			rset.first();
			System.out.println(rset.getInt("courseId"));
			System.out.println(rset.getString("title"));
			System.out.println(rset.getString("author"));
			rset.last();
			System.out.println(rset.getInt("courseId"));
			System.out.println(rset.getString("title"));
			System.out.println(rset.getString("author"));
			rset.absolute(-5);
			System.out.println(rset.getInt("courseId"));
			System.out.println(rset.getString("title"));
			System.out.println(rset.getString("author"));
			rset.relative(3);
			System.out.println(rset.getInt("courseId"));
			System.out.println(rset.getString("title"));
			System.out.println(rset.getString("author"));
			//System.out.println(); 
//			if(execute)
//			{
//				rset.beforeFirst();
//				execute=false;
//			}
//		}
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
}
