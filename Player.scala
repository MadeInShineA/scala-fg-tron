package ScalaFGTron

import java.awt.Color

class Player (var xPosition: Int, var yPosition: Int, val color: Color, var orientation: Orientations.Value, var size: Int = 3){
  def move(): Unit = {
    orientation match {
      case Orientations.UP => {yPosition -= 1}
      case Orientations.DOWN => {yPosition += 1}
      case Orientations.LEFT => {xPosition -= 1}
      case Orientations.RIGHT => {xPosition += 1}
    }
  }
}
