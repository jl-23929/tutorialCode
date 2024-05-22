package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Basic TeleOp", group = "TeleOp")
//Telemetry Operated OpModes are located underneath the right button of the Driver Station, while Autonomous OpModes are under the left. Putting the group as TeleOp is unnecessary. (Lollback)
public class OpMode extends com.qualcomm.robotcore.eventloop.opmode.OpMode {

    Robot robot;

    @Override
    public void init() {

        //   Servo leftClaw = hardwareMap.get(Servo.class, "leftClaw"), rightClaw = hardwareMap.get(Servo.class, "rightClaw");

        //   DcMotor armMotor = hardwareMap.get(DcMotor.class, "armMotor");
        robot = new org.firstinspires.ftc.teamcode.Robot(hardwareMap);
        telemetry.addData("Status: ", "Initialised");
        telemetry.update();
    }

    @Override
    public void loop() {
        if (gamepad1.right_bumper) {
            robot.drive.driver(gamepad1);
        } else {
            robot.drive.slowDriver(gamepad1);

        }
     /*   if (gamepad1.a) {
            robot.claw.leftClawOpen();
        }
        if (gamepad1.b) {
            robot.claw.rightClawOpen();
        }

        if (gamepad1.right_bumper) {
            robot.arm.runToPosition(90);
        }

        if (gamepad1.left_bumper) {
            robot.arm.runToPosition(0);
        } */

    }
}
