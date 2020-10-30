package at.ac.codingcookies.ccc2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO doc
 *
 * @author Felix Koch
 * @version 2020-10-30
 */
public class level3 {



    public static void doAllStuff() {
        for (int i = 1; i < 6; i++) {
            String level = "3_"+i;
            doStuff(level);
        }
    }

    public static void doStuff(String level){
        String INPUT_FILE = "input/level3/level"+level+".in";
        String OUTPUT_FILE = "output/level3/level"+level+".out";
        System.out.println("INPUT_FILE = " + INPUT_FILE);

        LinkedList<Integer[]> input = IOTools.parseInput(INPUT_FILE);

        Integer[] linetwo = input.get(0);
        Integer[] lineone = input.get(1);
        int winInc = linetwo[0];
        int lossDec = -1*linetwo[1];

        Object[] in = IOTools.parseGames(INPUT_FILE);

        HashMap<Integer, Player> ps = (HashMap<Integer, Player>) in[1];


        List<Game> games = (List<Game>) in[0];

        for(Game game: games) {
            int id = game.winner();
            ps.get(id).changePoints(winInc);
            int idLoser= game.loser();
            ps.get(idLoser).changePoints(lossDec);
        }

        ArrayList<String> output = new ArrayList<>();
        Player[] playerArray = ps.values().stream().sorted((o1, o2) -> {
            if (o1.getPoints()<o2.getPoints()) return 1;
            else if(o1.getPoints() == o2.getPoints()) {
                if (o1.getId()>o2.getId()) return 1;
                else return -1;
            }
            return -1;
        }).toArray(Player[]::new);
        for (Player o :
                playerArray) {
            output.add(o.toString());
        }

        IOTools.saveStrings(output,OUTPUT_FILE);
    }

    public static void main(String[] args) {
        doAllStuff();
        //doStuff("3_example");
    }
}
