// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.DrivebaseSubsystem;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.DriveConstants;

public class DriveFeet extends CommandBase {
  /** Creates a new DriveFeet. */
  DriveSubsystem m_drive;
  double m_feet;
  double m_distance;
  ProfiledPIDController pPID = new ProfiledPIDController(DriveConstants.kP, DriveConstants.kI, DriveConstants.kD, 
      new TrapezoidProfile.Constraints(DriveConstants.kVelocity, DriveConstants.kAcceleration));

  public DriveFeet(DriveSubsystem drive, double feet) {
    m_drive = drive;
    m_feet = feet;
    addRequirements(m_drive);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // converts feet to encoder ticks
    m_distance = m_feet * (4096 / DriveConstants.kWheelCircumfrince);
    pPID.setGoal(m_distance);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drive.setDrive(pPID.calculate(m_drive.getAvgEncoder()));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
