package com.lugou.score.bean;

import java.util.List;

public class MenuBean {


    /**
     * title : 主页
     * icon : layui-icon-home
     * list : [{"title":"控制台","jump":"/"},{"name":"homepage1","title":"主页一","jump":"home/homepage1"},{"name":"homepage2","title":"主页二","jump":"home/homepage2"}]
     * name : muser
     */

    private String title;
    private String icon;
    private String name;
    private List<ListBean> list;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * title : 控制台
         * jump : /
         * name : homepage1
         */

        private String title;
        private String jump;
        private String name;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getJump() {
            return jump;
        }

        public void setJump(String jump) {
            this.jump = jump;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
