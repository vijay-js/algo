package ArraysLearn.InterviewPrep;

//Given unsorted array of intgeres and 2 numbers x and y -> find the closest distance between them . Array might contain duplictaes
public class ClosetDistanceBetween2Numbers {

    public static void main(String[] args) {
        int a[] = {2,5,3,5,4,2,3};
        int x = 3, y=2;

        int answer = findClosestDistance(a,x,y);
        System.out.println(answer);
    }

    private static int findClosestDistance(int a[],int x, int y) {
        int prevOccurence = Integer.MAX_VALUE;
        int prevIndex = -1;
        int answer = Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++) {
             if(a[i] == x && prevOccurence == x || a[i]==y && prevOccurence == y)  {
                 prevIndex = i;
             }
             else if(a[i] ==x && prevOccurence ==y || a[i]==y && prevOccurence == x) {
                 answer= Math.min(answer,i-prevIndex);
                 prevOccurence=a[i];
                 prevIndex = i;
             }
             else if(a[i] == x ||a[i] ==y) {
                 prevOccurence = a[i];
                 prevIndex = i;
             }
        }
        return answer;
    }
}
