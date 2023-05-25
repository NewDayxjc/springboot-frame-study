package com.xjc.likou.dynamicPlan;

public class RobberyTest {

    public static void main(String[] args) {
        int n;
//        Integer result = new RobberyTest().climbStairs(9);
//        System.out.println(result);
        /*母牛生产*/

        Integer result = new RobberyTest().productCows(6);
        System.out.println(result);
    }

    /**
     * 题目描述: 有 N 阶楼梯，每次可以上一阶或者两阶，求有多少种上楼梯的方法。
     * 上到第i层楼的方法有第i-1和第i-2种
     *
     * @param n
     * @return
     */
    public Integer climbStairs(Integer n) {
        if (n <= 2) {
            return n;
        }
        int pre1 = 1;
        int pre2 = 2;
        for (Integer i = 2; i < n; i++) {
            int cur = pre1 + pre2;
            pre1 = pre2;
            pre2 = cur;
        }
        return pre2;
    }

    /**
     * 题目描述: 假设农场中成熟的母牛每年都会生 1 头小母牛，并且永远不会死。第一年有 1 只小母牛，从第二年开始，母牛开始生小母牛。每只小母牛 3 年之后成熟又可以生小母牛。给定整数 N，求 N 年后牛的数量。
     * 第一年：1
     * 第二年：1+1
     * 第三年：2+1
     * 第四年：3+1+1
     * 第五年：5+3    1
     * 第六年：8+4
     * <p>
     * 第一年：1
     * 第二年：1+1
     * 第三年：2+1
     * 第四年：3+1    4
     * 第五年：4+2    6
     * 第六年：6+3    9
     *
     * @param n
     * @return
     */

    public Integer productCows(Integer n) {

        if (n <= 4) {
            return n;
        }

        int pre1 = 3;
        for (Integer i = 4; i <= n; i++) {
            int total = i - 3 + pre1;
            pre1 = total;
        }
        return pre1;


//        int []dp=new int [n+1];
//        if(n<=3){
//            return n;
//        }
//        dp[0]=0;
//        dp[1]=1;
//        dp[2]=2;
//        dp[3]=3;
//        for(int i=4;i<=n;i++){
//            dp[i]=dp[i-1]+dp[i-3];
//        }
//        return dp[n];

    }


}
