package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.Range;

public class Drive {

    DcMotor frontLeft, frontRight, rearLeft, rearRight;

    double drive, turn, strafe, frontLeftPower, frontRightPower, rearLeftPower, rearRightPower;

    public Drive(DcMotor frontLeft, DcMotor frontRight, DcMotor rearLeft, DcMotor rearRight) {
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        this.rearLeft = rearLeft;
        this.rearRight = rearRight;
        //TODO: Reverse the directions of the motors as required (Lollback)
        // frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        // rearLeft.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    public void drive(Gamepad gamepad1) {
        drive = gamepad1.left_stick_y * -1;
        turn = gamepad1.right_stick_x;
        strafe = gamepad1.left_stick_x * 1; // TODO: This coefficient will likely need to be tuned to fix imperfect strafing.

        frontLeftPower = Range.clip(drive + turn + strafe, -1, 1);
        rearLeftPower = Range.clip(drive + turn - strafe, -1, 1);
        frontRightPower = Range.clip(drive - turn - strafe, -1, 1);
        rearRightPower = Range.clip(drive - turn + strafe, -1, 1);

        frontLeft.setPower(frontLeftPower);
        rearLeft.setPower(rearLeftPower);
        frontRight.setPower(frontRightPower);
        rearRight.setPower(rearRightPower);


    }

}
