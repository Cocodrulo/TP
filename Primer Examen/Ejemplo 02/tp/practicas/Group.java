package tp.practicas;

import java.util.ArrayList;
import java.util.List;

public class Group extends Contact {
    private List<Contact> contactList;

    public Group(String name) {
        super(name);
        contactList = new ArrayList<>();
    }

    public boolean isMember(int id) {
        for (int i = 0; i < contactList.size(); i++) {
            final Contact CONTACT = contactList.get(i);

            if (CONTACT.getId() == id) return true;
            if (CONTACT instanceof Group) {
                Group group = (Group) CONTACT;
                if (group.isMember(id)) return true;
            }
        }
        return false;
    }

    public boolean add(Contact contact) {
        if (contact.equals(this) || this.isMember(contact.getId())) return false;
        
        contactList.add(contact);
        return true;
    }

    public boolean remove(int id) {
        for (Contact contact: contactList) {
            if (contact.getId() == id) {
                contactList.remove(contact);
                return true;
            }
        }
        return false;
    }

    public List<Contact> getContacts() {
        List<Contact> copyList = new ArrayList<>(contactList);
        copyList.sort((contactA, contactB) -> Integer.compare(contactA.getId(), contactB.getId()));
        return copyList;
    }

    @Override
    public String toString() {
        String result = this.getName() + "\n";
        
        List<Contact> copyList = new ArrayList<>(contactList);
        copyList.sort((contactA, contactB) -> contactA.getName().compareTo(contactB.getName()));
        for (Contact contact: copyList) {
            result += contact.toString() + "\n";
        }
        return result;
    }

    @Override
    public void sendSMS(String msg) {
        for (Contact contact: contactList) {
            contact.sendSMS(msg);
        }
    }
}