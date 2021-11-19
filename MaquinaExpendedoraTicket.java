public class MaquinaExpendedoraTicket {

    private int precio;
    private char tipoboleto;
    private int saldo;
    private int totalrecaudado;

    public int getPrecio() {
        return precio; 
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public char getTipoboleto() {
        return tipoboleto;
    }

    public void setTipoboleto(char tipoboleto) {
        this.tipoboleto = tipoboleto;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getTotalrecaudado() {
        return totalrecaudado;
    }

    public void setTotalrecaudado(int totalrecaudado) {
        this.totalrecaudado = totalrecaudado;
    }

    public void mostrarSaldo(){
        System.out.println("Saldo: " + saldo);
    }
    public void mostrarTotalRecaudado(){
        System.out.println("mostrarTotalRecaudado:" + totalrecaudado);
    }

    public void imprimirBoleto(){
        System.out.print("Su boleto tipo: "+ tipoboleto);
        System.out.print(" con un precio de: " + precio);
        System.out.println(" está listo!");
    }


}