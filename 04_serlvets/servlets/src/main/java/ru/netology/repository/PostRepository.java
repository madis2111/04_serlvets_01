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

//    posts.put(1L,new Post(123,"123text"));
//    posts.put(2L,new Post(234,"234text"));
//    posts.put(3L,new Post(345,"345text"));

    System.out.println("posts1: " + posts);
  }

  public Collection<Post> all() {
    return posts.values();
  }

  public Optional<Post> getById(long id) {

    return Optional.ofNullable(posts.get(id));

  }

  public Post save(Post post) {
    posts.put(counter.getAndIncrement(), post);
    System.out.println("posts3: " + posts);

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
