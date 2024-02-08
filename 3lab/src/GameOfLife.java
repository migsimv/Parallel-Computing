
class GameOfLife {
    private final int rows;
    private final int cols;
    public int[][] board;
    private final int[][] tempBoard;
    public int iterationCount;

    public GameOfLife(int iterationCount, int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        this.board = new int[rows][cols];
        this.tempBoard = new int[rows][cols];
        this.iterationCount = iterationCount;
    }
    public void swap(int firstRow, int lastRow) {

        for (int i = firstRow; i <= lastRow; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = tempBoard[i][j];
            }
        }
    }


//
    public void updateNeighbourCount(int firstRow, int lastRow) {

        int neighbours = 0;
        for (int i = firstRow; i <= lastRow; i++) {
            for (int j = 0; j < cols; j++) {
                neighbours = 0;
                if ((j - 1) >= 0)
                    neighbours += board[i][j - 1];

                if ((j + 1) < cols)
                    neighbours += board[i][j + 1];

                if ((i - 1) >= 0) {
                    neighbours += board[i - 1][j];

                    if ((j - 1) >= 0)
                        neighbours += board[i - 1][j - 1];

                    if ((j + 1) < cols)
                        neighbours += board[i - 1][j + 1];
                }
                if ((i + 1) < rows) {
                    neighbours += board[i + 1][j];
                    if ((j - 1) >= 0)
                        neighbours += board[i + 1][j - 1];

                    if ((j + 1) < cols)
                        neighbours += board[i + 1][j + 1];
                }
                if (neighbours < 2 || neighbours > 3) {
                    tempBoard[i][j] = 0;
                } else if (neighbours == 2) {
                    if (board[i][j] == 1) {
                        tempBoard[i][j] = 1;
                    } else {
                        tempBoard[i][j] = 0;
                    }
                } else {
                    tempBoard[i][j] = 1;
                }
            }
        }

        if(firstRow == 0) {
            print(tempBoard);
        }
    }
    private void print(int[][] tempBoard) {
        System.out.println("********");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                if (tempBoard[i][j] == 1) {
                    System.out.print("|*");
                } else {
                    System.out.print("|_");
                }
            }
            System.out.println("|");
        }
    }

    public void start() {
        board[3][5] = 1;
        board[3][6] = 1;

        board[4][2] = 1;
        board[4][3] = 1;
        board[4][4] = 1;
        board[4][6] = 1;
        board[4][7] = 1;

        board[5][2] = 1;
        board[5][3] = 1;
        board[5][4] = 1;
        board[5][5] = 1;
        board[5][6] = 1;

        board[6][3] = 1;
        board[6][4] = 1;
        board[6][5] = 1;
    }}