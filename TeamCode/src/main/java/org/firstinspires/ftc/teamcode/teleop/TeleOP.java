package org.firstinspires.ftc.teamcode.teleop;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.TankDrive;
import org.firstinspires.ftc.teamcode.tuning.TuningOpModes;


@TeleOp(name="TeleOP", group="TeleOP")
@Config

public class TeleOP extends LinearOpMode {

    double intakePower = 0;
    double releasePower = 0;
    double liftPower = 0;
    boolean slowflag;
    double strafe;
    double turn;
    double straight;

    @Override
    public void runOpMode() throws InterruptedException {

        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));

        waitForStart();

        while (opModeIsActive()) {

            if (slowflag){
                straight = (-gamepad1.left_stick_y/2 > 0.1) ? (-gamepad1.left_stick_y/2 + 0.26) : (-gamepad1.left_stick_y < -0.1) ? (-gamepad1.left_stick_y - 0.26) : 0;
                strafe = (gamepad1.left_stick_x > 0.1) ? (gamepad1.left_stick_x/2 + 0.26) : (gamepad1.left_stick_x < -0.1) ? (gamepad1.left_stick_x/2 - 0.26) : 0;
                turn = (gamepad1.right_stick_x > 0.1) ? (gamepad1.right_stick_x/2 + 0.26) : (gamepad1.right_stick_x < -0.1) ? (gamepad1.right_stick_x/2 - 0.26) : 0;
            } else{
                straight = (-gamepad1.left_stick_y > 0.1) ? (Math.pow(-gamepad1.left_stick_y, 3) + 0.26) : (-gamepad1.left_stick_y < -0.1) ? (Math.pow(-gamepad1.left_stick_y, 3) - 0.26) : 0;
                strafe = (gamepad1.left_stick_x > 0.1) ? (Math.pow(gamepad1.left_stick_x, 3) + 0.26) : (gamepad1.left_stick_x < -0.1) ? (Math.pow(gamepad1.left_stick_x, 3) - 0.26) : 0;
                turn = (gamepad1.right_stick_x > 0.1) ? (Math.pow(gamepad1.right_stick_x, 5) + 0.26) : (gamepad1.right_stick_x < -0.1) ? (Math.pow(gamepad1.right_stick_x, 5) - 0.26) : 0;
            }



            drive.setDrivePowers(new PoseVelocity2d(new Vector2d(straight, -strafe), -turn));
            drive.updatePoseEstimate();


            //Dpad Right
            if (gamepad2.dpad_right) {
                releasePower = 0.8;
            } else if (gamepad2.dpad_left) {
                releasePower = -0.8;
            }
            //Intake
            else if (gamepad2.left_bumper) {
                intakePower = -1;
                releasePower = -0.8;
            } else if (gamepad2.left_trigger > 0.05) {
                intakePower = 1;
                releasePower = 0.8;
            } else {
                intakePower = 0;
                releasePower = 0;
            }


            //lift
            if (gamepad2.right_trigger > 0.1) {
                liftPower = gamepad2.right_trigger;
            } else if (gamepad2.right_bumper) {
                liftPower = -1;
            } else {
                liftPower = 0;
            }


            //drone_launcher
            if (gamepad1.dpad_up) {
                drive.launcher.setPosition(0.5);
                telemetry.addData(">", "launching drone");
            } else {
                drive.launcher.setPosition(0.0);
                telemetry.addData(">", "nothing");
            }


            //lift turn (larger radius)
            if (gamepad2.a) {
                drive.out1.setPosition(0.53);
                drive.out2.setPosition(0.17);
//                telemetry.addData(">", "lift servo moving up");
//                sleep(500);
                drive.rotate.setPosition(0.18);

            } else {
                drive.out1.setPosition(0.18);
                drive.out2.setPosition(0.53);
                drive.rotate.setPosition(0);
                telemetry.addData(">", "lift servo at rest");
            }

            //hang
//            boolean activated = false;
            double vm1 = 0.0;

            if (gamepad1.left_trigger > 0.05) {
                vm1 = gamepad1.left_trigger;
                telemetry.addData(">", "lifting...");
            } else if (gamepad1.right_trigger > 0.05) {
                // Check if the right stick is pushed forward or backward
                vm1 = -gamepad1.right_trigger;
            }

            drive.intake.setPower(intakePower);
            drive.release.setPower(releasePower);
            drive.lift.setPower(liftPower);
            drive.hang1.setPower(vm1);
            drive.hang2.setPower(-vm1);

            telemetry.update();
        }


    }
}
