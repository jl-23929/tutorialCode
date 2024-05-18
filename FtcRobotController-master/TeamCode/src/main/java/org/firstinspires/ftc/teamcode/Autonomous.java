package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous
public class Autonomous extends OpMode {

    Robot robot;
    ElapsedTime timer;

    @Override
    public void init() {
        DcMotor frontLeft = hardwareMap.get(DcMotor.class, "frontLeft"),
                frontRight = hardwareMap.get(DcMotor.class, "frontRight"),
                rearLeft = hardwareMap.get(DcMotor.class, "rearLeft"),
                rearRight = hardwareMap.get(DcMotor.class, "rearRight");

        //   Servo leftClaw = hardwareMap.get(Servo.class, "leftClaw"), rightClaw = hardwareMap.get(Servo.class, "rightClaw");

        //   DcMotor armMotor = hardwareMap.get(DcMotor.class, "armMotor");
        robot = new org.firstinspires.ftc.teamcode.Robot(frontLeft, frontRight, rearLeft, rearRight/*, armMotor, leftClaw, rightClaw*/);
        telemetry.addData("Status: ", "Initialised");
        telemetry.update();
        timer = new ElapsedTime();
    }

    public void start() {
        timer.reset();
    }

    @Override
    public void loop() {
      /*  while (timer.seconds() <= 1) {
            robot.drive.driveForward();
        }
        robot.drive.stop();
        while (timer.seconds() <= 1.2) {
            robot.drive.driveBack();
        } */

        if (timer.seconds() <= 1) {
            robot.drive.driveForward();

        } else {
            robot.drive.stop();
        }

        if (timer.seconds() <= 1.2 && timer.seconds() > 1) {
        }
        if (timer.seconds() <= 1.4 && timer.seconds() > 1.2){
            robot.drive.driveBack();
        }

    }
}

