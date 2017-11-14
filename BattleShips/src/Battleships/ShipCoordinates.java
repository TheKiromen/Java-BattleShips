package Battleships;

public class ShipCoordinates {
    private int x,y;
    public boolean hit;
    
    public ShipCoordinates(int x, int y){
        this.x=x;
        this.y=y;
        this.hit = false;
    }
}
