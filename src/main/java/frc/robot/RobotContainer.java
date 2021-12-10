// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.control.XboxControllerButton;
import frc.robot.control.XboxControllerEE;
import frc.robot.subsystems.ArmSubsystem.ArmSubsystem;
import frc.robot.subsystems.ArmSubsystem.DriveArm;
import frc.robot.subsystems.DrivebaseSubsystem.ArcadeDrive;
import frc.robot.subsystems.DrivebaseSubsystem.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem.DriveIntake;
import frc.robot.subsystems.IntakeSubsystem.IntakeSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private final DriveSubsystem m_drive = new DriveSubsystem();
  private final IntakeSubsystem m_intake = new IntakeSubsystem();
  private final ArmSubsystem m_arm = new ArmSubsystem();

  public static XboxControllerEE m_controller = new XboxControllerEE(0);

  // The robot's subsystems and commands are defined here...
 

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    m_drive.setDefaultCommand(
      new ArcadeDrive(m_drive, 
                      () -> m_controller.getLeftY(), 
                      () -> m_controller.getRightX()));

    m_arm.setDefaultCommand( 
	    new DriveArm(m_arm,
                  () -> m_controller.getRightTriggerAxis(),
                  () -> m_controller.getLeftTriggerAxis()));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new XboxControllerButton(m_controller, XboxController.Button.kA).whenPressed(new DriveIntake(m_intake, 0.5));

    new XboxControllerButton(m_controller, XboxController.Button.kY).whenPressed(new DriveIntake(m_intake, -0.5));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
