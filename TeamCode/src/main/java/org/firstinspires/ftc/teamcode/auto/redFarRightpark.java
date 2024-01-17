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
import java.lang.Math;

@Autonomous
public class redFarRightpark extends LinearOpMode {

    public void runOpMode()
    {
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(-36, -60, Math.toRadians(90))
        );
        waitForStart();

        runBlocking(new SequentialAction(
                drive.actionBuilder(drive.pose)
                        .lineToYConstantHeading(-10)
                        .splineToLinearHeading(new Pose2d(53, -14, 0), 0)
                        .build()));

        drive.intake.setPower(-1);
        drive.release.setPower(-0.8);
        sleep(8000);

//        drive.setDrivePowers(new PoseVelocity2d(new Vector2d(0, 0.5), -0));
//        sleep(2200);
//        drive.updatePoseEstimate();
    }
}
