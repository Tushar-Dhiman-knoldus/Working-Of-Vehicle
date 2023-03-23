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
