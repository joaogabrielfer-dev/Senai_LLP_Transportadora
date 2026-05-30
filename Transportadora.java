import java.util.Scanner;

public class Transportadora {

    public static double calcularFreteTransporte(
            Transporte transporte,
            double peso,
            double altura,
            double largura,
            double distancia) {

        return transporte.calcularFrete(
                peso,
                altura,
                largura,
                distancia);
    }

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        System.out.print("Peso da carga: ");
        double peso = ler.nextDouble();

        System.out.print("Altura da carga: ");
        double altura = ler.nextDouble();

        System.out.print("Largura da carga: ");
        double largura = ler.nextDouble();

        System.out.print("Distância do transporte: ");
        double distancia = ler.nextDouble();

        Caminhao caminhao = new Caminhao();
        Aviao aviao = new Aviao();
        PortaContainer portaContainer = new PortaContainer();

        System.out.printf(
                "\nFrete Caminhão: R$ %.2f",
                calcularFreteTransporte(caminhao,peso,altura,largura,distancia));

        System.out.printf(
                "\nFrete Avião: R$ %.2f",
                calcularFreteTransporte(aviao,peso,altura,largura,distancia));

        System.out.printf(
                "\nFrete PortaContainer: R$ %.2f",
                calcularFreteTransporte(portaContainer,peso,altura,largura,distancia));

        ler.close();
    }
}

interface Transporte {
    double calcularFrete(
            double peso,
            double altura,
            double largura,
            double distancia);
}

abstract class Veiculo implements Transporte {

    private int anoDeFabricacao;
    private String marca;
    private String modelo;
    private String propulsao;

    public int getAnoDeFabricacao() {
        return anoDeFabricacao;
    }

    public void setAnoDeFabricacao(int anoDeFabricacao) {
        this.anoDeFabricacao = anoDeFabricacao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPropulsao() {
        return propulsao;
    }

    public void setPropulsao(String propulsao) {
        this.propulsao = propulsao;
    }
}

abstract class VeiculoTerrestre extends Veiculo {

    private int qtDeRodas;
    private int qtDePortas;
    private String placa;
    private String chassi;

    public int getQtDeRodas() {
        return qtDeRodas;
    }

    public void setQtDeRodas(int qtDeRodas) {
        this.qtDeRodas = qtDeRodas;
    }

    public int getQtDePortas() {
        return qtDePortas;
    }

    public void setQtDePortas(int qtDePortas) {
        this.qtDePortas = qtDePortas;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }
}

abstract class VeiculoAereo extends Veiculo {

    private String rab;
    private int qtDeMotores;

    public String getRab() {
        return rab;
    }

    public void setRab(String rab) {
        this.rab = rab;
    }

    public int getQtDeMotores() {
        return qtDeMotores;
    }

    public void setQtDeMotores(int qtDeMotores) {
        this.qtDeMotores = qtDeMotores;
    }
}

abstract class VeiculoFluvial extends Veiculo {

    private String regMarinha;
    private double boca;
    private double calado;

    public String getRegMarinha() {
        return regMarinha;
    }

    public void setRegMarinha(String regMarinha) {
        this.regMarinha = regMarinha;
    }

    public double getBoca() {
        return boca;
    }

    public void setBoca(double boca) {
        this.boca = boca;
    }

    public double getCalado() {
        return calado;
    }

    public void setCalado(double calado) {
        this.calado = calado;
    }
}

class Caminhao extends VeiculoTerrestre {

    private int qtDeEixos;
    private int capacidade;
    private String carroceria;

    public int getQtDeEixos() {
        return qtDeEixos;
    }

    public void setQtDeEixos(int qtDeEixos) {
        this.qtDeEixos = qtDeEixos;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(String carroceria) {
        this.carroceria = carroceria;
    }

    @Override
    public double calcularFrete(
            double peso,
            double altura,
            double largura,
            double distancia) {

        return (peso + (altura * largura)) * (distancia * 6.99);
    }
}

class Aviao extends VeiculoAereo {

    private int capacidadeDeCarga;
    private double mtow;

    public int getCapacidadeDeCarga() {
        return capacidadeDeCarga;
    }

    public void setCapacidadeDeCarga(int capacidadeDeCarga) {
        this.capacidadeDeCarga = capacidadeDeCarga;
    }

    public double getMtow() {
        return mtow;
    }

    public void setMtow(double mtow) {
        this.mtow = mtow;
    }

    @Override
    public double calcularFrete(
            double peso,
            double altura,
            double largura,
            double distancia) {

        return ((peso * peso) * (altura * largura)) * (distancia * 9.99);
    }
}

class PortaContainer extends VeiculoFluvial {

    private int teu;
    private String categoria;

    public int getTeu() {
        return teu;
    }

    public void setTeu(int teu) {
        this.teu = teu;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public double calcularFrete(
            double peso,
            double altura,
            double largura,
            double distancia) {

        return (peso + (altura * largura)) * distancia;
    }
}
