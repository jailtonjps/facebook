package facebook4j;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.Comment;
import com.restfb.types.Post;
import static java.lang.System.out;
import java.util.List;

/**
 *
 * @author jailton.santos
 */
public class Facebook4j {

       @SuppressWarnings("empty-statement")
       public static void main(String[] args) {
   
          String accessToken = "EAACEdEose0cBAGcz6ZC7RHUYRWiIp0P6jHoKPjTXzqXp7Im2aTSUtSZCxvD4BoyMxZA6poSbZC2i8qmUdZAEy3mGwFSzNZBCtCBR7awEFAT9tSZBMGNYF7YStKv1FSiWFjNE2GSN2mZBhHQFY17k2APVYtz3FMUcsyeAvmy2koOS0LvfBiNg6IAXObrLffkl3HathUFpxeXL63cHfmkbQ26JZA95wMycwfcwZD";
          FacebookClient fbClient = new DefaultFacebookClient(accessToken);
      
    
Connection<Post> myFeed = fbClient.fetchConnection("me/feed", Post.class);
for (List<Post> myFeedPage : myFeed) {

  for (Post post : myFeedPage) {
    out.println("Post: " + post);
  }
}
String postId = "1404208189600333";
Connection<Comment> commentConnection 
   = fbClient.fetchConnection(postId + "/comments", 
         Comment.class, Parameter.with("limit", 10));

int personalLimit = 50;

for (List<Comment> commentPage : commentConnection) {
  for (Comment comment : commentPage) {
    System.out.println("Id: " + comment.getId());
    personalLimit--;

 
    if (personalLimit == 0) {
       return;
    }
  }
}

}
    }








