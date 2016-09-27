/* NOTE:
 * - consider whether the analysis should be done in real-time (probably) or statically (board is complete)
 * - variable size N, M Board
 * - ***tradeoff between space and time complexity:
 *      if we don't care about space and want constant time, there are only 3^(N*M) board states,
 *      so store them all in a hashtable, and as the players mark spots, shift 1 bit into N*M-length int/long,
 *      and lookup in hashtable to see if it's a winning board state.
 *      otherwise, use solution below
 */


public enum DIRECTION {
  DOWN, DOWNRIGHT, RIGHT;
}

public boolean winnerTicTacToe(Board b){
  if(b.isInvalid()){
    /*
     *  checks for: min size N=3,M=3
     *
     *
     */
    throw new EmptyBoardException();
  }

  BoardSize size = b.getSize();
  Position p = new Position(0,0);
  char curr = b.get(p);

  boolean hasWinner = false;

  if(b.hasDown(p.x,p.y)){
    hasWinner ? hasWinner : seek(b, new Position(++p.x,p.y), curr, 1);
  }

  //diagonal case
  if(b.hasDiagonal(0,0)){
      hasWinner ? hasWinner : seek(b, new Position(++p.x,++p.y), curr, 1);
  }

  if(b.hasRight(0,0)){
      hasWinner ? hasWinner : seek(b, new Position(p.x,++p.y), curr, 1);
  }

  return hasWinner;
}

private boolean seek(Board b, Position p, char curr, DIRECTION prevDir, int consecutive){
  if (b.get(p) != null && b.get(p) == curr) {
    consecutive++;
    if(consecutive == 3){
      return true;
    }
  }
  else {
    consecutive = 1;
    curr = b.get(p);
  }

  if(b.hasDown(p)){
    return seek(b, new Position(++p.x,p.y), curr, DOWN == prevDir ? consecutive : 1);
  }

  //diagonal case
  //TODO: OPTIMIZE
  if(b.hasDiagonal(p)){
      return seek(b, new Position(++p.x,++p.y), curr, DOWNRIGHT == prevDir ? consecutive : 1);
  }

  if(b.hasRight(p)){
      return seek(b, new Position(p.x,++p.y), curr, RIGHT == prevDir ? consecutive : 1);
  }

  return false;
}


public Board{

get(Position);
isEmptyOrInvalid();
hasDown();
hasDiagonal();
hasRight();
}

//EmptyBoardException extends Exception
