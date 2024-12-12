package org.firstinspires.ftc.teamcode.modules;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class extendo {
    static Servo extendoServo;

    public static void init(HardwareMap hardwareMap) {
        extendoServo = hardwareMap.get(Servo.class, "extendoServo");
    }


}
