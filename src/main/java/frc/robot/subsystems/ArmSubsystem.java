package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {

  //add motors here
  private TalonFX motor = new TalonFX(0);
  
  public ArmSubsystem() {
  }

  public void setPower(double power) {
    motor.set(ControlMode.PercentOutput, power);
  }
  
  //consider what methods are necessary for the motor to run effectively
  
  @Override
  public void periodic() {


  }
}
