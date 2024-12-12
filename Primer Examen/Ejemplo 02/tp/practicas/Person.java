package tp.practicas;

public class Person extends Contact {
    private String phone;

    public Person(String name, String phone) {
        super(name);
        this.phone = phone;
    }

    @Override
    public void sendSMS(String msg) {
        SMSTools.sendMessage(this.phone, msg);
    }

    @Override
    public String toString() {
        return this.getName() + ": " + this.phone;
    }
}