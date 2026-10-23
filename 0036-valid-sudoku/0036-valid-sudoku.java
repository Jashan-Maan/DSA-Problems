class Solution {
    // Single pass — check row, col, box simultaneously for each cell.
    // One HashSet per row, col, and box (27 sets total).
    // Box index formula: (row/3)*3 + (col/3) → maps cell to 0-8.
    // HashSet.add() returns false if duplicate → elegant one-line check.
    // O(81) time — fixed board size makes this effectively O(1).
    public boolean isValidSudoku(char[][] board) {

        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] grids = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            grids[i] = new HashSet<>();
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char val = board[row][col];
                if (val == '.') {
                    continue;
                }
                if (rows[row].contains(val) || cols[col].contains(val)
                        || grids[(row / 3) * 3 + (col / 3)].contains(val)) {
                    return false;
                }
                rows[row].add(val);
                cols[col].add(val);
                grids[(row / 3) * 3 + (col / 3)].add(val);
            }
        }
        return true;
    }
}