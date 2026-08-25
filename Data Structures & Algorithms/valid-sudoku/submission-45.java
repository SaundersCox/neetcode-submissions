class Solution {
    public boolean isValidSudoku(char[][] board) {

        // need to handle 9 rows, 9 cols, 9 boxes, each with 9 unique elements
        for (int i = 0; i < 9; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> box = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char c = board[i][j]; // traverses row
                if (c != '.' && !row.add(c)) return false;

                c = board[j][i]; // traverses col
                if (c != '.' && !col.add(c)) return false;
                // INNER
                // 012 012 012 -> reset every 3 j%3,
                // but every 9 add 3 (+ 000 333 666 -> i*3), 
                // but reset every 27 i%3
                // [j%3 + i%3*3]

                // OUTER
                // 000 111 222 ->  j/3
                // but every 27 add 3 -> i/3*3
                // [j/3 + i/3*3]
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
