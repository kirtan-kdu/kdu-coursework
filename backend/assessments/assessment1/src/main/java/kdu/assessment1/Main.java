package kdu.assessment1;

import com.opencsv.CSVWriter;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.nio.file.Path;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static final long HOUR = 3600*1000;
    private static ArrayList<Player> parseCSV(String path) throws IOException {
        ArrayList<Player> parsedCSV = new ArrayList<Player>();
        String line = "";
        String splitBy = ",";
        BufferedReader br = Files.newBufferedReader(Path.of(path));
        br.readLine();

        while ((line = br.readLine()) != null)   //returns a Boolean value
        {
            String[] properties = line.split(splitBy);    // use comma as separator
//            ConsoleLogger.infoMethod("player [name=" + properties[0] + ", team=" + properties[1] + ", role=" + properties[2] + ", matches=" + properties[3] + ", runs=" + properties[4] + ", average=" + properties[5] + ", strikerate=" + properties[6] + ", wickets=" + properties[7]  + "]");
            Player player = new Player(properties[0],properties[1],properties[2],Integer.parseInt(properties[3]),Integer.parseInt(properties[4]),Double.parseDouble(properties[5]),Double.parseDouble(properties[6]),Integer.parseInt(properties[7]));
            parsedCSV.add(player);
        }
        return parsedCSV;
    }

    private static void writeCSV(ArrayList<String[]> content) throws IOException {
        CSVWriter writer = null;
        try {
            String mycontent = "This String would be written" +
                    " to the specified File";
            //Specify the file name and path here
            String path = Main.class.getClassLoader().getResource("fixtures.csv").getPath();
            File csvOutputFile = new File(path);

            writer = new CSVWriter(new FileWriter(path));

            writer.writeAll(content);

            writer.flush();
            System.out.println("Data entered");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            writer.flush();
            System.out.println("Data entered");
        }
    }

    private static void GenerateAndWriteCSV(ArrayList<String> teams){

        ArrayList<String[]> fixtures = new ArrayList<>();
        int n =teams.size();
        for(int i=0;i<n ;i++){
            for(int j= i+1 ; j<n; j++){
                String[] fixtureHome = {teams.get(i), teams.get(j), teams.get(i)+"_home"};
                fixtures.add(fixtureHome);
                String[] fixtureAway = {teams.get(i), teams.get(j), teams.get(j)+"_home"};
                fixtures.add(fixtureAway);
            }
        }

        Date currDate = new Date(2023, 01,16, 18, 30, 0);

        int numberOfMatches = fixtures.size();
        int matches = 1;
        Random random = new Random();

        ArrayList<String[]> generatedmatches = new ArrayList<>();

        // Randomly generated matches
        while (numberOfMatches > 0){
            // Twice a day logic
            int rand = random.nextInt(numberOfMatches);
            Date newDate = new Date(currDate.getTime() + 24 * HOUR);
            String date = newDate.toString();
            String[] match1 = {date, ""+matches, fixtures.get(rand)[0] , fixtures.get(rand)[1], fixtures.get(rand)[2]};
            fixtures.remove(rand);
            numberOfMatches--;
            matches++;

            rand = random.nextInt(numberOfMatches);
            newDate = new Date(currDate.getTime() + 3 * HOUR);
            date = newDate.toString();
            String[] match2 = {date, ""+matches, fixtures.get(rand)[0] , fixtures.get(rand)[1], fixtures.get(rand)[2]};
            fixtures.remove(rand);
            numberOfMatches--;
            matches++;


            generatedmatches.add(match1);
            generatedmatches.add(match2);

            currDate = newDate;
        }

        try {
            writeCSV(generatedmatches);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void main(String[] args) {
        String path = Main.class.getClassLoader().getResource("IPL_2021-data.csv").getPath();
        ArrayList<Player> players = new ArrayList<>();
        try {
            players = parseCSV(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean flag = true;
        Scanner sc = new Scanner(System.in);

        while (flag){

            ConsoleLogger.infoMethod("\n");
            ConsoleLogger.infoMethod("\n");
            ConsoleLogger.infoMethod("\n");
            ConsoleLogger.infoMethod("Select the options based on below choices,");
            ConsoleLogger.infoMethod("1. Get list of bowlers who have taken atleast 40 wickets");
            ConsoleLogger.infoMethod("2. Get details of highest run-scorer and highest wicket taker");
            ConsoleLogger.infoMethod("3. Get top 3 run scorer and top 3 wicket takers of the season");
            ConsoleLogger.infoMethod("4. To stop the program");

            int choice = Integer.parseInt(sc.nextLine());
            String team;
            switch (choice){
                case 1:
                    ConsoleLogger.infoMethod("Enter the team name: ");
                    team = sc.nextLine();
                    players.stream().filter(player -> player.getTeam().equals(team) && player.getWickets()>=40).forEach(player -> ConsoleLogger.infoMethod(player.getName()));
                    break;
                case 2:
                    ConsoleLogger.infoMethod("Enter the team name: ");
                    team = sc.nextLine();
                    Optional<Player> highestWicketTaker = players.stream().filter(player -> player.getTeam().equals(team)).max((player1, player2) -> player1.getWickets() - player2.getWickets());
                    Optional<Player> highestRunsScorer = players.stream().filter(player -> player.getTeam().equals(team)).max((player1, player2) -> player1.getRuns() - player2.getRuns());
                    ConsoleLogger.infoMethod("Highest wicket taker from team: " + team + " is " + highestWicketTaker.get().getName() + " and highest runs scorer is " + highestRunsScorer.get().getName());
                    break;
                case 3:
                    List<Player> topWickettakers = players.stream().sorted(Comparator.comparing(Player::getWickets).reversed()).limit(3).toList();
                    List<Player> topRunScorer = players.stream().sorted(Comparator.comparing(Player::getRuns).reversed()).limit(3).toList();
                    ConsoleLogger.infoMethod("Top wicket takers are as below:");
                    topWickettakers.forEach(player -> ConsoleLogger.infoMethod(player.getName()));
                    ConsoleLogger.infoMethod("Top run scorers are as below:");
                    topRunScorer.forEach(player -> ConsoleLogger.infoMethod(player.getName()));
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    ConsoleLogger.warnMethod("Invalid choice");
            }


        }

        ArrayList<String> teams = new ArrayList<>();

        ConsoleLogger.infoMethod("Enter the number of teams: ");
        int noOfTeams = Integer.parseInt(sc.nextLine());
        for(int i=1; i<=noOfTeams; i++){
            ConsoleLogger.infoMethod("Enter the name of team " + i + ": ");
            String input = sc.nextLine();
            teams.add(input);
        }

        GenerateAndWriteCSV(teams);


    }
}