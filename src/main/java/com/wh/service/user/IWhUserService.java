package com.wh.service.user;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.base.ResponseBase;
import com.wh.entity.user.UserInfo;
import org.springframework.validation.BindingResult;

public interface IWhUserService extends IService<UserInfo> {

//    ResponseBase serviceSelUserByRName(String rName);
//

    /**
     * 查询所有用户租户信息
     *
     * @param user
     * @return
     */
    ResponseBase getByUserInfoList(UserInfo user);

    //
//    //修改用户
//    ResponseBase upUserInfo(UserInfo user);
//

    /**
     * 新增租户用户
     *
     * @param user
     * @return
     */
    String insertUserInfoAndTenant(UserInfo user);

//    //删除 用户信息
//    ResponseBase delUserInfo(List<Integer> uids);

}
