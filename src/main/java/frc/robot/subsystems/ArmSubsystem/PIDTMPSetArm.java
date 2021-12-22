// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.ArmSubsystem;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ArmConstants;

public class PIDTMPSetArm extends CommandBase {
  /** Creates a new PIDTMPSetArm. */
  ArmSubsystem m_arm;
  ProfiledPIDController pPID = new ProfiledPIDController(ArmConstants.kP, ArmConstants.kI, ArmConstants.kD, 
                                         new TrapezoidProfile.Constraints(ArmConstants.kVelocity, ArmConstants.kAcceleration));
  Boolean m_state;
  public PIDTMPSetArm(ArmSubsystem arm, Boolean state) {
     m_state = state;
     m_arm = arm;
     addRequirements(m_arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(m_state){
      pPID.setGoal(ArmConstants.kStore);
    }
    else{
      pPID.setGoal(ArmConstants.kIntake);
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_arm.setArm(pPID.calculate(m_arm.getEncoderValue()));
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
