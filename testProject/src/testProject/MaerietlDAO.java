package testProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class MaerietlDAO {
	
	public Vector listProduct() {
		Vector items = new Vector();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.oraConn();
			String sql = "select product_no,plocal,pname,"
					+ "company,redate,uprice,pacc,sprice "
					+ " from product order by pname";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()){
				Vector row = new Vector();
				row.add(rs.getString("product_no"));
				row.add(rs.getString("plocal"));
				row.add(rs.getString("pname"));
				row.add(rs.getString("company"));
				row.add(rs.getDate("redate"));
				row.add(rs.getInt("uprice"));
				row.add(rs.getInt("pacc"));
				row.add(rs.getInt("sprice"));
				items.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(pstmt!=null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}//finally
		return items;
	}//listEmp	

	public Vector searchProduct(String name) {
		Vector items = new Vector();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.oraConn();
			String sql = "select product_no,plocal,pname,"
					+ "company,redate,uprice,pacc,sprice "
					+ " from product where product_no like ? "
					+ " order by pname";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");
			rs = pstmt.executeQuery();
			while (rs.next()){
				Vector row = new Vector();
				row.add(rs.getString("product_no"));
				row.add(rs.getString("plocal"));
				row.add(rs.getString("pname"));
				row.add(rs.getString("company"));
				row.add(rs.getDate("redate"));
				row.add(rs.getInt("uprice"));
				row.add(rs.getInt("pacc"));
				row.add(rs.getInt("sprice"));
				items.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			try {
				if(pstmt!=null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}//finally
		return items;
	}
	public int insertProduct(MaerietlDTO dto) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.oraConn();
			String sql = "insert into product values(?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getProduct_no());
			pstmt.setString(2, dto.getPlocal());
			pstmt.setString(3, dto.getPname());
			pstmt.setString(4, dto.getCompany());
			pstmt.setDate(5, dto.getRedate());
			pstmt.setInt(6, dto.getUprice());
			pstmt.setInt(7, dto.getPacc());
			pstmt.setInt(8, dto.getSprice());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}//finally
		return result;
	}
	public int deleteProduct(String product_no) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.oraConn();
			String sql = "delete from product where product_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product_no);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt!=null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if (conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}//finally
		return result;
		
	}//deleteProduct()	
	
	public int updateProduct(MaerietlDTO dto){
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.oraConn();
			String sql = "update product set "
					+ " plocal=?,pname=?,company=?,redate=?, uprice=?,pacc=?,sprice=? where product_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPlocal());
			pstmt.setString(2, dto.getPname());
			pstmt.setString(3, dto.getCompany());
			pstmt.setDate(4, dto.getRedate());
			pstmt.setInt(5, dto.getUprice());
			pstmt.setInt(6, dto.getPacc());
			pstmt.setInt(7, dto.getSprice());
			pstmt.setString(8, dto.getProduct_no());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}//finally
		return result;
	}	
	
}


