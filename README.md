# motor-tester

Note: This project is setup upon the base of the ultimate-goal repository we used, and thus is very similar at the time of creation.

This project was dedicated to servicing the teams in testing their motors efficiently, independent of the actual robot they constructed.

See below for how to configure the Robot Controller app and use the project.

## Configuration

We have set our standard configuration to use the 0, 1, 2, and 3 (zero indexed) ports on the Expansion Hub.

We also use the 20:1 REV Robotics HD Hex Motor, the 40:1 REV Robotics HD Hex Motor, and the REV Hex Core Motor.

| Slot ID | Motor Name | DeviceName |
| --- | --- | --- |
| 0 | REV Robotics Hex Core Motor | motorOne |
| 1 | 20:1 REV Robotics HD Hex Motor | motorTwo |
| 2 | 20:1 REV Robotics HD Hex Motor | motorThree |
| 3 | 40:1 REV Robotics HD Hex Motor | motorFour |

## Usage

This project is pretty simple and currently only uses the gamepad's sticks in Telop mode.

To use, plug in 1-2 gamepads. Then, move the sticks. Movements in the positive X/Y directions control
the power output of the motor. The direction of the stick controls the direction at which the
motor moves (forward or backward).

Gamepad 1 controls the first two motors, and Gamepad 2 the third and fourth.

Reminder: To activate gamepads, press Start + B (Gamepad 1) or Start + A (Gamepad 2).

## Meta

Version 6.0 (20200921-085816)

This repository contains the public FTC SDK for the Ultimate Goal (2020-2021) competition season.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[FtcRobotController Documentation](https://github.com/FIRST-Tech-Challenge/FtcRobotController/wiki)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[FTC Javadoc Documentation](https://first-tech-challenge.github.io/FtcRobotController)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[FTC Technology Forum](https://ftcforum.usfirst.org/forumdisplay.php?156-FTC-Technology)