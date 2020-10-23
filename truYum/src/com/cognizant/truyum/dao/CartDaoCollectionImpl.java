package com.cognizant.truyum.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

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
	public void addCartItem (long userId,long menuItemId) {
		// TODO Auto-generated method stub
		MenuItemDao menuItemDao = new  MenuItemDaoCollectionImpl();
		 MenuItem item = menuItemDao.getMenuItem(menuItemId);
		 
		 if (userCarts.containsKey(userId)) {
				List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
				menuItemList.add(item);
				userCarts.get(userId).setMenuItemList(menuItemList);
			}
		 else {
				List<MenuItem> newUserMenuList = new ArrayList<>();
				newUserMenuList.add(item);
				Cart c = new Cart(newUserMenuList, 0);
				userCarts.put(userId, c);
			}
		 
		
	}
	
	public CartDaoCollectionImpl() {
		super();
		if(userCarts==null) {
			userCarts = new HashMap <Long, Cart>();
			
		}
		
	}

}
