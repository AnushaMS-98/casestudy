package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public interface MenuItemDao {
	List<MenuItem> getMenuItemListAdmin() throws ClassNotFoundException, IOException, SQLException ;
	List<MenuItem> getMenuItemListCustomer() throws ClassNotFoundException, IOException, SQLException;
	void modifyMenuItem(MenuItem menuItem) throws ClassNotFoundException, IOException, SQLException, ParseException; 
	MenuItem getMenuItem(long menuItemId) throws ClassNotFoundException, IOException, SQLException;

}
