package org.firstinspires.ftc.teamcode;


import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.controller.PIDFController;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Arm {
    DcMotor armMotor;

    double kP, kI, kD, kF;


    double motorTicks = 288; //TODO: Check value for the motor used. (It will also need to be adapted for differing gear ratios) (Lollback)

    double ticksPerDegree = motorTicks/180;

    PIDController armController;

    public Arm(DcMotor armMotor) {
        this.armMotor = armMotor;
        armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        armController = new PIDController(kP, kI, kD);
    }

    public void runToPosition(int targetAngle) {
        armController.setPID(kP, kI, kD);

        int armPos = armMotor.getCurrentPosition();

        double pid = armController.calculate(armPos, targetAngle/motorTicks);

        double ff = Math.cos(Math.toRadians(targetAngle/ticksPerDegree)) * kF; //The cosine of the angle

        double power = pid+ff;

        armMotor.setPower(power);
    }


}
