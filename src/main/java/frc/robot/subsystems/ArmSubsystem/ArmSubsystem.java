// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.ArmSubsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
 import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CanConstants;

public class ArmSubsystem extends SubsystemBase {
  /** Creates a new ArmSubsystem. */
  private final TalonSRX m_arm = new TalonSRX(CanConstants.karmMotor);

  public ArmSubsystem() {
    m_arm.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void driveArm(double speed){
    m_arm.set(ControlMode.PercentOutput, speed);
  }

  public double getEncoderValue(){
    //gets encoder value in degrees
    return m_arm.getSelectedSensorPosition()*(360/4096);
  }
  public void setArm(double position){
    m_arm.set(ControlMode.Position, position);
  }
  public void encoderValueGraph(){
    SmartDashboard.putNumber("encoder value", getEncoderValue());
  }
}
