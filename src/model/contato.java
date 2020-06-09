package model;

import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "contato")
public class contato implements Serializable {

        @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name = "id", nullable = false)
            long id;

        @Column(name = "descricao")
        String descricao;

        @Column(name = "endereco")
        String endereco;

        @Column(name = "numero")
        int numero;

        @OneToOne
        cidade idCidade;

        @Column(name = "email")
        String email;

        @Column(name = "nascimento")
        LocalDate nascimento;

        @Column(name = "tel1")
        Long tel1;

        @Column(name = "tel2")
        Long tel2;

        @OneToOne
        tipoContato idTipoContato;

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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public cidade getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(cidade idCidade) {
        this.idCidade = idCidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public Long getTel1() {
        return tel1;
    }

    public void setTel1(Long tel1) {
        this.tel1 = tel1;
    }

    public Long getTel2() {
        return tel2;
    }

    public void setTel2(Long tel2) {
        this.tel2 = tel2;
    }

    public tipoContato getIdTipoContato() {
        return idTipoContato;
    }

    public void setIdTipoContato(tipoContato idTipoContato) {
        this.idTipoContato = idTipoContato;
    }
}
