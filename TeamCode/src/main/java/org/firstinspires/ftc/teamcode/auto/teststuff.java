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

@Autonomous
public class teststuff extends LinearOpMode {

    public void runOpMode()
    {
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(12, -60, Math.PI/2));
        waitForStart();

        runBlocking(new SequentialAction(
                drive.actionBuilder(drive.pose)
//                        .lineToYConstantHeading(-50)
                        .splineToLinearHeading(new Pose2d(46, -36, Math.toRadians(0)), Math.toRadians(0))
                        .build()));


//        drive.setDrivePowers(new PoseVelocity2d(new Vector2d(0, 0.5), -0));
//        sleep(2200);
//        drive.updatePoseEstimate();

    }
}
