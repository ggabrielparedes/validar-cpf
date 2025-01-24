import java.util.Scanner;

public class Main {

    public static String validarCPF(String cpf) {
        int dv1, dv2;
        dv1 = 0;
        dv2 = 0;
        String cpfClean = cpf.replaceAll("[^\\d]", "");

        if (cpfClean.length() != 11) {
            return "CPF Invalido";
        }

        for (int i = 0; i < cpfClean.length() - 2; i++) {
            dv1 += (Character.getNumericValue(cpfClean.charAt(i)) * (10 - i));
        }
        dv1 = 11 - (dv1 % 11);
        if (dv1 == 0 || dv1 == 1) dv1 = 0;

        for (int i = 0; i < cpfClean.length() - 1; i++) {
            dv2 += (Character.getNumericValue(cpfClean.charAt(i)) * (11 - i));
        }
        dv2 = 11 - (dv2 % 11);
        if (dv2 == 0 || dv2 == 1) dv2 = 0;
        if((dv1 == Character.getNumericValue(cpfClean.charAt(9))) && (dv2 == Character.getNumericValue(cpfClean.charAt(10)))) {
            return "CPF Valido";
        } else {
            return "CPF Invalido";
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value;
        System.out.print("Digite CPF >> ");
        value = scanner.nextLine();
        System.out.println(Main.validarCPF(value));

    }
}