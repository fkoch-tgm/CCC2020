package at.ac.codingcookies.ccc2020;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO doc
 *
 * @author Felix Koch
 * @version 2020-10-30
 */
public class Level1_1 {
    private static String INPUT_FILE="input/level1/level1_5.in";
    private static String OUTPUT = "output/level1_5.out";
    public static void main(String[] args) {
        List<Integer[]> input = IOTools.parseInput(INPUT_FILE);
        int curMaxScore=-1;
        int maxPlayerID=-1;

        input.remove(0);
        for (Integer[] line :
                input) {
            if (line[1] > curMaxScore) {
                curMaxScore = line[1];
                maxPlayerID = line[0];
            }
            else if (line[1] == curMaxScore) {
                if (line[0] < maxPlayerID) {
                    curMaxScore = line[1];
                    maxPlayerID = line[0];
                }
            }
            if (line[3] > curMaxScore) {
                curMaxScore = line[3];
                maxPlayerID = line[2];
            }
            else if (line[3] == curMaxScore) {
                if (line[2] < maxPlayerID) {
                    curMaxScore = line[3];
                    maxPlayerID = line[2];
                }
            }
        }
        System.out.println("maxPlayerID = " + maxPlayerID);
        System.out.println("curMaxScore = " + curMaxScore);
        IOTools.saveStrings(new LinkedList<>(Arrays.asList(String.valueOf(maxPlayerID)+" " + String.valueOf(curMaxScore))),OUTPUT);
    }

    public void consumeInput(List<Integer[]> input) {
        for (Integer[] line: input) {

        }
    }

    public static int searchPlayerFromMaxScore(int max) {
        List<Integer[]> input = IOTools.parseInput(INPUT_FILE);
        input.remove(0);
        for(Integer[] line: input) {
            if(max == line[1]) {
                return line[0];
            } else if(max == line[3]) {
                return line[2];
            }
        }
        return -1;
    }
}
