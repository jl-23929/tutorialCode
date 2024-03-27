package org.firstinspires.ftc.teamcode;


import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.controller.PIDFController;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Arm {
    DcMotor armMotor;

    double kP, kI, kD, kF;

    double motorTicks = 288; //TODO: Check value.
    PIDController armController;

    public Arm(DcMotor armMotor) {
        this.armMotor = armMotor;
        armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void runToPosition(int target) {
        armController.setPID(kP, kI, kD);

        int armPos = armMotor.getCurrentPosition();

        double pid = armController.calculate(armPos, target);

        double ff = Math.cos(Math.toRadians(target/motorTicks)) * kF;

        double power = pid+ff;

        armMotor.setPower(power);
    }

}
