// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class shooterSub extends SubsystemBase {
  /** Creates a new shooterSub. */
  CANSparkMax shooterL,shooterR;
  //shooterB;
  
  public shooterSub() {
    shooterL = new CANSparkMax(Constants.shooterL, MotorType.kBrushless);
    shooterR = new CANSparkMax(Constants.shooterR, MotorType.kBrushless);
  //  shooterB = new CANSparkMax(Constants.shooterB, MotorType.kBrushless);
    shooterL.restoreFactoryDefaults();
    shooterR.restoreFactoryDefaults();
  }

public void setShooter(){
  shooterL.set(.9);
  shooterR.set(-.9);
//  shooterB.set(.5);
}

public void setShooterReverse(){
  shooterL.set(-.2);
  shooterR.set(.2);

}
public void stopShooter(){
  shooterL.set(0);
  shooterR.set(0);
  //shooterB.set(0);

}



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
