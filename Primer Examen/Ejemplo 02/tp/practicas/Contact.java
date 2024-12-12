package tp.practicas;

public abstract class Contact {
    private String name;
    private int id;

    public Contact(String name) {
        this.name = name;
        this.id = SMSTools.getUniqueId();
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public abstract void sendSMS(String msg);

    @Override
    public int hashCode() {
        return this.id;
    }
}