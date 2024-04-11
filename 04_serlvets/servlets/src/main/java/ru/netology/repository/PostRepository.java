package ru.netology.repository;

import ru.netology.exception.NotFoundException;
import ru.netology.model.Post;

import java.util.*;

// Stub
public class PostRepository {

  private HashMap<Integer, Post> posts;

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

  public Post edit(int id, Post newPost) {

    if (posts.containsKey(id)) {
        posts.put(id, newPost);
        return newPost;
    }

    throw new NotFoundException("No such id");
  }

  public void removeById(long id) {
  }
}
