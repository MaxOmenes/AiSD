import models.Labyrinth;

public class Main {
    public static void main(String[] args) {
        int[][] a = {{5,10 ,14},
                     {9,5,6},
                     {7,8,12}};
        Labyrinth l = new Labyrinth();
        l.setLabyrinth(l.generateLabyrinthById(a));
        int[][] ans = Labyrinth.findPath(l, 2, 2);
        for (int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++){
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }
    }
}