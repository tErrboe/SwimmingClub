import java.util.ArrayList;
import java.util.Scanner;
import java.io.Console;

public class Admin extends Login{
    private ArrayList<Member> members = new ArrayList<Member>();
    Console console = System.console();
    Scanner scan = new Scanner(System.in);

    
    public Admin(String username, String password) {
        super(username, password);
    }

    //Add member method
    //Booleans are used as menu handlers
    public void addMember(){
        boolean addMemberMenu = true;

        while (addMemberMenu) {
            String firstname = console.readLine("Members firstname: ");
            String lastname = console.readLine("Members lastname: ");
            int age = Integer.parseInt(console.readLine("Age: "));
            String email = console.readLine("EMail: ");
            double subscription = 0.0;
            String activeOrPassive = console.readLine("Is the member going to be active or passive? Type 'active' or 'passive': \n");
            boolean activeMember = true;

            if (activeOrPassive.equalsIgnoreCase("active")) {
                activeMember = true;
                System.out.println("Member has been added as an active member.");
            }
            else if (activeOrPassive.equalsIgnoreCase("passive")) {
                activeMember = false;
                System.out.println("Member has been added as a passive member.");
            }
    
    
            if (activeMember) {
                if (age < 18) {
                    subscription = 1000;
                }
                else if (age >= 18 && age < 60) {
                    subscription = 1600;
                }
                else if (age >= 60) {
                    subscription = 1600 * 0.75;
                }
                else {
                    System.out.println("Program fail. Try again please.");
                }
            }
            else {
                subscription = 500;
            }

        Member member = new Member(firstname, lastname, age, email, subscription);
        members.add(member);
        System.out.println("You have succesfully added a member: " + firstname + " " + lastname);
        
        boolean moreMembers = true;

        while (moreMembers) {
            System.out.println("Do you want to add another member? Yes(y) or no(n)");
            String answer = scan.next();

            if (answer.equalsIgnoreCase("y")) {
                addMemberMenu = true;
                moreMembers = false;
            }

            else if (answer.equalsIgnoreCase("n")) {
                addMemberMenu = false;
                moreMembers = false;
            }

            else {
                System.out.println("Invalid input");
                moreMembers = true;
            }
        }
        }
     }

     public void printMembers() {
        for (Member m : members) {
            System.out.println(members.indexOf(m) + ": " + m);
        }    
    }
    
   
    //Delete members
    //Booleans are used as menu handlers
    public void deleteMember() {
        boolean deleteMemberMenu = true;

            while (deleteMemberMenu) {
                printMembers();
                System.out.println("Which member do you want to delete? ");
                int index = 0;
                index = scan.nextInt();

                    if (index >= 0 && index <= members.size()) {
                        members.remove(index);
                        boolean deleteMore = false;

                        while (deleteMore) {      
                            System.out.println("Do you want to delete another member? Yes(y) or no(n)");
                            String answer = scan.next();

                            if (answer.equals("y")) {
                                deleteMemberMenu = true;
                            }

                            else if (answer.equals("n")) {
                                deleteMemberMenu = false;
                            }
                            else {
                                System.out.println("Please only press y or n");
                                deleteMore = true;
                            }
                        }
                    }
                    else {
                        System.out.println("Try again.");
                    }
            }
    }


     public ArrayList<Member> getMembers() {
         return members;
     } 


     public void setMembers(ArrayList<Member> members){
         this.members = members;
     }

}