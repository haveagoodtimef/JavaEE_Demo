package com.map.app;

//import org.junit.Test;

import com.map.app.AMapUtils;
import com.map.app.LngLat;

public class AMapTest
{
	public static void main(String[] args) {
			LngLat start = new LngLat(116.686349, 39.871926);
	      LngLat end = new LngLat(116.678811, 39.875496);
	      System.err.println(AMapUtils.calculateLineDistance(start, end));
	}
   
//   public void Test()
//   {
//      LngLat start = new LngLat(116.368904, 39.923423);
//      LngLat end = new LngLat(116.387271, 39.922501);
//      System.err.println(AMapUtils.calculateLineDistance(start, end));
//   }
}
