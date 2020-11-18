package com.RealEstateProject.item;

import com.RealEstateProject.Person;

public class BaseItem {

   private double cubicMeter;
   private String name;
   private Person owner;



   public BaseItem(String name, double cubicMeter,Person owner) {
      this.cubicMeter = cubicMeter;
      this.name = name;
      this.owner=owner;
   }

   public double getCubicMeter() {
      return cubicMeter;
   }

   public void setCubicMeter(double cubicMeter) {
      this.cubicMeter = cubicMeter;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }   public Person getOwner() {
      return owner;
   }

   public void setOwner(Person owner) {
      this.owner = owner;
   }
}
