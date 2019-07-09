package com.wh.mapper.menu;


import org.apache.ibatis.jdbc.SQL;

/**
 * 建动态sql语句
 */
public class MenuProvider {

    private final static String sqlKey = "m.`menu_id`,m.`m_name`,m.`parent_id`,m.`path`,m.`icon`," +
            "m.`menu_order`,m.`type`,m.`version`,m.`is_delete`,m.`is_parent_node`";

    public String findQueryMenuList() {
        return new SQL() {{
            SELECT(sqlKey + " FROM `wh_user_menu` AS m");
            WHERE("m.is_delete =0");
            ORDER_BY("m.`menu_order` asc");
        }}.toString();

    }
}
