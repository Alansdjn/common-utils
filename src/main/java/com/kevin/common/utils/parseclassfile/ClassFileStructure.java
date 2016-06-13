package com.kevin.common.utils.parseclassfile;

public enum ClassFileStructure {

    MAGIC(10),
    MINOR_VERSION(20),
    MAJOR_VERSION(30),
    CONSTANT_POOL_COUNT(40),
    CONSTANT_POOL(50),
    ACCESS_FLAGS(60),
    THIS_CLASS(70),
    SUPER_CLASS(80),
    INTERFACES_COUNT(90),
    INTERFACES(100),
    FIELDS_COUNT(110),
    FIELDS(120),
    METHODS_COUNT(130),
    METHODS(140),
    ATTRIBUTES_COUNT(150),
    ATTRIBUTES(160);
    
    private int order;
    
    private ClassFileStructure(int order) {
        this.order = order;
    }
    
    public int getOrder() {
        return this.order;
    }
}


