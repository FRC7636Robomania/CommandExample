/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Rack extends SubsystemBase {
  TalonSRX rack;
  /**
   * Creates a new Shuffleboard.
   */
  
  public Rack() {
    rack = new TalonSRX(25);
    rack.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
  }

  public void forward(){
    rack.set(ControlMode.PercentOutput, 0.25);
  }

  public void reverse(){
    rack.set(ControlMode.PercentOutput, -0.25);
  }

  public void stop(){
    rack.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //不斷被調用的程式，即使Disable時，用手改變齒條的位置，儀表板上的值也會改變
    SmartDashboard.putNumber("rack", rack.getSelectedSensorPosition());
  }
}
