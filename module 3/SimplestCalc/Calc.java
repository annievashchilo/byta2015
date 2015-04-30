import java.lang.NumberFormatException;

class Calc {
    public static void main(String[] args) {
        float arg1 = 0;
        float arg2 = 0;
        String op = null;
        if (args.length != 3) {
            System.err.println("Usage: Calc arg1 op arg2");
            System.exit(-1);
        }

        try 
        {
        arg1 = Float.parseFloat(args[0]);
        
        op = args[1];
        arg2 = Float.parseFloat(args[2]);
        }
        catch (NumberFormatException e) {
            System.err.println("Invalid number format");
            System.exit(1);
        }

        float result = Float.NaN;
        

        if (op.equals("+")) result = arg1 + arg2;
        else if (op.equals("-")) result = arg1 - arg2;
        else if (op.equals("*")) result = arg1 * arg2;
        else if (op.equals("/")) result = arg1 / arg2;

        if (Float.isNaN(result)) {
            System.err.println("Wrong operation");
        } else {
            System.out.printf("%.2f %s %.2f = %.2f\n", arg1, op, arg2, result);
        }

    }
}

