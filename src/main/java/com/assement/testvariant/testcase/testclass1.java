package com.assement.testvariant.testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.assement.testvariant.utility.baseclass;

import org.testng.annotations.BeforeTest;
import java.util.logging.Logger;


public class testclass1{

	 Logger logger
     = Logger.getLogger(
         testclass1.class.getName());
		String jsonbody;
		//add json file path to check other json file for same format
		String filepath="C:\\Users\\anand_jha1\\eclipse-workspace\\com.assement.testvariant\\src\\main\\resources\\sample.json";
  @BeforeTest
  public void beforeTest() throws IOException {
	   jsonbody= baseclass.loadjson(filepath);
	   logger.info(jsonbody);
	
  }


 
  @Test
  public void foregienplayer_check() {
	  // Player outside India accept 4 player max
	 int india_player_count =0;
	 int forefien_player_count =0;
	 for(int i =0;i<10;i++) {
		 String country= baseclass.palyer_country(jsonbody, i);
		 if(country.contains("India")) {
			 india_player_count=india_player_count+1;
		 }else {
			 forefien_player_count=forefien_player_count+1;
		 } 

	 	} 
		Assert.assertEquals(forefien_player_count, 4); 
		logger.info("forefien_player_count:");
		System.out.print(forefien_player_count);
		
	  }
  
  @Test
  public void weekedkeeper_player_check() {
	  // Player check for wicket keeper only  1 player max
	  int WicketKepper_count =0;
		 int other_player = 0;
		 for(int i =0;i<10;i++) {
			 String WickedKepper= baseclass.palyer_role(jsonbody, i);
			 if(WickedKepper.contains("Wicket-keeper")) {
				 WicketKepper_count=WicketKepper_count+1;
				 if(WicketKepper_count<2) {
				//	 Assert.assertEquals(WicketKepper_count, 1);
					 break; }
				 
			 }else {
				 other_player=other_player+1;
			 } 
	  }
		 logger.info("other_player:");
		 System.out.println(other_player);
		 Assert.assertEquals(WicketKepper_count, 1);
		 logger.info("WicketKepper_count:");
			System.out.print(WicketKepper_count);
		 
  }

}
