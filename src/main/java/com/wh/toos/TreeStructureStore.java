package com.wh.toos;


import com.wh.dto.TreeDto;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TreeStructureStore
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/26 10:12
 **/
public class TreeStructureStore {

    /**
     * 树形数据转换
     *
     * @param result
     * @return
     */
    public static List<TreeDto> getTree(List<TreeDto> result) {
        //一级目录
        List<TreeDto> firstArrList = new ArrayList<>();
        //子目录
        List<TreeDto> childArrList = new ArrayList<>();
        if (result != null && result.size() > 0) {
            for (TreeDto obj : result) {
                if (obj.getParentId() != null) {
                    if (obj.getParentId() == 0) {
                        //是否为父目录
                        firstArrList.add(obj);
                    } else {
                        childArrList.add(obj);
                    }
                }
            }
            // 为一级目录设置子目录 getChild是递归调用的
            for (TreeDto firs : firstArrList) {
                firs.setChildNode(getChild(firs.getTreeId(), childArrList));
            }
        }
        return firstArrList;
    }

    private static List<TreeDto> getChild(Integer treeId, List<TreeDto> childNodeList) {
        List<TreeDto> childList = new ArrayList<>();
        // 遍历childNodeList，找出所有的根节点和非根节点
        if (childNodeList != null && childNodeList.size() > 0) {
            // 子菜单
            for (TreeDto v : childNodeList) {
                //如果子跟父ID相同 就设置进去
                if (treeId.equals(v.getParentId())) {
                    childList.add(v);
                }
            }
        }
        //查询子节点
        for (TreeDto childV : childList) {
            //如果是true 说明下面还有子菜单
            if (childV.getNextLevel()) {
                childV.setChildNode(getChild(childV.getTreeId(), childNodeList));
            }
        }
        // 递归退出条件
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }

//    /**
//     * 获取某个父节点下面的所有子节点
//     *
//     * @param menuList
//     * @param pid
//     * @return
//     */
//    public static List<ParentTree> treeMenuList(List<ParentTree> menuList, int pid) {
//        List<ParentTree> childMenu = new ArrayList<ParentTree>();
//        for (ParentTree mu : menuList) {
//            //遍历出父id等于参数的id，add进子节点集合
//            if (Integer.valueOf(mu.getParentId()) == pid) {
//                //递归遍历下一级
//                treeMenuList(menuList, Integer.valueOf(mu.getTreeId()));
//                childMenu.add(mu);
//            }
//        }
//        return childMenu;
//    }

}
