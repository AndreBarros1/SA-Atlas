package br.atlas.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Feed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    @NotNull
    private String nome;

    @OneToMany(mappedBy = "social")
    @JsonManagedReference
    private Set<Register> user_list;

    @OneToMany(mappedBy = "social")
    @JsonManagedReference
    private Set<Esqc> esqc_list;

    @ManyToMany
    @JoinTable(
            name = "posts",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "social_id")
    )
    private Set<Po st> post_list;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Register> getUser_list() {
        return user_list;
    }

    public void setUser_list(Set<Register> user_list) {
        this.user_list = user_list;
    }

    public Set<Esqc> getEsqueceu_list() {
        return esqc_list;
    }

    public void setEsqueceu_list(Set<Esqc> esqc_list) {
        this.esqc_list = esqc_list;
    }



    @Override
    public String toString() {
        return "Social{" +
                "nome='" + nome + '\'' +
                ", user_list=" + user_list +
                ", esqueceu_list=" + esqc_list +
                ", post_list=" + post_list +
                '}';
    }
}
