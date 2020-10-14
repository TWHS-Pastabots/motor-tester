package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "Manual")
public class Manual extends OpMode {

    RobotHardware robot = new RobotHardware();
    ElapsedTime runTime = new ElapsedTime();
    double slowCon = 0.8;

    // https://charbase.com/block/block-elements
    // http://jkorpela.fi/chars/spaces.html

    int barWidth = 34;
    static final String space = "\u2591"; // "   " = 1/4em * 3
    static final String bar = "\u2588"; // "█" = ~1em

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
     *
     * @return The float with the highest magnitude, preferring param A.
     */
    public static float maxMagnitude(float a, float b) {
        return Math.abs(a) >= Math.abs(b) ? a : b;
    }

    /**
     * @param sub    The String to be repeated
     * @param repeat The number of times to repeat the String
     * @return A new string made out of the sub string repeated a certain number of times.
     */
    public static String repeat(String sub, int repeat) {
        return new String(new char[repeat]).replace("\0", sub);
    }

    /**
     * @param duration The duration of the time to be printed
     * @return A human readable representation of a positive duration
     */
    public static String getHumanDuration(float duration) {
        if (duration > 3600) {
            int hours = (int) (duration / 3600);
            int minutes = (int) ((duration % 3600) / 60);
            int seconds = (int) (duration % 60);
            return String.format("%d hours, %d minutes and %d seconds", hours, minutes, seconds);
        } else if (duration > 60) {
            int minutes = (int) (duration / 60);
            int seconds = (int) (duration % 60);
            return String.format("%d minutes and %d seconds", minutes, seconds);
        } else if (duration > 0) {
            return String.format("%d seconds", Math.round(duration));
        }
        return "";
    }

    /**
     * Create a progressbar out of Unicode characters.
     *
     * @param level The level of the progressbar to be rendered.
     * @return A progressbar made out of Unicode block and space characters with a certain percent filling.
     */
    public String createLevel(float level) {
        StringBuilder builder = new StringBuilder("[");
        int halfWidth = this.barWidth / 2;
        int barCount = Math.round(Math.abs(level) * halfWidth);

        // Credit to Matt P. (@BSFishy) for the idea - expanding the bar to show signage like a numberline
        builder.append(repeat(space, halfWidth));
        builder.append(repeat(bar, barCount));
        builder.append(repeat(space, halfWidth - barCount));
        builder.append("]");

        if (level < 0)
            builder.reverse();

        return builder.toString();
    }

    /**
     * Easing function from https://easings.net/#easeInSine
     *
     * @param number A value in the 0.0 to 1.0 range
     * @return A value with the easeInSine easing function applied
     */
    public static float easeInSine(float number) {
        return (float) (1 - Math.cos((number * Math.PI) / 2));
    }

    // Loop on start()
    @Override
    public void loop() {
        // Calculate inputs using easeInSine easing function
        float inputOne = easeInSine(maxMagnitude(gamepad1.left_stick_x, gamepad1.left_stick_y));
        float inputTwo = easeInSine(maxMagnitude(gamepad1.right_stick_x, gamepad1.right_stick_y));
        float inputThree = easeInSine(maxMagnitude(gamepad2.left_stick_x, gamepad2.left_stick_y));
        float inputFour = easeInSine(maxMagnitude(gamepad2.right_stick_x, gamepad2.right_stick_y));

        // Set power to inputs
        robot.motorOne.setPower(inputOne);
        robot.motorTwo.setPower(inputTwo);
        robot.motorThree.setPower(inputThree);
        robot.motorFour.setPower(inputFour);

        // Print input telemetry, power level bars
        telemetry.addData("Started", getHumanDuration((float) runTime.seconds()) + " ago");
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

