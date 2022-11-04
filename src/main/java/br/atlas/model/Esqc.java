package br.atlas.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Esqc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    @NotNull
    private String email;

    @Size(max = 100)
    @NotNull
    private String nome;

    @Size(max = 100)
    @NotNull
    private String telefone;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Feed getSocial() {
        return feed;
    }



    @Override
    public String toString() {
        return "Contatos{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", social=" + feed +
                '}';
    }
}
