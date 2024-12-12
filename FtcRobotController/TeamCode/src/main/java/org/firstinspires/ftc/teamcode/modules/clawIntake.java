package org.firstinspires.ftc.teamcode.modules;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class clawIntake {

    static Servo clawServo, clawRotation;
    ;

    public static void init(HardwareMap hardwareMap) {

        clawServo = hardwareMap.get(Servo.class, "clawServo");
        clawRotation = hardwareMap.get(Servo.class, "clawRotation");
    }


    public static void close() {
        clawServo.setPosition(0);
    }

    public static void intakePos() {
        clawRotation.setPosition(0);
    }

    public static void outtakePos() {
        clawRotation.setPosition(1);
    }

    public static void restPos() {
        clawRotation.setPosition(0.5);
    }

    public static void open() {

        clawServo.setPosition(1);
    }

}
