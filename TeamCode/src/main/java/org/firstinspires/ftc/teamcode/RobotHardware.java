package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Formal class for organizing all RobotHardware for usage across different Telop/Autonomous driving modes.
 * Contains references to HardwareMap and all motors, encoders and sensors used.
 */
public class RobotHardware {
    public DcMotor motorOne = null;
    public DcMotor motorTwo = null;

    HardwareMap hwMap =  null;

    public RobotHardware(){
    }

    public void init(HardwareMap hwMap) {
        // Save reference to Hardware map
        this.hwMap = hwMap;

        motorOne = hwMap.get(DcMotor.class, "motorOne");
        motorTwo = hwMap.get(DcMotor.class, "motorTwo");

        // Motor direction is FORWARD by default
        motorOne.setDirection(DcMotor.Direction.FORWARD);
        motorTwo.setDirection(DcMotor.Direction.FORWARD);

        // Set all motors to zero power
        motorOne.setPower(0);
        motorTwo.setPower(0);

        // Set all motors to run without encoders.
        motorOne.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorTwo.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Motors will break on Zero power
        motorOne.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorTwo.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
}
