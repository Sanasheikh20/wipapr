package com.wip.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.wip.model.Product;
import com.wip.util.MyDBConnection;

public class ProductDao {

	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	CallableStatement cs;
	Scanner sc = new Scanner(System.in);

	public void insertProduct(Product pr) {
		try {
			con = MyDBConnection.getMyDBConnection();
			ps = con.prepareStatement("insert into product values(?,?)");
			ps.setInt(1, pr.getPid());
			ps.setString(2, pr.getPname());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted successfully !!!!");

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void retrieveProducts() {
		try {
			con = MyDBConnection.getMyDBConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from product");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " -- " + rs.getString(2));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void updateProduct() {
	    try {
	        con = MyDBConnection.getMyDBConnection();

	        System.out.println("Enter Product Id to Update:");
	        int pid = sc.nextInt();
	        

	        System.out.println("Enter Product Name to Update:");
	        String pname = sc.next();

	        ps = con.prepareStatement("UPDATE product SET pname=? WHERE pid=?");

	        ps.setString(1, pname);
	        ps.setInt(2, pid);

	        int rows = ps.executeUpdate();
	        
	        System.out.println("Rows affected " + rows);

	        if (rows > 0) {
	            System.out.println("Product updated successfully!");
	        } else {
	            System.out.println("No product found with given ID!");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void deleteProduct() {
//delete from product where pid=?;
		try {
			con = MyDBConnection.getMyDBConnection();
			
			System.out.println("Enter Product Id to Delete:");
			int pid = sc.nextInt();
			
	    	
	    	ps = con.prepareStatement("delete from product where pid=?");
	    	
	    	
	    	ps.setInt(1, pid);
	    	
	    	int rows = ps.executeUpdate();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public void insertProductUsingProcedure(Product pr) {
		try {
			con = MyDBConnection.getMyDBConnection();
			cs=con.prepareCall("{call createProduct(?,?)}");
			cs.setInt(1, pr.getPid());
			cs.setString(2, pr.getPname());
			int rowsupdated = cs.executeUpdate();
			System.out.println(rowsupdated + " inserted via procedure...");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void getProductNameById() {
	    try {
	        con = MyDBConnection.getMyDBConnection();

	        System.out.println("Enter Product Id:");
	        int pid = sc.nextInt();

	        cs = con.prepareCall("{call getProductNameById(?)}");
	        cs.setInt(1, pid);

	        rs = cs.executeQuery();

	        if (rs.next()) {
	            System.out.println("Product Name: " + rs.getString(1));
	        } else {
	            System.out.println("No product found with given ID!");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
