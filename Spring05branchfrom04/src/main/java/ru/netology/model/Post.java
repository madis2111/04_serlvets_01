package ru.netology.model;

public class Post {
  private long id;
  private String content;

  public Post() {   // postman -> controller -> service -> repository (ArrayList)
  }

  public Post(long id, String content) {
    this.id = id;
    this.content = content;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public String toString() {
    return "Post{" +
            "id=" + id +
            ", content='" + content + '\'' +
            '}';
  }
}
