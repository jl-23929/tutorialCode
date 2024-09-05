package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class classRobotDrive extends LinearOpMode {
    private Drive Drive;

    @Override
    public void runOpMode() {
        Drive = new Drive(this.hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            double drive = -gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x;
            double turn = gamepad1.right_stick_x;

            Drive.drive(drive, strafe, turn);
        }
    }
}