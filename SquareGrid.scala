package ScalaFGTron

import java.awt.Color

class SquareGrid (xLength: Int, yLength: Int){
  var squares: Array[Array[Square]] = populateGrid()

  def populateGrid(): Array[Array[Square]] = {
    Array.tabulate(xLength, yLength) { (x, y) => new Square(x, y, Color.green) }
  }

  def getSquare(x: Int, y: Int): Square = {
    assert(x < xLength)
    assert(y < yLength)
    squares(x)(y)
  }

  def getSquareFromPosition(x: Int, y: Int, gridSize: Int): Square = {
    squares(x / gridSize)(y / gridSize)
  }
}
