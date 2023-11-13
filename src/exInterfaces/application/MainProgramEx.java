package exInterfaces.application;

import exInterfaces.model.entities.Contract;
import exInterfaces.model.services.ContractService;
import exInterfaces.model.services.PayPalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainProgramEx {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter fmt =  DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("Entre com os dados do contrato:");
        System.out.print("Número: ");
        int number = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDateTime data = LocalDateTime.parse(scanner.nextLine(), fmt);
        System.out.print("Valor do contrato: ");
        double valorContrato = scanner.nextDouble();

        Contract contract = new Contract(number, data, valorContrato);

        System.out.print("Entre com o número de parcelas: ");
        int parcelas = scanner.nextInt();

        ContractService contractService = new ContractService(parcelas, new PayPalService());

        contractService.processContract(contract, parcelas);
    }
}
