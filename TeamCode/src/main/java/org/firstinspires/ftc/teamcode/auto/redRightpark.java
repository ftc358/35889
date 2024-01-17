package org.firstinspires.ftc.teamcode.auto;

import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.MecanumDrive;
import com.acmerobotics.roadrunner.Pose2d;
import java.lang.Math;

@Autonomous
public class redRightpark extends LinearOpMode {

    public void runOpMode()
    {
        waitForStart();

        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(12, -60, Math.PI/2));

        drive.setDrivePowers(new PoseVelocity2d(new Vector2d(0, -0.5), -0));
        sleep(2200);
        drive.updatePoseEstimate();
        drive.setDrivePowers(new PoseVelocity2d(new Vector2d(0,0),0));

        drive.intake.setPower(-1);
        drive.release.setPower(-0.8);
        sleep(8000);

    }
}
