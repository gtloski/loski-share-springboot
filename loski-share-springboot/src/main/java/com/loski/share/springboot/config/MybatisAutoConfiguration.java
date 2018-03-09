package com.loski.share.springboot.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageInterceptor;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

@Configuration
public class MybatisAutoConfiguration {

	@Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setMarkerInterface(Mapper.class);
        mapperScannerConfigurer.setBasePackage("com.loski.share.springboot.dao");
        Properties properties = new Properties();
        properties.put("IDENTITY", "mysql");
        properties.put("seqFormat", "{0}.nextval");
        mapperScannerConfigurer.setProperties(properties);
        return mapperScannerConfigurer;
    }
	
	@Bean
    public PageInterceptor pageInterceptor() {
        PageInterceptor interceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.put("helperDialect", "mysql");//配置helperDialect属性来指定分页插件使用哪种方言。配置时，可以使用下面的缩写值：oracle,mysql,mariadb
        properties.put("offsetAsPageNum", "true");//offsetAsPageNum：默认值为 false，该参数对使用 RowBounds 作为分页参数时有效。 当该参数设置为 true 时，会将 RowBounds 中的 offset 参数当成 pageNum 使用，可以用页码和页面大小两个参数进行分页。
        properties.put("rowBoundsWithCount", "true");//默认值为false,使用 RowBounds 分页不会进行 count 查询
        properties.put("pageSizeZero", "true");//默认值为 false，当该参数设置为 true 时，如果 pageSize=0 或者 RowBounds.limit = 0 就会查询出全部的结果
        properties.put("reasonable", "false");//默认值为false。当该参数设置为 true 时，pageNum<=0 时会查询第一页， pageNum>pages（超过总数时），会查询最后一页
        properties.put("supportMethodsArguments", "true");//支持通过 Mapper 接口参数来传递分页参数，默认值false
        properties.put("params", "pageNum=start;pageSize=limit;");
        interceptor.setProperties(properties);
        return interceptor;
    }
}
