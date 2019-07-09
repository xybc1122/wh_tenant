package com.wh.mapper.menu;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wh.dto.TreeDto;
import com.wh.entity.menu.WhUserMenu;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-14
 */
public interface WhUserMenuMapper extends BaseMapper<WhUserMenu> {


    /**
     * 查询树形菜单
     *
     * @return
     */
    @SelectProvider(type = MenuProvider.class, method = "findQueryMenuList")
    @Results({
            @Result(column = "menu_id", property = "treeId"),
            @Result(column = "m_name", property = "treeName"),
            @Result(column = "is_parent_node", property = "nextLevel"),
    })
    List<TreeDto> selTreeList();


}
