// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.ArmSubsystem;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveArm extends CommandBase {
  /** Creates a new DriveIntake. */
  ArmSubsystem m_arm;
  DoubleSupplier m_fSpeed, m_rSpeed;

  //m_rSpeed reverse speed - left trigger
  //m_fSpeed forward speed - right trigger 

  public DriveArm(ArmSubsystem arm, DoubleSupplier fSpeed, DoubleSupplier rSpeed) {
    m_arm = arm;
    m_fSpeed = fSpeed;
    m_rSpeed = rSpeed;
    addRequirements(m_arm);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(Math.abs(m_fSpeed.getAsDouble()) > 0.0){
    m_arm.driveArm(Math.abs(m_fSpeed.getAsDouble()));
    }
    if(Math.abs(m_rSpeed.getAsDouble()) > 0.0){
    m_arm.driveArm(-(Math.abs(m_rSpeed.getAsDouble())));
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_arm.driveArm(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
