package org.example.network;

import java.io.Serial;
import java.io.Serializable;

public class User implements Serializable {
    private String login;
    private String password;
    @Serial
    private static final long serialVersionUID = 400L;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
