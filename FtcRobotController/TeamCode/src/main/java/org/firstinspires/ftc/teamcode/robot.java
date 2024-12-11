package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

import java.util.List;

public class robot {
    public static List<LynxModule> allHubs;
    static double totalCurrent = 0;

    public static void init(HardwareMap hardwareMap) {
        drivebase.init(hardwareMap);

        //Lynx Module enables bulk reading of sensors, lowering loop times.
        allHubs = hardwareMap.getAll(LynxModule.class);
        for (LynxModule hub : allHubs) {
            hub.setBulkCachingMode(LynxModule.BulkCachingMode.AUTO);
        }


    }
    //Returns the total current draw of the robot. This can be used to determine if there are issues with the battery or robot design.
    //If the current draw is too high, investigate the current draw of individual motors, but they must be DcMotorEx objects, not DcMotor.
    //A current alert can also be set (motor.getCurrentAlert()), which will only trigger if a motor pulls current over the specified value (motor.setCurrentAlert()).
    public static double getCurrent() {
        for (LynxModule hub : allHubs) {
            totalCurrent = hub.getCurrent(CurrentUnit.AMPS);
        }
        return totalCurrent;
    }
}
