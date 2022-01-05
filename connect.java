package net.codejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connect {
	public static void main(String[] args)
	{
		//String jdbcUrl = "jdbc:sqlite:C:\\sqlite\\usersdb.db ";
		// Here is Connection Code
		
		String jdbcUrl = "jdbc:sqlite:newMovie.db ";
		try {
		Connection connection = DriverManager.getConnection(jdbcUrl);
		
		// Here Create Movie Table
		
	    String sql2 = " create table movies (movieName varchar(30), actorName varchar(20), actressName varchar(20), yearOfRelease int(5), directorName varchar(30) )";
		Statement statement2 = connection.createStatement();
		statement2.executeUpdate(sql2);
		System.out.println("Table is Successfully created"); 
		
		// Here Values inserted in movies table
		String sql1 = " INSERT into movies VALUES( '3 Idiot','Amir Khan','Kareena Kapoor',2009,'Rajkumar Hirane'),('Welcome','Akshay Kumar','Katrina Kaif',2007,'Anees Bozmee')";
		Statement statement1 = connection.createStatement();
		
		int rows = statement1.executeUpdate(sql1);
		
		if(rows > 0) {
			System.out.println("Value is Successfully inserted in table");
		}
		
		// Here Data is Fetched from table
		
		System.out.println("---- Movie Table -----");
		System.out.println();
		
		String sql = "SELECT * FROM movies ";
		 
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(sql);
		System.out.println("Movie Name" + " | "  + " Actor Name " + " | " + "Actress Name" + " | "  + " Year of Release " + " | " + "Director Name");
		while(result.next())
		{ 
			String name     = result.getString("movieName");
			String actor    = result.getString("actorName");
			String actress  = result.getString("actressName");
			int year        = result.getInt("yearOfRelease");
			String director = result.getString("directorName");
			
			System.out.println(name + " | " + actor + " | " + actress + " | " + year + " | " + director);
		}  
		
		// Here Fetched Movie name Using Where condition
		
		System.out.println();
		System.out.println(" Movie Name Using Actor name");
		System.out.println();
		
	    String sql3 = "SELECT movieName FROM movies WHERE  actorName ='Amir Khan'";
		 
		Statement statement3 = connection.createStatement();
		ResultSet result3 = statement3.executeQuery(sql3);
		
		while(result3.next())
		{ 
			String name1 = result3.getString("movieName");
			System.out.println("----> " + name1);
		} 
		} 
		
		catch (SQLException e){
			System.out.println("Error connecting to SQlite Database");
			e.printStackTrace();
		}
	}

}
