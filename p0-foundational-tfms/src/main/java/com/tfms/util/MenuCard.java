package com.tfms.util;

import org.apache.log4j.Logger;

import com.tfms.app.menu.MenuDrivenApplication;

public class MenuCard {
	private static final Logger logger = Logger.getLogger(MenuDrivenApplication.class);
public static void print() {

//	public class MenuCard {
//		public static void print() {
			char dimond = '\u2666';
			char heart = '\u2665';
			char club = '\u2663';
			char spade = '\u2660';
			char degree = '\u00B0';
			logger.info("");
//			for (int i = 0; i < 50; i++) {
//				logger.info(dimond);
//			}
//			logger.info("");
//			for (int i = 0; i < 19; i++) {
//				logger.info("-");
//			}
//			logger.info(" " + degree + " ");
//			for (int i = 0; i < 20; i++) {
//				logger.info("-");
//			}
//			logger.info("");
//			for (int i = 0; i < 50; i++) {
//				logger.info(dimond);
//			}
			
			logger.info("");
			logger.info("                   Welcome!");
			
			logger.info("");
			logger.info("      Please Choose from below options-");
			logger.info("");
			logger.info("      1. Add Associate");
			logger.info("      2. Update Associate");
			logger.info("      3. Delete Associate");
			logger.info("      4. Search Associate");
			logger.info("");
			logger.info("      Press (n) to exit...");
			logger.info("");
			
			logger.info("");
		}
	
}

