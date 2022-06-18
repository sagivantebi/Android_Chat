package api;

import com.example.freakner.Chat;
import com.example.freakner.Post;
import com.example.freakner.User;

import java.util.ArrayList;

public class ApiUser {
        public String username ;

        public String password;

        public String nickName;

        public String image ;

        public String server;

        public ArrayList<Post> contacts;

        public ArrayList<Chat> chats;

        public ApiUser(String username, String password, String nickName, String image, String server) {
            this.username = username;
            this.password = password;
            this.nickName = nickName;
            this.image = image;
            this.server = server;
            contacts = new ArrayList<Post>();
            chats = new ArrayList<Chat>();
        }
        public ApiUser(User u){
            this.username = u.username;
            this.nickName = u.nickName;
            this.password = u.password;
            this.image = "no Image";
            this.server = u.server;
            contacts = new ArrayList<Post>();
            chats = new ArrayList<Chat>();
        }

}
