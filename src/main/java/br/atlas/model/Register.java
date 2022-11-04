package br.atlas.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    @NotNull
    @Column(unique = true)
    private String username;

    @Size(max = 100)
    @NotNull
    private String password;

    private Long confirmpassword;



    @ManyToOne
    @JoinColumn(name = "social_id", nullable = true)
    @JsonBackReference
    private Feed feed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(Long confirmpassword) {
        this.confirmpassword = confirmpassword;
    }



    public Feed getSocial() {
        return feed;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", CONFIRMpassword='" + confirmpassword + '\'' +
                ", social=" + feed +
                '}';
    }
}