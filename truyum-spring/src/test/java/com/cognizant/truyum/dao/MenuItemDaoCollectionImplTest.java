package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {

	static MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException, ParseException {
		testGetMenuItemListAdmin();
		System.out.println();
		testGetMenuListCustomer();
		System.out.println();
		testModifyMenuItem();

	}

	public static void testGetMenuItemListAdmin() throws ClassNotFoundException, IOException, SQLException {

		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();

		for (MenuItem item : menuItemList) {
			System.out.println(item);
		}
	}

	public static void testGetMenuListCustomer() throws ClassNotFoundException, IOException, SQLException {

		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();

		for (MenuItem item : menuItemList) {
			System.out.println(item);
		}
	}

	public static void testModifyMenuItem() throws ClassNotFoundException, IOException, SQLException, ParseException {
		//System.out.println("here at 43");
		MenuItem newMenuItem = new MenuItem(1, "Sandwich", 102.00f, true, new DateUtil().convertToDate("02/07/2017"),
				"MainCourse", true);
//		//System.out.println("46");
		menuItemDao.modifyMenuItem(newMenuItem);
		MenuItem modifiedMenuItem = menuItemDao.getMenuItem(1);
		System.out.println(modifiedMenuItem);

	}
}