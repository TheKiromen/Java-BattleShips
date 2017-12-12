package Battleships;

public class Tile {
    private boolean hit = false;
    char icon = 'O';
    
    public int hit(int x,int y){
        if(hit==false){
            icon='~';
            hit=true;
            System.out.println("Miss!");
            return 0;
        }else{
            System.out.println("You already hit this tile.");
            return -1;
        }
    }
    
}
