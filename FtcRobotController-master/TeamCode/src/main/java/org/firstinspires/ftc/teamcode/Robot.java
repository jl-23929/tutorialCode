package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.List;

public class Robot {

    public Claw claw = null;
    public Arm arm = null;
    public Drive drive = null;
    HardwareMap hardwareMap;
    Telemetry telemetry;
    DcMotor frontLeft, frontRight, rearLeft, rearRight, armMotor;
    Servo leftClaw, rightClaw;

    public Robot(HardwareMap map ) {


    //    this.armMotor = armMotor;

    //    this.leftClaw = leftClaw;
    //    this.rightClaw = rightClaw;

        // Init Module class
    //    claw = new Claw(leftClaw, rightClaw);
    //    arm = new Arm(armMotor);
        drive = new Drive(map);
    }
}