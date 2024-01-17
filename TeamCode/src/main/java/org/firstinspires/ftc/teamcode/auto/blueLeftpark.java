package org.firstinspires.ftc.teamcode.auto;

import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.MecanumDrive;
import com.acmerobotics.roadrunner.Pose2d;
import java.lang.Math;

@Autonomous
public class blueLeftpark extends LinearOpMode {

    public void runOpMode()
    {
        waitForStart();

        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(11.5, 60, Math.toRadians(90)));

        drive.setDrivePowers(new PoseVelocity2d(new Vector2d(0, 0.5), -0));
        sleep(2200); //lol what is this roadrunner/time based abomination
        drive.updatePoseEstimate();
        drive.setDrivePowers(new PoseVelocity2d(new Vector2d(0,0),0)); // i'm just dumb don't mind me

        drive.intake.setPower(-1);
        drive.release.setPower(-0.8);
        sleep(8000); //spins too long?
    }
}
