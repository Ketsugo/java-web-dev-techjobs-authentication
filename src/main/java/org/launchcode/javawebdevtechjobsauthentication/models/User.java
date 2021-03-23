package org.launchcode.javawebdevtechjobsauthentication.models;

import org.launchcode.javawebdevtechjobsauthentication.models.data.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User extends AbstractEntity{

    @NotNull
    @Size(min = 1, max = 32)
    private String username;
    private String encryptedPassword;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User(){}

    public User(String username, String password){

        this.username = username;
        this.encryptedPassword = encoder.encode(password);
    }

    // methods...

    public boolean searchForUsername(String usernameSearch){
        UserRepository results = new UserRepository.findAllById(User<String username>,usernameSearch);

    }

    public boolean verifyPassword(String verifyPassword, String password){
        if(verifyPassword.equals(password)){
                return true;
            }
            else {
                return false;
            }
    }

}
