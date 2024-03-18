package ru.netology.repository;

import ru.netology.model.Post;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.HashMap;

// Stub
public class PostRepository {

  private HashMap<Integer, Post> posts;  //  [1,post1;2,post2;3,post3]

  private int counter;

  public PostRepository() {
    posts = new HashMap<>();
    counter = 1;
    System.out.println("posts: " + posts);
  }

  public List<Post> all() {
    return Collections.emptyList();
  }

  public Optional<Post> getById(long id) {
    return Optional.empty();
  }

  public Post save(Post post) {
    posts.put(counter, post);
    counter++;
    System.out.println("posts: " + posts);

    return post;
  }

  public void removeById(long id) {
  }
}
