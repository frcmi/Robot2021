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
private final NetworkTableEntry tx = table.getEntry("tx");
public final NetworkTableEntry ty = table.getEntry("ty");
public final NetworkTableEntry ta = table.getEntry("ta");

  /** Creates a new NetworkTables. */
  public NetworkTables() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }

  public void postValues() {
  //read values periodically
  double x = tx.getDouble(0.0);
  double y = ty.getDouble(0.0);
  double area = ta.getDouble(0.0);

  //post to smart dashboard periodically
  SmartDashboard.putNumber("LimelightX", x);
  SmartDashboard.putNumber("LimelightY", y);
  SmartDashboard.putNumber("LimelightArea", area);
  }
}
