package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {
	//public static CartDao cartDao =new CartDaoCollectionImpl();
	public static void main(String[] args) throws CartEmptyException, ClassNotFoundException, ParseException, IOException, SQLException{
		System.out.println("adding item into cart(menuitem id:3)"); 
		testAddCartItem();
		 System.out.println("getting all cartitem");
		 testGetAllCartItems();
		 System.out.println("removing item from cart(menuitem id:3)");
		 testRemoveCartItem();
	}
	public static void testAddCartItem() throws ParseException, CartEmptyException, ClassNotFoundException, IOException, SQLException {
		CartDao cartDao = new CartDaoCollectionImpl();
		//cartDao.addCartItem(1, 1);
		cartDao.addCartItem(1, 3);
		List<MenuItem> menuItemList = cartDao.getAllCartItems(1);
		menuItemList.forEach(System.out::println);

	}
	public static void  testRemoveCartItem() throws CartEmptyException, ClassNotFoundException, IOException, SQLException {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.removeCartItem(1, 3);
		testGetAllCartItems();


	}
	public static void testGetAllCartItems() throws ClassNotFoundException, SQLException {
		CartDao cartDao =new CartDaoCollectionImpl();
		try {
			List<MenuItem> lst = cartDao.getAllCartItems(1);
			for(MenuItem newList: lst) {
				System.out.println(newList);
			}
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			System.out.println("cart is empty");
			e.printStackTrace();
		}
	}

}
