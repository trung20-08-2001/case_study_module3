package com.example.case_study_module3.model;

import java.util.Date;


public class SalaryInformation{
    private Date monthYear;
    private int standardWorkingDays;
    private double actualWorkingDays;
    private double overTimeNormal;
    private double overTimeHoliday;
    private double overtTimeWeekend;
    private double takeLeave;
    private double remindLeave;
    private double basicSalary;
    private double petroleumAllowance;
    private double mealAllowance;
    private double positionAllowance;
    private double seniorityAllowance;
    private  double grossSalary;
    private double unemploymentInsurance;   //bảo hiểm thất nghiệp
    private double healthInsurance;       // bảo hiểm y tế
    private double socialInsurance;     // bảo hiểm xã hội
    private double personalTaxDeduction;  // thuế giảm trừ bản thân
    private double dependentTaxDeduction;  // giảm trừ thuế cho người phụ thuộc
    private double taxPayable;              // thuế phải đóng
    private double netSalary;

    public SalaryInformation(Date monthYear, int standardWorkingDays, double actualWorkingDays, double overTimeNormal, double overTimeHoliday, double overtTimeWeekend, double takeLeave, double remindLeave, double basicSalary, double petroleumAllowance, double mealAllowance, double positionAllowance, double seniorityAllowance, double grossSalary, double unemploymentInsurance, double healthInsurance, double socialInsurance, double personalTaxDeduction, double dependentTaxDeduction, double taxPayable,double netSalary) {
        this.monthYear = monthYear;
        this.standardWorkingDays = standardWorkingDays;
        this.actualWorkingDays = actualWorkingDays;
        this.overTimeNormal = overTimeNormal;
        this.overTimeHoliday = overTimeHoliday;
        this.overtTimeWeekend = overtTimeWeekend;
        this.takeLeave = takeLeave;
        this.remindLeave = remindLeave;
        this.basicSalary = basicSalary;
        this.petroleumAllowance = petroleumAllowance;
        this.mealAllowance = mealAllowance;
        this.positionAllowance = positionAllowance;
        this.seniorityAllowance = seniorityAllowance;
        this.grossSalary = grossSalary;
        this.unemploymentInsurance = unemploymentInsurance;
        this.healthInsurance = healthInsurance;
        this.socialInsurance = socialInsurance;
        this.personalTaxDeduction = personalTaxDeduction;
        this.dependentTaxDeduction = dependentTaxDeduction;
        this.taxPayable = taxPayable;
        this.netSalary=netSalary;
    }

    public Date getMonthYear() {
        return monthYear;
    }

    public void setMonthYear(Date monthYear) {
        this.monthYear = monthYear;
    }

    public int getStandardWorkingDays() {
        return standardWorkingDays;
    }

    public void setStandardWorkingDays(int standardWorkingDays) {
        this.standardWorkingDays = standardWorkingDays;
    }

    public double getActualWorkingDays() {
        return actualWorkingDays;
    }

    public void setActualWorkingDays(double actualWorkingDays) {
        this.actualWorkingDays = actualWorkingDays;
    }

    public double getOverTimeNormal() {
        return overTimeNormal;
    }

    public void setOverTimeNormal(double overTimeNormal) {
        this.overTimeNormal = overTimeNormal;
    }

    public double getOverTimeHoliday() {
        return overTimeHoliday;
    }

    public void setOverTimeHoliday(double overTimeHoliday) {
        this.overTimeHoliday = overTimeHoliday;
    }

    public double getOvertTimeWeekend() {
        return overtTimeWeekend;
    }

    public void setOvertTimeWeekend(double overtTimeWeekend) {
        this.overtTimeWeekend = overtTimeWeekend;
    }

    public double getTakeLeave() {
        return takeLeave;
    }

    public void setTakeLeave(double takeLeave) {
        this.takeLeave = takeLeave;
    }

    public double getRemindLeave() {
        return remindLeave;
    }

    public void setRemindLeave(double remindLeave) {
        this.remindLeave = remindLeave;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getPetroleumAllowance() {
        return petroleumAllowance;
    }

    public void setPetroleumAllowance(double petroleumAllowance) {
        this.petroleumAllowance = petroleumAllowance;
    }

    public double getMealAllowance() {
        return mealAllowance;
    }

    public void setMealAllowance(double mealAllowance) {
        this.mealAllowance = mealAllowance;
    }

    public double getPositionAllowance() {
        return positionAllowance;
    }

    public void setPositionAllowance(double positionAllowance) {
        this.positionAllowance = positionAllowance;
    }

    public double getSeniorityAllowance() {
        return seniorityAllowance;
    }

    public void setSeniorityAllowance(double seniorityAllowance) {
        this.seniorityAllowance = seniorityAllowance;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public double getUnemploymentInsurance() {
        return unemploymentInsurance;
    }

    public void setUnemploymentInsurance(double unemploymentInsurance) {
        this.unemploymentInsurance = unemploymentInsurance;
    }

    public double getHealthInsurance() {
        return healthInsurance;
    }

    public void setHealthInsurance(double healthInsurance) {
        this.healthInsurance = healthInsurance;
    }

    public double getSocialInsurance() {
        return socialInsurance;
    }

    public void setSocialInsurance(double socialInsurance) {
        this.socialInsurance = socialInsurance;
    }

    public double getPersonalTaxDeduction() {
        return personalTaxDeduction;
    }

    public void setPersonalTaxDeduction(double personalTaxDeduction) {
        this.personalTaxDeduction = personalTaxDeduction;
    }

    public double getDependentTaxDeduction() {
        return dependentTaxDeduction;
    }

    public void setDependentTaxDeduction(double dependentTaxDeduction) {
        this.dependentTaxDeduction = dependentTaxDeduction;
    }

    public double getTaxPayable() {
        return taxPayable;
    }

    public void setTaxPayable(double taxPayable) {
        this.taxPayable = taxPayable;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }
}
