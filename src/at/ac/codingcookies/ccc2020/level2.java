package at.ac.codingcookies.ccc2020;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.naming.ldap.HasControls;
import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;

/**
 * TODO doc
 *
 * @author Felix Koch
 * @version 2020-10-30
 */
public class level2 {



    public static void doAllStuff() {
        for (int i = 1; i < 6; i++) {
            String level = "2_"+i;
            doStuff(level);
        }
    }

    public static void doStuff(String level){
        String INPUT_FILE = "input/level2/level"+level+".in";
        String OUTPUT_FILE = "output/level"+level+".out";
        System.out.println("INPUT_FILE = " + INPUT_FILE);
        LinkedList<Integer[]> input = IOTools.parseInput(INPUT_FILE);
        Integer[] lineone = input.get(0);
        HashMap<Integer, Player> ps = new HashMap<>();
        for(int i = 0; i < lineone[1]; i++) {
            ps.put(i, new Player(i,0));
        }

        List<Game> games = IOTools.parseGames(INPUT_FILE);
        List<Player> playerwins = new ArrayList<>();
        for(Game game: games) {
            int id = game.winner();
            ps.get(id).setWins(ps.get(id).getWins()+1);
        }

        ArrayList<String> output = new ArrayList<>();
        Player[] playerArray = ps.values().stream().sorted((o1, o2) -> {
            if (o1.getWins()<o2.getWins()) return 1;
            else if(o1.getWins() == o2.getWins()) {
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
    }
}
