package com.example;


import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;

import javax.annotation.Resource;
//

/**
 * Redission实现布隆过滤器
 * 查询key是否存在，避免每次根据key去查找对应的value值；减少磁盘IO次数，提升我系统程序性能
 */
public class BloomTest {

    public static void main(String[] args) {
        Config config = new Config();
//        ClusterServersConfig clusterServersConfig = config.useClusterServers();
        SingleServerConfig singleServerConfig = config.useSingleServer();
        singleServerConfig.setAddress("redis://127.0.0.1:6379");
        singleServerConfig.setPassword(null);

        RedissonClient redissonClient = Redisson.create(config);
        RBloomFilter<String> bloomFilter = redissonClient.getBloomFilter("phoneList");
        //初始化布隆过滤器：预计元素为100000000L,误差率为3%
        bloomFilter.tryInit(100000000L,0.03);
        //将号码10086插入到布隆过滤器中
        bloomFilter.add("10086");
        System.out.println(bloomFilter.contains("123456"));
        System.out.println(bloomFilter.contains("10086"));
    }
}
