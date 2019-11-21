import sistema.*;

import java.io.IOException;
import java.io.FileNotFoundException;

public class Main {
    /**
     * @version 7.O
     */
    public static void main(String[] args) {
        SistemaPPGI sys = new SistemaPPGI();
        
        String  fileDocentes = "";
        String  fileVeiculos = "";
        int     ano = -1;
        String  filePublicacoes = "";
        String  fileQualis = "";
        String  fileRegras = "";
        // Leitura de argumentos{
        try {   // Prints arguments
                /* for(String arg : args) {
                    System.out.print(arg + " ");
                }
                System.out.println(""); */

            // Ensures input are on the correct length
            if(args.length != 12 && args.length != 13)
                throw new ArrayIndexOutOfBoundsException();

            /**
             * 0 = normal
             * 1 = read-only
             * 2 = write-only
             */
            int opMode = 0;
            
            // Leitura das flags de entrada;
            for(int i = 0; i < args.length; i++) {
                switch(args[i]) {
                    case "-d":
                        i++;
                        fileDocentes = args[i];
                    break;
                    case "-v":
                        i++;
                        fileVeiculos = args[i];
                    break;
                    case "-a":
                        i++;
                        ano = Integer.parseInt(args[i]);
                    break;
                    case "-p":
                        i++;
                        filePublicacoes = args[i];
                    break;
                    case "-q":
                        i++;
                        fileQualis = args[i];
                    break;
                    case "-r":
                        i++;
                        fileRegras = args[i];
                    break;
                    case "--write-only":
                        opMode = 2;
                    break;
                    case "--read-only":
                        opMode = 1;
                    break;
                    default:
                            throw new IllegalArgumentException(args[i]);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught!");
            System.out.println("Por favor, verifique suas flags e argumentos de entrada.");
            System.out.println("Nº argumentos:" + args.length + " Esperado:12 ou 13");
            System.out.println(e);
            System.exit(1);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught!");
            System.out.println("Argumento não identificado:" + e.getMessage());
            System.out.println("Por favor, verifique suas flags e argumentos de entrada.");
            System.exit(1);
        }
            // }Leitura de argumentos
            // Leitura de arquivos{
        try{
            // Add input subfolder to file path {
            // WARN REVIEW  REMOVE THIS BEFORE TURNING IN YOUR ASSIGNMENT YOU FISH-BRAINED DUMFUCK
            String inputFolder  = "in/";
            fileDocentes = inputFolder + fileDocentes;
            fileVeiculos = inputFolder + fileVeiculos;
            filePublicacoes = inputFolder + filePublicacoes;
            fileQualis = inputFolder + fileQualis;
            fileRegras = inputFolder + fileRegras;
            // }
            sys.lerArquivos(fileDocentes, fileVeiculos, filePublicacoes, fileQualis, fileRegras);

            // }Leitura de arquivos
            // Print de relatórios {

            sys.printarTodosArquivos(ano);

        } catch(FileNotFoundException e) {
            System.out.println("Exception caught!");
            System.out.println("FILE NOT FOUND " + e.getMessage());
            System.exit(1);
        } catch(IOException e) {
            System.out.println("ERRO DE I/O");
        }

        // System.out.print(sys);
    }
}