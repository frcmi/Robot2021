// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class NetworkTables extends SubsystemBase {
private final NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
private NetworkTableEntry tv = table.getEntry("tv");
private final NetworkTableEntry tx = table.getEntry("tx");
public final NetworkTableEntry ty = table.getEntry("ty");
public final NetworkTableEntry ta = table.getEntry("ta");

  /** Creates a new NetworkTables. */
  public NetworkTables() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    table.getEntry("ledMode").setNumber(0);
    table.getEntry("camMode").setNumber(0);
    table.getEntry("pipeline").setNumber(0);
  }

  public void postValues() {
  //post to smart dashboard periodically
  SmartDashboard.putNumber("LimelightV", tv.getDouble(0.0));
  SmartDashboard.putNumber("LimelightX", getTx());
  SmartDashboard.putNumber("LimelightY", getTy());
  SmartDashboard.putNumber("LimelightArea", getTa());
  }

  //returns 0 or 1 (1 if there is a valid target)
  public boolean isTarget() { 
		return tv.getDouble(0.0) == 1;
	}

  //returns horizontal offset from crosshair to target (-27 degrees to 27 degrees)
  public double getTx() {
    return tx.getDouble(0.0);
  }

  //returns vertical offset from crosshair to target (-20.5 degrees to 20.5 degrees)
  public double getTy() {
    return ty.getDouble(0.0);
  }

  //returns target area (0% of image to 100% of image)
  public double getTa() {
    return ta.getDouble(0.0);
  }
}
