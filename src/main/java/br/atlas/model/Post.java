package br.atlas.model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "post_list")
    private Set<Social> social_list;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Social> getSocial_list() {
        return social_list;
    }

    public void setSocial_list(Set<Social> social_list) {
        this.social_list = social_list;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", social_list=" + social_list +
                '}';
    }
}
