package tests;

import com.jsonplaceholder.typicode.model.Post;
import com.jsonplaceholder.typicode.model.User;
import com.jsonplaceholder.typicode.utils.*;
import com.jsonplaceholder.typicode.utils.Config;
import kong.unirest.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
import static com.jsonplaceholder.typicode.utils.HttpStatusCode.*;

public class RestApiTest extends BaseTest {

    @Test
    public void jsonPlaceHolderTest() throws UnirestException, IOException {

        PostsResponse postsResponse = TypicodeHttpClient.getPosts(Config.POSTS);
        Assert.assertEquals(postsResponse.getStatusCode(), OK.getValue(), "Invalid status code");
        Assert.assertTrue(postsResponse.isSuccess(), "It is not the json format");
        Assert.assertTrue(DataMathWork.isPostIdSorted(postsResponse.getPostList()), "ID fields not sorted");
        APIUtils.getSerialize(postsResponse.getPostList(), Config.FILE1);


        PostsResponse post99Response = TypicodeHttpClient.getPost(Config.POSTS, Config.ROUTE_ID_PARAM, TestData.getRouteParam(Config.ROUTE_ID_PARAM,TestData.POST_ID_99));
        Assert.assertEquals(post99Response.getStatusCode(), OK.getValue(), "Invalid status code");
        Assert.assertEquals(String.valueOf(post99Response.getPost().getUserId()), TestData.POST_USERID_99, "Wrong userId");
        Assert.assertEquals(String.valueOf(post99Response.getPost().getId()), TestData.POST_ID_99, "Wrong Id");
        Assert.assertFalse(post99Response.getPost().getTitle().isEmpty(), "Title is empty");
        Assert.assertFalse(post99Response.getPost().getBody().isEmpty(), "Body is empty");
        APIUtils.getSerialize(post99Response.getPost(), Config.FILE2);


        HttpResponse<String> stringPost150 = TypicodeHttpClient.getStringResponse(Config.POSTS, Config.ROUTE_ID_PARAM, TestData.getRouteParam(Config.ROUTE_ID_PARAM,TestData.POST_ID_150));
        Assert.assertEquals(stringPost150.getStatus(), NOT_FOUND.getValue(), "Invalid status code");
        APIUtils.getSerialize(stringPost150.getBody(), Config.FILE3);
        Assert.assertTrue(APIUtils.isRequestBodyEmpty(stringPost150.getBody()), "Body is not empty");


        PostsResponse postNewPost = TypicodeHttpClient.postNewPost(Config.POSTS, TestData.getPostFielsData());
        Assert.assertEquals(postNewPost.getStatusCode(), CREATED.getValue(), "Invalid status code");
        APIUtils.getSerialize(postNewPost.getPost(), Config.FILE4);
        Post newPostAfterDeSerialize = APIUtils.getDeSerializeObj(Config.FILE4, Post.class);
        Assert.assertEquals(postNewPost.getPost().getTitle(), newPostAfterDeSerialize.getTitle(), "Wrong title");
        Assert.assertEquals(postNewPost.getPost().getBody(), newPostAfterDeSerialize.getBody(), "Wrong Body");
        Assert.assertEquals(postNewPost.getPost().getUserId(), newPostAfterDeSerialize.getUserId(), "Wrong UserId");
        Assert.assertTrue(postNewPost.getPost().getId() != null && newPostAfterDeSerialize.getId() != null, "Id is null");


        UsersResponse usersResponse = TypicodeHttpClient.getUsers(Config.USERS);
        User user5 = usersResponse.getUserList().get(DataMathWork.getUserObjectIndexById(usersResponse.getUserList(), TestData.USER_ID_5));
        APIUtils.getSerialize(usersResponse.getUserList(), Config.FILE5);
        List<User> newUsersAfterDeSerialize = APIUtils.getDeSerializeListObj(Config.FILE5, User[].class);
        User user5AfterDeserialize = newUsersAfterDeSerialize.get(DataMathWork.getUserObjectIndexById(newUsersAfterDeSerialize, TestData.USER_ID_5));
        Assert.assertEquals(usersResponse.getStatusCode(), OK.getValue(), "Invalid status code");
        Assert.assertTrue(usersResponse.isSuccess(), "It is not the json format");
        Assert.assertEquals(user5, user5AfterDeserialize, "Wrong user data");


        UsersResponse user5Response = TypicodeHttpClient.getUser(Config.USERS, Config.ROUTE_ID_PARAM, TestData.getRouteParam(Config.ROUTE_ID_PARAM,TestData.USER_ID_5));
        APIUtils.getSerialize(user5Response.getUser(), Config.FILE6);
        Assert.assertEquals(user5Response.getStatusCode(), OK.getValue(), "Invalid status code");
        Assert.assertEquals(user5Response.getUser(), user5AfterDeserialize, "Wrong user data");
    }
}