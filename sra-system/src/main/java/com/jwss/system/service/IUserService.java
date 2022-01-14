package com.jwss.system.service;

import com.jwss.system.param.user.UserAddParam;
import com.jwss.system.param.user.UserLoginParam;
import com.jwss.system.vo.UserVO;
import org.sagacity.sqltoy.model.Page;

/**
 * @date 2022-1-12 15:32:55
 * @author jwss
 */
public interface IUserService {
    /**
     * 搜索
     * @param pageModel
     * @param fruitOrderVO
     * @return
     */
    Page<UserVO> searchFruitOrder(Page<UserVO> pageModel, UserVO fruitOrderVO);

    /**
     * 新增用户
     * @param param 用户表单
     * @return 成功返回TRUE
     */
    boolean add(UserAddParam param);

    /**
     * 用户登录
     * @param param 登录参数
     * @return token
     */
    String login(UserLoginParam param);
}
