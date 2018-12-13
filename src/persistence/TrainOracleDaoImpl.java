package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Train;

public class TrainOracleDaoImpl extends OracleBaseDao implements TrainDao {
	public boolean createTrain(Train train) {
		if (checkTrainName(train.getName())) {
			try (Connection conn = super.getConnection()) {
				String query = "insert into train values(?)";
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setString(1, train.getName());
				pstmt.executeQuery();
				System.out.println("Train created");
				return true;
			} catch (SQLException e) {
				System.out.println("Error in SQL");
				e.printStackTrace();
				return false;
			}
		} else {
			System.out.println("Train already exists");
			return false;
		}
	}

	public boolean deleteTrain(String name) {
		deleteTrainComponents(name);
		try (Connection conn = super.getConnection()) {
			String query = "delete from train where name = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.executeQuery();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public int getSeatsTrain(String trainName) {
		try (Connection conn = super.getConnection()) {
			String query = "select sum(c.seats) as seats\r\n" + "from component c, connection conn\r\n"
					+ "where c.name = conn.componentname\r\n" + "and conn.trainname = ?;";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, trainName);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt("SEATS");
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	private void deleteTrainComponents(String name) {
		try (Connection conn = super.getConnection()) {
			String query = "delete from connection where trainname = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private boolean checkTrainName(String name) {
		try (Connection conn = super.getConnection()) {
			String query = "select name from train where name = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			if (rs.getString("name").equals(name)) {
				System.out.println("checkTrainName false; naam bestaat al");
				return false;
			} else {
				System.out.println("checkTrainName true; naam bestaat niet");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("checkTrainName error");
			return false;
		}
	}
}
