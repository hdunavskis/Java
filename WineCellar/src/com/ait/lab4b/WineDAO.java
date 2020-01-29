package com.ait.lab4b;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class WineDAO {

    public List<Wine> findAll() {
        List<Wine> list = new ArrayList<Wine>();
        Connection c = null;
    	String sql = "SELECT * FROM wine ORDER BY name";
        try {
            c = ConnectionHelper.getConnection();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                list.add(processRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
        return list;
    }
    
    public Wine findById(int wineId) {
    	Wine wine = null;
    	Connection c = null;
    	String sql = "SELECT * FROM wine where id = ?";
        try {
            c = ConnectionHelper.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, wineId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
            	wine = processRow(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
       return wine;
    }

    public Wine create(Wine wine) {
    	
    	Connection connection = null;
    	PreparedStatement ps = null;
    	
    	try {
    		connection = ConnectionHelper.getConnection();
    		ps = connection.prepareStatement("INSERT into wine (name, grapes, country, region, year, picture, description) "
    				+ "values(?,?,?,?,?,?,?)", new String[] {"ID"});
    		ps.setString(1, wine.getName());
    		ps.setString(2, wine.getGrapes());
    		ps.setString(3, wine.getCountry());
    		ps.setString(4, wine.getRegion());
    		ps.setString(5, wine.getYear());
    		ps.setString(6, wine.getPicture());
    		ps.setString(7, wine.getDescription());
    		
    		ps.executeUpdate();
    		ResultSet rs = ps.getGeneratedKeys();
    		rs.next();
    		wine.setId(rs.getInt(1));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	finally {
			ConnectionHelper.close(connection);
		}
    	return wine;
    }
   
    public Wine update(Wine wine) {
    	Connection connection = null;
    	PreparedStatement ps = null;
    	try {
    		connection = ConnectionHelper.getConnection();
    		ps = connection.prepareStatement("UPDATE wine SET name=?, year = ?, grapes =?, "
    				+ "country=?, region=?, description=?, picture =? where id = ?");
    		ps.setString(1, wine.getName());
    		ps.setString(2, wine.getYear());
    		ps.setString(3, wine.getGrapes());
    		ps.setString(4, wine.getCountry());
    		ps.setString(5, wine.getRegion());
    		ps.setString(6, wine.getDescription());
    		ps.setString(7, wine.getPicture());
    		ps.setInt(8, wine.getId());
    		
    		ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	finally {
			ConnectionHelper.close(connection);
		}
    	return wine;
    }
    
    public boolean delete(int wineID) {
    	
    	Connection connection = null;
    	PreparedStatement ps = null;
    	
    	try {
    		connection = ConnectionHelper.getConnection();
    		ps = connection.prepareStatement("DELETE FROM wine where id = ?");
    		
    		ps.setInt(1, wineID);
    		int count = ps.executeUpdate();
    		
    		return count == 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	finally {
			ConnectionHelper.close(connection);
		}
    	return false;
    }
    protected Wine processRow(ResultSet rs) throws SQLException {
        Wine wine = new Wine();
        wine.setId(rs.getInt("id"));
        wine.setName(rs.getString("name"));
        wine.setGrapes(rs.getString("grapes"));
        wine.setCountry(rs.getString("country"));
        wine.setRegion(rs.getString("region"));
        wine.setYear(rs.getString("year"));
        wine.setPicture(rs.getString("picture"));
        wine.setDescription(rs.getString("description"));
        return wine;
    }
    
}
