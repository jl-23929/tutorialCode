package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import com.qualcomm.hardware.bosch.BNO055IMU;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class RobotDriveFieldOrientated extends LinearOpMode {
    private DcMotor leftFront, rightFront, leftRear, rightRear;
    private Servo servo;
    private BNO055IMU imu;
    private ElapsedTime runtime = new ElapsedTime();
    private Orientation angles;

    @Override
    public void runOpMode() {
        leftFront = hardwareMap.get(DcMotor.class, "left_front");
        rightFront = hardwareMap.get(DcMotor.class, "right_front");
        leftRear = hardwareMap.get(DcMotor.class, "left_rear");
        rightRear = hardwareMap.get(DcMotor.class, "right_rear");
        servo = hardwareMap.get(Servo.class, "servo");

        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.RADIANS;
        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);

        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftRear.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            double drive = -gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x;
            double turn = gamepad1.right_stick_x;

            angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.RADIANS);
            double botHeading = angles.firstAngle;

            double rotX = strafe * Math.cos(botHeading) - drive * Math.sin(botHeading);
            double rotY = strafe * Math.sin(botHeading) + drive * Math.cos(botHeading);

            double leftFrontPower = rotY + rotX + turn;
            double rightFrontPower = rotY - rotX - turn;
            double leftRearPower = rotY - rotX + turn;
            double rightRearPower = rotY + rotX - turn;

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
