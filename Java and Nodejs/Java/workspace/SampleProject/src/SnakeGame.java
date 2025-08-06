import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class SnakeGame {

    private static final int WIDTH = 20;
    private static final int HEIGHT = 20;
    private static final char SNAKE_BODY = 'O';
    private static final char SNAKE_HEAD = '@';
    private static final char FOOD = '*';
    private static final char EMPTY = ' ';

    private LinkedList<int[]> snake;
    private int[] food;
    private int[] direction;
    private boolean isGameOver;

    public SnakeGame() {
        snake = new LinkedList<>();
        snake.add(new int[]{HEIGHT / 2, WIDTH / 2});
        direction = new int[]{0, 1};
        isGameOver = false;
        generateFood();
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (!isGameOver) {
            printBoard();

            // Get the next move
            System.out.print("Enter direction (WASD): ");
            String input = scanner.next().toUpperCase();
            switch (input) {
                case "W":
                    direction = new int[]{-1, 0};
                    break;
                case "A":
                    direction = new int[]{0, -1};
                    break;
                case "S":
                    direction = new int[]{1, 0};
                    break;
                case "D":
                    direction = new int[]{0, 1};
                    break;
                default:
                    System.out.println("Invalid input. Use WASD.");
                    continue;
            }

            // Move the snake
            int[] head = snake.getFirst();
            int[] newHead = new int[]{head[0] + direction[0], head[1] + direction[1]};

            // Check for collision with walls or itself
            if (newHead[0] < 0 || newHead[0] >= HEIGHT || newHead[1] < 0 || newHead[1] >= WIDTH || snake.contains(newHead)) {
                isGameOver = true;
                System.out.println("Game Over!");
                break;
            }

            // Check for food
            if (newHead[0] == food[0] && newHead[1] == food[1]) {
                generateFood();
            } else {
                snake.removeLast();
            }

            snake.addFirst(newHead);
        }
    }

    private void printBoard() {
        char[][] board = new char[HEIGHT][WIDTH];

        // Initialize board with empty cells
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                board[i][j] = EMPTY;
            }
        }

        // Place snake on board
        for (int[] segment : snake) {
            board[segment[0]][segment[1]] = SNAKE_BODY;
        }
        int[] head = snake.getFirst();
        board[head[0]][head[1]] = SNAKE_HEAD;

        // Place food on board
        board[food[0]][food[1]] = FOOD;

        // Print the board
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private void generateFood() {
        Random random = new Random();
        int row, col;
        do {
            row = random.nextInt(HEIGHT);
            col = random.nextInt(WIDTH);
        } while (snake.contains(new int[]{row, col}));
        food = new int[]{row, col};
    }

    public static void main(String[] args) {
        SnakeGame game = new SnakeGame();
        game.play();
    }
}
