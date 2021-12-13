package wiess.jdbc;
import java.sql.*;
public class JDBC {
	private String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://127.0.0.1:3306/user";
	private String n="root";
	private String p="root";
	public void select(){
		try{
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url, n, p);
			String sql="select * from user";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			System.out.println("id\tname\tpass\tpermission");
			while(rs.next()){
				System.out.print(rs.getString("id")+"\t");
				System.out.print(rs.getString("name")+"\t");
				System.out.print(rs.getString("pass")+"\t");
				System.out.println(rs.getString("permission")+"\t");
			}
			con.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public String select(String name,String pass){
		String result ="";
		try{
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url, n, p);
			String sql="select * from user where name=? and pass=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				result=rs.getString("permission");
			}
			con.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return result;
	}
	
	public String select(String name){
		String result ="";
		try{
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url, n, p);
			String sql="select * from user where name=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				result=rs.getString("permission");
			}
			con.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return result;
	}
	
	public int update(String name,String oldpass,String newpass){
		int i=0;
		if(!select(name,oldpass).equals("")){
			try{
				Class.forName(driver);
			    Connection con=DriverManager.getConnection(url, n, p);
			    String sql="update user set pass=? where name=?";
			    PreparedStatement ps=con.prepareStatement(sql);
			    ps.setString(1, newpass);
			    ps.setString(2, name);
			    i=ps.executeUpdate();
			    con.close();
			    }catch(Exception e){
			    	System.out.println(e);
			    	}
			}
		return i;
		}
	
	public int insert(String name,String pass,String permission){
		int i=0;
		if(select(name).equals("")){
			try{
				Class.forName(driver);
				Connection con=DriverManager.getConnection(url, n, p);
			    String sql="insert into user(name,pass,permission) values(?,?,?)";
			    PreparedStatement ps=con.prepareStatement(sql);
			    ps.setString(1, name);
			    ps.setString(2, pass);
			    ps.setString(3, permission);
			    i=ps.executeUpdate();
			    con.close();
			    }catch(Exception e){
			    	System.out.println(e);
			    	}
			}
		return i;
		}
	public int delete(String name){
		int i=0;
		try{
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url, n, p);
			String sql="delete from user where name=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
		    i=ps.executeUpdate();
			con.close();
			}catch(Exception e){
				System.out.println(e);
				}
		return i;
	}
}
