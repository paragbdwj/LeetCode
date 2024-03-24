package machine_coding.meesho.facebook_design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

public class FacebookApplication {

    public boolean createPost(int userId, String content) {
        User user = User.userIdToUserMap.get(userId);
        if(Objects.isNull(user)) {
            return printNotExist(userId);
        }
        Post post = new Post(content);
        post.setUser(user);
        user.getPosts().add(post);
        System.out.println("post with postId : " + post.getPostId() + " created for userId : " + userId);
        return true;
    }

    private boolean printNotExist(int userId) {
        System.out.println("User with userId : " + userId + "doesn't exist");
        return false;
    }

    public List<Post> getNewsFeedTopN(int userId, int noOfFeedsToShow) {
        User user = User.userIdToUserMap.get(userId);
        if(Objects.isNull(user)) {
            printNotExist(userId);
            return null;
        }
        TreeSet<Post> posts = user.getPosts();
        Iterator iterator = posts.iterator();
        List<Post> ans = new ArrayList<>();
        while(noOfFeedsToShow-- > 0 && iterator.hasNext()) {
            ans.add((Post) iterator.next());
        }
        System.out.println("Feed for userId : " + userId + " looks like");
        for (Post post : ans) {
            System.out.println(post.getPostId());
        }
        return ans;
    }

    public boolean follow(int followerId, int followeeId) {
        User follower = User.userIdToUserMap.get(followerId);
        if(Objects.isNull(follower)) {
            return printNotExist(followerId);
        }

        User followee = User.userIdToUserMap.get(followeeId);
        if(Objects.isNull(followee)) {
            return printNotExist(followeeId);
        }
        System.out.println("In the follow function");
        for(Post post : followee.getPosts()) {
            follower.getPosts().add(post);
            System.out.println("Post with postId : " + post.getPostId() + " added for userId : " + followee.getUserId());
        }

        follower.getFollowees().add(followeeId);
        System.out.println("followee : " + followeeId + "getting added for followerId : " + followerId);
        followee.getFollowers().add(followerId);
        System.out.println("follower : " + follower + "getting added for followeeId : " + followeeId);
        return true;
    }

    public boolean deletePost(int userId, int postId) {
        User user = User.userIdToUserMap.get(userId);
        if(Objects.isNull(user)) {
            return printNotExist(userId);
        }
        Post postToBeDel = Post.postIdToPostMap.remove(postId);
        user.getPosts().removeIf(post -> user.getPosts().contains(postToBeDel));
        System.out.println("Post with postId : " + postId + " removed from userId : " + userId);

        for(Integer userChild : user.getFollowers()) {
            User userFollower = User.userIdToUserMap.get(userChild);
            if(Objects.isNull(userFollower)) {
                System.out.println("This won't be happening , userChild : " + userChild + "userFollower : null");
                continue;
            }
            userFollower.getPosts().removeIf(post -> userFollower.getPosts().contains(postToBeDel));
            System.out.println("Post with postId : " + postId + " removed from userId : " + userChild);
        }
        return true;
    }

    private boolean createUser() {
        User user = new User();
        System.out.println("User created with userId : " + user.getUserId());
        return true;
    }
    public static void main(String[] args) {
        FacebookApplication facebookApplication = new FacebookApplication();

        for(int i = 1; i < 4; i++) {
            facebookApplication.createUser();
        }

        facebookApplication.createPost(1, "userId:1 ka pehla post");
        facebookApplication.createPost(2, "userId:2 ka pehla post");
        facebookApplication.createPost(1, "userId:1 ka doosra post");
        facebookApplication.createPost(1, "userId:1 ka teesra post");
        facebookApplication.createPost(1, "userId:1 ka choutha post");
        facebookApplication.createPost(2, "userId:2 ka doosra post");
        facebookApplication.createPost(0, "userId:0 ka pehla post");
        facebookApplication.createPost(1, "userId:1 ka paanchva post");
        facebookApplication.createPost(2, "userId:2 ka teesra post");
        facebookApplication.createPost(0, "userId:0 ka doosra post");
        facebookApplication.createPost(0, "userId:0 ka teesra post");

        facebookApplication.deletePost(0,9);

        facebookApplication.follow(1, 0);

        facebookApplication.deletePost(1,3);

        facebookApplication.getNewsFeedTopN(1, 11);

    }
}
