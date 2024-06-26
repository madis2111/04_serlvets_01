package ru.netology.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.netology.model.Post;
import ru.netology.service.PostService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Reader;


public class PostController {
  public static final String APPLICATION_JSON = "application/json";

  @Autowired
  private final PostService service;

//   public PostController(PostService service) {
//    this.service = service;
//  }

  public void all(HttpServletResponse response) throws IOException {
    response.setContentType(APPLICATION_JSON);
    final var data = service.all();
    final var gson = new Gson();
    response.getWriter().print(gson.toJson(data));
  }

  public void getById(long id, HttpServletResponse response) {
    // TODO: deserialize request & serialize response
  }

//  /id=0
//  /id!=0

  public void save(Reader body, HttpServletResponse response) throws IOException {
    response.setContentType(APPLICATION_JSON);
    final var gson = new Gson();
    final Post post = gson.fromJson(body, Post.class);
    final var data = service.save(post);
    response.getWriter().print(gson.toJson(data));
  }

  public void edit(HttpServletRequest req, HttpServletResponse response) throws IOException {
    response.setContentType(APPLICATION_JSON);
    final var gson = new Gson();
    final Post post = gson.fromJson(req.getReader(), Post.class);
    int id = Integer.parseInt(req.getParameter("id"));
    final var data = service.edit(id, post);

    if (data != null) {
      response.getWriter().print(gson.toJson(data));
    } else {
      response.setContentType(null);
    }
  }

  public void removeById(long id, HttpServletResponse response) {
    // TODO: deserialize request & serialize response
  }
}
