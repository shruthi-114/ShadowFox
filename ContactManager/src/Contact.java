public class Contact {
    private String name;
    private String phone;
    private String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String updatedName) {
        this.name = updatedName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String updatedPhone) {
        this.phone = updatedPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String updatedEmail) {
        this.email = updatedEmail;
    }

    public void printContact() {
        System.out.println("Name : " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
    }
}
