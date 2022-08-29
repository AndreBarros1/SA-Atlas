package br.atlas.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Social {

    @Size(max = 100)
    @NotNull
    private String nome;

    @OneToMany(mappedBy = "social")
    @JsonManagedReference
    private Set<Usuario> user_list;

    @OneToMany(mappedBy = "social")
    @JsonManagedReference
    private Set<Contatos> contatos_list;

    @ManyToMany
    @JoinTable(
            name = "posts",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "social_id")
    )
    private Set<Post> post_list;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Usuario> getUser_list() {
        return user_list;
    }

    public void setUser_list(Set<Usuario> user_list) {
        this.user_list = user_list;
    }

    public Set<Contatos> getContatos_list() {
        return contatos_list;
    }

    public void setContatos_list(Set<Contatos> contatos_list) {
        this.contatos_list = contatos_list;
    }

    public Set<Post> getPost_list() {
        return post_list;
    }

    public void setPost_list(Set<Post> post_list) {
        this.post_list = post_list;
    }

    @Override
    public String toString() {
        return "Social{" +
                "nome='" + nome + '\'' +
                ", user_list=" + user_list +
                ", contatos_list=" + contatos_list +
                ", post_list=" + post_list +
                '}';
    }
}
