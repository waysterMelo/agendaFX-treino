package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuarios")
public class usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name = "id", nullable = false)
             long id;

    @Column(name = "descricao")
    String descricao;

    @Column(name = "senha")
    String senha;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
