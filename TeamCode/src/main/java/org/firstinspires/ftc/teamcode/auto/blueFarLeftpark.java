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
public class blueFarLeftpark extends LinearOpMode {

    public void runOpMode()
    {
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(-36, 60, Math.toRadians(270))
        );
        waitForStart();

        runBlocking(new SequentialAction(
                drive.actionBuilder(drive.pose) //roadrunner why are you just bad
                        .lineToYConstantHeading(10)
                        .splineToLinearHeading(new Pose2d(53, 16, 0), 0) //line to linear heading function doesn't work so here we are
                        .build()));

                drive.intake.setPower(-1);
                drive.release.setPower(-0.8);
                sleep(8000);

//        drive.setDrivePowers(new PoseVelocity2d(new Vector2d(0, 0.5), -0));
//        sleep(2200);
//        drive.updatePoseEstimate();
    }
}