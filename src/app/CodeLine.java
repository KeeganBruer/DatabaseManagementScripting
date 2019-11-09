package app;

import java.lang.reflect.Parameter;

public class CodeLine {
    private String dst;
    private Operation operation;

    public CodeLine(String codeLine) {
        String token = "";
        for (int i = 0; i < codeLine.length(); i++) {
            if (codeLine.charAt(i) == '=') {
                dst = token.trim();
                token = "";
                i += 1;
            } if (codeLine.charAt(i) == '(') {
                String command = token.trim(); //save the operation
                token = "";
                String[] parameters = new String[0];
                i += 1;
                while (codeLine.charAt(i) != ')' && i < codeLine.length()) {//get the parameters
                    if (codeLine.charAt(i) == ',') { //if parameter deliminator
                        String[] array = new String[parameters.length + 1];
                        for (int g = 0; g < array.length-1; g++) {
                            array[g] = parameters[g];
                        }
                        array[array.length-1] = token.trim();
                        parameters = array;
                        token = "";
                        i+=1;
                    }
                    token += codeLine.charAt(i);//keep building token
                    i += 1;//go up;
                }
                String[] array = new String[parameters.length + 1];
                for (int g = 0; g < array.length-1; g++) {
                    array[g] = parameters[g];
                }
                array[array.length-1] = token.trim();
                parameters = array;
                token = "";
                operation = new Operation(command, parameters);
            } if (codeLine.charAt(i) == '*') {
                String[] params = new String[2];
                params[0] = token.trim();
                params[1] = null;
                token = "";
                i += 1;
                while (params[1] == null && i < codeLine.length()) {
                    try {
                        String convert = "0"+ (token + codeLine.charAt(i)).trim(); 
                        Double.parseDouble(convert);
                        token += codeLine.charAt(i);
                        i += 1;
                    } catch (Exception e) {
                        params[1] = token.trim();
                        System.out.println("TOKOT" + token);
                        token = "";
                    }
                }
                
                if (token != "") {
                    params[1] = token.trim();
                    token = "";
                }
                operation = new Operation("*", params);
            } else {
                token += codeLine.charAt(i);
            }
        }
        System.out.println("DST: " + dst);
        System.out.println("Left Over: " + token + " end");
    }

    private void constructor(String dst, Operation operation) {

    }

    public String toString() {
        return dst + "=" + operation;
    }
}
