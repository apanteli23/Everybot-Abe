// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.ArmSubsystem;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

public class PIDSetArm extends CommandBase {
  //This is going to use basic PID to set the arm to a specific setpoint

  //This can also be done in a seperate subsystem 
  //but for simplicity it is going to all be here 
  //and there can only be one type of PID for the motor
  ArmSubsystem m_arm;
  double m_setPoint; 
  PIDController pidArm = new PIDController(Constants.ArmConstants.kP, Constants.ArmConstants.kI, Constants.ArmConstants.kD);
  public PIDSetArm(ArmSubsystem arm, double setPoint) {
    m_arm = arm;
    m_setPoint = setPoint;
    addRequirements(m_arm);
  }

  @Override
  public void initialize() {
    //Change to a reasonable error tolerance based on results of tuning. 
    pidArm.setTolerance(0.5);
  }

  @Override
  public void execute() {
    m_arm.setArm(pidArm.calculate(m_arm.getEncoderValue(), m_setPoint));
  }

  @Override
  public void end(boolean interrupted) {
    pidArm.reset();
    m_arm.driveArm(0.0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
