package Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BD.DBConnection;
import Journal.IJournal;
import Pack.TypePackage;
import Services.Universite;
public class UniversiteRepository implements IUniversite {

	@Override
	public Universite GetById(int universityId, IJournal j) throws SQLException {

		DBConnection BD= DBConnection.getInstance();
		Connection connect= BD.getConn();
		Statement stmt = connect.createStatement();
		j.outPut_Msg("LogBD : d�but recherche de id universit� dans la base de donn�e");

		String sql = "SELECT * FROM universite WHERE id_universite="+ universityId;
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();	
		TypePackage p=TypePackage.valueOf(rs.getString(3));
		Universite u = new Universite (rs.getInt(1),rs.getString(2),p);

		j.outPut_Msg("LogBD : universit� r�cup�r�e");

		//connect.close();
		return u;	
	
		
	}	
	
}