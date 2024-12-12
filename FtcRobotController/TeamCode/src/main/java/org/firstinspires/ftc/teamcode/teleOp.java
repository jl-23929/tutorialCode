package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.modules.clawIntake;
import org.firstinspires.ftc.teamcode.modules.drivebase;

@TeleOp(name = "Driver Controlled")
public class teleOp extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);

        waitForStart();

        clawIntake.clawState = clawIntake.ClawState.REST;

        while (opModeIsActive()) {
            drivebase.fieldDrive(gamepad1);

            telemetry.addData("Current Draw: ", robot.getCurrent());
        }
    }
}
