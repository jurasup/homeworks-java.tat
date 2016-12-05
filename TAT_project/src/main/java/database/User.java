package database;

import java.util.HashMap;

/**
 * Represents an user entity. There are 5 types of possible users: administrator, editor,
 * author, contributor, subscriber.
 * @author Yury Suponev
 */
public class User {
    private static long nextID = 100;

    private final long ID;
    private String login;
    private String password;
    private String email;
    private String creationTime = "2016-12-05 00:00:00";
    private UserMeta meta;

    private User() {
        this.ID = nextID;
        nextID++;
    }

    public long getID() {
        return this.ID;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public HashMap<String, String> getMeta() {
        return this.meta.getData();
    }

    public static UserBuilder newBuilder() {
        return new User().new UserBuilder();
    }

    public class UserBuilder {
        //private static final int ADMIN_STATUS = 0;
        // static final int EDITOR_STATUS = 1;
        //private static final int AUTHOR_STATUS = 2;
        //private static final int CONTRIBUTOR_STATUS = 3;
        //private static final int SUBSCRIBER_STATUS = 4;
        public static final String ADMIN = "administrator";
        public static final String EDITOR = "editor";
        public static final String AUTHOR = "author";
        public static final String CONTRIBUTOR = "contributor";
        public static final String SUBSCRIBER = "subscriber";


        private UserBuilder() {

        }

        public User build(String status) {
            switch (status) {
                case ADMIN:
                    newUser(status, UserMeta.ADMIN_LEVEL);
                    break;
                case EDITOR:
                    newUser(status, UserMeta.EDITOR_LEVEL);
                    break;
                case AUTHOR:
                    newUser(status, UserMeta.AUTHOR_LEVEL);
                    break;
                case CONTRIBUTOR:
                    newUser(status, UserMeta.CONTRIBUTOR_LEVEL);
                    break;
                case SUBSCRIBER:
                    newUser(status, UserMeta.SUBSCRIBER_LEVEL);
                    break;
                default:
                    newUser(status, UserMeta.SUBSCRIBER_LEVEL);
                    break;
            }
            return User.this;
        }

        private void newUser(String status, int level) {
            User.this.login = status + User.this.getID();
            User.this.password = status;
            User.this.email = User.this.login + "@gmail.com";
            User.this.meta = new UserMeta(status, level);
        }
    }
}
