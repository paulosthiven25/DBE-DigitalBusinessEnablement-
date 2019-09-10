package br.com.fiap.fiaphotel.model;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@SequenceGenerator(name ="hotel",sequenceName = "SEQ_HOTEL",allocationSize = 1)
public class Hotel {
    @Id
    @GeneratedValue(generator ="hotel",strategy = GenerationType.SEQUENCE)
    private int codigo;
    private String nome;
    private boolean aceitaAnimais;
    private LocalDate dataAbertura;

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

    public boolean isAceitaAnimais() {
        return aceitaAnimais;
    }

    public void setAceitaAnimais(boolean aceitaAnimais) {
        this.aceitaAnimais = aceitaAnimais;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }
}
