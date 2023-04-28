package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import domain.ChangeDTO;
import domain.MemberDTO;

public class MemberDAO {
	// 드라이버 로드
		private PreparedStatement pstmt;
		private Connection con;
		private ResultSet rs;
		// DB 서버 연결
		public Connection getConnection() {
			try {
				
				Context ctx = new InitialContext();
				DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/myoracle");
				Connection con = ds.getConnection();
				
				// DML 실행 시 트랜잭션 관리를 직접하겠음
				con.setAutoCommit(false);
				return con;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;

		}

		// 자원해제
		public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void close(Connection con, PreparedStatement pstmt) {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void commit(Connection con) {
			try {
				con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}

		public void rollback(Connection con) {
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// login
		
		// 아이디와 비밀번호 일치하면 아이디와 이름만 추출 
		// select userid, name from membertbl where userid=? and password=?
		
		public MemberDTO isLogin(String userid,String password) {
			MemberDTO dto = null;
			
			try {
				
				con=getConnection();
				
				
				String sql="select userid, name from memtbl where userid=? and password=?";
				
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, userid);
				pstmt.setString(2, password);
				
				rs =pstmt.executeQuery();
				
				if(rs.next()) {
					dto = new MemberDTO();
					dto.setUserid(rs.getString("userid"));
					dto.setUserid(rs.getString("name"));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(con, pstmt, rs);
			}
			return dto;
		}
		//insert into membertbl values('hong123', 'hong123@','honggildong','남','hong123@gmail.com');

		public boolean insertMember(MemberDTO dto) {
			boolean flag = false;
			
			try {
				con= getConnection();
				String sql="insert into membertbl values(?,?,?,?,?)";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, dto.getUserid());
				pstmt.setString(2, dto.getPassword());
				pstmt.setString(3, dto.getName());
				pstmt.setString(4, dto.getGender());
				pstmt.setString(5, dto.getEmail());
				
				int result= pstmt.executeUpdate();
				
				if(result >0) {
					flag = true;
					commit(con);
				}
				
			} catch (Exception e) {
				rollback(con);
				e.printStackTrace();
			}finally {
				close(con, pstmt);
			}
			return flag;
		}
		
		public boolean update(ChangeDTO dto) {
			boolean flag = false;
			
			try {
				con=getConnection();
				String sql="update membertbl set password=? where userid=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, dto.getConfirmPassword());
				pstmt.setString(1, dto.getUserid());
				
				
				int result=pstmt.executeUpdate();
				
				if(result>0) {
					flag =true;
					commit(con);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
				rollback(con);
			}finally {
				close(con, pstmt);
			}
			return flag;
		}
		
		// 회원탈퇴 - 아이디와 비밀번호 일치시
		public boolean delete(String userid) {
			boolean flag=false;
			
			try {
				con=getConnection();
				String sql=" delete membertbl set userid=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, userid);
				
				int result = pstmt.executeUpdate();
				
				if(result>0) flag = true;
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(con, pstmt);
			}
			return flag;
		}
		
		// 중복 아이디 검사
		// 존재하는 아이디가 있다면 true 리턴 false 리턴
		
		public boolean duplicateId(String userid) {
			boolean flag= true;
			
			try {
				
				con = getConnection();
				String sql="select count(*) from membertbl where userid=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, userid);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					int cnt = rs.getInt(1);
					if(cnt>0) flag = false;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(con, pstmt);
			}
			return flag;
		}
		
}


















