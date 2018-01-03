package Battleships;

public class Tile {
    private boolean hit = false;
    int sizeofship;
    public ShipCoordinates[] coordinates;
    
    public int hit(int x,int y){
        if(hit==false){
            hit=true;
            return 2;
        }else{
            return -1;
        }
    }
    
    public void draw(int x,int y){
        if(hit==false){
            System.out.print("O ");
        }else{
            System.out.print("~ ");
        }
    }
    
}
