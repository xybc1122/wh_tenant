package com.wh.service.rm.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.entity.rm.WhUserRoleMenu;
import com.wh.exception.LsException;
import com.wh.mapper.rm.WhUserRoleMenuMapper;
import com.wh.service.rm.IWhUserRoleMenuService;
import com.wh.toos.Constants;
import com.wh.utils.CheckUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 角色菜单权限表 服务实现类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-14
 */
@Service
public class WhUserRoleMenuServiceImpl extends ServiceImpl<WhUserRoleMenuMapper, WhUserRoleMenu> implements IWhUserRoleMenuService {


    @Override
    public ResponseBase saveRoleMenu(Long rid, List<Integer> menus) {
        WhUserRoleMenu whUserRoleUser;
        List<WhUserRoleMenu> roleMenuList = new ArrayList<>();
        //新增菜单
        if (rid != null && menus != null && menus.size() > 0) {
            //如果有多个
            for (Integer mid : menus) {
                whUserRoleUser = new WhUserRoleMenu(mid.longValue(), rid);

                //whUserRoleUser.setCreate(ReqUtils.getUserName());

                roleMenuList.add(whUserRoleUser);
            }
            CheckUtils.saveResult(this.saveBatch(roleMenuList));


            return JsonData.setResultSuccess("success");
        }
        throw new LsException("参数 is null");
    }

}
