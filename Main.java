
import java.util.HashMap;
import java.util.Map;

class Meter {
    private String meterId;
    private double meterReading;

    public Meter(String meterId, double meterReading) {
        this.meterId = meterId;
        this.meterReading = meterReading;
    }

    public String getMeterId() {
        return meterId;
    }

    public double getMeterReading() {
        return meterReading;
    }

    public void setMeterReading(double meterReading) {
        this.meterReading = meterReading;
    }
}

class Bill {
    private String billId;
    private Meter meter;
    private double amount;

    public Bill(String billId, Meter meter, double amount) {
        this.billId = billId;
        this.meter = meter;
        this.amount = amount;
    }

    public String getBillId() {
        return billId;
    }

    public Meter getMeter() {
        return meter;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

class BillingSystem {
    private Map<String, Meter> meters;
    private Map<String, Bill> bills;

    public BillingSystem() {
        meters = new HashMap<>();
        bills = new HashMap<>();
    }

    public void addMeter(String meterId, double initialReading) {
        Meter meter = new Meter(meterId, initialReading);
        meters.put(meterId, meter);
    }

    public void generateBill(String billId, String meterId, double currentReading) {
        if (!meters.containsKey(meterId)) {
            System.out.println("Meter not found.");
            return;
        }

        Meter meter = meters.get(meterId);
        double previousReading = meter.getMeterReading();
        double unitsConsumed = currentReading - previousReading;
        double ratePerUnit = 5.0; // Assuming a fixed rate for simplicity
        double amount = unitsConsumed * ratePerUnit;

        Bill bill = new Bill(billId, meter, amount);
        meter.setMeterReading(currentReading);
        bills.put(billId, bill);

        System.out.println("Bill generated successfully.");
    }

    public void printBill(String billId) {
        if (!bills.containsKey(billId)) {
            System.out.println("Bill not found.");
            return;
        }

        Bill bill = bills.get(billId);
        Meter meter = bill.getMeter();

        System.out.println("Bill ID: " + bill.getBillId());
        System.out.println("Meter ID: " + meter.getMeterId());
        System.out.println("Previous Reading: " + meter.getMeterReading());
        System.out.println("Amount: $" + bill.getAmount());
    }
}

public class Main {
    public static void main(String[] args) {
        BillingSystem billingSystem = new BillingSystem();

        billingSystem.addMeter("M001", 1000);
        billingSystem.generateBill("B001", "M001", 1200);
        billingSystem.printBill("B001");
    }
}
