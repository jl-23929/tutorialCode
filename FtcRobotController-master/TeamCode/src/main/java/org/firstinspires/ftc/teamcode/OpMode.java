package org.firstinspires.ftc.teamcode;

public class OpMode extends robot{
    @Override
    public void init() {
        initHardware();
        telemetry.addData("Status: ", "Initialised");
        telemetry.update();
    }

    @Override
    public void loop() {
        if (gamepad1.a) {
            clawModule.leftClawOpen();
        }
        if (gamepad1.b) {
            clawModule.rightClawOpen();
        }

        if (gamepad1.right_bumper) {
            armModule.runToPosition(90);
        }
    }
}
