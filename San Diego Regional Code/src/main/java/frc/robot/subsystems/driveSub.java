// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class driveSub extends SubsystemBase {
  /** Creates a new driveSub. */
  CANSparkMax flDrive,blDrive,frDrive,brDrive;
  NetworkTable limelight = NetworkTableInstance.getDefault().getTable("limelight-phantom");


  public driveSub() {
    flDrive = new CANSparkMax(Constants.flMotor,MotorType.kBrushless);
    blDrive = new CANSparkMax(Constants.blMotor,MotorType.kBrushless);
    frDrive = new CANSparkMax(Constants.frMotor,MotorType.kBrushless);
    brDrive = new CANSparkMax(Constants.brMotor,MotorType.kBrushless);

    flDrive.restoreFactoryDefaults();
    blDrive.restoreFactoryDefaults();
    frDrive.restoreFactoryDefaults();
    brDrive.restoreFactoryDefaults();

    flDrive.setInverted(false);
    blDrive.setInverted(false);
    frDrive.setInverted(true);
    brDrive.setInverted(true);
    flDrive.setOpenLoopRampRate(0.25); // Previosuly all 0.2
    blDrive.setOpenLoopRampRate(0.25);
    frDrive.setOpenLoopRampRate(0.25);
    brDrive.setOpenLoopRampRate(0.25);
  }


public void setPower(double left,double right){

//single line comment format "//"
//mass comment format 
/*
^
*/

flDrive.set(left);
blDrive.set(left);
frDrive.set(right);
brDrive.set(right);

}

public void turntotarget(){
  double targetx = limelight.getEntry("tx").getDouble(0);
  if (targetx > 2){
    setPower(0.05, -0.05);
  
  }
  else if (targetx < -2){
    setPower(-0.05,0.05);
  }
}

public double getDistance(){
double limelightHeight = 27;
double limelightMountingAngle = 45;
double hubHeight = 104;
double hubAngle = limelight.getEntry("ty").getDouble(0);
boolean hastarget = limelight.getEntry("tv").getDouble(0) == 1;
if (hastarget) {
  return (hubHeight - limelightHeight) /(Math.tan(Units.degreesToRadians(hubAngle+limelightMountingAngle)));

}
else {
return 0;
}
}
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("limelight", limelight.getEntry("tx").getDouble(0));
    SmartDashboard.putNumber("Distance", getDistance());
  }
}
