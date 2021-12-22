// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class CanConstants{
        //these are the motors used
        public static final int kdriveMotorRight1 = 1;
        public static final int kdriveMotorRight2 = 2;
        public static final int kdriveMotorLeft1 = 3;
        public static final int kdriveMotorLeft2 = 4;
        public static final int kintakeMotor = 5;
        public static final int karmMotor = 6;
    }
    public static final class ArmConstants{
        
        //Arm Gains
        public static final double kP = 0.0;
        public static final double kI = 0.0;
        public static final double kD = 0.0;
        //max linear velocity of arm motor
        public static final double kVelocity = 0.4;
        //volts
        public static double kS = 0.0;
        public static double kCos = 0.0;
        //volts * seconds^2 / radians
        public static double kV = 0.0;
        public static double kAcceleration;
        //Encoder Value when intaking
        public static double kIntake = 0.0;
        //Encoder Value when stored
        public static double kStore = 85.0;

        /*
        Tuning PID 
        Increase kP until the motor oscillates around the setpoint
        Increase kD until the graph stabilizes on or close to the setpoint without oscillating 

        Calculating FeedForward
        kS and kCos should have units of volts, 
        kV should have units of volts * seconds / radians, 
        */
    }

    public static final class DriveConstants{

        public static final double kWheelCircumfrince = 0.5*Math.PI;
        //Arm Gains
        public static final double kP = 0.0;
        public static final double kI = 0.0;
        public static final double kD = 0.0;
        //max linear velocity of arm motor
        public static final double kVelocity = 0.4;
        //volts
        public static double kS = 0.0;
        public static double kCos = 0.0;
        //volts * seconds^2 / radians
        public static double kV = 0.0;
        public static double kAcceleration;
        //Encoder Value when intaking
        public static double kIntake = 0.0;
        //Encoder Value when stored
        public static double kStore = 85.0;
    }
}
