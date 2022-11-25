package net.cocotea.admin.bootstrap.handler;

import cn.dev33.satoken.stp.StpUtil;
import org.sagacity.sqltoy.model.DataAuthFilterConfig;
import org.sagacity.sqltoy.model.IgnoreCaseSet;
import org.sagacity.sqltoy.model.IgnoreKeyCaseMap;
import org.sagacity.sqltoy.plugins.IUnifyFieldsHandler;
import org.sagacity.sqltoy.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @date 2022-1-14 23:08:02
 * @author jwss
 */
public class SqlToyUnifyFieldsHandler implements IUnifyFieldsHandler {
    private final Logger logger = LoggerFactory.getLogger(SqlToyUnifyFieldsHandler.class);

    @Override
    public Map<String, Object> createUnifyFields() {
        LocalDateTime nowTime = DateUtil.getDateTime();
        String loginId;
        try {
            loginId  = (String) StpUtil.getLoginId();
        } catch (Exception e) {
            logger.info("warning!func[createUnifyFields],add this item not login.");
            loginId = "";
        }
        Map<String, Object> map = new HashMap<>(Character.OTHER_LETTER);
        map.put("createBy", loginId);
        map.put("createTime", nowTime);
        map.put("updateBy", loginId);
        map.put("updateTime", nowTime);
        map.put("deleteStatus", Character.UPPERCASE_LETTER);
        map.put("sort", Character.UPPERCASE_LETTER);
        return map;
    }

    @Override
    public Map<String, Object> updateUnifyFields() {
        LocalDateTime nowTime = DateUtil.getDateTime();
        String loginId = (String) StpUtil.getLoginId();
        Map<String, Object> map = new HashMap<>(Character.TITLECASE_LETTER);
        map.put("updateBy", loginId);
        map.put("updateTime", nowTime);
        return map;
    }

    @Override
    public IgnoreCaseSet forceUpdateFields() {
        return IUnifyFieldsHandler.super.forceUpdateFields();
    }

    @Override
    public IgnoreKeyCaseMap<String, DataAuthFilterConfig> dataAuthFilters() {
        return IUnifyFieldsHandler.super.dataAuthFilters();
    }
}
