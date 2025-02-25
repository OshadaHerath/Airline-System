package airline;

import java.util.LinkedList;
import java.util.Queue;

public class Payment {
    private int paymentMethod;
    private int amount;
    private static Queue<Payment> paymentQueue = new LinkedList<>();

    public Payment(int paymentMethod, int amount) {
        this.paymentMethod = paymentMethod;
        this.amount = amount;
    }

    public static void enqueuePayment(Payment payment) {
        paymentQueue.offer(payment);
        System.out.println("Payment of Rs." + payment.amount + " added to the queue.");
    }

    public static void processPayments() {
        while (!paymentQueue.isEmpty()) {
            Payment payment = paymentQueue.poll();  // Dequeue
            String method = (payment.paymentMethod == 1) ? "PayPal" : "Card Payment";
            System.out.println("Processing payment of Rs." + payment.amount + " via " + method + "...");
            System.out.println("Payment Successful!");
        }
    }
}
