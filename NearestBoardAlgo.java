import java.util.ArrayList;
import java.util.List;

class Board{
    int top;
    int left;
    int width;
    int height;
    String name;
    public Board() {
    }
    public Board(int top, int left, int width, int height, String name) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
        this.name = name;
    }
    public int getTop() {
        return top;
    }
    public void setTop(int top) {
        this.top = top;
    }
    public int getLeft() {
        return left;
    }
    public void setLeft(int left) {
        this.left = left;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}


//                  |
//                  |
//         2nd Plan |   1st Plan
//           (-, -) |  (+, -)
//   ---------------|-----------------
//           (-, +) |  (+, +)
//         4th Plan |   3rd Plan
//                  |
//                  |

class NavigationAlgo{
    public String nextNearestBoard(List<Board> boards, Board currentBoard, String direction){
        // step 1: check in the boundary of current board, if boards found then return nearest board
        // step 2: collect all board those comes before the current board 
        // step 3 : sort board on the basis of distance between current boards,
            // step 3.1: if two boards are at same distance then sort them according to distance from left(in decending order)
        // step 4: take board which is closest from current board and farthest from left



        // create tree which store value on the basis of co-ordinates and 
        // inner branch are created using the like if for same x value 4 value present then divide branch according to that
        // ** it help to find inserting and searching data very easily (log n)
        
        String name = "";
        if(direction.equals("left")){
            ////////****************Logic for left********************/////////////

            // 1. if board in 1st plan
                // check first if any board closest board present in 1st plan
                // otherwise, check in 2nd plan and select closest
                /* priority order: 1st plan -> 2nd plan */
            
            // 2. if board in 2nd plan
                // check in 1st plan but if any board present in 2nd which is near to the 
                // current board then take that board
                /* priority order: 1st plan -> 2nd plan */

            // 3. if board in 3rd plan
                // check first if any closest board present in 3rd plan
                // otherwise check in 4th plan(coming before current board) --> 1st plan -> 2nd plan
                /* priority order: 3rd plan -> 4th plan, 1st plan -> 2nd plan */
            
            // 4. if board in 4th plan
                // check in 3rd plan only which are coming before current board's starting point 
                // 4th plan, 1st plan, 2nd which is coming closest
                /* priority order: 3rd -> 4th plan, 1st plan -> 2nd plan */

            

        }else if(direction.equals("right")){
            ////////****************Logic for Right********************/////////////

            // 1. if board in 1st plan
                // check first if any board closest board present in 2nd plan and 1st plan
                // otherwise, check in 4th plan and 3rd plan
                /* priority order: 2nd -> 1st, 4th -> 3rd */
            
            // 2. if board in 2nd plan
                // check in 1st plan but if any board present in 2nd which are afte current board
                // current board then take that board
                /* priority order: 1st plan -> 2nd plan, 4th -> 3rd */

            // 3. if board in 3rd plan
                // check first if any closest board present in 4th plan
                // otherwise check in 3rd
                /* priority order: 4th -> 3rd */
            
            // 4. if board in 4th plan
                // check in 3rd plan and then in 4th plan
                /* priority order: 3rd -> 4th plan */
        } else if(direction.equals("up")){
            // take only those boards which are coming in current board's area
        }else if(direction.equals("down")){
            // take only those boards which are coming in current board's area` 
        }
        return name;
    }
}

public class NearestBoardAlgo {
    public static void main(String[] args) {
        List<Board> boardsData = new ArrayList<>();
        Board b1 = new Board(215, 143, 197, 178, "Board1");
        Board b2 = new Board(215, 370, 197, 178, "Board2");
        Board b3 = new Board(215, 597, 197, 178, "Board3");
        Board b4 = new Board(215, 824, 197, 178, "Board4");
        Board b5 = new Board(491, 143, 197, 178, "Board5");
        Board b6 = new Board(487, 388, 197, 178, "Board6");
        boardsData.add(b1);
        boardsData.add(b2);
        boardsData.add(b3);
        boardsData.add(b4);
        boardsData.add(b5);
        boardsData.add(b6);
    }
    
}