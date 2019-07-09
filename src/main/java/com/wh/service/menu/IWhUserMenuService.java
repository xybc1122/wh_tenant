package com.wh.service.menu;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wh.base.ResponseBase;
import com.wh.entity.menu.WhUserMenu;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-14
 */
public interface IWhUserMenuService extends IService<WhUserMenu> {

    /**
     * 查询树形菜单
     *
     * @return
     */
    ResponseBase serviceSelTreeList();


}
