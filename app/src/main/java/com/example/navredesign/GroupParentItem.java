package com.example.navredesign;

import java.util.List;

public class GroupParentItem {
    private String name;
    private int flag = -1;
    private List<String> childList;

    public GroupParentItem(String name, int flag) {
        this.name = name;
        this.flag = flag;
    }

    public GroupParentItem(String name, int flag, List<String> childList) {
        this.name = name;
        this.flag = flag;
        this.childList = childList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public List<String> getChildList() {
        return childList;
    }

    public void setChildList(List<String> childList) {
        this.childList = childList;
    }
}
