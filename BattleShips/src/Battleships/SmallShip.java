package Battleships;

public class SmallShip extends Ship{
    ShipCoordinates[] coordinates = new ShipCoordinates[2];
    
    private SmallShip(){}
    
    void setship(int x,int y){
        axis=(int)Math.round(Math.random());
        if(axis==1){
            coordinates[0]=new ShipCoordinates(x,y);
            coordinates[1]=new ShipCoordinates(x+1,y);
        }else{
            coordinates[0]=new ShipCoordinates(x,y);
            coordinates[1]=new ShipCoordinates(x,y+1);
        }
    }
}
