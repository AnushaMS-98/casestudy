package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException, CartEmptyException {
		// TODO Auto-generated method stub
		System.out.println("adding items to cart:");
		testAddCartItem();
		System.out.println("printing all items inside cart");
		testGetAllCartItem();
		System.out.println("removing cart item ");
		testRemoveCartItem();
	
	}
	
	public static void testAddCartItem() throws ClassNotFoundException, IOException, SQLException, CartEmptyException {
		CartDao cartDao = new CartDaoSqlImpl();   
		//System.out.println("test add");
		cartDao.addCartItem(1, 1);//(userid,menuid)
        cartDao.addCartItem(1, 2);
        cartDao.addCartItem(1, 3);
		List<MenuItem> cartItemList = cartDao.getAllCartItems(1);
		cartItemList.forEach(System.out::println);
		
	}
	
	public static void testGetAllCartItem() throws ClassNotFoundException, IOException, SQLException, CartEmptyException {
		 CartDao cartDao = new CartDaoSqlImpl();
		List<MenuItem> cartItemList = cartDao.getAllCartItems(1);//userid
		cartItemList.forEach(System.out::println);

		
		
	}
	
	public static void testRemoveCartItem() throws ClassNotFoundException, IOException, SQLException, CartEmptyException {
		CartDaoSqlImpl cartDaoImpl = new CartDaoSqlImpl();
        long userId = 1;
		long menuItemId = 1;
		cartDaoImpl.removeCartItem(userId, menuItemId);
		System.out.println("After removing items");
 			for(MenuItem item : cartDaoImpl.getAllCartItems(userId)) {
				System.out.println(item);
			}
	}
}
	
	
			
