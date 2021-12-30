package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionDB;
import entities.Category;
import entities.Product;

public class ProductDAOImp implements GeneralDAO<Product>{
	private List<Product> data;
	private static ProductDAOImp instance;
	
	private ProductDAOImp() {
	}
	
	public static ProductDAOImp getInstance() {
		if (instance == null) {
			instance = new ProductDAOImp();
		}
		return instance;
	}
	
	@Override
	public List<Product> get() {
		Connection conn = null;
		PreparedStatement pstm = null;
		List<Product> list = new ArrayList<Product>();
		
		try {
			conn = ConnectionDB.connectionsql();
			pstm = conn.prepareStatement("SELECT product.*,category.name as categoryName FROM product inner join category ON product.categoryId=category.id ");
			ResultSet res = pstm.executeQuery();
			while(res.next()) {
				Product pro = new Product();
				pro.setId(res.getString("id"));
				pro.setName(res.getString("name"));
				pro.setPrice(res.getDouble("price"));
				pro.setCategoryName(res.getString("categoryName"));
				pro.setStatus(res.getBoolean("status"));
				
				list.add(pro);
				
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
	public List<Product> getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findId(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Product entity) {
		boolean flag = false;
		Connection conn;
		PreparedStatement pstm = null;
		ResultSet res = null;
		conn = ConnectionDB.connectionsql();
		try {
			pstm = conn.prepareStatement("INSERT INTO product(id,name,price,categoryId,status) VALUES(?,?,?,?,?)");
			pstm.setString(1, entity.getId());
			pstm.setString(2, entity.getName());
			pstm.setDouble(3, entity.getPrice());
			pstm.setInt(4, entity.getCategoryId());
			pstm.setBoolean(5, entity.isStatus());
			
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
	public boolean edit(Product entity) {
		boolean flag = false;
		Connection conn;
		PreparedStatement pstm = null;
		ResultSet res = null;
		conn = ConnectionDB.connectionsql();
		try {
			pstm = conn.prepareStatement("UPDATE product SET name=?, price=?, categoryId=?, status=? WHERE id=?");
			pstm.setString(1, entity.getName());
			pstm.setDouble(2, entity.getPrice());
			pstm.setInt(3, entity.getCategoryId());
			pstm.setBoolean(4, entity.isStatus());
			pstm.setString(5, entity.getId());
			
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
	public boolean remove(Product entity) {
		boolean flag = false;
		Connection conn;
		PreparedStatement pstm = null;
		ResultSet res = null;
		conn = ConnectionDB.connectionsql();
		try {
			pstm = conn.prepareStatement("DELETE FROM product WHERE id=?");
			pstm.setString(1, entity.getId());
			
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

