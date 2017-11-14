package Battleships;

public class Tile {
    private boolean hit = false;
    char icon = 'O';
    
    public int hit(int x,int y){
        if(hit==false){
            icon='~';
            hit=true;
            return 1;
        }else{
            return 0;
        }
    }
    
}
