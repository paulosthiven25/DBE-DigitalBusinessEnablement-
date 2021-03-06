package br.com.fiap.revisao.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@SequenceGenerator(name="quarto",sequenceName = "SQ_T_QUARTO",allocationSize = 1)
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quarto")
    private int codigo;
    @NotBlank(message="Número de quarto obrigatório")
    private int numero;

    private boolean suite;
    @Min(value = 0,message = "Preço inválido")
    private float valor;

    @OneToMany
    private List<Reserva> reservas;

    @ManyToOne
    private Hotel hotel;

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isSuite() {
        return suite;
    }

    public void setSuite(boolean suite) {
        this.suite = suite;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
