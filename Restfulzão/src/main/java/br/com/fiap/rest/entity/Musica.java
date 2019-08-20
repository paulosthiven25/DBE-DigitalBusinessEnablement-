package br.com.fiap.rest.entity;

import javax.persistence.*;

@Entity
@Table(name = "T_MUSICA")
@SequenceGenerator(name="musica",sequenceName = "SQ_T_MUSICA")
public class Musica {
    @Id
    @GeneratedValue(generator="musica",strategy = GenerationType.SEQUENCE)
    @Column(name="cd_musica")
    private int codigo;
    @Column(name="nm_musica")
    private String nome;
    @Column(name="qt_duracao_musica")
    private int duracao;
    @Column(name="nm_compositor_musica")
    private String compositor;

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

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getCompositor() {
        return compositor;
    }

    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }
}
