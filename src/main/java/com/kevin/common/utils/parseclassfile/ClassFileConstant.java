package com.kevin.common.utils.parseclassfile;

public class ClassFileConstant {

    public static final int MAGIC = 1;
    public static final int MINOR_VERSION = 1;
    public static final int MAJOR_VERSION = 1;
    public static final int CONSTANT_POOL_COUNT = 1;
    public static final int CONSTANT_POOL = CONSTANT_POOL_COUNT - 1;
    public static final int ACCESS_FLAGS = 1;
    public static final int THIS_CLASS = 1;
    public static final int SUPER_CLASS = 1;
    public static final int INTERFACES_COUNT = 1;
    public static final int INTERFACES = INTERFACES_COUNT;
    public static final int FIELDS_COUNT = 1;
    public static final int FIELDS = FIELDS_COUNT;
    public static final int METHODS_COUNT = 1;
    public static final int METHODS = METHODS_COUNT;
    public static final int ATTRIBUTES_COUNT = 1;
    public static final int ATTRIBUTES = ATTRIBUTES_COUNT;
    
    private ClassFileConstant(){}
}


