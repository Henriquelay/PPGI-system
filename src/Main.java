import sistema.*;

public class Main {
    public static void main(String[] args) {
        if(args.lenght != 12 && args.lenght != 13)
            throw "argument_parse_error";
        
        for(String argument : arg) {
            switch(argument) {
                case "-d":
                    
                break;
                case "-v":
                break;
                case "-a":
                break;
                case "-p":
                break;
                case "-q":
                break;
                case "-r":
                break;
                case "--write-only":
                break;
                case "--read-only":
                break;
                default throw "invalid argument";
            }
        }
    }
}