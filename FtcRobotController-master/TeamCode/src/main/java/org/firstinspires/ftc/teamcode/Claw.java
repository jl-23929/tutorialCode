package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw {

    Servo leftClaw, rightClaw;
    double leftClawOpen = 1, leftClawClose = 0;
    double rightClawOpen = 1, rightClawClose = 0;

    public  Claw (Servo leftClaw, Servo rightClaw){
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
