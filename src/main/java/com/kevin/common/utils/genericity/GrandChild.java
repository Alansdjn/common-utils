package com.kevin.common.utils.genericity;

public class GrandChild extends Child {

    /* (non-Javadoc)
     * @see com.kevin.common.utils.designpattern.test.Child#process()
     */
    @Override
    protected String process() {
        return " Process in GrandChild class.";
    }

    
    public static void main(String[] args) {
        System.out.println(new GrandChild().getInfo("Hello world!"));
    }
}


