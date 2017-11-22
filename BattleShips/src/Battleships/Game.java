package Battleships;

import java.util.Random;
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
        System.out.print("  ");
        for(int x=0;x<map[0].length;x++){
            System.out.print(x+" ");
        }
        System.out.println();
        for(int i=0;i<map.length;i++){
            System.out.print(y+" ");
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
            try{
                x = scan.nextInt();
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
            System.out.println("Input y coordinate");
            try{
                y = scan.nextInt();
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
    
    
    //PLACES SHIP ON A MAP
    private boolean placeship(Tile[][] map, Ship ship){
        int axis = (int)Math.round(Math.random());
        Random rnd = new Random();
        boolean stop = false;
        int x = 0,y = 0;
        while(stop==false){
        //AXIS 1 = | //ASIX 0 = --
        //Checking if there are no other ships around
            if(axis==1){
                x=rnd.nextInt(map[0].length-2)+1;
                y=rnd.nextInt(map.length-(ship.sizeofship+1))+1;
                for(int i=-1;i<=ship.sizeofship;i++){
                    for(int j=-1;j<2;j++){
                        if(map[y+i][x+j] instanceof Ship){
                            return false;
                        }
                    }
                }
            stop=true;
            }else{
                x=rnd.nextInt(map[0].length-(ship.sizeofship+1))+1;
                y=rnd.nextInt(map.length-2)+1;
                for(int i=-1;i<=ship.sizeofship;i++){
                    for(int j=-1;j<2;j++){
                        if(map[y+j][x+i] instanceof Ship){
                            return false;
                        }
                    }
                }
            stop=true;
            }
        }
        for(int i=0;i<ship.sizeofship;i++){
            if(axis==1){
                map[y+i][x]=ship;
                ship.coordinates[i]=new ShipCoordinates(x,y+i);
            }else{
                map[y][x+i]=ship;
                ship.coordinates[i]=new ShipCoordinates(x+i,y);
            }
        }
        this.drawmap(map);
        return true;
    }
    
    
    //STARTS THE GAME
    public void start(){
        //MAP[y][x] AS TABLE (REVERSED COORDINATES)
        Tile[][] map = createmap();
        Scanner input = new Scanner(System.in);
        SmallShip smallship1=new SmallShip();
        boolean check=false;
        while(check==false){
            check=placeship(map,smallship1);
        }
        
        //TO-DO
        //-Check hits
        //-Display if no more ships can be placed
        //-Make a move's limit for game to last
        //-Difficulty levels?
        //-All the tiles around destroyed when Ship is sinking
        //-Make other ships
    }
}
