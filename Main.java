import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Admin admin = new Admin("admin", "admin");
        Member m1 = new Member("firstname", "lastname", 29, "EMail", 1600);
        FileReadWrite fileReadWrite = new FileReadWrite();
        admin.getMembers().add(m1);
        admin.setMembers(fileReadWrite.loadMembers());
        
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Choose account:\n1: Admin\n2: Cashier\n");

            boolean menu = true;
            int menuChoice = 0;
            
            menuChoice = scan.nextInt();
            switch (menuChoice) {
                case 1:
                    if (admin.login()){
                        while(menu){ 
                            System.out.println("1: Add member\n2: Delete member\n3: Print members\n4: Logout");
                            menuChoice = scan.nextInt();
                            switch (menuChoice) {
                                case 1:
                                    admin.addMember();
                                    break;
                                case 2:
                                    admin.deleteMember();
                                    break;
                                case 3:
                                    admin.printMembers();
                                    break;
                                case 4:
                                    menu = false;
                                    break;
                                default:
                                    System.out.println("Try again");
                                    break;
                            }  
                        }
                    }
                    else{
                        System.out.println("Invalid username or password\n");
                    }
                    break;
                   
                    
                    default:
                        System.out.println("Try again");
                    break;
            }       

            fileReadWrite.saveMembers(admin.getMembers());
        }
    }
}