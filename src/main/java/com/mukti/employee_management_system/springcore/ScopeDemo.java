package com.mukti.employee_management_system.springcore;

import org.springframework.stereotype.Component;

@Component
public class ScopeDemo {
    private PrototypeDemo prototypeDemo1;
    private PrototypeDemo prototypeDemo2;
    public ScopeDemo(PrototypeDemo prototypeDemo1,PrototypeDemo prototypeDemo2){
        this.prototypeDemo1=prototypeDemo1;
        this.prototypeDemo2=prototypeDemo2;
    }
    public void checkScope(){
        System.out.println(prototypeDemo1);
        System.out.println(prototypeDemo2);
    }
}
