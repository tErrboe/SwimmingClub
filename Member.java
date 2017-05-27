public class Member{
    
    private String firstname;
    private String lastname;
    private int age;
    private String email;
    private double subscription;

    public Member(String firstname, String lastname, int age, String email, double subscription) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.subscription = subscription;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public String getFirstname(){
        return firstname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public String getLastname(){
        return lastname;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public void setEMail(String email){
        this.email = email;
    }

    public String getEMail(){
        return email;
    }

    public void setSubscription(double subscription){
        this.subscription = subscription;
    }

    public double getSubscription(){
        return subscription;
    }

    @Override
    public String toString() {
        return "Firstname: " + firstname + "\nLastname: " + lastname + "\nAge: " + age + 
        "\nEMail: " + email + "\nSubscription: " + subscription;
    }

}
