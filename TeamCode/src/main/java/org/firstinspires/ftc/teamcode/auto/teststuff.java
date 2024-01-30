package org.firstinspires.ftc.teamcode.auto;

import static com.acmerobotics.roadrunner.ftc.Actions.runBlocking;

import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.MecanumDrive;
import com.acmerobotics.roadrunner.Pose2d;
import java.lang.Math;
import org.firstinspires.ftc.teamcode.auto.tensorflow;

@Autonomous
public class teststuff extends LinearOpMode {

    public void runOpMode()
    {
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(12, -60, Math.PI/2));
        waitForStart();

//        drive.intake.setPower(1);
//        sleep(2000);
//        double servo1 =drive.out1.getPosition();
//        double servo2 =drive.out2.getPosition();
//
//        telemetry.addData("servo 1", servo1);
//        telemetry.addData("servo 2", servo2);
//        telemetry.update();

        drive.lift.setPower(0.4);
        sleep(6500);
        drive.lift.setPower(0);

        drive.out1.setPosition(0.53);
        drive.out2.setPosition(0.17);
        telemetry.addData(">", "lift servo moving up");
        sleep(500);
        drive.rotate.setPosition(0.18);

        drive.release.setPower(-0.8);
        sleep(3000);

//        drive.out1.setPosition(0.53);
//        drive.out2.setPosition(0.17);
//                telemetry.addData(">", "lift servo moving up");
//                sleep(500);
//        drive.rotate.setPosition(0.18);
//
//        drive.release.setPower(-0.5);
//        sleep(4000);
//
//        runBlocking(new SequentialAction(
//                drive.actionBuilder(drive.pose)
////                        .lineToYConstantHeading(-50)
//                        .splineToLinearHeading(new Pose2d(46, -36, Math.toRadians(0)), Math.toRadians(0))
//                        .build()));


//        drive.setDrivePowers(new PoseVelocity2d(new Vector2d(0, 0.5), -0));
//        sleep(2200);
//        drive.updatePoseEstimate();

    }
}
