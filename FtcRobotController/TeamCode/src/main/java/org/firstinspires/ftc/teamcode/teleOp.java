package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.robot.allHubs;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

@TeleOp
public class teleOp extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);

        waitForStart();
        while (opModeIsActive()) {
            drivebase.drive(gamepad1);

            telemetry.addData("Current Draw: ", robot.getCurrent());
        }
    }
}
