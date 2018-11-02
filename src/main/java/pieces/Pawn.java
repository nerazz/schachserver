package pieces;

/**
 * created on: 02.11.18
 */

public class Pawn extends Piece {

    public String color;
    public boolean hasMoved;
    public Coordinate current_coordinate;
    public Coordinate new_coordinate;

    private Coordinates[] validmoves;


    public Pawn(String color){
        this.color = color;
        this.hasMoved = false;
    }

   public boolean valid (Coodinate xy) {
       if (validmoves.contains(xy))
           return true;
       else return false;
   }

   if(color.equals("white")){
       validmoves[0] = current_coordinates
    }





    //test
}
