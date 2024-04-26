package ru.netology.repository;

import ru.netology.exception.NotFoundException;
import ru.netology.model.Post;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

// Stub
public class PostRepository {

  private ConcurrentHashMap<Long, Post> posts;

  private AtomicLong counter;

  public PostRepository() {
    posts = new ConcurrentHashMap<>();
    counter = new AtomicLong(1);
    System.out.println("posts: " + posts);
  }

  public List<Post> all() {
    return Collections.emptyList();
  }

  public Optional<Post> getById(long id) {

    return Optional.of(posts.get(id));

  }

  public Post save(Post post) {
    posts.put(counter.getAndIncrement(), post);
    System.out.println("posts: " + posts);

    return post;
  }

  public Post edit(long id, Post newPost) {

    if (posts.containsKey(id)) {
        posts.put(id, newPost);
        return newPost;
    }

    throw new NotFoundException("No such id");
  }

  public void removeById(long id) {
    if (posts.containsKey(id)) {
      posts.remove(id);
      return;
    }
    throw new NotFoundException("No such id");
  }
}
