import java.util.ArrayList;

public class Tests {
    public static void main(String[] args) {
        System.out.println("\nInitialization starts");
        TechnionTournament tournament = new TechnionTournament();
        tournament.init();
        System.out.println("Initialization is over\n");

        System.out.println("Adding faculties to tournament...");
        Faculty CS_Faculty = new Faculty(1, "Computer Science");
        Faculty DS_Faculty = new Faculty(2, "Data Science");
        Faculty SE_Faculty = new Faculty(3, "Civil Engineering");
        Faculty EL_Faculty = new Faculty(4, "Electricity");
        Faculty ME_Faculty = new Faculty(5, "Machines Engineering");

        tournament.addFacultyToTournament(CS_Faculty);
        tournament.addFacultyToTournament(DS_Faculty);
        tournament.addFacultyToTournament(SE_Faculty);
        tournament.addFacultyToTournament(EL_Faculty);
        tournament.addFacultyToTournament(ME_Faculty);
        System.out.println("Faculties added to tournament successfully\n");


        System.out.println("Adding players to tournament...");
        Player csPlayer1 = new Player(11, "CS Player 1");
        tournament.addPlayerToFaculty(1, csPlayer1);
        Player csPlayer2 = new Player(12, "CS Player 2");
        tournament.addPlayerToFaculty(1, csPlayer2);
        Player csPlayer3 = new Player(13, "CS Player 3");
        tournament.addPlayerToFaculty(1, csPlayer3);
        Player csPlayer4 = new Player(14, "CS Player 4");
        tournament.addPlayerToFaculty(1, csPlayer4);
        Player csPlayer5 = new Player(15, "CS Player 5");
        tournament.addPlayerToFaculty(1, csPlayer5);
        Player csPlayer6 = new Player(16, "CS Player 6");
        tournament.addPlayerToFaculty(1, csPlayer6);

        Player dsPlayer1 = new Player(21, "DS Player 1");
        tournament.addPlayerToFaculty(2, dsPlayer1);
        Player dsPlayer2 = new Player(22, "DS Player 2");
        tournament.addPlayerToFaculty(2, dsPlayer2);
        Player dsPlayer3 = new Player(23, "DS Player 3");
        tournament.addPlayerToFaculty(2, dsPlayer3);
        Player dsPlayer4 = new Player(24, "DS Player 4");
        tournament.addPlayerToFaculty(2, dsPlayer4);
        Player dsPlayer5 = new Player(25, "DS Player 5");
        tournament.addPlayerToFaculty(2, dsPlayer5);
        Player dsPlayer6 = new Player(26, "DS Player 6");
        tournament.addPlayerToFaculty(2, dsPlayer6);

        Player sePlayer1 = new Player(31, "SE Player 1");
        tournament.addPlayerToFaculty(3, sePlayer1);
        Player sePlayer2 = new Player(32, "SE Player 2");
        tournament.addPlayerToFaculty(3, sePlayer2);
        Player sePlayer3 = new Player(33, "SE Player 3");
        tournament.addPlayerToFaculty(3, sePlayer3);
        Player sePlayer4 = new Player(34, "SE Player 4");
        tournament.addPlayerToFaculty(3, sePlayer4);
        Player sePlayer5 = new Player(35, "SE Player 5");
        tournament.addPlayerToFaculty(3, sePlayer5);
        Player sePlayer6 = new Player(36, "SE Player 6");
        tournament.addPlayerToFaculty(3, sePlayer6);


        Player elPlayer1 = new Player(41, "EL Player 1");
        tournament.addPlayerToFaculty(4, elPlayer1);
        Player elPlayer2 = new Player(42, "EL Player 2");
        tournament.addPlayerToFaculty(4, elPlayer2);
        Player elPlayer3 = new Player(43, "EL Player 3");
        tournament.addPlayerToFaculty(4, elPlayer3);
        Player elPlayer4 = new Player(44, "EL Player 4");
        tournament.addPlayerToFaculty(4, elPlayer4);
        Player elPlayer5 = new Player(45, "EL Player 5");
        tournament.addPlayerToFaculty(4, elPlayer5);
        Player elPlayer6 = new Player(46, "EL Player 6");
        tournament.addPlayerToFaculty(4, elPlayer6);

        Player mePlayer1 = new Player(51, "ME Player 1");
        tournament.addPlayerToFaculty(5, mePlayer1);
        Player mePlayer2 = new Player(52, "ME Player 2");
        tournament.addPlayerToFaculty(5, mePlayer2);
        Player mePlayer3 = new Player(53, "ME Player 3");
        tournament.addPlayerToFaculty(5, mePlayer3);
        Player mePlayer4 = new Player(54, "ME Player 4");
        tournament.addPlayerToFaculty(5, mePlayer4);
        Player mePlayer5 = new Player(55, "ME Player 5");
        tournament.addPlayerToFaculty(5, mePlayer5);
        Player mePlayer6 = new Player(56, "ME Player 6");
        tournament.addPlayerToFaculty(5, mePlayer6);
        System.out.println("Players added to tournament successfully\n");

        System.out.println("First Game: CS vs DS");
        ArrayList<Integer> goals1 = new ArrayList<>();
        ArrayList<Integer> goals2 = new ArrayList<>();
        ArrayList<Integer> goals3 = new ArrayList<>();
        ArrayList<Integer> goals4 = new ArrayList<>();
        ArrayList<Integer> goals5 = new ArrayList<>();

        goals1.add(11); // cs1 = 1
        goals1.add(11); // cs1 = 2
        goals1.add(12); // cs2 = 1
        goals1.add(11); // cs3 = 3
        goals1.add(15); // cs5 = 1
        goals1.add(15); // cs5 = 2

        goals2.add(22); // ds2 = 1
        goals2.add(23); // ds3 = 1

        /*Top players: CS1: 3, CS5: 2, CS2: 1, DS2: 1, DS3: 1*/

        tournament.playGame(1, 2, 1, goals1, goals2);
        System.out.println("Current leading scorer is CS player 1");
        Player testPlayer = new Player(0, "test");
        System.out.println("Testing...");
        tournament.getTopScorer(testPlayer);
        if (testPlayer.getName() == "CS Player 1")
            System.out.println("Success! top player is indeed CS Player 1");
        else System.out.println("Problem in top scorer/playGame function");


        System.out.println();
        System.out.println("Second game: DS vs EL");
        goals2 = new ArrayList<>();
        goals2.add(22); // ds2 = 2
        goals2.add(22); // ds2 = 3
        goals2.add(25); // ds5 = 1
        goals2.add(22); // ds2 = 4
        goals2.add(22); // ds2 = 5
        goals2.add(22); // ds2 = 6

        goals4.add(41); // el1 = 1

        /*Top players: DS2: 6, CS1: 3, CS5: 2, CS2: 1, DS3: 1, DS5: 1, EL1: 1*/

        tournament.playGame(2, 4, 1, goals2, goals4);

        System.out.println("Current leading faculty is DS");
        Faculty testFaculty = new Faculty(0, "test");
        tournament.getTheWinner(testFaculty);

        System.out.println("Current leading scorer is DS player 2");
        testPlayer = new Player(0, "test");
        System.out.println("Testing...");
        tournament.getTopScorer(testPlayer);
        if (testPlayer.getName() == "DS Player 2")
            System.out.println("Success! top player is indeed DS Player 2");
        else System.out.println("Problem in top scorer/playGame function");

        goals2 = new ArrayList<>();
        goals2.add(22);

        /*Top players: DS2: 7, CS1: 3, CS5: 2, CS2: 1, DS3: 1, DS5: 1, EL1: 1*/

        tournament.playGame(2, 3, 0, goals2, goals3);

        ArrayList<Faculty> faculties = new ArrayList<>();

        System.out.println("Testing top 5 faculties descending");
        int k = 5;
        tournament.getTopKFaculties(faculties, k, false);

        Object[] facultiesArray = faculties.toArray();
        System.out.println("Faculty number 1 is: " + ((Faculty) facultiesArray[0]).getName() + ", should be: Data Science");
        System.out.println("Faculty number 2 is: " + ((Faculty) facultiesArray[1]).getName() + ", should be: Computer Science");
        System.out.println("Faculty number 3 is: " + ((Faculty) facultiesArray[2]).getName() + ", should be: Civil Engineering");
        System.out.println("Faculty number 4 is: " + ((Faculty) facultiesArray[3]).getName() + ", should be: Electricity");
        System.out.println("Faculty number 5 is: " + ((Faculty) facultiesArray[4]).getName() + ", should be: Machines Engineering");

        System.out.println("!!!!!!! Check if your names are the names that suppose to be");
        System.out.println();
        System.out.println("Removing Computer Science faculty from tournament...");
        tournament.removeFacultyFromTournament(1);
        System.out.println("succeed to remove computer science faculty");

        faculties = new ArrayList<>();
        System.out.println();

        System.out.println("Testing top 4 faculties Ascending");
        k = 4;
        tournament.getTopKFaculties(faculties, k, true);
        facultiesArray = faculties.toArray();
        System.out.println("Faculty number 4 is: " + ((Faculty) facultiesArray[0]).getName() + ", should be: Machines Engineering");
        System.out.println("Faculty number 3 is: " + ((Faculty) facultiesArray[1]).getName() + ", should be: Electricity");
        System.out.println("Faculty number 2 is: " + ((Faculty) facultiesArray[2]).getName() + ", should be: Civil Engineering");
        System.out.println("Faculty number 1 is: " + ((Faculty) facultiesArray[3]).getName() + ", should be: Data Science");
        System.out.println();
        /*Top players: DS2: 7, CS1: 3, CS5: 2, CS2: 1, DS3: 1, DS5: 1, EL1: 1*/

        System.out.println("checking Top 10 players descending, 7 with goals, 3 without");
        ArrayList<Player> players  = new ArrayList<>();
        k = 10;
        tournament.getTopKScorers(players, k, false);
        Object[] playersArray = players.toArray();
        System.out.println("Player number 1 is: "+ ((Player) playersArray[0]).getName() + ", should be: DS Player 2, num of goals: 7");
        System.out.println("Player number 2 is: "+ ((Player) playersArray[1]).getName() + ", should be: CS Player 1, num of goals: 3");
        System.out.println("Player number 3 is: "+ ((Player) playersArray[2]).getName() + ", should be: CS Player 5, num of goals: 2");
        System.out.println("Player number 4 is: "+ ((Player) playersArray[3]).getName() + ", should be: CS Player 2, num of goals: 1");
        System.out.println("Player number 5 is: "+ ((Player) playersArray[4]).getName() + ", should be: DS Player 3, num of goals: 1");
        System.out.println("Player number 6 is: "+ ((Player) playersArray[5]).getName() + ", should be: DS Player 5, num of goals: 1");
        System.out.println("Player number 7 is: "+ ((Player) playersArray[6]).getName() + ", should be: EL Player 1, num of goals: 1");
        System.out.println("Now players with no goals, sorted by ID:");
        System.out.println("Player number 8 is: "+ ((Player) playersArray[7]).getName() + ", should be: CS Player 3, num of goals: 0");
        System.out.println("Player number 9 is: "+ ((Player) playersArray[8]).getName() + ", should be: CS Player 4, num of goals: 0");
        System.out.println("Player number 10 is: "+ ((Player) playersArray[9]).getName() + ", should be: CS Player 6, num of goals: 0");

        System.out.println();
        System.out.println("checking top 3 players ascending:");
        k = 3;
        players = new ArrayList<>();
        tournament.getTopKScorers(players, k, true);
        playersArray = players.toArray();
        System.out.println("Player number 3 is: "+ ((Player) playersArray[0]).getName() + ", should be: CS Player 5, num of goals: 2");
        System.out.println("Player number 2 is: "+ ((Player) playersArray[1]).getName() + ", should be: CS Player 1, num of goals: 3");
        System.out.println("Player number 1 is: "+ ((Player) playersArray[2]).getName() + ", should be: DS Player 2, num of goals: 7");

        System.out.println();
        testPlayer = new Player(0, "test");
        tournament.getTopScorerInFaculty(2, testPlayer);
        System.out.println("Top player in DS Faculty is: "+ testPlayer.getName() +", should be DS Player 2");
        System.out.println("Trying to remove DS Player 2 from DS Faculty...");
        tournament.removePlayerFromFaculty(2, 22);
        System.out.println("if removed successfully, top player in DS Faculty would be DS Player 3");
        testPlayer = new Player(0, "test");
        tournament.getTopScorerInFaculty(2, testPlayer);
        System.out.println("Top player in DS Faculty is: "+ testPlayer.getName()+", should be DS Player 3");

    }

}
