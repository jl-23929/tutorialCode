package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.List;

public abstract class robot extends OpMode {

    public Claw clawModule = null;
    public Arm armModule = null;

    public Drive driveModule = null;

    public void initHardware() {

        Servo leftClaw = hardwareMap.get(Servo.class, "leftClaw");
        Servo rightClaw = hardwareMap.get(Servo.class, "rightClaw");
        DcMotor armMotor = hardwareMap.get(DcMotor.class, "armMotor");
        DcMotor frontLeft = hardwareMap.get(DcMotor.class, "frontLeft"),
                frontRight = hardwareMap.get(DcMotor.class, "frontRight"),
                rearLeft = hardwareMap.get(DcMotor.class, "rearLeft"),
                rearRight = hardwareMap.get(DcMotor.class, "rearRight");

        List<DcMotor> motors;
        motors = hardwareMap.getAll(DcMotor.class);
        for (DcMotor motor : motors) {
            motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
        // Init Module class
        clawModule = new Claw(leftClaw, rightClaw);
        armModule = new Arm(armMotor);
        driveModule = new Drive(frontLeft, frontRight, rearLeft, rearRight);
    //    telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry);
    }

}
