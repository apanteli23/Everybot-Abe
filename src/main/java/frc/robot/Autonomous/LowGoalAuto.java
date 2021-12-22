// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Autonomous;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ArmSubsystem.ArmSubsystem;
import frc.robot.subsystems.ArmSubsystem.PIDTMPSetArm;
import frc.robot.subsystems.DrivebaseSubsystem.DriveFeet;
import frc.robot.subsystems.DrivebaseSubsystem.DriveSubsystem;
import frc.robot.subsystems.DrivebaseSubsystem.PivotDrive;
import frc.robot.subsystems.IntakeSubsystem.DriveIntake;
import frc.robot.subsystems.IntakeSubsystem.IntakeSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class LowGoalAuto extends SequentialCommandGroup {
  /** Creates a new LowGoalAuto. */
  ArmSubsystem m_arm;
  IntakeSubsystem m_intake;
  DriveSubsystem m_drive;
  public LowGoalAuto(ArmSubsystem arm, IntakeSubsystem intake, DriveSubsystem drive) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    m_arm = arm;
    m_intake = intake;
    m_drive = drive;
    addRequirements(m_arm,m_drive,m_intake);
    addCommands(
        new DriveFeet(m_drive, 6),
        new DriveIntake(m_intake, 0.8).withTimeout(5.0),
        new DriveFeet(m_drive, -1),
        new PivotDrive(m_drive, true).withTimeout(2.0),
        new DriveFeet(m_drive, 9),
        new PIDTMPSetArm(m_arm, false),
        new ParallelCommandGroup(
                                new DriveIntake(m_intake, 0.8),
                                new DriveFeet(m_drive, 2)),
        new PIDTMPSetArm(m_arm, true),
        new PivotDrive(m_drive, true).withTimeout(2.0),
        new DriveFeet(m_drive, 12.0),
        new DriveIntake(m_intake, 0.8).withTimeout(5.0)
    );
  }
}
