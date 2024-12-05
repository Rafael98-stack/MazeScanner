import java.util.Random;
import java.util.Scanner;

public class Labirinto {
  static  int[][] labirinto ={
            {0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0},
            {0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0},
            {0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0},
            {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
            {0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0},
            {0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    static void stampaLabirinto() {
        for (int i = 0; i < labirinto.length; i++) {
            for (int j = 0; j < labirinto[i].length; j++) {
                System.out.print(labirinto[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static void posizionamentoGiocatore() {
        Random random = new Random();
        int x;
        int y;

        do {
            x = random.nextInt(labirinto.length);
            y = random.nextInt(labirinto[0].length);
        } while (labirinto[x][y] != 1);
        labirinto[x][y] = 2;
        stampaLabirinto();
    }

static void movimentoGiocatore(String awsd){
        int positionPlayerX = -1;
        int positionPlayerY = -1;
    for (int i = 0; i < labirinto.length; i++) {
        for (int j = 0; j < labirinto[i].length; j++) {
            if (labirinto[i][j] == 2) {
                positionPlayerX = i;
                positionPlayerY = j;
                break;
            }
        }
    }
    if (positionPlayerX < 0 || positionPlayerY < 0){
        System.out.println("Giocatore non trovato");
    }
    int newPositionX = positionPlayerX;
    int newPositionY = positionPlayerY;
    switch (awsd){
        case "a":
newPositionY--;
if (labirinto[newPositionX][newPositionY] == 0){
    System.out.println("posizione non valida");
    newPositionY++;
} else {
    labirinto[positionPlayerX][positionPlayerY] = 1;
    labirinto[newPositionX][newPositionY] = 2;
}
            break;
        case "d":
            newPositionY++;
            if (labirinto[newPositionX][newPositionY] == 0){
                System.out.println("posizione non valida");
                newPositionY--;
            } else {
                labirinto[positionPlayerX][positionPlayerY] = 1;
                labirinto[newPositionX][newPositionY] = 2;
            }
            break;
        case "w":
            newPositionX--;
            if (labirinto[newPositionX][newPositionY] == 0){
                System.out.println("posizione non valida");
                newPositionX++;
            } else {
                labirinto[positionPlayerX][positionPlayerY] = 1;
                labirinto[newPositionX][newPositionY] = 2;
            }
            break;
        case "s":
            newPositionX++;
            if (labirinto[newPositionX][newPositionY] == 0){
                System.out.println("posizione non valida");
                newPositionX--;
            } else {
                labirinto[positionPlayerX][positionPlayerY] = 1;
                labirinto[newPositionX][newPositionY] = 2;
            }
            break;
    }
    System.out.println();
  stampaLabirinto();
}

    public static void main(String[] args) {
        System.out.println("BENVENUTO IN MAZERUNNER");
      stampaLabirinto();

        System.out.println("CERCA DI SCAPPARE, SEI RAPPRESENTATO CON IL NUMERO 2. Arriva oltre il numero 3");
      posizionamentoGiocatore();

        Scanner scanner = new Scanner(System.in);
while (true){
        System.out.println("PREMI UNO DI QUESTI TASTI: AWSD. PER MUOVERTI.");
    try {
        String movimento = scanner.next();
        movimentoGiocatore(movimento);
    } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("SEI RIUSCITO A SCAPPARE");
        break;
    }

}
    }
}
