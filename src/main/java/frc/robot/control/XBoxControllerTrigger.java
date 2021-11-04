/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.control;

import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * One of the four arms of a {@link DPad} that gets its state from an {@link XboxController}.
 */
public class XBoxControllerTrigger extends Trigger
{

    private final XboxController m_controller;
    private final XboxController.Hand m_hand;

    /**
     * Create a DPad object for triggering commands.
     *
     * @param ctrlr   The XboxController object that has that DPad
     * @param dpadArm The DPad arm
     */
    public XBoxControllerTrigger(XboxController ctrlr, XboxController.Hand hand)
    {
        m_controller = ctrlr;
        m_hand = hand;
    }

    /**
     * Gets the state of the DPad arm.
     *
     * @return The state of the DPad arm (true = Pressed; false = Unpressed)
     */
    public boolean get()
    {
        return (m_controller.getTriggerAxis(m_hand) > 0.2);
    }

	
}
