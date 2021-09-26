package com.fangdongze.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * JedisPool ：Jedis提供的连接池技术
 * poolConfig :连接池配置对象
 * host : redis服务地址
 * port : redis服务端口号
 * public JedisPool(GenericObjectPoolConfig poolConfig, String host, int port) {
 * this(poolConfig, host, port, 2000, (String)null, 0, (String)null);
 * }
 */

public class JedisUtils {
    private static JedisPool jp = null;
    private static String host = null;
    private static int port;
    private static int maxTotal;
    private static int maxIdle;

    //静态代码块初始化资源
    static {
        //获取redis的配置文件
        ResourceBundle rb = ResourceBundle.getBundle("redis");
        host = rb.getString("redis.host");
        port = Integer.parseInt(rb.getString("redis.port"));
        maxTotal = Integer.parseInt(rb.getString("redis.maxTotal"));
        maxIdle = Integer.parseInt(rb.getString("redis.maxIdle"));
        JedisPoolConfig jpc = new JedisPoolConfig();
        jpc.setMaxTotal(maxTotal);
        jpc.setMaxIdle(maxIdle);
        jp = new JedisPool(jpc,host,port);
    }

    //对外访问接口，提供jedis连接对象，连接从连接池获取
    public static Jedis getJedis(){
        return jp.getResource();
    }
    public static void main(String[] args){
        JedisUtils.getJedis();
    }
}
