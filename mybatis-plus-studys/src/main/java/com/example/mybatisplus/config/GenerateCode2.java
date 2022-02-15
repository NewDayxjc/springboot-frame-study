package com.example.mybatisplus.config;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;

import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.example.engine.MyFreemarkerTemplateEngine;
import com.example.superEntity.BaseController;
import com.example.superEntity.BaseEntity;

import java.io.File;
import java.util.*;
import java.util.function.BiConsumer;

/**
 * @author XiongJinChen
 * @version 1.0
 * @date 2021/6/23 7:33
 * <p>
 * GenerateCode
 */
public class GenerateCode2 {
    /**
     * 读取控制台输入内容
     */
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String TEMPLATE_PATH ="/template/";


    /**
     * 控制台输入内容读取并打印提示信息
     *
     * @param message 提示信息
     * @return
     */
    public static String scannerNext(String message) {
        System.out.println(message);
        String nextLine = SCANNER.nextLine();
        if (StringUtils.isBlank(nextLine)) {
            // 如果输入空行继续等待
            return SCANNER.next();
        }
        return nextLine;
    }

    protected static <T> T configBuilder(IConfigBuilder<T> configBuilder) {
        return null == configBuilder ? null : configBuilder.build();
    }

    public static void main(String[] args) {
        // 自定义模板，key 为 自定义的包名:Entity 后缀，value 为模板路径
        Map<String, String> customFile = new HashMap<>();
//        customFile.put("domain/qo:GetQO", "/template/entityQO.java");
//        customFile.put("domain/qo:ListQO", "/template/entityQO.java");
//        customFile.put("domain/qo:SaveQO", "/template/entityQO.java");
//        customFile.put("domain/qo:UpdateQO", "/template/entityQO.java");
//        customFile.put("domain/qo:RemoveQO", "/template/entityQO.java");
//
//        customFile.put("domain/vo:ListVO", "/template/entityVO.java");
//        customFile.put("domain/vo:GetVO", "/template/entityVO.java");

//        customFile.put("struct:Struct", "/template/struct.java");

        // 代码生成器
        new AutoGenerator(configBuilder(new DataSourceConfig.Builder("jdbc:mysql://8.129.128.32:3306/xwt?characterEncoding=UTF-8&useSSL=false&useUnicode=true&serverTimezone=UTC", "dev1", "zazndev2021$")))
                // 全局配置
                .global(configBuilder(new GlobalConfig.Builder()
                        // 覆盖已生成文件，默认 false
                        .fileOverride()
                        // 禁用打开生成目录
                        // .disableOpenDir()
                        // 输出目录，默认 windows: D://  linux or mac: /tmp
//                        .outputDir("/generator/src/main/java")
                         .outputDir(System.getProperty("user.dir")+ "/mybatis-plus-studys/src/main/java")
                        // 作者，默认无
                        // .author("")
                        // 注释时间（@since），默认 yyyy-MM-dd
                        .commentDate("")
                        // 开启 swagger 模式，默认 false
                        .enableSwagger()
                ))
                // 包配置
                .packageInfo(configBuilder(new PackageConfig.Builder()
                        // 模块名
                        .moduleName(SCANNER.next())
                        // 实体包名
                        .entity("domain")
                        // 父包名
                        .parent("com.bisci.common")
                ))
                // 自定义配置
                .injection(configBuilder(new InjectionConfig.Builder()
                        .beforeOutputFile(new BiConsumer<TableInfo, Map<String, Object>>() {
                            @Override
                            public void accept(TableInfo tableInfo, Map<String, Object> stringObjectMap) {
                                // 不启用 @TableName 注解
                                // tableInfo.setConvert(false);

                                // 自定义 Mapper XML 生成目录
                                ConfigBuilder config = (ConfigBuilder) stringObjectMap.get("config");
                                Map<OutputFile, String> pathInfoMap = config.getPathInfo();
                                pathInfoMap.put(OutputFile.mapperXml, pathInfoMap.get(OutputFile.mapperXml).replaceAll("/java.*", "/resources/mapper"));
                                stringObjectMap.put("config", config);
                            }
                        })
                        // 自定义文件，比如 VO
                        .customFile(customFile)
                ))
                // 策略配置
                .strategy(configBuilder(new StrategyConfig.Builder()
                        // 表名
                        .addInclude(scannerNext("请输入表名（英文逗号分隔）：").split(","))
                        // 过滤表前缀
                        .addTablePrefix("tb_")

                        // Entity 策略配置
                        .entityBuilder()
                        // 开启 Lombok 模式
                        .enableLombok()
                        // 禁用生成 serialVersionUID
                        .disableSerialVersionUID()
                        // 数据库表映射到实体的命名策略：下划线转驼峰
                        .naming(NamingStrategy.underline_to_camel)
                        // 主键策略为自增，默认 IdType.AUTO
                        .idType(IdType.AUTO)
                        // 父类
                        .superClass(BaseEntity.class)

                        // Controller 策略配置
                        .controllerBuilder()
                        // 生成 @RestController 注解
                        .enableRestStyle()
                        // 父类
                        .superClass(BaseController.class)
                ))
                // 模板配置
                .template(configBuilder(new TemplateConfig.Builder()
                        // 自定义模板：https://github.com/baomidou/generator/tree/develop/mybatis-plus-generator/src/main/resources/templates
                        .entity("/template/entity.java")
                        .mapper("/template/mapper.java")
                        .service("/template/service.java")
                        .serviceImpl("/template/serviceImpl.java")
                        .controller("/template/controller.java")
                ))

                // 执行并指定模板引擎
                .execute(new MyFreemarkerTemplateEngine());
        // .execute(new FreemarkerTemplateEngine());
    }
}
