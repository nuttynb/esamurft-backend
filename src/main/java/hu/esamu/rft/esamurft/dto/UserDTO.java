package hu.esamu.rft.esamurft.dto;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@ToString(exclude = "password")
public class UserDTO {

    @Id
    private String userId;
    private String facebookId;
    private String googleId;
    private String username;
    private String password;

}