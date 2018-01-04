package Battleships;

public abstract class Ship extends Tile{
    
    int sink = 0;
        
    public int hit(int x,int y){
        //-1 was hit already ||1 is sinking ||0 is hit
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
    
    public void draw(int x,int y){
        for(int i=0;i<sizeofship;i++){
            if(coordinates[i].x==x&&coordinates[i].y==y){
                if(coordinates[i].hit==false){
                    System.out.print("O ");
                }else if(coordinates[i].hit==true){
                    System.out.print("X ");
                }
            }
        }
    }
    
}
