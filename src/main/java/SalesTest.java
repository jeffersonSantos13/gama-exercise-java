import entity.person.*;
import entity.vehicle.Car;
import entity.vehicle.HandicappedCar;
import entity.vehicle.Vehicles;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class SalesTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AtomicBoolean exit = new AtomicBoolean(true);
        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("Digite seu nome");
        String name = scanner.next();

        System.out.println();

        // System.out.println("Informe o valor do seu saldo");
        // double amount = Double.parseDouble(scanner.next());

        System.out.println("Você é uma pessoa com necessidades especiais? " +
                "\n1=Sim" +
                "\n2=Não");

        boolean deficient = (Integer.parseInt(scanner.next()) == 1);

        Client client = new Client();

        client.setName(name);
        client.setAmount(10000);
        client.setDeficient(deficient);

        while(exit.get()){
            System.out.println();

            System.out.println("Selecione um operador com quem deseja realizar a compra:");
            System.out.println("1=Estagíário " +
                    "\n2-Vendedor " +
                    "\n3-Gerente");

            int operator = Integer.parseInt(scanner.next());

            Employee employee = (operator == 1 ? new Intern("Estagiário") : operator == 2 ? new SalesMan("Vendedor") : new Manager("Gerente") );

            Vehicles soldCar = (client.getDeficient() ? new HandicappedCar() : new Car());
            soldCar.setValue(10000.00);

            if (employee.getPosition().equals(EmployeeType.INTERN.toString())) {
                Manager internManager = new Manager("Gerente");
                Intern intern = (Intern) employee;

                intern.setManagerSupervisor(internManager);

                System.out.println("Para realizar a compra com Estágiario, \n" +
                        "insira a senha de autorização do Gerente");

                String password = scanner.next();

                if (password.isEmpty()) {
                    System.out.println("\nA senha não foi informado operação cancelada!");
                    break;
                }

                System.out.println("\nO gerente permite essa venda? " +
                        "\n1=Sim" +
                        "\n2=Não");

                boolean authorization = (Integer.parseInt(scanner.next()) == 1);

                internManager.setPasswordAuthorization(password);
                intern.setAuthorization(authorization, internManager);

                if (!intern.getAuthorization()) {
                    System.out.println("\nNão autorizado a realizar a venda");
                    break;
                }
            }

            System.out.println("\nDeseja realizar a compra do Veículo?");
            System.out.println("Valor do carro R$ " + df.format(soldCar.getCarValue()));
            System.out.println("1=Sim\n2=Não");

            int buyCarOperation = Integer.parseInt(scanner.next());

            if (buyCarOperation == 2) {
                break;
            }

            System.out.println("Deseja financiar o carro? " +
                    "\nPagamento à vista tem " + soldCar.getDiscount() + "% de desconto"+
                    "\n1=Sim" +
                    "\n2=Não");

            boolean optionFinance = (Integer.parseInt(scanner.next()) == 1);

            if (optionFinance) {
                System.out.println("Deseja financiar em quatas parcelas? " +
                        "\nAviso: Para cada parcela será adicionado um acrescimento de " + soldCar.getFinancePercentage() + "%");

                int quantityFinance = Integer.parseInt(scanner.next());

                soldCar.setQuantityFinance(quantityFinance);
            }

            System.out.println();

            soldCar.resultSoldVehicle();

            System.out.println(client);
            System.out.println(employee);
            System.out.println(soldCar);

            exit.set(false);
        }

        scanner.close();
    }

}
