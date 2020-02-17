package com.bitedu.osm;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;

public class OSResource {
    private static OperatingSystemMXBean mxBean = ManagementFactory.getPlatformMXBean(
            OperatingSystemMXBean.class);

    private static final int DATA_LENGTH = 60;
    //记录60个坐点，也就是一个统计周期
    private static XYPair[] xyPairs = new XYPair[DATA_LENGTH];
    private static int firstIndex = DATA_LENGTH;
    static {
        for (int i = 0; i <xyPairs.length ; i++) {
            xyPairs[i] = new XYPair(0,0);
        }
    }

    public static class XYPair{
        private double x;
        private double y;

        public XYPair(double x,double y){
            this.x = x;
            this.y = y;
        }
        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }
    }

    public static XYPair[] getCPUPercetage() {

       double cpu = mxBean.getSystemCpuLoad();

       moveCPUData(cpu);

       return xyPairs;

    }

    public static String getOSName(){
        return mxBean.getName();
    }

    private static void moveCPUData(double cpuPercetage){
        int movIdx = -1;
        if (firstIndex == 0){
            movIdx = firstIndex + 1;
        }else {
            movIdx = firstIndex;
            firstIndex--;
        }
        for (; movIdx <xyPairs.length; ++movIdx){
            xyPairs[movIdx-1].setX(xyPairs[movIdx].getX()-1);
            xyPairs[movIdx-1].setY(xyPairs[movIdx].getY());
        }
        movIdx--;
        xyPairs[movIdx] = new XYPair(movIdx, cpuPercetage);
    }
}
