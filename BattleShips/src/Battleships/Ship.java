package Battleships;

public abstract class Ship extends Tile{
    public ShipCoordinates[] coordinates;
    int sizeofship;
    int sink = 0;
    
        
    public int hit(int x,int y){
        //-1 was hit already ||1 is sinking ||0 is hit
        for(int i=0;i<sizeofship;i++){
            if(coordinates[i].x==x&&coordinates[i].y==y){
                if(coordinates[i].hit==true){
                    System.out.println("You already hit this tile.");
                    return -1;
                }else{
                    this.icon='X';
                    sink++;
                    coordinates[i].hit=true;
                    if(sink==sizeofship){
                        System.out.println("The ship is sinking!");
                        return 1;
                    }else{
                        System.out.println("Bingo!");
                        return 0;
                    }
                }
            }
        }
    return 0;
    }
}
