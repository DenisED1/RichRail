package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Locomotive;
import domain.Wagon;

public class ComponentOracleDaoImpl extends OracleBaseDao implements ComponentDao {
	public boolean createLocomotive(Locomotive locomotive) {
		try(Connection conn = super.getConnection()) {
			String query = "insert into components (name, type) values(?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, locomotive.getName());
			pstmt.setString(2, locomotive.getType());
			pstmt.executeQuery();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean createWagon(Wagon wagon) {
		try(Connection conn = super.getConnection()) {
			String query = "insert into components (name, seats, type) values(?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, wagon.getName());
			pstmt.setInt(2, wagon.getSeats());
			pstmt.setString(3, wagon.getType());
			pstmt.executeQuery();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addComponent(String trainName, String componentName) {
		int place = checkComponentPlace(trainName);
		try(Connection conn = super.getConnection()) {
			String query = "insert into connection (trainname, componentname, place) values(?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, trainName);
			pstmt.setString(2, componentName);
			pstmt.setInt(3, place);
			pstmt.executeQuery();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//teller van plaats connection aanpassen
	public boolean removeComponent(String trainName, String componentName) {
		int place = getLastComponentInConnection(trainName, componentName);
		try(Connection conn = super.getConnection()) {
			String query = "delete from connection where trainname = ? and componentname = ? and place = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, trainName);
			pstmt.setString(2, componentName);
			pstmt.setInt(3, place);
			pstmt.executeQuery();
			lowerPlaceComponents(place, trainName);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteComponent(String componentName) {
		if (checkComponentUsed(componentName)) {
			try (Connection conn = super.getConnection()) {
				String query = "delete from component where name = ?";
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setString(1, componentName);
				pstmt.executeQuery();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		} else {
			System.out.println("Verwijderd component niet");
			return false;
		}
	}
	
	public int getSeatsComponent(String name) {
		try (Connection conn = super.getConnection()) {
			String query = "select seats from component where name = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt("SEATS");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql error");
			return 0;
		}
	}
	
	private int checkComponentPlace(String trainName) {
		try (Connection conn = super.getConnection()) {
			String sql = "select count(trainname) amountcomponents from connection where trainname = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, trainName);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int aantal = rs.getInt("amountcomponents");
			return aantal + 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	private boolean checkComponentUsed(String componentName) {
		try (Connection conn = super.getConnection()) {
			String sql = "select componentname from connection where componentname = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, componentName);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			if (rs.getString("componentname").equals(componentName)) {
				System.out.println("Component bestaat al in connection");
				return false;
			} else {
				System.out.println("Component bestaat niet in connection");
				return true;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql error checkComponentUsed()");
			return false;
		}
	}
	
	private int getLastComponentInConnection(String trainName, String componentName) {
		try (Connection conn = super.getConnection()) {
			String sql = "select place from connection where trainname = ? and componentname = ? order by place desc fetch first 1 rows only";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, trainName);
			pstmt.setString(2, componentName);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt("place");
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	private void lowerPlaceComponents(int place, String trainName) {
		try (Connection conn = super.getConnection()) {
			String sql = "update connection set place = place - 1 where place > ? and trainname = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, place);
			pstmt.setString(2, trainName);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
