package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Category;
import connection.ConnectionDB;

public class CategoryDAOImp implements GeneralDAO<Category>{
	private List<Category> data;
	private static CategoryDAOImp instance;
	
	private CategoryDAOImp() {
	}
	
	public static CategoryDAOImp getInstance() {
		if (instance == null) {
			instance = new CategoryDAOImp();
		}
		return instance;
	}
	
	@Override
	public List<Category> get() {
		Connection conn = null;
		PreparedStatement pstm = null;
		List<Category> list = new ArrayList<Category>();
		
		try {
			conn = ConnectionDB.connectionsql();
			pstm = conn.prepareStatement("SELECT * FROM category ORDER BY name asc");
			ResultSet res = pstm.executeQuery();
			while(res.next()) {
				Category cate = new Category();
				cate.setId(res.getInt("id"));
				cate.setName(res.getString("name"));
				cate.setStatus(res.getBoolean("status"));
				
				list.add(cate);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDB.closeConnection(conn);
		}
		return list;
	}

	@Override
	public List<Category> getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category findId(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Category entity) {
		boolean flag = false;
		Connection conn;
		PreparedStatement pstm = null;
		ResultSet res = null;
		conn = ConnectionDB.connectionsql();
		try {
			pstm = conn.prepareStatement("INSERT INTO category(id,name,status) VALUES(?,?,?)");
			pstm.setInt(1, entity.getId());
			pstm.setString(2, entity.getName());
			pstm.setBoolean(3, entity.isStatus());
			
			int check = pstm.executeUpdate();
			if(check>0) {
				flag = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean edit(Category entity) {
		boolean flag = false;
		Connection conn;
		PreparedStatement pstm = null;
		ResultSet res = null;
		conn = ConnectionDB.connectionsql();
		try {
			pstm = conn.prepareStatement("UPDATE category SET name=?, status=? WHERE id=?");
			pstm.setString(1, entity.getName());
			pstm.setBoolean(2, entity.isStatus());
			pstm.setInt(3, entity.getId());
			
			int check = pstm.executeUpdate();
			if(check>0) {
				flag = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean remove(Category entity) {
		boolean flag = false;
		Connection conn;
		PreparedStatement pstm = null;
		ResultSet res = null;
		conn = ConnectionDB.connectionsql();
		try {
			pstm = conn.prepareStatement("DELETE FROM category WHERE id=?");
			pstm.setInt(1, entity.getId());
			
			int check = pstm.executeUpdate();
			if(check>0) {
				flag = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}
