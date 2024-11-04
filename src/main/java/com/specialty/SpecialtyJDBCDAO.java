package com.specialty;

import java.util.*;

import java.sql.*;


public class SpecialtyJDBCDAO implements SpecialtyDAO_interface{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/db01?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "into759hurt494";

	private static final String INSERT_STMT = 
		"INSERT INTO specialty (specNo, specName, specDesc) VALUES (?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT specNo, specName, specDesc FROM specialty order by specNo";
	private static final String GET_ONE_STMT = 
		"SELECT specNo, specName, specDesc FROM specialty where specNo = ?";
	private static final String DELETE = 
		"DELETE FROM specialty where specNo = ?";
	private static final String UPDATE = 
		"UPDATE specialty set specNo=?, specName=?, specDesc=? where specNo = ?";

	@Override
	public void insert(SpecialtyVO specialtyVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, specialtyVO.getSpecNo());
			pstmt.setString(2, specialtyVO.getSpecName());
			pstmt.setString(3, specialtyVO.getSpecDesc());
			
			

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void update(SpecialtyVO specialtyVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, specialtyVO.getSpecNo());
			pstmt.setString(2, specialtyVO.getSpecName());
			pstmt.setString(3, specialtyVO.getSpecDesc());
			pstmt.setInt(4, specialtyVO.getSpecNo());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void delete(Integer specNo) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, specNo);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public SpecialtyVO findByPrimaryKey(Integer specNo) {

		SpecialtyVO specialtyVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, specNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// specialtyVO 也稱為 Domain objects
				specialtyVO = new SpecialtyVO();
				specialtyVO.setSpecNo(rs.getInt("specNo"));
				specialtyVO.setSpecName(rs.getString("specName"));
				specialtyVO.setSpecDesc(rs.getString("specDesc"));
				
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return specialtyVO;
	}

	@Override
	public List<SpecialtyVO> getAll() {
		List<SpecialtyVO> list = new ArrayList<SpecialtyVO>();
		SpecialtyVO specialtyVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// specialtyVO 也稱為 Domain objects
				specialtyVO = new SpecialtyVO();
				specialtyVO.setSpecNo(rs.getInt("specNo"));
				specialtyVO.setSpecName(rs.getString("specName"));
				specialtyVO.setSpecDesc(rs.getString("specDesc"));
				
				list.add(specialtyVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {

		SpecialtyJDBCDAO dao = new SpecialtyJDBCDAO();

//		新增
		SpecialtyVO specialtyVO1 = new SpecialtyVO();
		specialtyVO1.setSpecNo(1);
		specialtyVO1.setSpecName("塔羅牌占卜");
		specialtyVO1.setSpecDesc("透過塔羅牌解讀未來的指引與建議。");
		
		dao.insert(specialtyVO1);

//		修改
//		SpecialtyVO specialtyVO2 = new SpecialtyVO();
//		specialtyVO2.setSpecNo(21);
//		specialtyVO2.setSpecName("Tarot");
//		specialtyVO2.setSpecDesc("Interpreting the future through Tarot cards to provide guidance and advice.");
//		
//		dao.update(specialtyVO2);
//
//		// 刪除
//		dao.delete(23);

		// 查詢
		SpecialtyVO specialtyVO3 = dao.findByPrimaryKey(21);
		System.out.print(specialtyVO3.getSpecNo() + ",");
		System.out.print(specialtyVO3.getSpecName() + ",");
		System.out.print(specialtyVO3.getSpecDesc() + ",");
		
		System.out.println("---------------------");

		// 查詢
		List<SpecialtyVO> list = dao.getAll();
		for (SpecialtyVO aSpecialty : list) {
			System.out.print(aSpecialty.getSpecNo() + ",");
			System.out.print(aSpecialty.getSpecName() + ",");
			System.out.print(aSpecialty.getSpecDesc() + ",");
			
			System.out.println();
		}
	}

}
