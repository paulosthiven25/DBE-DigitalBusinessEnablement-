package com.fiap.demo.Model;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@SequenceGenerator(name="cliente", sequenceName = "SQ_T_CLIENTE", allocationSize = 1)
public class Cliente {

    @Id
    @GeneratedValue(generator = "name", strategy = GenerationType.SEQUENCE)
    @NotNull
    private int codigo;
    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 10)
    private String nome;
    @NotNull
    @Past(message = "Data deve estar no passado")
    private LocalDate dataNasc;
    @NotBlank(message = "Email obrigatório")
    @Email(message = "Email com formato inválido")
    private String email;
    @NotNull
    @CPF(message = "CPF inválido")
    private String cpf;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}


