class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> box = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.' && !row.add(c)) return false;
                c = board[j][i];
                if (c != '.' && !col.add(c)) return false;
                c = board[j/3 + i/3*3][j%3 + i%3*3];
                if (c != '.' && !box.add(c)) return false;
            }
            row.clear();
            col.clear();
            box.clear();
        }
        return true;
    }
}
