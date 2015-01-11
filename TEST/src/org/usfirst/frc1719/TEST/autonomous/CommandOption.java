package org.usfirst.frc1719.TEST.autonomous;

public interface CommandOption {
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
