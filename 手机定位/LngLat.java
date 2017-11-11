package com.map.app;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * �洢��γ������ֵ���࣬��λ�Ƕ�
 * 
 * @author jianggujin
 *
 */
public final class LngLat implements Cloneable
{
   /**
    * γ�� (��ֱ����)
    */
   public final double latitude;
   /**
    * ���� (ˮƽ����)
    */
   public final double longitude;
   /**
    * ��ʽ��
    */
   private static DecimalFormat format = new DecimalFormat("0.000000", new DecimalFormatSymbols(Locale.US));

   /**
    * ʹ�ô���ľ�γ�ȹ���LatLng ����һ�Ծ�γ��ֵ���������һ���ص㡣
    * 
    * @param longitude
    *           �ص�ľ��ȣ���-180 ��180 ֮���double ����ֵ��
    * @param latitude
    *           �ص��γ�ȣ���-90 ��90 ֮���double ����ֵ��
    */
   public LngLat(double longitude, double latitude)
   {
      this(longitude, latitude, true);
   }

   /**
    * ʹ�ô���ľ�γ�ȹ���LatLng ����һ�Ծ�γ��ֵ���������һ���ص�
    * 
    * @param longitude
    *           �ص�ľ��ȣ���-180 ��180 ֮���double ����ֵ��
    * 
    * @param latitude
    *           �ص��γ�ȣ���-90 ��90 ֮���double ����ֵ��
    * @param isCheck
    *           �Ƿ���Ҫ��龭γ�ȵĺ����ԣ�������дtrue
    */
   public LngLat(double longitude, double latitude, boolean isCheck)
   {
      if (isCheck)
      {
         if ((-180.0D <= longitude) && (longitude < 180.0D))
            this.longitude = parse(longitude);
         else
         {
            throw new IllegalArgumentException("the longitude range [-180, 180].");
            // this.longitude = parse(((longitude - 180.0D) % 360.0D + 360.0D) %
            // 360.0D - 180.0D);
         }

         if ((latitude < -90.0D) || (latitude > 90.0D))
         {
            throw new IllegalArgumentException("the latitude range [-90, 90].");
         }
         this.latitude = latitude;
         // this.latitude = parse(Math.max(-90.0D, Math.min(90.0D, latitude)));
      }
      else
      {
         this.latitude = latitude;
         this.longitude = longitude;
      }
   }

   /**
    * ����
    * 
    * @param d
    * @return
    */
   private static double parse(double d)
   {
      return Double.parseDouble(format.format(d));
   }

   public LngLat clone()
   {
      return new LngLat(this.latitude, this.longitude);
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      long temp;
      temp = Double.doubleToLongBits(latitude);
      result = prime * result + (int) (temp ^ (temp >>> 32));
      temp = Double.doubleToLongBits(longitude);
      result = prime * result + (int) (temp ^ (temp >>> 32));
      return result;
   }

   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      LngLat other = (LngLat) obj;
      if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
         return false;
      if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
         return false;
      return true;
   }

   public String toString()
   {
      return "lat/lng: (" + this.latitude + "," + this.longitude + ")";
   }
}