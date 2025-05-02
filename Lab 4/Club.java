package vishu;

public class Club {

    static String clubName = "Tech Enthusiasts";

    String memberName;

    public Club(String memberName) {

        this.memberName = memberName;

    }

    public static void displayClubName() {

        System.out.println("Club Name: " + clubName);

    }

    public void displayMemberDetails() {

        System.out.println("Member Name: " + memberName);

    }



    public static void main(String[] args) {

        Club.displayClubName();



        Club member1 = new Club("Alice");

        Club member2 = new Club("Bob");

        Club member3 = new Club("Charlie");

        

        member1.displayMemberDetails();

        member2.displayMemberDetails();

        member3.displayMemberDetails();

    }

}
