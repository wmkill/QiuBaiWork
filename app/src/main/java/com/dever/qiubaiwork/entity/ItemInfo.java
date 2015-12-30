package com.dever.qiubaiwork.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by admin on 2015/12/30.
 */
public class ItemInfo {

    /**
     * format : word
     * image : null
     * published_at : 1451293202
     * tag :
     * user : {"avatar_updated_at":0,"last_visited_at":1440232522,"created_at":1440232522,"state":"active","email":"","last_device":"android_7.3.0","role":"n","login":"没大招的阿木木","id":30147593,"icon":"20150911114453.jpg"}
     * image_size : null
     * id : 114455410
     * votes : {"down":-371,"up":11749}
     * is_mine : false
     * created_at : 1451289783
     * content : 我以为生活就是猫吃鱼，狗吃肉，奥特曼打小怪兽。现实却是鼠整猫，羊耍狼，两熊玩死光头强。不是我们不坚强，只是世界太疯狂!
     * state : publish
     * comments_count : 134
     * allow_comment : true
     * share_count : 1414
     * type : hot
     */
    @SerializedName("article")
    private ArticleEntity article;

    public void setArticle(ArticleEntity article) {
        this.article = article;
    }

    public ArticleEntity getArticle() {
        return article;
    }

    public static class ArticleEntity {
        @SerializedName("format")
        private String format;
        /**
         * avatar_updated_at : 0
         * last_visited_at : 1440232522
         * created_at : 1440232522
         * state : active
         * email :
         * last_device : android_7.3.0
         * role : n
         * login : 没大招的阿木木
         * id : 30147593
         * icon : 20150911114453.jpg
         */

        @SerializedName("user")
        private UserEntity user;
        @SerializedName("id")
        private int id;
        /**
         * down : -371
         * up : 11749
         */

        @SerializedName("votes")
        private VotesEntity votes;
        @SerializedName("content")
        private String content;
        @SerializedName("comments_count")
        private int comments_count;
        @SerializedName("share_count")
        private int share_count;
        @SerializedName("type")
        private String type;

        public void setFormat(String format) {
            this.format = format;
        }

        public void setUser(UserEntity user) {
            this.user = user;
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

        public void setType(String type) {
            this.type = type;
        }

        public String getFormat() {
            return format;
        }

        public UserEntity getUser() {
            return user;
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

        public String getType() {
            return type;
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
