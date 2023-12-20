package ScalaFGTron

import hevs.graphics.FunGraphics

import java.awt.Color

object Runner extends App{
  val DISPLAY_WIDTH = 1200
  val DISPLAY_HEIGHT = 800
  val SQUARE_SIZE = 20
  val display = new FunGraphics(DISPLAY_WIDTH, DISPLAY_HEIGHT)
  val squareGrid = new SquareGrid(DISPLAY_WIDTH / SQUARE_SIZE, DISPLAY_HEIGHT / SQUARE_SIZE)
  var player1: Option[Player] = None
  val PLAYER1_COLOR = Color.cyan
  var player2: Option[Player] = None
  val PLAYER2_COLOR = Color.lightGray


  def drawGrid(): Unit = {
    for(x: Int <- squareGrid.squares.indices){
      for(square: Square <- squareGrid.squares(x)){
        display.setColor(square.color)
        display.drawFillRect(square.xPosition * SQUARE_SIZE, square.yPosition * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE)
        display.setColor(Color.black)
        display.drawRect(square.xPosition * SQUARE_SIZE, square.yPosition * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE)
      }
    }
  }

  def spawnPlayers(): Unit = {
    player1 = Some(new Player(0, 0, PLAYER1_COLOR,Orientation.RIGHT ))
    squareGrid.getSquare(0, 0).color = PLAYER1_COLOR

    player2 = Some(new Player(DISPLAY_WIDTH / SQUARE_SIZE, DISPLAY_HEIGHT / SQUARE_SIZE, PLAYER2_COLOR,Orientation.RIGHT ))
    squareGrid.getSquare(DISPLAY_WIDTH / SQUARE_SIZE - 1, DISPLAY_HEIGHT / SQUARE_SIZE - 1).color = PLAYER2_COLOR
  }

  spawnPlayers()

  drawGrid()


}
