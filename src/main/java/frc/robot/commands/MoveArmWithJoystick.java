package frc.robot.commands;

import java.util.function.Consumer;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.ArmSubsystem;

public class MoveArmWithJoystick extends CommandBase {
  /** Creates a new MoveArmWithJoystick. */
  // Set the scheduler to log Shuffleboard events for command initialize, interrupt, finish
  CommandScheduler.getInstance()
  .onCommandInitialize(
      command ->
          Shuffleboard.addEventMarker(
              "Command initialized", command.getName(), EventImportance.kNormal));
  //initialize your subsystems, controllers
  XboxController joystick1;
  public MoveArmWithJoystick(ArmSubsystem armSubsystem, XboxController joystick1) {
    //add your parameters to the command
    // Use addRequirements() here to declare subsystem dependencies.
    this.joystick1 = joystick1;
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    double joystickArmPower = joystick1.getLeftY(); //use this joystick armpower to set power to your motors
    m_scheduledCommands.add(command);
    for (Subsystem requirement : requirements) {
      m_requirements.put(requirement, command);
    }
    command.initialize();
    for (Consumer<Command> action : m_initActions) {
      action.accept(command);
    }

    m_watchdog.addEpoch(command.getName() + ".initialize()");
  }


  @Override
  public void end(boolean interrupted) {
    
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
