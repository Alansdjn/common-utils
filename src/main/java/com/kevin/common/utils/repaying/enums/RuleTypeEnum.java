package com.kevin.common.utils.repaying.enums;

public enum RuleTypeEnum {

    OFFER_SHIELD("offerShield", "offer资源屏蔽处理器");
    
    private String type;
    private String description;
    
    private RuleTypeEnum(String type, String description) {
        this.type = type;
        this.description = description;
    }
}


