package com.fiap.demo.Model;

import com.fiap.demo.Model.Cliente;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@SequenceGenerator(name="pedido", sequenceName = "SQ_T_PEDIDO", allocationSize = 1)
public class Pedido {

    @Id
    @GeneratedValue(generator = "pedido", strategy = GenerationType.SEQUENCE)
    @NotNull
    private int codigo;
    @NotNull
    @DecimalMin(value = "1",message = "O valor não pode ser menor que 0,00")
    private double valor;
    @NotNull
    @Future(message = "A data não pode estar no passado")
    private LocalDate data;
    @NotNull
    @Min(value = 1,message = "A quantidade mínima é 1")
    private int quantidade;

    private boolean pago;
    @NotNull
    @ManyToOne
    private Cliente cliente;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


}
