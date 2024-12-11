package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class drivebase {
    static DcMotor frontLeft, frontRight, rearLeft, rearRight;
    static IMU imu;

    static double y, x, rx, rotX, rotY, botHeading;
    static double denominator, frontLeftPower, frontRightPower, rearLeftPower, rearRightPower;
    static double strafingCoefficient = 1; //TODO: Tune this value until the robot strafes correctly. It is typically higher than 1.
    public static void init(HardwareMap hardwareMap) {
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        rearLeft = hardwareMap.get(DcMotor.class, "rearLeft");
        rearRight = hardwareMap.get(DcMotor.class, "rearRight");
        imu = hardwareMap.get(IMU.class, "imu");
// Adjust the orientation parameters to match your robot
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP, //TODO: This needs to match the orientation of the logo on the REV Hub relative to the robot.
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD)); //TODO: This needs to match the orientation of the USB Port on the REV Hub relative to the robot.
// Without this, the REV Hub's orientation is assumed to be logo up / USB forward
        imu.initialize(parameters);
    }
    public static void drive(Gamepad gamepad) {
        double y = -gamepad.left_stick_y; // The Y stick is reversed!
        double x = gamepad.left_stick_x * strafingCoefficient;
        double rx = gamepad.right_stick_x;

        //The denominator preserves the power ratio for controls, by redistributing them out of 1.
        denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);

        frontLeftPower = (y + x + rx) / denominator;
        rearLeftPower = (y - x + rx) / denominator;
        rearLeftPower = (y - x - rx) / denominator;
        rearRightPower = (y + x - rx) / denominator;

        frontLeft.setPower(frontLeftPower);
        rearLeft.setPower(rearLeftPower);
        frontLeft.setPower(frontLeftPower);
        frontLeft.setPower(frontLeftPower);
    }

    public static void fieldDrive(Gamepad gamepad) {
        if (gamepad.back) {
            imu.resetYaw(); //Can be used to reset the IMU in case of drift. Ensure the button used to activate it is hard to press. You don't want to do this accidentally.
        }

        y = -gamepad.left_stick_y; // The Y stick is reversed!
        x = gamepad.left_stick_x * strafingCoefficient;
        rx = gamepad.right_stick_x;

        botHeading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);

        rotX = x * Math.cos(-botHeading) - y * Math.sin(-botHeading);
        rotY = x * Math.sin(-botHeading) + y * Math.cos(-botHeading);

        rotX = rotX * 1.1;  // Counteract imperfect strafing

        // Denominator is the largest motor power (absolute value) or 1
        // This ensures all the powers maintain the same ratio,
        // but only if at least one is out of the range [-1, 1]
        denominator = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(rx), 1);
        frontLeftPower = (rotY + rotX + rx) / denominator;
        rearLeftPower = (rotY - rotX + rx) / denominator;
        frontRightPower = (rotY - rotX - rx) / denominator;
        rearRightPower = (rotY + rotX - rx) / denominator;

        frontLeft.setPower(frontLeftPower);
        rearLeft.setPower(rearLeftPower);
        frontRight.setPower(frontRightPower);
        rearRight.setPower(rearRightPower);

    }
}
