package org.firstinspires.ftc.teamcode.modules;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class arm {
    static DcMotorEx arm;
    public static void init(HardwareMap hardwareMap) {
        arm = hardwareMap.get(DcMotorEx.class, "armMotor");
    }

}