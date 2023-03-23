package com.knoldus.vehicleworking
import scala.util.Try

case class VehicleCar() {

  private val fuelCapacity = 50

  // Stateful Object
  private var fuel = 50
  def currentFuel: Int = fuel

  // Function to move the vehicle.
  def moveTheVehicle(): String = {
    Try {
      if (fuel >= 20) {
        fuel -= 20
        "The Vehicle is moving..."
      } else {
        throw new RuntimeException("There is not enough fuel..")
      }
    }.getOrElse(s"There is not enough fuel.. \nFailed to move the Vehicle")
  }

  // Function to fill the fuel.
  def fillTheFuel(): Int = {
    Try {
      fuel += fuelCapacity - fuel
      fuel
    }.getOrElse(throw new RuntimeException("Error: Failed to fill the fuel"))
  }
}

