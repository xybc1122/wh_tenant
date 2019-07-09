package com.wh.service.ur.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.entity.ur.WhUserRoleUser;
import com.wh.entity.user.UserInfo;
import com.wh.exception.LsException;
import com.wh.mapper.ur.WhUserRoleUserMapper;
import com.wh.service.ur.IWhUserRoleUserService;
import com.wh.utils.CheckUtils;
import com.wh.utils.WrapperUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 用户跟角色表 服务实现类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-14
 */
@Service
public class WhUserRoleUserServiceImpl extends ServiceImpl<WhUserRoleUserMapper, WhUserRoleUser> implements IWhUserRoleUserService {

    /**
     * 一个用户 添加多个角色 通用
     *
     * @param uid
     * @param rids
     * @return
     */
    @Override
    public void saveListRole(Long uid, String rids) {
        List<WhUserRoleUser> roleUserList = new ArrayList<>();
        WhUserRoleUser whUserRoleUser;
        boolean isResult;
        //新增角色
        if (uid != null && StringUtils.isNotBlank(rids)) {
            //如果是-1说明只增加一个角色
            for (String rId : rids.split(",")) {
                whUserRoleUser = new WhUserRoleUser(uid, Long.parseLong(rId));
                roleUserList.add(whUserRoleUser);
            }
            isResult = this.saveOrUpdateBatch(roleUserList);
            if (!isResult) {
                throw new LsException("添加角色失败");
            }
        }
    }


    @Override
    public ResponseBase upUserAndRole(UserInfo user) {
        if (user == null || user.getUid() == null) {
            return JsonData.setResultError("参数 is null");
        }
        // 1 先删除用户角色表的 用户id
        QueryWrapper<WhUserRoleUser> ruQuery = WrapperUtils.getQuery();
        ruQuery.eq("u_id", user.getUid());
        CheckUtils.saveResult(this.remove(ruQuery));
        if (StringUtils.isNotBlank(user.getRids())) {
            //2 重新添加角色
            saveListRole(user.getUid(), user.getRids());
        }

        return JsonData.setResultSuccess("success");
    }
}
