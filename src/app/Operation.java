package app;

public class Operation {
    private String[] values;
    private String operation;
    private String[] parameters;

    public Operation(String operation, String[] parameters) {
        System.out.println("Operation: " + operation);
        for (int i = 0; i < parameters.length; i++) {
            System.out.println(i + " Paremeter: " + parameters[i]);
        }
        this.operation = operation;
        this.parameters = parameters;

    }

    public String evaluate() {
        switch (operation) {
            case "*":
                return "" + (Double.parseDouble(parameters[0]) * Double.parseDouble(parameters[1]));
            case "getDataBase":
                System.out.println("Getting Database at: " + parameters[0] + " Using Mode: " + parameters[0]);
                return "123";
            default:
                System.err.println("Operation Not Defined");
                return null;
        }
    }

    public String toString() {
        return evaluate();
    }
}
