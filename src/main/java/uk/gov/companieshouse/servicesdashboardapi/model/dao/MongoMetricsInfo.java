package uk.gov.companieshouse.servicesdashboardapi.model.dao;

import org.springframework.data.mongodb.core.mapping.Field;

public class MongoMetricsInfo {

   @Field("critical")
   private int critical;

   @Field("high")
   private int high;

   @Field("medium")
   private int medium;

   @Field("low")
   private int low;

   @Field("vulnerabilities")
   private int vulnerabilities;

   @Field("components")
   private int components;

   @Field("policyViolationsTotal")
   private int policyViolationsTotal;
   
   @Field("policyViolationsWarn")
   private int policyViolationsWarn;
   
   @Field("policyViolationsFail")
   private int policyViolationsFail;
   
   // Getters and Setters
   public int getCritical() {
      return critical;
   }
   public void setCritical(int critical) {
      this.critical = critical;
   }

   public int getHigh() {
      return high;
   }

   public void setHigh(int high) {
      this.high = high;
   }

   public int getMedium() {
      return medium;
   }

   public void setMedium(int medium) {
      this.medium = medium;
   }

   public int getLow() {
      return low;
   }

   public void setLow(int low) {
      this.low = low;
   }

   public int getVulnerabilities() {
      return vulnerabilities;
   }

   public void setVulnerabilities(int vulnerabilities) {
      this.vulnerabilities = vulnerabilities;
   }

   public int getComponents() {
      return components;
   }

   public void setComponents(int components) {
      this.components = components;
   }

   public int getPolicyViolationsTotal() {
      return policyViolationsTotal;
   }
   
   public void setPolicyViolationsTotal(int policyViolationsTotal) {
      this.policyViolationsTotal = policyViolationsTotal;
   }
   
   public int getPolicyViolationsWarn() {
      return policyViolationsWarn;
   }
   
   public void setPolicyViolationsWarn(int policyViolationsWarn) {
      this.policyViolationsWarn = policyViolationsWarn;
   }

   public int getPolicyViolationsFail() {
      return policyViolationsFail;
   }

   public void setPolicyViolationsFail(int policyViolationsFail) {
      this.policyViolationsFail = policyViolationsFail;
   }

   @Override
   public String toString() {
      return String.format("critical:%s high:%s medium:%s low:%s vulnerabilities:%s policyViolationsTotal:%s policyViolationsWarn:%s policyViolationsFail:%s",
      critical, high, medium, low, vulnerabilities, policyViolationsTotal, policyViolationsWarn, policyViolationsFail);
   }
}


