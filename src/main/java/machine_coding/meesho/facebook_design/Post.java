package machine_coding.meesho.facebook_design;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Post {
    private User user;
    private String content;
    private int postId;
    private int time;

    private static int postIdCtr = 0;
    private static int timeCtr = 0;
    public static Map<Integer, Post> postIdToPostMap = new HashMap<>();

    Post(String content) {
        postIdToPostMap.put(postIdCtr, this);
        this.postId = postIdCtr++;
        this.content = content;
        this.time = timeCtr++;
    }
}
