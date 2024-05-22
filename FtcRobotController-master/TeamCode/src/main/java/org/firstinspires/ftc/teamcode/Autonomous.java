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

        robot = new org.firstinspires.ftc.teamcode.Robot(hardwareMap);
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

