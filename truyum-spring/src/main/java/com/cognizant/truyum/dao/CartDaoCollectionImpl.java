package com.cognizant.truyum.dao;

import java.util.*;
import java.io.*;
import java.sql.SQLException;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao {
	
	private static Map<Long, Cart> userCarts;


	public Map<Long, Cart> getUserCarts() {
		return userCarts;
	}

	public void setUserCarts(HashMap<Long, Cart> userCarts) {
		CartDaoCollectionImpl.userCarts = userCarts;
	}

	@Override
	public void addCartItem (long userId,long menuItemId) throws ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		MenuItemDao menuItemDao = new  MenuItemDaoCollectionImpl();
		 MenuItem item = menuItemDao.getMenuItem(menuItemId);
		 
		 if (userCarts.containsKey(userId)) {
				List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
				menuItemList.add(item);
				userCarts.get(userId).setMenuItemList(menuItemList);
			}
		 else {
				List<MenuItem> newUserMenuList = new ArrayList<MenuItem>();
				newUserMenuList.add(item);
				Cart c = new Cart(newUserMenuList);
				userCarts.put(userId, c);
			}
		 
		
	}
	
	public CartDaoCollectionImpl() {
		super();
		if(userCarts==null) {
			userCarts = new HashMap <Long, Cart>();
			
		}
		
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException{
		Cart c = userCarts.get(userId);
		double price =0;
		List<MenuItem> cartItems = c.getMenuItemList();
		//System.out.println(cartItems);
		if(cartItems.isEmpty()==true) {
			//System.out.println("empty");
			throw new CartEmptyException();
		}
		else {
			
			for(MenuItem item: cartItems) {
					price =price + item.getPrice();
			}
			c.setTotal(price);
		}
		return cartItems;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) throws CartEmptyException{
		// TODO Auto-generated method stub
		Cart c = userCarts.get(userId);
		List<MenuItem> cartItems = c.getMenuItemList();
		MenuItem removeItem =null;
		for(MenuItem item: cartItems) {
			if(menuItemId == item.getId()) {
				removeItem = item;
			}
		}
		cartItems.remove(removeItem);
		Cart ca = userCarts.get(userId);
		ca.setMenuItemList(cartItems);
		userCarts.put(userId, ca);
		
		
	}

}
