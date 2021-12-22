// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.DrivebaseSubsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
 
  private final WPI_TalonSRX m_rightDrive1 = new WPI_TalonSRX(Constants.CanConstants.kdriveMotorRight1);
  private final WPI_TalonSRX m_rightDrive2 = new WPI_TalonSRX(Constants.CanConstants.kdriveMotorRight2);
  private final WPI_TalonSRX m_leftDrive1 = new WPI_TalonSRX(Constants.CanConstants.kdriveMotorLeft1);
  private final WPI_TalonSRX m_leftDrive2 = new WPI_TalonSRX(Constants.CanConstants.kdriveMotorLeft2);

  private final DifferentialDrive m_drive;

  public DriveSubsystem() {

    m_leftDrive1.setInverted(true);
    m_leftDrive2.setInverted(true);

    MotorControllerGroup leftControllers = new MotorControllerGroup(m_leftDrive1, m_leftDrive2);
    MotorControllerGroup rightControllers = new MotorControllerGroup(m_rightDrive1, m_rightDrive2);
    
    m_drive = new DifferentialDrive(leftControllers, rightControllers);

    m_leftDrive1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    m_leftDrive2.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    m_rightDrive1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    m_rightDrive2.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);


  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


  public void arcadeDrive(double fwd, double rot)
  { 
    m_drive.arcadeDrive(fwd, rot);
  }

  public double getAvgEncoder(){
    return (m_leftDrive1.getSelectedSensorPosition() + m_rightDrive1.getSelectedSensorPosition() + m_rightDrive2.getSelectedSensorPosition() + m_leftDrive2.getSelectedSensorPosition())/4;
  }

  public void setDrive(double position){
    m_rightDrive1.set(ControlMode.Position, position);
    m_rightDrive2.set(ControlMode.Position, position);
    m_leftDrive1.set(ControlMode.Position, position);
    m_leftDrive2.set(ControlMode.Position, position);
  }

  public void pivotDriveRight(double velocity){
    m_rightDrive1.set(ControlMode.Velocity, -velocity);
    m_rightDrive2.set(ControlMode.Velocity, -velocity);
    m_leftDrive1.set(ControlMode.Velocity, velocity);
    m_leftDrive2.set(ControlMode.Velocity, velocity);
  }

  public void pivotDriveLeft(double velocity){
    m_rightDrive1.set(ControlMode.Velocity, velocity);
    m_rightDrive2.set(ControlMode.Velocity, velocity);
    m_leftDrive1.set(ControlMode.Velocity, -velocity);
    m_leftDrive2.set(ControlMode.Velocity, -velocity);
  }

}
