package exInterfaces.model.entities;

import java.time.LocalDateTime;

public class Installment {

    private LocalDateTime dueDate;
    private double amount;

    public Installment(LocalDateTime dueDate, double amount) {
        this.dueDate = dueDate;
        this.amount = amount;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
