package Battleships;

import java.util.Scanner;

public class Game {
    
    
    //CREATE A MAP
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
    
    
    
    //DRAWING MAP IN CONSOLE
    private void drawmap(Tile[][] map){
        int y=0;
        for(int x=0;x<map[0].length;x++){
            System.out.print(x+" ");
        }
        System.out.println();
        for(int i=0;i<map.length;i++){
            System.out.print(y);
            for(int j=0;j<map.length;j++){
                System.out.print(map[i][j].icon+" ");
            }
            System.out.println();
            y++;
        }
    }
    
    
    
    //MAKES USER INPUT COORDINATES
    private int[] input(Scanner scan,Tile[][] map){
        int[] coordinates = new int[2];
        int x,y;
        String input;
        boolean xbool=false,ybool = false;
        while(xbool==false){
            System.out.println("Input x coordinate");
            input = scan.nextLine();
            try{
                x=Integer.parseInt(input);
                if(x>=0&&x<map[0].length){
                  coordinates[0]=x;
                  xbool=true;  
                }else{
                    System.out.println("Please input integer between 0 and "+map[0].length);
                }
            }catch(NumberFormatException ex){
                System.out.println("Please enter an intiger.");
            }
        }
        while(ybool==false){
            System.out.println("Input x coordinate");
            input = scan.nextLine();
            try{
                y=Integer.parseInt(input);
                if(y>=0&&y<map.length){
                    coordinates[1]=y;
                    ybool=true;
                }else{
                    System.out.println("Please input integer between 0 and "+map.length);
                }
            }catch(NumberFormatException ex){
                System.out.println("Please enter an intiger.");
            }
        }
        return coordinates;
    }
    
    
    //PLACES SHIP ON A MAP ----------------------------------------------TO DO
    public boolean placeship(Tile[][] map, Ship ship){
        int axis = (int)Math.round(Math.random());
        //AXIS 1 = | //ASIX 0 = --
        if(axis==1){
            int x=(int)Math.floor(Math.random()*map[0].length);
            int y=(int)Math.floor(Math.random()*map.length)-ship.sizeofship;
            //TO DO:------------------------------------------------------------
            //-Check if next tiles arent "SHIP"
            //-Set "SHIP's" coordinates according to drawn numbers
            //-return false if there are no possible spaces to place ship
            //------------------------------------------------------------------
        }else{
            int y=(int)Math.floor(Math.random()*map[0].length);
            int x=(int)Math.floor(Math.random()*map.length)-ship.sizeofship;
        }
        return true;
    }
    
    //STARTS THE GAME
    public void start(){
        //MAP[y][x] AS TABLE (REVERSED COORDINATES)
        Tile[][] map = createmap();
        Scanner input = new Scanner(System.in);
        SmallShip smallship1=new SmallShip();
    }
}
