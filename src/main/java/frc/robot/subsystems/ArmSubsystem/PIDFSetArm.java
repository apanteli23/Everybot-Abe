// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.ArmSubsystem;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ArmConstants;

public class PIDFSetArm extends CommandBase {
  /** Creates a new PIDFSetArm. */
  ArmSubsystem m_arm;
  double m_setPoint;
  PIDController pidArm = new PIDController(ArmConstants.kP, ArmConstants.kI, ArmConstants.kD);
  ArmFeedforward ffArm = new ArmFeedforward(ArmConstants.kS, ArmConstants.kCos, ArmConstants.kV);

  public PIDFSetArm(ArmSubsystem arm, double setPoint) {
    m_arm = arm;
    m_setPoint = setPoint;
    addRequirements(m_arm);  }


    @Override
    public void initialize() {
      //Change to a reasonable error tolerance based on results of tuning. 
      pidArm.setTolerance(0.5);
    }
  
    @Override
    public void execute() {
      m_arm.setArm(pidArm.calculate(m_arm.getEncoderValue(), m_setPoint)+ ffArm.calculate(m_setPoint * (Math.PI/180), ArmConstants.kVelocity, ArmConstants.kAcceleration));
      
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
