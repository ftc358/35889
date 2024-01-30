package org.firstinspires.ftc.teamcode.auto;

import static com.acmerobotics.roadrunner.ftc.Actions.runBlocking;

import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.teamcode.MecanumDrive;
import com.acmerobotics.roadrunner.Pose2d;
import java.lang.Math;
import java.util.List;

import org.firstinspires.ftc.teamcode.auto.tensorflow;

@Autonomous
public class testvision extends LinearOpMode {

    public void runOpMode()
    {
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(12, -60, Math.PI/2));
        tensorflow vision = new tensorflow();
        vision.initTfod();
        vision.telemetryTfod();
        telemetry.update();
        List<Recognition> currentRecognitions = vision.tfod.getRecognitions();
        if (currentRecognitions.size()==0){

        }
        waitForStart();
    }
}
