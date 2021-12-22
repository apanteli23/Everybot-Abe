// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.DrivebaseSubsystem;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class PivotDrive extends CommandBase {
  /** Creates a new PivotDrive. */
  //true = right false = left
  boolean m_right;
  DriveSubsystem m_drive;
  public PivotDrive(DriveSubsystem drive, boolean right) {
    m_right = right;
    m_drive = drive;
    addRequirements(m_drive);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_right){
      m_drive.pivotDriveRight(0.5);
    }
    else if (m_right == false){
      m_drive.pivotDriveLeft(0.5);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.pivotDriveLeft(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
