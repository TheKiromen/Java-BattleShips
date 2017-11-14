package Battleships;

import java.util.Scanner;

public class Game {
    
    private Tile[][] createmap(){
        Tile[][] battlefield = new Tile[10][10];//Tile[y][x]//
        for(int y=0;y<10;y++){
            for(int x=0;x<10;x++){
                battlefield[y][x]= new Tile();
            }
        }
        drawmap(battlefield);
        return battlefield;
    }
    
    private void drawmap(Tile[][] map){
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map.length;j++){
                System.out.print(map[i][j].icon+" ");
            }
            System.out.println();
        }
    }
    
    //TO DO: USERS INPUT (Only int 0-size of table,String conversion)//
    private int[] input(Scanner input){
        int[] coordinates = new int[2];
        boolean xbool=false,ybool = false;
        while(xbool==false){
            System.out.print("Input x coordinate");
            String x = input.nextLine();
        }
        while(ybool==false){
            System.out.print("Input y coordinate");
            String y = input.nextLine();
        }
        return coordinates;
    }
    
    public void start(){
        Tile[][] map = createmap();
        Scanner input = new Scanner(System.in);
    }
}