import java.util.Scanner;

public class Ch08Q20 {
    //game rule
    static final int BOARD_SIZE = 7;
    static final int CHECK_SIZE = 7;
    //board piece setting
    static final int BLANK = 0;
    static final int RED = 1;
    static final int YELLOW = 2;
    //check board status
    static final int OK = 0;
    static final int FULL = -2;
    static final int POS_ERR = -1;
    //misc
    static final char SEPARATOR = '|';
    static final char BOTTOM = '-';

    public static void main(String[] args) {

        int[][] pieces;
        pieces = new int[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
                pieces[i][j] = BLANK;
            }
        }
        int status;
        int rounds = 0;
        int player;
        Scanner scan = new Scanner(System.in);
        int input;
        do {
            drawBoard(pieces);
            rounds++;
            if (rounds % 2 != 0) {
                player = RED;
            } else {
                player = YELLOW;
            }
            System.out.println();
            System.out.printf("Drop a %s disk at coloum (0-%d): ", (player == RED) ? "red" : "yellow", pieces.length);
            input = scan.nextInt();
            while (input > pieces.length - 1 || input < 0) {
                System.out.println("input error, please input again: ");
                input = scan.nextInt();
            }
            int boardStatus = modifyBoard(pieces, player, input);

            while (boardStatus != OK) {
                if (boardStatus == FULL) {
                    System.out.println("board is full. draw.");
                    return;
                }
                if (boardStatus != POS_ERR) {
                    System.out.println("Input error, please input again: ");
                    return;
                }
                boardStatus = modifyBoard(pieces, player, input);
            }
            status = checkBoard(pieces);
        } while (status == OK);
        drawBoard(pieces);
        System.out.println();
        System.out.printf("The %s player won, congratulations!", (player == RED) ? "red" : "yellow");
        System.out.println();
    }

    public static int checkBoard(int[][] pieces) {
        // 检测棋局状态

        return 0;
    }

    public static int modifyBoard(int[][] pieces, int player, int input) {
        for (int i = pieces.length - 1; i >= 0; i--) {
            if (pieces[i][input] == BLANK) {
                pieces[i][input] = player;
                return OK;
            }
        }
        if (isBoardFull(pieces)) {
            return FULL;
        }
        return POS_ERR;
    }

    public static boolean isBoardFull(int[][] pieces) {
        boolean full = true;
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces.length; j++) {
                if (pieces[i][j] == BLANK) {
                    full = false;
                    return full;
                }
            }
        }
        return full;
    }

    public static void drawBoard(int[][] pieces) {
        char displayed = ' ';
        for (int i = 0; i < pieces.length; i++) {
            System.out.print(SEPARATOR);
            for (int j = 0; j < pieces[i].length; j++) {
                switch (pieces[i][j]) {
                    case 0:
                        displayed = ' ';
                        break;
                    case 1:
                        displayed = 'R';
                        break;
                    case 2:
                        displayed = 'Y';
                        break;
                }
                System.out.print(displayed);
                System.out.print(SEPARATOR);
            }
            System.out.println();
        }
        for (int i = 0; i < pieces.length * 2 + 1; i++) {
            System.out.print('-');
        }
        System.out.println();
    }
}
