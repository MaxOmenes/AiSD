package models;

import java.util.Random;

public class Labyrinth {
    private Cell[][] labyrinth;

    //cellModels
    public final Cell emptyCell = new Cell(false, false, false, false); //id0
    public final Cell wallUp = new Cell(true, false,false ,false); //id1
    public final Cell wallDown = new Cell(false, true,false ,false); //id2
    public final Cell wallLeft = new Cell(false, false,true ,false); //id3
    public final Cell wallRight = new Cell(false, false,false ,true); //id4
    public final Cell cornerUpLeft = new Cell(true, false, true, false); //id5
    public final Cell cornerUpRight = new Cell(true, false, false, true); //id6
    public final Cell cornerDownLeft = new Cell(false, true, true, false); //id7
    public final Cell cornerDownRight = new Cell(false, true, false, true); //id8
    public final Cell hallVertical = new Cell(false, false, true ,true); //id9
    public final Cell hallHorizontal = new Cell(true, true, false ,false); //id10
    public final Cell deadEndUp = new Cell(true, false, true ,true); ////id11
    public final Cell deadEndDown = new Cell(false, true, true ,true); //id12
    public final Cell deadEndLeft = new Cell(true, true, true ,false); //id13
    public final Cell deadEndRight = new Cell(true, true, false ,true);//id14
    public final Cell fullCell = new Cell(true, true, true ,true); //id15
    private final Cell[] cellClassifier = new Cell[]{emptyCell,
            wallUp, wallDown, wallLeft, wallRight,
            cornerUpLeft, cornerUpRight, cornerDownLeft, cornerDownRight,
            hallVertical, hallHorizontal,
            deadEndUp, deadEndDown, deadEndLeft, deadEndRight,
            fullCell};

    private class Cell{
        private boolean upWall;
        private boolean downWall;
        private boolean leftWall;
        private boolean rightWall;
        public Cell(boolean upWall, boolean downWall, boolean leftWall, boolean rightWall){
            this.upWall = upWall;
            this.downWall = downWall;
            this.leftWall = leftWall;
            this.rightWall = rightWall;
        }

        public boolean isUpWall() {
            return upWall;
        }

        public void setUpWall(boolean upWall) {
            this.upWall = upWall;
        }

        public boolean isDownWall() {
            return downWall;
        }

        public void setDownWall(boolean downWall) {
            this.downWall = downWall;
        }

        public boolean isLeftWall() {
            return leftWall;
        }

        public void setLeftWall(boolean leftWall) {
            this.leftWall = leftWall;
        }

        public boolean isRightWall() {
            return rightWall;
        }

        public void setRightWall(boolean rightWall) {
            this.rightWall = rightWall;
        }

        public static boolean canGoUp(Cell fromCell, Cell toCell){
            return !(fromCell.isUpWall() || toCell.isDownWall());
        }

        public boolean canGoUp(Cell toCell){
            return !(isUpWall() || toCell.downWall);
        }

        public static boolean canGoDown(Cell fromCell, Cell toCell){
            return !(fromCell.isDownWall() || toCell.isUpWall());
        }

        public boolean canGoDown( Cell toCell){
            return !(isDownWall() || toCell.isUpWall());
        }

        public static boolean canGoLeft(Cell fromCell, Cell toCell){
            return !(fromCell.isLeftWall() || toCell.isRightWall());
        }

        public boolean canGoLeft( Cell toCell){
            return !(isLeftWall() || toCell.isRightWall());
        }

        public static boolean canGoRight(Cell fromCell, Cell toCell){
            return !(fromCell.isRightWall() || toCell.isLeftWall());
        }

        public boolean canGoRight(Cell toCell){
            return !(isRightWall() || toCell.isLeftWall());
        }

    }

    public Labyrinth(Cell[][] labyrinth) {
        this.labyrinth = labyrinth;
    }

    public Labyrinth(){
    }

    public Cell[][] getLabyrinth() {
        return labyrinth;
    }

    public void setLabyrinth(Cell[][] labyrinth) {
        this.labyrinth = labyrinth;
    }

    public Cell getCellClassifier(int i) {
        return cellClassifier[i];
    }

    public Cell[][] generateLabyrinthById(int[][] userArray){
        /**
         * Generate Labyrinth by creating integer matrix
         *         Just use id's as a template
         *         ID's:
         *             0 - (empty cell)
         *                  _         _                      _
         *             1 -        5 -|     9 - | |     11 - | |
         *                            _         _
         *             2 - _      6 -  |   10 - _      12 - |_|
         *                                                   _
         *             3 - |      7 - |_               13 - |_
         *                                                  _
         *             4 -  |     8 - _|               14 - _|
         *                   _
         *             15 - |_|
         */

        Cell[][] ans = new Cell[userArray.length][];

        for(int i = 0; i < userArray.length; i++){
            Cell[] tmpArr = new Cell[userArray[i].length];
            for(int j = 0; j < userArray[i].length; j++){
                tmpArr[j] = getCellClassifier(userArray[i][j]);
            }
            ans[i] = tmpArr;
        }

        return ans;
    }

    public Cell[][] generateRandomLabyrinth(int width, int height){
        Random rn = new Random();
        int[][] arr = new int[width][];
        for(int i = 0; i < width; i++){
            int[] tmpArr = new int[height];
            for(int j = 0; j < height; j++){
                tmpArr[j] = rn.nextInt(0, 16);
            }
            arr[i] = tmpArr;
        }
        return generateLabyrinthById(arr);
    }

    public Cell[][] generateRandomLabyrinth(){
        Random rn = new Random();
        return generateRandomLabyrinth(rn.nextInt(1, 10), rn.nextInt(1, 10));
    }

}