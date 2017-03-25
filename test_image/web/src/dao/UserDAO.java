package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 
import entity.User;
import util.DBHelper;

public class UserDAO {
	//�ж��Ƿ�Ϸ��û�
	public boolean TestLogin (User u) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from user where name=? and pwd=? and isAdmin=?"; // SQL���
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, u.getName());
			stmt.setString(2, u.getPwd());
			stmt.setBoolean(3, u.isAdmin());			
			rs = stmt.executeQuery(); 
			if (rs.next()) {
				u.setRealName(rs.getString("realName"));
				return true;
			} else {
				return false;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			// �ͷ����ݼ�����
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// �ͷ�������
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		} 
	}
	
	public boolean TestReg (User u) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int rs;
		try {
			conn = DBHelper.getConnection();
			String sql = "insert into user values(?,?,?,0)"; // SQL���
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, u.getName());
			stmt.setString(2, u.getPwd());
			stmt.setString(3, u.getRealName());			
			rs = stmt.executeUpdate(); 
			if (rs>0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			// �ͷ����ݼ�����
			// �ͷ�������
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		} 
	}
}
