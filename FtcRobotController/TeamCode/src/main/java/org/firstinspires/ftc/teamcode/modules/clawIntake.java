package org.firstinspires.ftc.teamcode.modules;

import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcontroller.external.samples.SensorREV2mDistance;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class clawIntake {

    static Servo clawServo, clawRotation;

    static DistanceSensor clawSensor;

    static boolean pieceDetected;

    public static void init(HardwareMap hardwareMap) {

        clawServo = hardwareMap.get(Servo.class, "clawServo");
        clawRotation = hardwareMap.get(Servo.class, "clawRotation");
        clawSensor = hardwareMap.get(DistanceSensor.class, "clawSensor");
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

    public static void transferPos() {
        clawRotation.setPosition(0.5);
    }

    public static void open() {

        clawServo.setPosition(1);
    }

    public static boolean gamePiece() {
        if (clawSensor.getDistance(DistanceUnit.MM) > 5) {
            pieceDetected = false;
        } else {
            pieceDetected = true;
        }
        return pieceDetected;
    }

}
