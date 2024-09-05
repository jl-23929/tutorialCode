package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class RobotDrive extends LinearOpMode {
    private DcMotor leftFront, rightFront, leftRear, rightRear;
    private Servo servo;
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        leftFront = hardwareMap.get(DcMotor.class, "left_front");
        rightFront = hardwareMap.get(DcMotor.class, "right_front");
        leftRear = hardwareMap.get(DcMotor.class, "left_rear");
        rightRear = hardwareMap.get(DcMotor.class, "right_rear");
        servo = hardwareMap.get(Servo.class, "servo");

        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftRear.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            double drive = -gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x;
            double turn = gamepad1.right_stick_x;

            double leftFrontPower = drive + strafe + turn;
            double rightFrontPower = drive - strafe - turn;
            double leftRearPower = drive - strafe + turn;
            double rightRearPower = drive + strafe - turn;

            leftFront.setPower(leftFrontPower);
            rightFront.setPower(rightFrontPower);
            leftRear.setPower(leftRearPower);
            rightRear.setPower(rightRearPower);

            if (gamepad1.a) {
                servo.setPosition(1.0);
            } else if (gamepad1.b) {
                servo.setPosition(0.0);
            }
        }
    }
}
