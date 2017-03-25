package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import util.DBHelper;
import entity.Discuss;
import entity.Items;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.DBHelper;


//��Ʒ��ҵ���߼���
public class DiscussDAO {

	// ������е���Ʒ��Ϣ
	public ArrayList<Discuss> getAllDiscuss() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Discuss> list2 = new ArrayList<Discuss>(); // ��Ʒ����
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from discuss;"; // SQL���
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Discuss discuss = new Discuss();
				discuss.setId(rs.getInt("id"));
				discuss.setTextid(rs.getInt("textid"));
				discuss.setName(rs.getString("name"));
				discuss.setContent(rs.getString("content"));
				list2.add(discuss);// ��һ����Ʒ���뼯��
			}
			return list2; // ���ؼ��ϡ�
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
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

	// ������Ʒ��Ż����Ʒ����
	public ArrayList<Discuss> getDiscussById(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Discuss> list3 = new ArrayList<Discuss>();
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from discuss where id=?;"; // SQL���
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Discuss discuss = new Discuss();
				discuss.setId(rs.getInt("id"));
				discuss.setTextid(rs.getInt("textid"));
				discuss.setName(rs.getString("name"));
				discuss.setContent(rs.getString("content"));
				list3.add(discuss);// ��һ����Ʒ���뼯��
			}
			return list3; 
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
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
	public Discuss getdiscuss(int textid) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from discuss where textid=?;"; // SQL���
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,textid);
			rs = stmt.executeQuery();
			if (rs.next()) {
				Discuss discuss = new Discuss();
				discuss.setTextid(rs.getInt("textid"));
				discuss.setName(rs.getString("name"));
				discuss.setContent(rs.getString("content"));
				return discuss;
			} else {
				return null;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
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
	public Discuss getTextdiscuss(int textid) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from textdiscuss where textid=?;"; // SQL���
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,textid);
			rs = stmt.executeQuery();
			if (rs.next()) {
				Discuss discuss = new Discuss();
				discuss.setTextid(rs.getInt("textid"));
				discuss.setName(rs.getString("name"));
				discuss.setTextcontent(rs.getString("textcontent"));
				return discuss;
			} else {
				return null;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
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
	public ArrayList<Discuss> getAllTextdiscussById(int textid) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Discuss> list3 = new ArrayList<Discuss>();
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from textdiscuss where textid=?;"; // SQL���
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, textid);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Discuss discuss = new Discuss();
				discuss.setTextid(rs.getInt("textid"));
				discuss.setName(rs.getString("name"));
				discuss.setTextcontent(rs.getString("textcontent"));
				list3.add(discuss);// ��һ����Ʒ���뼯��
			}
			return list3; 
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
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
}