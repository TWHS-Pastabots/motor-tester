package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "Manual", group = "Linear OpMode")
public class Manual extends OpMode {

    /* Declare OpMode members. */
    RobotHardware robot = new RobotHardware();
    ElapsedTime runTime = new ElapsedTime();
    double slowCon = 0.8;

    //run once on init()
    @Override
    public void init() {
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Initialized");    //
    }

    // loop on init()
    @Override
    public void init_loop() {
    }

    // Run once on start()
    @Override
    public void start() {
        runTime.reset();
        telemetry.addData("Run Time", "reset");
    }

    // Loop on start()
    @Override
    public void loop() {
        // Calculate inputs
        float inputOne = Math.max(gamepad1.left_stick_x, gamepad1.left_stick_y);
        float inputTwo = Math.max(gamepad1.right_stick_x, gamepad1.right_stick_y);

        // Set power to inputs
        robot.motorOne.setPower(inputOne);
        robot.motorTwo.setPower(inputTwo);

        // Print input telemetry, power level bars
        telemetry.addData("Elapsed", runTime.seconds());
        telemetry.addData("Input 1:", inputOne);
        telemetry.addData("Input 2:", inputTwo);

        telemetry.update();
    }

    // run once on stop()
    @Override
    public void stop() {
    }
}

