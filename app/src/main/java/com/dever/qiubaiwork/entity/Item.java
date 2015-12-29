package com.dever.qiubaiwork.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by admin on 2015/12/29.
 */
public class Item {

    /**
     * format : word
     * image : null
     * published_at : 1451346901
     * tag :
     * user : {"avatar_updated_at":1451392978,"last_visited_at":1327836426,"created_at":1327836426,"state":"active","email":" ","last_device":"ios_1.0","role":"n","login":"潇湘墨兰","id":441420,"icon":"20151229124258.jpg"}
     * image_size : null
     * id : 114462277
     * votes : {"down":-364,"up":15243}
     * created_at : 1451344564
     * content : 见学长夫妇，说是最近俩人一直分床睡，已经好几个月了。我还以为是关系冷淡期，关切地问怎么回事。学长含羞一笑，说俩人共同爱好太多，三观太和，永远有聊不完的话题，一不小心就唠到三四点，再愉快地啪啪一下，第二天根本没法起床上班...秀得我泪流满面…
     * state : publish
     * comments_count : 131
     * allow_comment : true
     * share_count : 506
     * type : hot
     */
    @SerializedName("items")
    private List<ItemsEntity> items;

    public void setItems(List<ItemsEntity> items) {
        this.items = items;
    }

    public List<ItemsEntity> getItems() {
        return items;
    }

    public static class ItemsEntity {
        @SerializedName("format")
        private String format;
        @SerializedName("image")
        private Object image;
        /**
         * avatar_updated_at : 1451392978
         * last_visited_at : 1327836426
         * created_at : 1327836426
         * state : active
         * email :
         * last_device : ios_1.0
         * role : n
         * login : 潇湘墨兰
         * id : 441420
         * icon : 20151229124258.jpg
         */
        @SerializedName("user")
        private UserEntity user;
        @SerializedName("image_size")
        private Object image_size;
        @SerializedName("id")
        private int id;
        /**
         * down : -364
         * up : 15243
         */
        @SerializedName("votes")
        private VotesEntity votes;
        @SerializedName("content")
        private String content;
        @SerializedName("comments_count")
        private int comments_count;
        @SerializedName("share_count")
        private int share_count;

        public void setFormat(String format) {
            this.format = format;
        }

        public void setImage(Object image) {
            this.image = image;
        }

        public void setUser(UserEntity user) {
            this.user = user;
        }

        public void setImage_size(Object image_size) {
            this.image_size = image_size;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setVotes(VotesEntity votes) {
            this.votes = votes;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setComments_count(int comments_count) {
            this.comments_count = comments_count;
        }

        public void setShare_count(int share_count) {
            this.share_count = share_count;
        }

        public String getFormat() {
            return format;
        }

        public Object getImage() {
            return image;
        }

        public UserEntity getUser() {
            return user;
        }

        public Object getImage_size() {
            return image_size;
        }

        public int getId() {
            return id;
        }

        public VotesEntity getVotes() {
            return votes;
        }

        public String getContent() {
            return content;
        }

        public int getComments_count() {
            return comments_count;
        }

        public int getShare_count() {
            return share_count;
        }

        public static class UserEntity {
            @SerializedName("login")
            private String login;
            @SerializedName("id")
            private int id;
            @SerializedName("icon")
            private String icon;

            public void setLogin(String login) {
                this.login = login;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setIcon(String icon) {
                this.icon = icon;
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

        public static class VotesEntity {
            @SerializedName("up")
            private int up;

            public void setUp(int up) {
                this.up = up;
            }

            public int getUp() {
                return up;
            }
        }
    }
}
