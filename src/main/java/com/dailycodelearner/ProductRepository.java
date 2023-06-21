package com.dailycodelearner;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.dailycodelearner.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductRepository {

	Connection conn=null;
	

	@Value("${url}")
	private String url;
	@Value("${username}")
	private String username;
	@Value("${password}")
	private String password;
	
	public Connection setConnection() throws ClassNotFoundException, SQLException {
//	Class.forName(driver);
	conn=DriverManager.getConnection(url,username,password);
	return conn;
	}
	
	public int insertProduct(Product product) throws ClassNotFoundException, SQLException {
		conn=setConnection();
		PreparedStatement prepareStatement=conn.prepareStatement("insert into product(name,place,type,waranty)values(?,?,?,?)");
		prepareStatement.setString(2, product.getName());
        prepareStatement.setString(3, product.getPlace());
        prepareStatement.setString(4, product.getType());
        prepareStatement.setInt(5, product.getWaranty());
        int row=prepareStatement.executeUpdate();
        prepareStatement.close();
        conn.close();
        return row;
    }

    public List<Product> findAll() {

        List<Product> product=new ArrayList<Product>();
        PreparedStatement preparedStatement = null;
        try {
            conn=setConnection();
            ResultSet result = preparedStatement.executeQuery("select * from product");
            while(result.next()){
                Product p=new Product();
                p.setId(result.getInt(1));
                p.setName(result.getString(2));
                p.setPlace(result.getString(3));
                p.setType(result.getString(4));
                p.setWaranty(result.getInt(5));
                product.add(p);
            }
            result.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return product;
    }

    public Product findById(int id) {
        Product p=new Product();
        try {
            conn = setConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("select * from product where id=?");
            preparedStatement.setInt(1,id);
            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){

                p.setId(result.getInt(1));
                p.setName(result.getString(2));
                p.setPlace(result.getString(3));
                p.setType(result.getString(4));
                p.setWaranty(result.getInt(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return p;
    }

    public int deleteById(int id) {
        int row = 0;
        try {
            conn = setConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("delete * from product where id=?");
            preparedStatement.setInt(1,id);
            row=preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return row;
    }
}
