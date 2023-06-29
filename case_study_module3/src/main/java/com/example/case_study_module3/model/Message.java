package com.example.case_study_module3.model;

public class Message {
    private int id;
    private int idEmployeeSent;
    private int idEmployeeReceive;

    public Message() {
    }

    public Message(int id, int idEmployeeSent, int idEmployeeReceive) {
        this.id = id;
        this.idEmployeeSent = idEmployeeSent;
        this.idEmployeeReceive = idEmployeeReceive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEmployeeSent() {
        return idEmployeeSent;
    }

    public void setIdEmployeeSent(int idEmployeeSent) {
        this.idEmployeeSent = idEmployeeSent;
    }

    public int getIdEmployeeReceive() {
        return idEmployeeReceive;
    }

    public void setIdEmployeeReceive(int idEmployeeReceive) {
        this.idEmployeeReceive = idEmployeeReceive;
    }
}
