// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.DrivebaseSubsystem;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
 
  private final MotorController m_rightDrive1 = new Talon(Constants.CanConstants.kdriveMotorRight1);
  private final MotorController m_rightDrive2 = new Talon(Constants.CanConstants.kdriveMotorRight2);
  private final MotorController m_leftDrive1 = new Talon(Constants.CanConstants.kdriveMotorLeft1);
  private final MotorController m_leftDrive2 = new Talon(Constants.CanConstants.kdriveMotorLeft2);

  private final DifferentialDrive m_drive;

  public DriveSubsystem() {

    m_leftDrive1.setInverted(true);
    m_leftDrive2.setInverted(true);

    MotorControllerGroup leftControllers = new MotorControllerGroup(m_leftDrive1, m_leftDrive2);
    MotorControllerGroup rightControllers = new MotorControllerGroup(m_rightDrive1, m_rightDrive2);
    
    m_drive = new DifferentialDrive(leftControllers, rightControllers);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


  public void arcadeDrive(double fwd, double rot)
  { 
    m_drive.arcadeDrive(fwd, rot);
  }




}
