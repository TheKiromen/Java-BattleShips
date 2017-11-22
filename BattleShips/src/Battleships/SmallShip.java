package Battleships;

public class SmallShip extends Ship{
    ShipCoordinates[] coordinates;
    
    public SmallShip(){
        sizeofship=2;
        coordinates=new ShipCoordinates[2];
        icon='>';
    }
}
