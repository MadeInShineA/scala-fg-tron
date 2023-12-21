package ScalaFGTron

import java.awt.Color

class SquareGrid (width: Int, height: Int, squareSize: Int){
  var squares: Array[Array[Square]] = populateGrid()

  /**
  Generates the different squares inside the grid
   */
  def populateGrid(): Array[Array[Square]] = {
    Array.tabulate(width / squareSize, height / squareSize) { (x, y) => new Square(x * squareSize, y * squareSize, Color.darkGray) }
  }

  /**
   *
   * @param x Index of the square in the grid's first dimension (x)
   * @param y Index of the square in the grid's second dimension (y)
   * @return The square at the x, y position inside the grid
   */
  def getSquare(x: Int, y: Int): Square = {
    assert(x <= width)
    assert(y <= height)
    squares(x)(y)
  }

  /**
   *
   * @param x X position on the display
   * @param y Y position on the display
   * @return  The square corresponding to the x and y position on the display
   */
  def getSquareFromPosition(x: Int, y: Int): Square = {
    assert(x <= width / squareSize)
    assert (y <= height / squareSize)
    squares(x / width)(y / height)
  }
}
