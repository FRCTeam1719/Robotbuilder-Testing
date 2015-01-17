package org.usfirst.frc1719.TEST.autonomous;

/**
 * Implement this to create a possible autonomous mode. Remeber to update org.usfirst.frc1719.TEST.Robot.EnumAutoCMD
 *  afterwards.
 * @author duncan
 *
 */
public interface ICommandOption {
	/**
	 * Called repeatedly during autonomous when selected.
	 */
	public void doCMD();
	/**
	 * Checks whether the command is finished running.
	 * @return true if calls should cease, false otherwise.
	 */
	public boolean done();
}
