package com.kevin.common.utils.json.model;

import java.util.List;

public class QualificationOperationItem {

    private String name;
    private String operation;
    private List<String> values;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getOperation() {
        return operation;
    }
    
    public void setOperation(String operation) {
        this.operation = operation;
    }
    
    public List<String> getValues() {
        return values;
    }
    
    public void setValues(List<String> values) {
        this.values = values;
    }
}
