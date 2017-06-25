package com.larry.utils;

import java.net.InetAddress;

/**
 * Created by Larry on 2017/6/5.
 */
public class UuidUtil {

    protected static final String IP;

    protected static final String JVM;

    protected static short COUNTER = (short) 0;

    protected static final Object _lock = new Object();

    static {
        int ip;
        try {
            // System.out.println(InetAddress.getLocalHost().getHostAddress());
            InetAddress ia = InetAddress.getLocalHost();
            // String _ip = ia.getHostAddress();
            ip = toInt(ia.getAddress());
        } catch (Exception e) {
            ip = 0;
        }
        String _ip = Integer.toHexString(ip);
        StringBuffer sb = new StringBuffer("00000000");
        sb.replace(8 - _ip.length(), 8, _ip);
        IP = sb.toString();

        int jvm = (int) (System.currentTimeMillis() >>> 8);
        String _jvm = Integer.toHexString(jvm);
        StringBuffer jvmSb = new StringBuffer("00000000");
        jvmSb.replace(8 - _jvm.length(), 8, _jvm);
        JVM = jvmSb.toString();
    }

    /**
     * 受保护的构造方法, 防止外部构建对象实例.
     */
    protected UuidUtil() {
        super();
    }

    /**
     * 二进制转换为Int值.
     *
     * @param bytes
     * @return int
     */
    public static int toInt(byte[] bytes) {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result = (result << 8) - Byte.MIN_VALUE + (int) bytes[i];
        }
        return result;
    }

    /**
     * Unique in a millisecond for this JVM instance (unless there
     * are > Short.MAX_VALUE instances created in a millisecond)
     */
    protected static short getCount() {
        synchronized (_lock) {
            if (COUNTER < 0) {
                COUNTER = 0;
            }
            return COUNTER++;
        }
    }

    /**
     * 生成数据库记录PK(模拟Hibernate中的UUID策略).
     *
     * @return String
     */
    public static String getUuid() {
        StringBuffer sb = new StringBuffer(36);
        sb.append(IP).append(JVM);

        short hitime = (short) (System.currentTimeMillis() >>> 32);
        String _hitime = Integer.toHexString(hitime);
        StringBuffer hitimeSb = new StringBuffer("0000");
        hitimeSb.replace(4 - _hitime.length(), 4, _hitime);
        sb.append(hitimeSb);

        int lotime = (int) System.currentTimeMillis();
        String _lotime = Integer.toHexString(lotime);
        StringBuffer lotimeSb = new StringBuffer("00000000");
        lotimeSb.replace(8 - _lotime.length(), 8, _lotime);
        sb.append(lotimeSb);

        short count = getCount();
        String _count = Integer.toHexString(count);
        StringBuffer countSb = new StringBuffer("0000");
        countSb.replace(4 - _count.length(), 4, _count);
        sb.append(countSb);

        return sb.toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(UuidUtil.getUuid());
        }
    }
}
