package org.openlake.springproject.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class User {
    private String username;
    private String name;
    private String password;
}
