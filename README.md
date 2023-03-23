# Working-Of-Vehicle

## Problem Statement

#### Create a program to illustrate the working of a vehicle(bike, car, truck) where the vehicle would have a fuel capacity. Create 2 methods - one which would move the vehicle and reduce the fuel from it, another one which would fill the fuel into the vehicle. Show how would the vehicle go on to a journey. Use stateful object for the vehicle to hold the current fuel value.
Considerations -

    The fuel capacity of the vehicle is 50 ltrs
    Moving the vehicle once reduces 20 ltrs
    You have to move the vehicle 3 times

Hint - We can move the vehicle 2 times and refuel the vehicle and move the vehicle again.'


### Source Code for the problem

```
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
```


### Test Cases For the Program

```
package com.knoldus.vehicleworking
import org.scalatest.flatspec.AnyFlatSpec

class VehicleCarSpec extends AnyFlatSpec {

  private val vehicleCarObject = VehicleCar()

  it should "move the vehicle and consume the fuel" in{
    vehicleCarObject.moveTheVehicle()
    assert(vehicleCarObject.currentFuel == 30)
    vehicleCarObject.moveTheVehicle()
    assert(vehicleCarObject.currentFuel == 10)
    assert(vehicleCarObject.moveTheVehicle() == s"There is not enough fuel.. \nFailed to move the Vehicle")
  }

  it should "Refuel the vehicle and move it the third time" in {
    vehicleCarObject.fillTheFuel()
    assert(vehicleCarObject.currentFuel == 50)
    assert(vehicleCarObject.moveTheVehicle() == "The Vehicle is moving...")
  }
}
```
