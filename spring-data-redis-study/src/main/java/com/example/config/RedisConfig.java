//package com.example.config;
//
//import org.redisson.Redisson;
//import org.redisson.api.RBloomFilter;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.ClusterServersConfig;
//import org.redisson.config.Config;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//
//@Configuration
//@PropertySource(value = "classpath:application.yml")
//public class RedisConfig {
//    @Value("${redis.nodes}")
//    private String clusterNodes;
//
//    @Bean
//    public RedissonClient getBloomFilter(){
//        Config config = new Config();
//        ClusterServersConfig clusterServersConfig = config.useClusterServers();
//        String[] cNodes = clusterNodes.split(",");
//        //分割出集群节点
//        for (String node : cNodes) {
//            clusterServersConfig.addNodeAddress("redis://" + node);
//        }
//        RedissonClient redissonClient = Redisson.create(config);
//        RBloomFilter<String> bloomFilter = redissonClient.getBloomFilter("phoneList");
//        //初始化布隆过滤器：预计元素为100000000L,误差率为3%
//        bloomFilter.tryInit(100000000L,0.03);
//        //将号码10086插入到布隆过滤器中
//        bloomFilter.add("10086");
//        return Redisson.create(config);
//    }
//}
