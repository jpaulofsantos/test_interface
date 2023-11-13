package exInterfaces.model.services;

import exInterfaces.model.entities.Contract;
import exInterfaces.model.entities.Installment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ContractService {

    private int parcelas;

    private OnlinePaymentService onlinePaymentService;

    public ContractService(int parcelas, OnlinePaymentService onlinePaymentService) {
        this.parcelas = parcelas;
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months) {
        List<Installment> installmentList = new ArrayList<>();

        for (int i=1; i<=months; i++) {

            LocalDateTime newDateTime = contract.getDate().plusMonths(i);
            DateTimeFormatter fmt =  DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            double fee = onlinePaymentService.paymentFee((contract.getTotalValue()/months));
            if (i>1) {
                fee += i;
            }
            double valueMonths = onlinePaymentService.interest(fee, i);
            contract.setInstallment(new Installment(newDateTime, valueMonths));
            installmentList.add(contract.getInstallment());
        }

        System.out.println("PARCELAS:");
        for (int i=0; i<installmentList.size(); i++) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = installmentList.get(i).getDueDate().format(formatter);

            System.out.println(formattedDate + " - " + installmentList.get(i).getAmount());
        }
    }
}
