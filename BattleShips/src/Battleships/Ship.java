package Battleships;

public abstract class Ship extends Tile{
    public ShipCoordinates[] coordinates;
    int sizeofship;
    int sink = 0;
    
        
    public int hit(int x,int y){
        for(int i=0;i<sizeofship;i++){
            if(coordinates[i].x==x&&coordinates[i].y==y){
                if(coordinates[i].hit==true){
                    return -1;
                }else{
                    sink++;
                    coordinates[i].hit=true;
                    if(sink==sizeofship){
                        return 1;
                    }else{
                        return 0;
                    }
                }
            }
        }
    return 0;
    }
}
