package hu.esamu.rft.esamurft.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class UserDTO {

    @Id
    private String id;

    private String username;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}