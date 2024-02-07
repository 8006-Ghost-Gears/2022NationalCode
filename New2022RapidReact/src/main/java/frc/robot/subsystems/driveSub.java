// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class driveSub extends SubsystemBase {
  /** Creates a new driveSub. */
  CANSparkMax flDrive,blDrive,frDrive,brDrive;

  public driveSub() {
    flDrive = new CANSparkMax(Constants.flMotor,MotorType.kBrushless);
    blDrive = new CANSparkMax(Constants.blMotor,MotorType.kBrushless);
    frDrive = new CANSparkMax(Constants.frMotor,MotorType.kBrushless);
    brDrive = new CANSparkMax(Constants.brMotor,MotorType.kBrushless);

    flDrive.restoreFactoryDefaults();
    blDrive.restoreFactoryDefaults();
    frDrive.restoreFactoryDefaults();
    brDrive.restoreFactoryDefaults();

    flDrive.setInverted(true);
    blDrive.setInverted(true);
    frDrive.setInverted(true);
    brDrive.setInverted(true);
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


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
