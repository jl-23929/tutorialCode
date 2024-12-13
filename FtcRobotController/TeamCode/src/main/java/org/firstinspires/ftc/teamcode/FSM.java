package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.modules.clawIntake;
import org.firstinspires.ftc.teamcode.modules.extendo;

public class FSM {
    public enum RobotState {INTAKE_OPEN, INTAKE_COLLECTED, TRANSFER, INTAKE_CLOSED, OUTTAKE_OPEN};

    static RobotState robotState;
    //TODO: Check if this will cause a Null Pointer Exception.
    static ElapsedTime timer;

    public static void init() {
        timer = new ElapsedTime();
    }

    public static void setRobotState(RobotState robotState) {
        if (robotState == RobotState.INTAKE_OPEN) {
            extendo.extend();
            clawIntake.intakePos();
            clawIntake.open();
            if (clawIntake.gamePiece()) {
                robotState = RobotState.INTAKE_CLOSED;
            }
        }

        if (robotState == RobotState.INTAKE_CLOSED) {
            timer.reset();
            clawIntake.close();
            clawIntake.transferPos();
            if (timer.seconds() > 2) { //TODO: This time needs to be tuned to match the time it takes to close the claw and retract the slides.
                robotState = RobotState.TRANSFER;
            }

        }

        if (robotState == RobotState.TRANSFER) {
            clawIntake.open();
        }

    }
}
