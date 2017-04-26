/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class App {
    
    private Integer option = -1;
    private static Scanner scan = new Scanner(System.in);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        App app = new App();
        Calculator calc = new Calculator();
        
        while(app.option != 0) {
            
            app.menu();

            switch(app.option) {

                case 1: System.out.println("Informe o valor: "); calc.somar(scan.nextInt()); break;
                case 2: System.out.println("Informe o valor: "); calc.subtrair(scan.nextInt()); break;
                case 3: System.out.println("Informe o valor: "); calc.dividir(scan.nextInt()); break;
                case 4: System.out.println("Informe o valor: "); calc.multiplicar(scan.nextInt()); break;
                case 5: calc.retornar(); break;
                case 6: calc.avancar(); break;
            }
            System.out.println("Resultado: " + calc.getResultado());
        }
        
        System.out.println("Resultado: " + calc.getResultado());
        
    }
    
    private void menu() {
        option = -1;
        while(option == -1) {
            //Menu        
            System.out.println("Escolha uma das opções e aperte ENTER:\n\n"
            + "1 - Soma\n"
            + "2 - Subtração\n"
            + "3 - Divisão\n"
            + "4 - Multiplicação\n"
            + "5 - Undo\n"
            + "6 - Redo\n"
            + "0 - SAIR");
            option = scan.nextInt();
       }
    }
        
        
        
}
