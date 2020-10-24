package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {
	
	private static MenuItemDaoSqlImpl menuItemDao = new MenuItemDaoSqlImpl();
	
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException, ParseException {
		System.out.println("Admin List:");
		testGetMenuItemListAdmin();
		System.out.println("Customer List:");
		testGetMenuItemListCustomer();
		System.out.println("Modifying and printing MenuItem");
		testModifyMenuItem();
		testGetMenuItemListAdmin();
		System.out.println("Get Menu Item");
		testGetMenuItem();
	}
	
	public static void testGetMenuItemListAdmin() throws ClassNotFoundException, IOException, SQLException {
		List<MenuItem> lst = menuItemDao.getMenuItemListAdmin();
		lst.forEach(System.out::println);
	}
	
	public static void testGetMenuItemListCustomer() throws ClassNotFoundException, IOException, SQLException {
		List<MenuItem> lst = menuItemDao.getMenuItemListCustomer();
		lst.forEach(System.out::println);
	}

	public static void testModifyMenuItem() throws ClassNotFoundException, IOException, SQLException, ParseException {
		MenuItem menuItem = new MenuItem(4, "French Fries", 62.0f, false, new DateUtil().convertToDate("15/03/2017"), "Starters", true);
		menuItemDao.modifyMenuItem(menuItem);
	}
	
	public static void testGetMenuItem() throws ClassNotFoundException, IOException, SQLException {
		MenuItem menuItem = menuItemDao.getMenuItem(3);
		if(menuItem == null) {
			System.out.println("The Item does not exist in our database");
			return;
		}
		System.out.println(menuItem);
	}
}