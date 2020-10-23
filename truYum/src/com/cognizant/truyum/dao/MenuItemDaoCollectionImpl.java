package com.cognizant.truyum.dao;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {
	private static List<MenuItem> menuItemList;

	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) {
		MenuItemDaoCollectionImpl.menuItemList = menuItemList;
	}

	public MenuItemDaoCollectionImpl() {
		super();
		//this.menuItemList = menuItemList;
		List<MenuItem> lst = new ArrayList <>();
		if(menuItemList==null) {
			lst.add(new MenuItem(1, "Sandwich", 99.0f, true, new DateUtil().convertToDate("15/03/2017"),
					"Main Course", true));
			lst.add(new MenuItem(2, "Burger", 129.0f, true, new DateUtil().convertToDate("23/12/2017"),
					"Main Course", false));
			lst.add(new MenuItem(3, "Pizza", 149.0f, true, new DateUtil().convertToDate("21/08/2018"),
					"Main Course", false));
			lst.add(new MenuItem(4, "French Fries", 57.0f, false, new DateUtil().convertToDate("02/07/2017"),
					"Starters", true));
			lst.add(new MenuItem(5, "Chocolate Brownie", 32.0f, true, new DateUtil().convertToDate("02/11/2022"),
					"Dessert", true));
		}
		menuItemList=lst;
	}
	 public List<MenuItem> getMenuItemListAdmin(){
		 return menuItemList;
	 }

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		// TODO Auto-generated method stub
		List<MenuItem> newItemList = new ArrayList<>();
		Date currDate = new DateUtil().convertToDate("20/10/2020");
		
		for(MenuItem item : menuItemList) {
			if(item.isActive() && currDate.after(item.getDateOfLaunch())){
				newItemList.add(item);
			}
		}
		return newItemList;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		for(MenuItem item:menuItemList) {
			if(menuItemList.equals(item)) {
				item.setId(menuItem.getId());
				item.setName(menuItem.getName());
				item.setPrice(menuItem.getPrice());
				item.setActive(menuItem.isActive());
				item.setDateOfLaunch(menuItem.getDateOfLaunch());
				item.setCategory(menuItem.getCategory());
				item.setFreeDelivery(menuItem.isFreeDelivery());
				item = menuItem;
			}
		}menuItemList.add(menuItem);
		
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		for(MenuItem item:menuItemList) {
			if(menuItemId == item.getId()) {
				return item;
			}
		}
		return null;
	} 
	


}
