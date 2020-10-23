package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {

	static MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();

	public static void main(String[] args) {
		testGetMenuItemListAdmin();
		testGetMenuListCustomer();
		testModifyMenuItem();

	}

	public static void testGetMenuItemListAdmin() {

		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();

		for (MenuItem item : menuItemList) {
			System.out.println(item);
		}
	}

	public static void testGetMenuListCustomer() {

		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();

		for (MenuItem item : menuItemList) {
			System.out.println(item);
		}
	}

	public static void testModifyMenuItem() {
		MenuItem newMenuItem = new MenuItem(1, "Sandwich", 109.00f, true, new DateUtil().convertToDate("02/07/2017"),
				"MainCourse", true);
		menuItemDao.modifyMenuItem(newMenuItem);
		MenuItem modifiedMenuItem = menuItemDao.getMenuItem(1);
		System.out.println(modifiedMenuItem);

	}
}