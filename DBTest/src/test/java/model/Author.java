package model;

import model.dbquery.AuthorTable;
import utils.TestData;

public class Author {

    private Integer id;
    private String name;
    private String login;
    private String email;

    public Author() {
    }

    public Author(String name, String login, String email) {
        this.name = name;
        this.login = login;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Author isAuthorEmpty() {
        if (id != null)
            return this;
        return null;
    }

    public static Author setAndGetAuthor(){
        AuthorTable.add(new Author(TestData.AUTHOR_NAME, TestData.AUTHOR_LOGIN, TestData.AUTHOR_EMAIL));
        return AuthorTable.get(TestData.AUTHOR_LOGIN);
    }
}
