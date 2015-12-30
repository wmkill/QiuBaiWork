package com.dever.qiubaiwork.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by admin on 2015/12/30.
 */
public class TalkList {

    @SerializedName("count")
    private int count;
    @SerializedName("total")
    private int total;
    @SerializedName("page")
    private int page;
    @SerializedName("err")
    private int err;
    /**
     * liked : false
     * floor : 1
     * created_at : 1451430539
     * content : 我是一楼
     * like_count : 0
     * user : {"last_visited_at":1418988473,"created_at":1418988473,"last_device":"android_4.0.0","email":"","state":"active","role":"n","login":"单身鳖！","id":24080710,"icon":"20151103095251.jpg"}
     * id : 346424608
     */

    @SerializedName("items")
    private List<ItemsEntity> items;

    public void setCount(int count) {
        this.count = count;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setErr(int err) {
        this.err = err;
    }

    public void setItems(List<ItemsEntity> items) {
        this.items = items;
    }

    public int getCount() {
        return count;
    }

    public int getTotal() {
        return total;
    }

    public int getPage() {
        return page;
    }

    public int getErr() {
        return err;
    }

    public List<ItemsEntity> getItems() {
        return items;
    }

    public static class ItemsEntity {
        @SerializedName("liked")
        private boolean liked;
        @SerializedName("floor")
        private int floor;
        @SerializedName("created_at")
        private int created_at;
        @SerializedName("content")
        private String content;
        @SerializedName("like_count")
        private int like_count;
        /**
         * last_visited_at : 1418988473
         * created_at : 1418988473
         * last_device : android_4.0.0
         * email :
         * state : active
         * role : n
         * login : 单身鳖！
         * id : 24080710
         * icon : 20151103095251.jpg
         */

        @SerializedName("user")
        private UserEntity user;
        @SerializedName("id")
        private int id;

        public void setLiked(boolean liked) {
            this.liked = liked;
        }

        public void setFloor(int floor) {
            this.floor = floor;
        }

        public void setCreated_at(int created_at) {
            this.created_at = created_at;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setLike_count(int like_count) {
            this.like_count = like_count;
        }

        public void setUser(UserEntity user) {
            this.user = user;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isLiked() {
            return liked;
        }

        public int getFloor() {
            return floor;
        }

        public int getCreated_at() {
            return created_at;
        }

        public String getContent() {
            return content;
        }

        public int getLike_count() {
            return like_count;
        }

        public UserEntity getUser() {
            return user;
        }

        public int getId() {
            return id;
        }

        public static class UserEntity {
            @SerializedName("last_visited_at")
            private int last_visited_at;
            @SerializedName("created_at")
            private int created_at;
            @SerializedName("last_device")
            private String last_device;
            @SerializedName("email")
            private String email;
            @SerializedName("state")
            private String state;
            @SerializedName("role")
            private String role;
            @SerializedName("login")
            private String login;
            @SerializedName("id")
            private int id;
            @SerializedName("icon")
            private String icon;

            public void setLast_visited_at(int last_visited_at) {
                this.last_visited_at = last_visited_at;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public void setLast_device(String last_device) {
                this.last_device = last_device;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public void setState(String state) {
                this.state = state;
            }

            public void setRole(String role) {
                this.role = role;
            }

            public void setLogin(String login) {
                this.login = login;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public int getLast_visited_at() {
                return last_visited_at;
            }

            public int getCreated_at() {
                return created_at;
            }

            public String getLast_device() {
                return last_device;
            }

            public String getEmail() {
                return email;
            }

            public String getState() {
                return state;
            }

            public String getRole() {
                return role;
            }

            public String getLogin() {
                return login;
            }

            public int getId() {
                return id;
            }

            public String getIcon() {
                return icon;
            }
        }
    }
}
