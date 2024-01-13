// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package Subsystems;

import SOTAlib.MotorController.SOTA_MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TankDrive extends SubsystemBase {

  SOTA_MotorController leftMotor;
  SOTA_MotorController rightMotor;

  /** Creates a new TankDrive. */
  public TankDrive(SOTA_MotorController leftMotor, SOTA_MotorController rightMotor) {
    this.leftMotor = leftMotor;
    this.rightMotor = rightMotor;
  }

  public void drive(double leftSpeed, double rightSpeed) {
    leftMotor.set(leftSpeed);
    rightMotor.set(rightSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
