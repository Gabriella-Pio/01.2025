package A_Introduction;

public class Caneta {
    public String modelo, cor;
    float ponta;
    int carga;
    boolean tampada;

    public void status() {
        System.out.println("-------------------------------------------");
        System.out.println("Uma caneta " + this.modelo + " de cor: " + this.cor);
        System.out.println("Ponta: " + this.ponta);
        System.out.println("Carga: " + this.carga);
        System.out.println("Estado: " + tampaStatus());
    }

    public void rabiscar() {
        if(this.tampada) {
            System.out.println("ERRO!!Não posso rabiscar.");
        } else {
            System.out.println("Estou rabiscando.");
        }
    }

    public void tampar() {
        this.tampada = true;
        System.out.println(tampaStatus());
    }

    public void destampar() {
        this.tampada = false;
        System.out.println(tampaStatus());
    }

    public String tampaStatus() {
        if(this.tampada) {
            return "Tampada";
        } else {
            return "Destampada";
        }
    }
}
