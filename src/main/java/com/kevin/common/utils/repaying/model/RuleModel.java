package com.kevin.common.utils.repaying.model;

import java.io.Serializable;

import com.kevin.common.utils.repaying.handler.RuleHandler;

public class RuleModel implements Serializable {

    private static final long serialVersionUID = -7186779789118856544L;
    
    private String name;
    
    private String description;
    
    /** 
     * @see com.kevin.common.utils.repaying.enums.RuleTypeEnum 
     */
    private String ruleType;
    
    private RuleHandler ruleHandler;

    
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
     * @return the ruleType
     */
    public String getRuleType() {
        return ruleType;
    }

    
    /**
     * @param ruleType the ruleType to set
     */
    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    
    /**
     * @return the ruleHandler
     */
    public RuleHandler getRuleHandler() {
        return ruleHandler;
    }

    
    /**
     * @param ruleHandler the ruleHandler to set
     */
    public void setRuleHandler(RuleHandler ruleHandler) {
        this.ruleHandler = ruleHandler;
    }

}


