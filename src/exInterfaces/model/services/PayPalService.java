package exInterfaces.model.services;

public class PayPalService implements OnlinePaymentService {

    @Override
    public double paymentFee(double amount) {
        double valor = amount + (amount*0.01);
        return valor;
    }

    @Override
    public double interest(double amount, int months) {
        double valor = (amount + (amount*0.02));
        return valor;
    }
}
