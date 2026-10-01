package com.example.parcial.Entity;
import jakarta.persistence.column;
import jakarta.presistence.column;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//falta mas

@jakarta.persistence.Entity
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationTyoe.IDENTITY)
    private long id;
    @column (nullable = false, unique = true)
    private String username;
    @column (nullable = false, unique = true)
    private email;
    @column (nullable = false)
    private String passsword; //la contraseña debe tener al menos 8 caracteres , la contraseña se debe  alamacenser usado PasswordEncoder
    @column (nullable = false)
    private strinf role = "ROLE_ATTENDE", "ROLE_ORGANIZAER, ROLE_ADEMIN";

    public User(){
    }
    public User(string username , string email; string Passsword ){
        this.Username =username;
        this.email = email;
        this.password= password;
    }
    public Long getId(){return id;}
    public void setId(Long id) {this.id=id;}
    // falta
}
