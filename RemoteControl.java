interface Switchable {

    void on();

    void off();

    default void toggle() {
        on();
    }
}

class Fan implements Switchable {

    public void on() {
        System.out.println("Fan ON");
    }

    public void off() {
        System.out.println("Fan OFF");
    }
}

class Light implements Switchable {

    public void on() {
        System.out.println("Light ON");
    }

    public void off() {
        System.out.println("Light OFF");
    }
}

@FunctionalInterface
interface SwitchPermission {

    boolean maySwitchOn(String device, int hour);
}

public class RemoteControl {

    public static void main(String[] args) {

        Switchable[] devices = {
            new Fan(),
            new Light()
        };

        for (Switchable d : devices) {
            d.toggle();
        }

        SwitchPermission officeRule = new SwitchPermission() {

            public boolean maySwitchOn(String d, int h) {
                return h >= 8 && h <= 18;
            }
        };

        SwitchPermission homeRule = (d, h) ->
                !d.equalsIgnoreCase("Fan") || h >= 6 && h <= 23;

        System.out.println("Office rule: "
                + officeRule.maySwitchOn("Light", 10));

        System.out.println("Home rule: "
                + homeRule.maySwitchOn("Fan", 22));
    }
}