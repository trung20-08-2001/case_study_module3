package com.example.case_study_module3.model;

public class AllowanceDetail {
    private int idContract;
    private int idAllowance;

    public AllowanceDetail() {
    }

    public AllowanceDetail(int idContract, int idAllowance) {
        this.idContract = idContract;
        this.idAllowance = idAllowance;
    }

    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public int getIdAllowance() {
        return idAllowance;
    }

    public void setIdAllowance(int idAllowance) {
        this.idAllowance = idAllowance;
    }
}
