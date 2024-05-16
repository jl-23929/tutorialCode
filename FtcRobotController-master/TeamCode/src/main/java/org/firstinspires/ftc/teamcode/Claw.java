package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw {

    Servo leftClaw, rightClaw;
    double leftClawOpen = 1, leftClawClose = 0; //TODO: These values need to be tuned. (Lollback)
    double rightClawOpen = 1, rightClawClose = 0; //TODO: These values need to be tuned. (Lollback)

    public Claw(Servo leftClaw, Servo rightClaw) {
        this.leftClaw = leftClaw;
        this.rightClaw = rightClaw;

    }

    public void leftClawOpen() {
        leftClaw.setPosition(leftClawOpen);
    }

    public void rightClawOpen() {
        rightClaw.setPosition(rightClawOpen);
    }
}
