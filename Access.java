import java.util.Scanner;
class Access{
    public void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Access i = new Access();

        System.out.println("===========================================================");
        System.out.println("---------------#-#-#-CSM - DEPARTMENT-#-#-#----------------");
        System.err.println("===========================================================");

        System.out.print("Enter your name: ");
        String name = s.nextLine();

        System.out.print("Enter your roll number: ");
        String roll = s.nextLine();
        i.rollValid(roll);
        
        System.out.print("Enter your email: ");
        String email = s.nextLine();
        i.emailValid(email);

        s.close();


    }
    public void rollValid(String roll){

        if(roll.contains("AG1A") && roll.length() == 10){
            if(roll.charAt(6) == '6' && roll.charAt(7) == '6'){
                int a = 22;

            }
            else{
            System.out.println("Roll number is invalid");
            System.exit(0);
        }

        }
        else{
            System.out.println("Roll number is invalid");
            System.exit(0);
        }


    }
    public void emailValid(String email){
        if(email.contains("@") && email.contains(".") && email.length() >= 4){
            System.out.println("*-----Data Stored-----*");
        }else{
            System.out.println("Email is invalid");
        }
    }

}