package uk.gov.companieshouse.servicesdashboardapi.model.deptrack;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DepTrackMetricsInfo {

   @JsonProperty("critical")
   private int critical;

   @JsonProperty("high")
   private int high;

   @JsonProperty("medium")
   private int medium;

   @JsonProperty("low")
   private int low;

   @JsonProperty("vulnerabilities")
   private int vulnerabilities;

   @JsonProperty("components")
   private int components;

   @JsonProperty("policyViolationsTotal")
   private int policyViolationsTotal;
   
   @JsonProperty("policyViolationsWarn")
   private int policyViolationsWarn;
   
   @JsonProperty("policyViolationsFail")
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
       return String.format("{C:%s/H:%s/M:%s/L:%s/v:%s/c:%s/pT:%s/pW:%s/pF:%s}", critical, high, medium, low, vulnerabilities, components, policyViolationsTotal, policyViolationsWarn, policyViolationsFail);
   }
}


