package at.ac.codingcookies.ccc2020;

import sun.awt.image.ImageWatched;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * TODO doc
 *
 * @author Felix Koch
 * @version 2020-10-30
 */
public class IOTools {

    /**
     * Loads a File as LinkedList
     */
    public static List<String> readLines(String filename) {
        List<String> list = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            list = reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * load file as double-list
     */
    public static List<Double> readDoubles(String filename) {
        List<String> lines = readLines(filename);
        return lines.stream().mapToDouble(Double::parseDouble).collect(LinkedList::new,LinkedList::add,LinkedList::addAll);
    }

    public static void saveStrings(List<String> out,String filename) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
            for (String line:
                 out) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LinkedList<Integer[]> parseInput(String filename) {
        List<String> lines = readLines(filename);
        LinkedList<Integer[]> input = new LinkedList<>();
        for (String line :
                lines) {
            String[] lps= line.split(" ");
            Integer[] ints = new Integer[lps.length];
            for(int i = 0; i < lps.length; i++) {
                ints[i] = Integer.parseInt(lps[i]);
            }
            input.add(ints);
        }
        return input;
    }

    public static Object[] parseGames(String filename) {
        List<Game> games = new LinkedList<>();
        List<Integer[]> lines = parseInput(filename);

        Integer[] lineone = lines.remove(0);
        HashMap<Integer, Player> ps = new HashMap<>();
        for(int i = 0; i < lineone[1]; i++) {
            ps.put(i, new Player(i));
        }

        for (Integer[] line:lines) {
            List<Play> plays = new ArrayList<>();
            for (int i = 0; i < line.length; i+=2) {
                plays.add(new Play(ps.get(line[i]),line[i+1]));
            }
            games.add(new Game(plays));
        }
        return new Object[]{games,ps};
    }
}
