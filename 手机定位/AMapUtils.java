package com.map.app;

/**
 * �ߵµ�ͼ����
 * 
 * @author jianggujin
 *
 */
public class AMapUtils
{
   /**
    * �����û��������յ㾭γ�ȼ����������룬�˾���Ϊ��Խ϶̵ľ��룬��λ�ס�
    * 
    * @param start
    *           ��������
    * @param end
    *           �յ������
    * @return
    */
   public static double calculateLineDistance(LngLat start, LngLat end)
   {
      if ((start == null) || (end == null))
      {
         throw new IllegalArgumentException("�Ƿ�����ֵ������Ϊnull");
      }
      double d1 = 0.01745329251994329D;
      double d2 = start.longitude;
      double d3 = start.latitude;
      double d4 = end.longitude;
      double d5 = end.latitude;
      d2 *= d1;
      d3 *= d1;
      d4 *= d1;
      d5 *= d1;
      double d6 = Math.sin(d2);
      double d7 = Math.sin(d3);
      double d8 = Math.cos(d2);
      double d9 = Math.cos(d3);
      double d10 = Math.sin(d4);
      double d11 = Math.sin(d5);
      double d12 = Math.cos(d4);
      double d13 = Math.cos(d5);
      double[] arrayOfDouble1 = new double[3];
      double[] arrayOfDouble2 = new double[3];
      arrayOfDouble1[0] = (d9 * d8);
      arrayOfDouble1[1] = (d9 * d6);
      arrayOfDouble1[2] = d7;
      arrayOfDouble2[0] = (d13 * d12);
      arrayOfDouble2[1] = (d13 * d10);
      arrayOfDouble2[2] = d11;
      double d14 = Math.sqrt((arrayOfDouble1[0] - arrayOfDouble2[0]) * (arrayOfDouble1[0] - arrayOfDouble2[0])
            + (arrayOfDouble1[1] - arrayOfDouble2[1]) * (arrayOfDouble1[1] - arrayOfDouble2[1])
            + (arrayOfDouble1[2] - arrayOfDouble2[2]) * (arrayOfDouble1[2] - arrayOfDouble2[2]));

      return (Math.asin(d14 / 2.0D) * 12742001.579854401D);
   }
}