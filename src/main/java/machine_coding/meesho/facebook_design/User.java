package machine_coding.meesho.facebook_design;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

@Getter
@Setter
public class User {
    private int userId;
    private List<Integer> followees;
    private List<Integer> followers;
    private TreeSet<Post> posts;

    private static int userIdCtr = 0;

    public static Map<Integer, User> userIdToUserMap = new HashMap<>();
    User() {
        userIdToUserMap.put(userIdCtr, this);
        this.userId = userIdCtr++; // assign each and every user a unique ID
        this.followees = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.posts = new TreeSet<>((a,b) -> b.getTime() - a.getTime());
    }
}
