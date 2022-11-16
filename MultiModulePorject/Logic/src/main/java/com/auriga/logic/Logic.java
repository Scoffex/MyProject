package com.auriga.logic;


public class Logic {
    
    private int num1;
    private int num2;
    private int operationId;
    
    public Logic(int num1, int num2, int operationId) {
       this.num1 = num1;
       this.num2=num2;
       this.operationId = operationId;
    }
    
    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int print() {
      
        switch(operationId) {
            case 1: 
                return num1+num2;
            case 2:
                return num1-num2;
            case 3:
                return num1*num2;
            case 4: 
                return num1/num2;
        }
        return 0;
    }

}