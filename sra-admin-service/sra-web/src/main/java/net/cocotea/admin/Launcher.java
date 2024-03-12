package net.cocotea.admin;

import com.sagframe.sagacity.sqltoy.plus.EnableSqlToyPlus;
import net.cocotea.admin.common.constant.GlobalConst;
import net.cocotea.admin.properties.DefaultProp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableSqlToyPlus
public class Launcher {

    private static final Logger logger = LoggerFactory.getLogger(Launcher.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Launcher.class, args);
        DefaultProp defaultProp = (DefaultProp) context.getBean("defaultProp");
        logger.info("强密码：{}, 权限缓存状态：{}", defaultProp.getStrongPassword(), defaultProp.getPermissionCache());
        GlobalConst.START_TIME = System.currentTimeMillis();
    }

}
