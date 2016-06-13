package com.kevin.common.utils.repaying.model;

import java.io.Serializable;
import java.util.List;

public class RuleGroup implements Serializable {

    private static final long serialVersionUID = 2391996910663107650L;
    
    private String name;
    
    private String description;
    
    private int priority;
    
    private List<RuleModel> ruleModels;

    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    
    /**
     * @return the priority
     */
    public int getPriority() {
        return priority;
    }

    
    /**
     * @param priority the priority to set
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    
    /**
     * @return the ruleModels
     */
    public List<RuleModel> getRuleModels() {
        return ruleModels;
    }

    
    /**
     * @param ruleModels the ruleModels to set
     */
    public void setRuleModels(List<RuleModel> ruleModels) {
        this.ruleModels = ruleModels;
    }

}


