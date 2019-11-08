import sistema.*;

public class Main {
    public static void main(String[] args) {
        try {   // Prints arguments
                for(String arg : args) {
                    System.out.print(arg + " ");
                }
                System.out.println("");
            
            // Ensures input are on the correct length
            if(args.length != 12 && args.length != 13)
                throw new ArrayIndexOutOfBoundsException();

            SistemaPPGI sys;
            
            String  fileDocentes = "";
            String  fileVeiculos = "";
            int     ano = -1;
            String  filePublicacoes = "";
            String  fileQualis = "";
            String  fileRegras = "";
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
                        // System.out.println(args[i]);
                        fileDocentes = args[i];
                    break;
                    case "-v":
                        i++;
                        // System.out.println(args[i]);
                        fileVeiculos = args[i];
                    break;
                    case "-a":
                        i++;
                        // System.out.println(args[i]);
                        ano = Integer.parseInt(args[i]);
                    break;
                    case "-p":
                        i++;
                        // System.out.println(args[i]);
                        filePublicacoes = args[i];
                    break;
                    case "-q":
                        i++;
                        // System.out.println(args[i]);
                        fileQualis = args[i];
                    break;
                    case "-r":
                        i++;
                        // System.out.println(args[i]);
                        fileRegras = args[i];
                    break;
                    case "--write-only":
                        // System.out.println(args[i]);
                        opMode = 2;
                    break;
                    case "--read-only":
                        // System.out.println(args[i]);
                        opMode = 1;
                    break;
                    default:
                            throw new IllegalArgumentException(args[i]);
                }
            }

            System.out.println(fileDocentes);
            System.out.println(fileVeiculos);
            System.out.println(ano);
            System.out.println(filePublicacoes);
            System.out.println(fileQualis);
            System.out.println(fileRegras);


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
    }
}