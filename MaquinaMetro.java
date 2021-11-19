import java.util.Scanner;

/**
 * @author jayalaa
 */

 
public class MaquinaMetro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Se definen las tres maquinas expendedoras de ticket
        MaquinaExpendedoraTicket maqA = new  MaquinaExpendedoraTicket();
        MaquinaExpendedoraTicket maqB = new  MaquinaExpendedoraTicket();
        MaquinaExpendedoraTicket maqC = new  MaquinaExpendedoraTicket();
        Scanner entrada = new Scanner(System.in);
        Scanner datos = new Scanner(System.in);

        //Precio de las 3 maquinas
        maqA.setPrecio(12);
        maqB.setPrecio(7);
        maqC.setPrecio(4);

        //Recaudado por las maquinas
        maqA.setTotalrecaudado(0);
        maqB.setTotalrecaudado(0);
        maqC.setTotalrecaudado(0);

        //Tipo de boleto de la maquina
        maqA.setTipoboleto('A');
        maqB.setTipoboleto('B');
        maqC.setTipoboleto('C');

        //Loop para menú
        int op = 1;
        while(op != 0){
            //Saldo inicial de las maquinas
            maqA.setSaldo(0);
            maqB.setSaldo(0);
            maqC.setSaldo(0);

            //menú de las maquinas
            System.out.println("Elija una opcion:");
            System.out.println("------------------");
            System.out.println("1.-Comprar boleto");
            System.out.println("2.-Consultar precio del boleto");
            System.out.println("3.-Mostrar total recaudado");
            System.out.println("0.-Para salir del sistema");
            System.out.print("Su opcion es: ");
            op = entrada.nextInt();


            switch(op){
                //Comprar boleto
                case 1:
                    char tipo = 'x';
                    int saldo = 0, y = 0, opc = 1;

                    //Submenú de comprar boleto
                    while(opc != 0){
                        System.out.println("Elija una opcion:");
                        System.out.println("------------------");
                        System.out.println("1.-Elegir un boleto");
                        System.out.println("2.-Mostrar Saldo");
                        System.out.println("3.-Imprimir boleto");
                        System.out.println("Si no desea realizar mas cambios en su compra pulse 0");
                        System.out.print("Su opcion es: ");
                        opc = datos.nextInt();
                        switch(opc){

                            //elegir un boleto
                            case 1:
                                while(y == 0){
                                    System.out.println("Boleto Tipo C: 1-4 estaciones | Boleto Tipo B: 5-8 estaciones | Boleto Tipo A: > 8 estaciones");
                                    System.out.print("Indique el tipo de boleto a comprar: ");
                                    tipo = datos.next().charAt(0);

                                   
                                    if(tipo!='C'&&tipo!='B'&&tipo!='A') {
                                        System.out.println("Valor incorrecto, intente de nuevo");
                                    } 
                                    else {
                                        y = 1;
                                    }
                                }
                                switch(tipo){//Compra el ticket segun el tipo de ticket indicado

                                    case 'A':
                                        maqA.setTotalrecaudado(maqA.getTotalrecaudado()+maqA.getPrecio());
                                        maqA.setSaldo(maqA.getSaldo()+maqA.getPrecio());
                                        y = 0;
                                        break;
                                    case 'B':
                                        maqB.setTotalrecaudado(maqB.getTotalrecaudado() + maqB.getPrecio());
                                        maqB.setSaldo(maqB.getSaldo() + maqB.getPrecio());
                                        y = 0;
                                        break;
                                    case 'C':
                                        maqC.setTotalrecaudado(maqC.getTotalrecaudado() + maqC.getPrecio());
                                        maqC.setSaldo(maqC.getSaldo() + maqC.getPrecio());
                                        y = 0;
                                        break;
                                }
                                break;
                            case 2://indica el saldo actual
                                saldo += maqA.getSaldo() + maqB.getSaldo() + maqC.getSaldo();
                                System.out.println("Su saldo hasta ahora es: " + saldo);
                                break;
                            case 3: //Imprime el boleto

                                if(maqA.getSaldo() == 0 && maqB.getSaldo() == 0 && maqC.getSaldo() == 0) { 
                                    System.out.println("Usted no ha comprado ningún boleto");
                                }

                                else{
                                    if(maqA.getSaldo() != 0){
                                        System.out.println("---------");
                                        maqA.imprimirBoleto();
                                    }
                                    if(maqB.getSaldo() != 0){
                                        System.out.println("---------");
                                        maqB.imprimirBoleto();
                                    }
                                    if(maqC.getSaldo() != 0){
                                        System.out.println("---------");
                                        maqC.imprimirBoleto();
                                    }
                                }
                        }
                    }
                    break;
                case 2: //Consulta precio del boleto
                    int x = 0;
                    char tip = 'x';
                    while(x == 0){
                        System.out.println("Boleto Tipo C: 1-4 estaciones | Boleto Tipo B: 5-8 estaciones | Boleto Tipo A: > 8 estaciones");
                        System.out.print("Indique el tipo de boleto a consultar: ");
                        tip = datos.next().charAt(0);

                        if(tip!= 'C' && tip != 'B' && tip != 'A') { 
                            System.out.println("Valor incorrecto, intente de nuevo");
                        }
                        else
                            x = 1;
                    }
                    switch(tip){
                        case 'A':
                            maqA.getPrecio();
                            break;
                        case 'B':
                            maqB.getPrecio();
                            break;
                        case 'C':
                            maqC.getPrecio();
                            break;
                    }

                    break;
                case 3:
                    int tot = maqA.getTotalrecaudado() + maqB.getTotalrecaudado() + maqC.getTotalrecaudado();
                    System.out.println("El total recaudado por la maquina es: " + tot);
                    break;
            }
        }

    }
}