// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import SOTAlib.Config.ConfigUtils;
import SOTAlib.Config.MotorControllerConfig;
import SOTAlib.Control.SOTA_Xboxcontroller;
import SOTAlib.Factories.MotorControllerFactory;
import SOTAlib.MotorController.SOTA_MotorController;
import Subsystems.TankDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class RobotContainer {

  private ConfigUtils configUtils;
  private SOTA_Xboxcontroller controller = new SOTA_Xboxcontroller(0);
  private TankDrive tDrive;

  public RobotContainer() {
    this.configUtils = new ConfigUtils();

    try {
      SOTA_MotorController leftMotor = MotorControllerFactory.generateMotorController(
        configUtils.readFromClassPath(MotorControllerConfig.class, "leftMotor"));
      SOTA_MotorController rightMotor = MotorControllerFactory.generateMotorController(
        configUtils.readFromClassPath(MotorControllerConfig.class, "rightMotor"));
      tDrive = new TankDrive(leftMotor, rightMotor);
    } catch (Exception e) {
      System.out.println(e.getStackTrace());
    }
    tDrive.setDefaultCommand(new InstantCommand(() -> tDrive.drive(controller.getLeftY(), controller.getRightY()), tDrive));
    configureBindings();
  }

  private void configureBindings() {
    
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
