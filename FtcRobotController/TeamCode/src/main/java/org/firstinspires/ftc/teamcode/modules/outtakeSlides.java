package org.firstinspires.ftc.teamcode.modules;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class outtakeSlides {

    double spoolDiameter = 50; //TODO: This value needs to be tuned to match the spool diameter for the slides on the robot.
    double spoolCircumference = (int) (Math.PI*spoolDiameter); //pi*diamter is the formula for the circumference of a circle.

    int ticksPerRevolution = 188; //TODO: This needs to be set to the value of your motor. Keep in mind how gear ratios might change it.

    int ticks;


    DcMotorEx slideMotor;
    public void init(HardwareMap hardwareMap) {
        slideMotor = hardwareMap.get(DcMotorEx.class, "slideMotor");
        slideMotor.setTargetPositionTolerance(50);
    }

    public void high() {
        runToPosition(100);


    }

    public void low() {

    }

    public void runToPosition(double position) {
        ticks = (int) ((position/spoolCircumference) * ticksPerRevolution); //The number of ticks for the motor must be an integer.
        slideMotor.setTargetPosition(ticks);


    }
}
