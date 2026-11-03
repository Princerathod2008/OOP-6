@FunctionalInterface
interface Notifier {
    void send(String message);
}

interface Urgent {
}

class UrgentEmail implements Notifier, Urgent {

    public void send(String m) {
        System.out.println("URGENT EMAIL: " + m);
    }
}

public class NotificationSenders {

    public static void main(String[] args) {

        Notifier email = m -> System.out.println("Email: " + m);

        Notifier sms = m -> System.out.println("SMS: " + m);

        Notifier urgent = new UrgentEmail();

        Notifier[] senders = {
            email,
            sms,
            urgent
        };

        String message = "Lab starts at 10 AM";

        for (Notifier n : senders) {

            n.send(message);

            if (n instanceof Urgent) {
                n.send(message);
            }
        }
    }
}