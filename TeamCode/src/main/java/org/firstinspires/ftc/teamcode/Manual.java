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

    // https://charbase.com/block/block-elements
    // http://jkorpela.fi/chars/spaces.html

    int barWidth = 30;
    String spaceChar = "\u2005\u2005\u2005"; // "   " = 1/4em * 3
    String barChar = "\u2588"; // "█" = ~1em

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

    /**
     * Like Math.max, but dependent on magnitude (ignores signage)
     * @return The float with the highest magnitude, preferring param A.
     */
    public static float maxMagnitude(float a, float b) {
        return Math.abs(a) >= Math.abs(b) ? a : b;
    }

    /**
     * @param sub The String to be repeated
     * @param repeat The number of times to repeat the String
     * @return A new string made out of the sub string repeated a certain number of times.
     */
    public static String repeat(String sub, int repeat) {
        return new String(new char[repeat]).replace("\0", sub);
    }

    /**
     * Create a progressbar out of Unicode characters.
     * @param level The level of the progressbar to be rendered.
     * @return A progressbar made out of Unicode block and space characters with a certain percent filling.
     */
    public String createLevel(float level) {
        int barCount = Math.round(Math.abs(level) * this.barWidth);
        String bars = repeat(this.barChar, barCount);
        String spaces = repeat(this.spaceChar, this.barWidth - barCount);
        return (level >= 0 ? "+" : "-") + " [" + bars + spaces + "]";
    }

    // Loop on start()
    @Override
    public void loop() {
        // Calculate inputs
        float inputOne = maxMagnitude(gamepad1.left_stick_x, gamepad1.left_stick_y);
        float inputTwo = maxMagnitude(gamepad1.right_stick_x, gamepad1.right_stick_y);
        float inputThree = maxMagnitude(gamepad2.left_stick_x, gamepad2.left_stick_y);
        float inputFour = maxMagnitude(gamepad2.right_stick_x, gamepad2.right_stick_y);

        // Set power to inputs
        robot.motorOne.setPower(inputOne);
        robot.motorTwo.setPower(inputTwo);
        robot.motorThree.setPower(inputThree);
        robot.motorFour.setPower(inputFour);

        // Print input telemetry, power level bars
        telemetry.addData("Elapsed", runTime.seconds());
        telemetry.addLine(createLevel(inputOne));
        telemetry.addLine(createLevel(inputTwo));
        telemetry.addLine(createLevel(inputThree));
        telemetry.addLine(createLevel(inputFour));
        telemetry.update();
    }

    // run once on stop()
    @Override
    public void stop() {
    }
}

