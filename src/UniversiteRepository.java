
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UniversiteRepository {

	

	Universite GetById(int universityId) throws SQLException {

		

		DBConnection BD= DBConnection.getInstance();
		Connection connect= BD.getConn();
		Statement stmt = connect.createStatement();
		System.out.println("LogBD : début recherche de id université dans la base de donnée");
		

		String sql = "SELECT * FROM universite WHERE id_universite="+ universityId;
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();	
		TypePackage p=TypePackage.valueOf(rs.getString(3));
		Universite u = new Universite (rs.getInt(1),rs.getString(2),p);
			

		System.out.println("LogBD : université récupérée");
		

		connect.close();
		//connect.close();
		return u;	
	
		


	}
}