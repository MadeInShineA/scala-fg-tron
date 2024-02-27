package ScalaFGTron

import hevs.graphics.FunGraphics

import java.awt.Color
import java.awt.event.{KeyEvent, KeyListener}

object Runner extends App{
  val DISPLAY_WIDTH = 1200
  val DISPLAY_HEIGHT = 800
  val SQUARE_SIZE = 20
  val display = new FunGraphics(DISPLAY_WIDTH, DISPLAY_HEIGHT)
  val squareGrid = new SquareGrid(DISPLAY_WIDTH, DISPLAY_HEIGHT, SQUARE_SIZE)
  val SQUARE_BORDER_COLOR = Color.black
  var player1: Option[Player] = None
  val PLAYER1_COLOR = Color.cyan
  var player2: Option[Player] = None
  val PLAYER2_COLOR = Color.lightGray

  val keyboardManager = new KeyListener {
    override def keyTyped(e: KeyEvent): Unit = {}

    override def keyPressed(e: KeyEvent): Unit = {
      val keyCode = e.getKeyCode
      keyCode match {
        case KeyEvent.VK_W => {player1.get.orientation = Orientations.UP}
        case KeyEvent.VK_A => {player1.get.orientation = Orientations.LEFT}
        case KeyEvent.VK_S => {player1.get.orientation = Orientations.DOWN}
        case KeyEvent.VK_D => {player1.get.orientation = Orientations.RIGHT}

        case KeyEvent.VK_UP => {player2.get.orientation = Orientations.UP}
        case KeyEvent.VK_LEFT => {player2.get.orientation = Orientations.LEFT}
        case KeyEvent.VK_DOWN => {player2.get.orientation = Orientations.DOWN}
        case KeyEvent.VK_RIGHT=> {player2.get.orientation = Orientations.RIGHT}
      }
    }

    override def keyReleased(e: KeyEvent): Unit = {}
  }


  def drawGrid(): Unit = {
    for(x: Int <- squareGrid.squares.indices){
      for(y: Int <- squareGrid.squares(x).indices){
        val square = squareGrid.squares(x)(y)
        display.setColor(square.color)
        display.drawFillRect(x * SQUARE_SIZE, y * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE)
        display.setColor(SQUARE_BORDER_COLOR)
        display.drawRect(x * SQUARE_SIZE, y * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE)
      }
    }
  }

  def spawnPlayers(): Unit = {
    player1 = Some(new Player(0, 0, PLAYER1_COLOR,Orientations.RIGHT))
    for(i: Int <- 0 until player1.size){
      print(player1.size)
      val square =  squareGrid.getSquare(i, 0)
      square.color = PLAYER1_COLOR
      square.category = Categories.PLAYER
    }

    squareGrid.getSquare(0, 0).color = PLAYER1_COLOR



    player2 = Some(new Player(DISPLAY_WIDTH / SQUARE_SIZE, DISPLAY_HEIGHT / SQUARE_SIZE, PLAYER2_COLOR,Orientations.LEFT ))
    squareGrid.getSquare(DISPLAY_WIDTH / SQUARE_SIZE - 1, DISPLAY_HEIGHT / SQUARE_SIZE - 1).color = PLAYER2_COLOR
  }

  spawnPlayers()

  drawGrid()


}
