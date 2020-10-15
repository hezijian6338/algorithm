import copy

def queens():

    res = []
    def solveNQueens(n):
        board = [['.']*n for i in range(n)]
        bracktrack(board, 0)
        return res
    

    def bracktrack(board, row):
        if len(board) == row:
            res.append(copy.deepcopy(board))
            return
        
        n = len(board)
        for i in range(0, n, 1):
            if (not isValid(board, row, i)):
                continue
            
            board[row][i] = 'Q'
            bracktrack(board, row + 1)
            board[row][i] = '.'
    

    def isValid(board, row, col) :
        n = len(board)
        for i in range(len(board)):
            if (board[i][col] == 'Q'):
                return False
        
        for i, j in zip(range(row - 1, -1, -1), range(col + 1, n, 1)):
            if (board[i][j] == 'Q'):
                return False

        for i, j in zip(range(row - 1, -1, -1), range(col - 1, -1, -1)):
            if (board[i][j] == 'Q'):
                return False
        
        return True
    
    return solveNQueens(5)

result = queens()

for r in result:
    for rr in r:
        print(rr),
    print('-------------------------')

