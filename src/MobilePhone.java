import java.util.ArrayList;


public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        // this.myContacts = new ArrayList<>(); bunu oluşturmadığım için nullPointer hatası aldım.
         this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact (Contact contact){
        int position = findContact(contact);
        if(position == -1){
            myContacts.add(contact);
            return true;
        }
        return false;
    }
    public boolean updateContact (Contact oldContact, Contact newContact){
        int position = findContact(oldContact);
        if (position != -1 ) {
            myContacts.remove(oldContact);
            myContacts.add(newContact);
            return true;
        }
        return false;
    }
    public boolean removeContact (Contact contact){
        int position = findContact(contact);
        if (position != -1) {
            myContacts.remove(contact);
            return true;
        }
        return false;
    }
    public int findContact(Contact contact){
        return myContacts.indexOf(contact);
    }
    public int findContact(String name){
        for(int i = 0; i < myContacts.size(); i++){
            if(myContacts.get(i).getName().toLowerCase().equals(name.toLowerCase())){
                return i;
            }
        }

        return -1;
    }
    public Contact queryContact (String name){
       int index =  findContact(name);
       if(index != -1){
           System.out.println("Contact: " + myContacts.get(index));
           return myContacts.get(index);
       }
       return null;
    }
    public void printContact(){
        for(Contact cont: myContacts){
            System.out.println(cont.getName() + "->" + cont.getPhoneNumber());
        }
    }

}
