package ${package}.config;

import ${package}.util.SystemEnv;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Properties;

/**
 * 扩展配置文件加载
 * 加载配置文件到全局变量中
 */

public class PropertyPlaceholderConfigurerEx extends PropertyPlaceholderConfigurer {

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
            throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        //建议使用PropertySourcesPlaceholderConfigurer加载
        System.setProperty("spring.profiles.active", props.getProperty("fn.env"));
        // 添加到系统变量中
        SystemEnv.addProperty(props);
        // 初始化Log4j
        PropertyConfigurator.configure(props);
    }

}
