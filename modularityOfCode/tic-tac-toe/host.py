import socket 
import threading

# Global variables
# board = [" " for _ in range(9)]

class TicTacToe:
    def __init__(self):
        self.board = [[" ", " ", " "], [" ", " ", " "], [" ", " ", " "]]
        self.turn = "X"
        self.you = "X"
        self.opponent = "O"
        self.winner = None
        self.game_over = False
        self.counter = 0
        print("\nGame starting...")
        self.print_board()

    def host_game(self, host, port):
        server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        server.bind((host, port))
        server.listen(1)
        print("Waiting for opponent to connect...")
        client, _ = server.accept()
        print("Opponent connected! Game is starting.")
        
        self.you = "X"
        self.opponent = "O"
        threading.Thread(target=self.handle_connection, args=(client,)).start()
        server.close()

    def connect_to_game(self, host, port):
        client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        client.connect((host, port))
        print("Successfully connected to the game!")
        
        self.you = 'O'
        self.opponent = 'X'
        threading.Thread(target=self.handle_connection, args=(client,)).start()

    def handle_connection(self, client):
        while not self.game_over:
            if self.turn == self.you:
                self.handle_your_turn(client)
            else:
                self.handle_opponent_turn(client)
        client.close()

    def handle_your_turn(self, client):
        move = input('Enter your move (row, col): ')
        if self.check_valid_move(move.split(',')):
            row, col = map(int, move.split(','))
            self.make_move(row, col, self.you)
            self.turn = self.opponent
            client.send(f"MOVE:{move}".encode('utf-8'))
            if self.check_game_end(client):
                self.game_over = True
        else:
            print('Invalid move. Try again.')

    def handle_opponent_turn(self, client):
        print("Waiting for opponent's move...")
        data = client.recv(1024).decode('utf-8')
        if not data:
            self.game_over = True
            return
        if data.startswith("MOVE:"):
            self.process_opponent_move(data[5:], client)
        elif data.startswith("END:"):
            self.process_game_end(data[4:])

    def process_opponent_move(self, move, client):
        row, col = map(int, move.split(','))
        self.make_move(row, col, self.opponent)
        self.turn = self.you
        if self.check_game_end(client):
            self.game_over = True

    def process_game_end(self, result):
        if result == "WIN":
            print("You lose!")
        elif result == "LOSE":
            print("You win!")
        elif result == "TIE":
            print("It's a tie!")
        self.game_over = True

    def make_move(self, row, col, player):
        if self.game_over:
            return
        self.counter += 1
        self.board[row][col] = player
        self.print_board()

    def check_game_end(self, client):
        if self.check_winner():
            self.game_over = True
            if self.winner == self.you:
                print('You win!')
                client.send("END:LOSE".encode('utf-8'))
            else:
                print('You lose!')
                client.send("END:WIN".encode('utf-8'))
            return True
        elif self.counter == 9:
            self.game_over = True
            print("It's a tie!")
            client.send("END:TIE".encode('utf-8'))
            return True
        return False

    def check_valid_move(self, move):
        try:
            row, col = int(move[0]), int(move[1])
            if 0 <= row <= 2 and 0 <= col <= 2:
                return self.board[row][col] == " "
            return False
        except (ValueError, IndexError):
            return False
    
    def check_winner(self):
        for i in range(3):
            if self.board[i][0] == self.board[i][1] == self.board[i][2] != " ":
                self.winner = self.board[i][0]
                return True
            
        for i in range(3):
            if self.board[0][i] == self.board[1][i] == self.board[2][i] != " ":
                self.winner = self.board[0][i]
                return True
            
        if self.board[0][0] == self.board[1][1] == self.board[2][2] != " ":
            self.winner = self.board[0][0]
            return True
        if self.board[0][2] == self.board[1][1] == self.board[2][0] != " ":
            self.winner = self.board[0][2]
            return True
        
        return False

    def print_board(self):
        print("\n")
        print("     0   1   2")
        print("   ┌───┬───┬───┐")
        for i in range(3):
            print(f" {i} │", end=" ")
            for j in range(3):
                print(self.board[i][j], end=" │ ")
            print()
            if i != 2:
                print("   ├───┼───┼───┤")
        print("   └───┴───┴───┘")
        print("\n")

game = TicTacToe()
game.host_game("localhost", 5555)