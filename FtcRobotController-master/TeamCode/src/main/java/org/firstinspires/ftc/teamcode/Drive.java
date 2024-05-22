package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

import java.util.List;

public class Drive {

    DcMotor frontLeft, frontRight, backLeft, backRight;

    double drive, turn, strafe, frontLeftPower, frontRightPower, backLeftPower, backRightPower;

    double power = 0.5;

    public Drive(HardwareMap map) {

        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");


        //TODO: Reverse the directions of the motors as required (Lollback)
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);

        List<DcMotor> motors;
        motors = map.getAll(DcMotor.class);
        for (DcMotor motor : motors) {
            motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }

    }


    public void driver(Gamepad gamepad1) {
        drive = gamepad1.left_stick_y * -1;
        turn = gamepad1.right_stick_x;
        strafe = gamepad1.left_stick_x * -1.1; // TODO: This coefficient will likely need to be tuned to fix imperfect strafing.

        frontLeftPower = Range.clip(drive + turn + strafe, -0.8, 0.8);
        backLeftPower = Range.clip(drive + turn - strafe, -0.8, 0.8);
        frontRightPower = Range.clip(drive - turn - strafe, -0.8, 0.8);
        backRightPower = Range.clip(drive - turn + strafe, -0.8, 0.8);

        frontLeft.setPower(frontLeftPower);
        backLeft.setPower(backLeftPower);
        frontRight.setPower(frontRightPower);
        backRight.setPower(backRightPower);


    }

    public void slowDriver(Gamepad gamepad2) {
        drive = gamepad2.left_stick_y * -1;
        turn = gamepad2.right_stick_x;
        strafe = gamepad2.left_stick_x * -1.1; // TODO: This coefficient will likely need to be tuned to fix imperfect strafing.

        frontLeftPower = Range.clip(drive + turn + strafe, -0.4, 0.4);
        backLeftPower = Range.clip(drive + turn - strafe, -0.4, 0.4);
        frontRightPower = Range.clip(drive - turn - strafe, -0.4, 0.4);
        backRightPower = Range.clip(drive - turn + strafe, -0.4, 0.4);

        frontLeft.setPower(frontLeftPower);
        backLeft.setPower(backLeftPower);
        frontRight.setPower(frontRightPower);
        backRight.setPower(backRightPower);


    }

    public void driveForward() {
        frontRight.setPower(power);
        frontLeft.setPower(power);
        backRight.setPower(power);
        backLeft.setPower(power);
    }

    public void driveBack() {
        frontRight.setPower(-power);
        frontLeft.setPower(-power);
        backRight.setPower(-power);
        backLeft.setPower(-power);
    }

    public void stop() {
        frontRight.setPower(0);
        frontLeft.setPower(0);
        backRight.setPower(0);
        backLeft.setPower(0);
    }
}
