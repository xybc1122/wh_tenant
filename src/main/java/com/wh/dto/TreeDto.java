package com.wh.dto;

import java.util.List;

/**
 * @ClassName TreeDto
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/7/1 9:37
 **/
public class TreeDto {
    /**
     * 树ID
     */
    private Integer treeId;
    /**
     * 树节点名称
     */
    private String treeName;
    /**
     * 子节点
     */
    private List<TreeDto> childNode;
    /**
     * 父ID
     */
    private Integer parentId;
    /**
     * 请求路径
     */
    private String path;


    /**
     * 版本标识
     */
    private Integer version;


    /**
     * 菜单图标
     */
    private String icon;


    /**
     * 是否还有下一级
     */
    private Boolean nextLevel;


    public Boolean getNextLevel() {
        return nextLevel;
    }

    public void setNextLevel(Boolean nextLevel) {
        this.nextLevel = nextLevel;
    }

    public Integer getTreeId() {
        return treeId;
    }

    public void setTreeId(Integer treeId) {
        this.treeId = treeId;
    }

    public String getTreeName() {
        return treeName;
    }

    public void setTreeName(String treeName) {
        this.treeName = treeName;
    }

    public List<TreeDto> getChildNode() {
        return childNode;
    }

    public void setChildNode(List<TreeDto> childNode) {
        this.childNode = childNode;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
