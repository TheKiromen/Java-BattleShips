package Battleships;

import java.util.Random;
import java.util.Scanner;

public class Game {
    
    //VARIABLES
    Random rnd = new Random();
    
    
    //CREATE A MAP
    private Tile[][] createmap(int x,int y){
        Tile[][] battlefield = new Tile[y][x];//Tile[y][x]//
        for(int i=0;i<y;i++){
            for(int j=0;j<x;j++){
                battlefield[i][j]= new Tile();
            }
        }
        return battlefield;
    }
    
    
    
    //DRAWING MAP IN CONSOLE
    private void drawmap(Tile[][] map){
        int y=0;
        System.out.print("  ");
        for(int x=0;x<map[0].length;x++){
            System.out.print(x+" ");
        }
        System.out.println("X");
        for(int i=0;i<map.length;i++){
            System.out.print(y+" ");
            for(int j=0;j<map.length;j++){
                map[i][j].draw(j,i);
            }
            System.out.println();
            y++;
        }
        System.out.println("Y");
        for(int i=0;i<map[0].length*2+3;i++){
            System.out.print("-"); 
        }
        System.out.println();
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
        boolean stop = false;
        int x = 0,y = 0;
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
        for(int i=0;i<ship.sizeofship;i++){
            if(axis==1){
                map[y+i][x]=ship;
                ship.coordinates[i]=new ShipCoordinates(x,y+i);
            }else{
                map[y][x+i]=ship;
                ship.coordinates[i]=new ShipCoordinates(x+i,y);
            }
        }
        return true;
    }
    
    
    //SKINKS THE SHIP
    private void sink(int x, int y,Tile[][] map,Tile ship){
        if(map[y][x].coordinates[0].x==map[y][x].coordinates[1].x){
            for(int i=-1;i<=ship.sizeofship;i++){
                for(int j=-1;j<2;j++){
                    map[y+i][x+j].hit(x,y);
                }
            }
        }else if(map[y][x].coordinates[0].y==map[y][x].coordinates[1].y){
            for(int i=-1;i<=ship.sizeofship;i++){
                for(int j=-1;j<2;j++){
                    map[y+j][x+i].hit(x,y);
                }
            }
        }
    }
    
    
    //STARTS THE GAME
    public void start(){
        //MAP[y][x] AS TABLE (REVERSED COORDINATES)
        Tile[][] map = createmap(10,10);
        Scanner input = new Scanner(System.in);
        
        //SETTING UP SHIPS
        Ship[] ships = new Ship[5];
        ships[0]= new SmallShip();
        ships[1]= new SmallShip();
        ships[2]= new SmallShip();
        ships[3]= new MediumShip();
        ships[4]= new LargeShip();
        boolean check;
        for(int i=0;i<ships.length;i++){
            check=false;
            while(check==false){
                if(placeship(map,ships[i])==true){
                    check=true;
                }
            }
        }
        

        
        //PLAYER's TURN
        drawmap(map);
        check=false;
        int amount_of_ships=ships.length;
        int tmp=0;
        for(int i=0;i<ships.length;i++){
            tmp+=ships[i].sizeofship*3;
        }
        int moves=map.length*map[0].length-tmp;
        int[] coordinates;
        int result;
        while(check==false){
            coordinates=input(input,map);
            result = map[coordinates[1]][coordinates[0]].hit(coordinates[0],coordinates[1]);
            if(result==1){
                sink(map[coordinates[1]][coordinates[0]].coordinates[0].x,map[coordinates[1]][coordinates[0]].coordinates[0].y,map,map[coordinates[1]][coordinates[0]]);
                amount_of_ships--;
                drawmap(map);
                System.out.println("The ship is sinking!");
                if(amount_of_ships==0){
                    drawmap(map);
                    System.out.println("YOU WIN!");
                    check=true;
                }
            }else if(result==2){
                moves--;
                drawmap(map);
                System.out.println("Miss!");
            }else if(result==-1){
                drawmap(map);
                System.out.println("You already hit this tile!");
            }else{
                drawmap(map);
                System.out.println("Bingo!");
            }
            
            if(moves==0){
                check=true;
                System.out.println("Game Over!");
            }
        }
    }
}
