package Sorting;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode {

    public static void main(String[] args) {
        int a[][] = new int[][] {
                {5,10},{2,5},{4,7},{3,9}
        };

        maximumUnits(a,10);
    }


    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        if(boxTypes.length == 0) return 0;
        List<BoxType> list = new ArrayList<>();
        for(int i=0;i<boxTypes.length;i++) {
            list.add(new BoxType(boxTypes[i][0],boxTypes[i][1]));
        }
        Collections.sort(list);

        int totalBoxes = 0;
        int totalUnits = 0;

        for(int i=0;i<list.size();i++) {
            BoxType b = list.get(i);
            int units = b.numUnits;
            int numBoxes = b.numBoxes;
            if(totalBoxes + numBoxes <= truckSize) {
                totalBoxes = totalBoxes + numBoxes;
                totalUnits = totalUnits + numBoxes * units;
            }
            else {
                int boxesPicked = truckSize - totalBoxes;
                totalBoxes = totalBoxes  + boxesPicked;
                totalUnits =totalUnits +  boxesPicked * units;
                break;
            }
        }

        return totalUnits;

    }

}


class BoxType implements Comparable<BoxType> {
    int numBoxes;
    int numUnits;

    BoxType(int boxes, int units) {
        this.numBoxes = boxes;
        this.numUnits = units;
    }


    @Override
    public int compareTo(BoxType o) {
        return o.numUnits - this.numUnits;
    }
}