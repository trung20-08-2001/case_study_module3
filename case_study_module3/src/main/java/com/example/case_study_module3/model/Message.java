package com.example.case_study_module3.model;

public class Message {
    private int id;
    private int idEmployeeSent;
    private int idEmployeeReceive;
    private String content;
    private boolean status;

    public Message() {
    }

    public Message(int id, int idEmployeeSent, int idEmployeeReceive,String content, boolean status) {
        this.id = id;
        this.idEmployeeSent = idEmployeeSent;
        this.idEmployeeReceive = idEmployeeReceive;
        this.status = status;
        this.content=content;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
