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
    private int[] input(Scanner scan){
        int[] coordinates = new int[2];
        int x,y;
        String input;
        boolean xbool=false,ybool = false;
        while(xbool==false){
            System.out.println("Input x coordinate");
            input = scan.nextLine();
            try{
                x=Integer.parseInt(input);
                coordinates[0]=x;
                xbool=true;
            }catch(NumberFormatException ex){
                System.out.println("Prosze podac liczbe.");
            }
        }
        while(ybool==false){
            System.out.println("Input x coordinate");
            input = scan.nextLine();
            try{
                x=Integer.parseInt(input);
                coordinates[0]=x;
                ybool=true;
            }catch(NumberFormatException ex){
                System.out.println("Prosze podac liczbe.");
            }
        }
        return coordinates;
    }
    
    public void start(){
        Tile[][] map = createmap();
        Scanner input = new Scanner(System.in);
        System.out.println(Integer.parseInt(input.nextLine()));
    }
}
