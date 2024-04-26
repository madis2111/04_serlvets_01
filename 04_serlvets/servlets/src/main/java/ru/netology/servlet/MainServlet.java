package ru.netology.servlet;

import ru.netology.controller.PostController;
import ru.netology.model.Post;
import ru.netology.repository.PostRepository;
import ru.netology.service.PostService;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
  private PostController controller;

  @Override
  public void init() {
    final var repository = new PostRepository();
    final var service = new PostService(repository);
    controller = new PostController(service);

    repository.save(new Post(1,"myMessage1"));
    repository.save(new Post(2,"myMessage2"));
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) {

    try {
      final String path = req.getRequestURI();
      final var method = req.getMethod();
      if (method.equals("GET") && path.equals("/api/posts")) {
        controller.all(resp);
        return;
      }
      if (method.equals("GET") && path.matches("/api/posts/\\d+")) {
        final var id = Long.parseLong(path.substring(path.lastIndexOf("/")));
        controller.getById(id, resp);
        return;
      }
      if (method.equals("POST") && path.equals("/api/posts")) {
        System.out.println();
        String idAsString = req.getParameter("id");
        long id = Long.parseLong(idAsString);
        if (id == 0) {
          controller.save(req.getReader(), resp);
        } else {
          controller.edit(req, resp, id);
        }
        return;
      }

      if (method.equals("DELETE") && path.matches("/api/posts/\\d+")) {
        int lastIndex = path.lastIndexOf("/");
        String newString = path.substring(lastIndex);
        final var id = Long.parseLong(newString);
        controller.removeById(id, resp);
        return;
      }
      resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
    } catch (Exception e) {
      e.printStackTrace();
      resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }
  }
}
