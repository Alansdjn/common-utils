package com.kevin.common.utils.bigbean;

public class BigBeanTest {

    private static final Integer TIMES = 100000000;
    public static void main(String[] args) {
        
        BigBeanTest bbt = new BigBeanTest();
        BigBean bb0 =  bbt.new BigBean();
        bb0.setA("finished!");
        
        BigBean bb1 =  bbt.new BigBean();
        bb1.setBigBean(bb0);
        BigBean bb2 =  bbt.new BigBean();
        bb2.setBigBean(bb1);
        BigBean bb3 =  bbt.new BigBean();
        bb3.setBigBean(bb2);
        BigBean bb4 =  bbt.new BigBean();
        bb4.setBigBean(bb3);
        BigBean bb5 =  bbt.new BigBean();
        bb5.setBigBean(bb4);
        BigBean bb6 =  bbt.new BigBean();
        bb6.setBigBean(bb5);
        BigBean bb7 =  bbt.new BigBean();
        bb7.setBigBean(bb6);
        BigBean bb8 =  bbt.new BigBean();
        bb8.setBigBean(bb7);
        BigBean bb9 =  bbt.new BigBean();
        bb9.setBigBean(bb8);
        BigBean bb10 =  bbt.new BigBean();
        bb10.setBigBean(bb9);
        
        
        long begin = System.currentTimeMillis(); 
        String a = null;
        for (int i = 0; i < TIMES; i++) {
            a = bb9.getBigBean().getBigBean().getBigBean().getBigBean().getBigBean().getBigBean().getBigBean().getBigBean().getBigBean().getA();
        }
        long middle = System.currentTimeMillis();
        
        for (int i = 0; i < TIMES; i++) {
            a = bb0.getA();
        }
        long end = System.currentTimeMillis();
        
        System.out.println((middle - begin) + " : " + (end - middle));
    }
    
    class BigBean {
        String a = "a";
        int b = 2;
        boolean flag = true;
        BigBean bigBean = null;
        
        /**
         * @return the a
         */
        public String getA() {
            return a;
        }
        
        /**
         * @param a the a to set
         */
        public void setA(String a) {
            this.a = a;
        }
        
        /**
         * @return the b
         */
        public int getB() {
            return b;
        }
        
        /**
         * @param b the b to set
         */
        public void setB(int b) {
            this.b = b;
        }
        
        /**
         * @return the flag
         */
        public boolean isFlag() {
            return flag;
        }
        
        /**
         * @param flag the flag to set
         */
        public void setFlag(boolean flag) {
            this.flag = flag;
        }
        
        /**
         * @return the bigBean
         */
        public BigBean getBigBean() {
            return bigBean;
        }
        
        /**
         * @param bigBean the bigBean to set
         */
        public void setBigBean(BigBean bigBean) {
            this.bigBean = bigBean;
        }
        
        
       
    }
}


