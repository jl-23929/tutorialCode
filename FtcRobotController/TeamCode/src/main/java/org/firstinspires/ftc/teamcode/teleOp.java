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

        while (opModeIsActive()) {
            drivebase.fieldDrive(gamepad1);
            if (gamepad1.a) {
                FSM.setRobotState(FSM.RobotState.INTAKE_OPEN);
            }
            if (gamepad1.b) {
                FSM.setRobotState(FSM.RobotState.OUTTAKE_OPEN);
            }
            telemetry.addData("Current Draw: ", robot.getCurrent());
        }
    }
}