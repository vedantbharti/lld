package commonLLDQuestions.foodOrdering.entity;


import lombok.Data;

import java.util.UUID;

@Data
public class User {

    private String userId;
    private String userName;

    public User(){}

    public User(String userName){
        this.userId = UUID.randomUUID().toString();
        this.userName = userName;
    }

}
