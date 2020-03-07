package com.peter.dao.machinecode;

import java.util.List;
import com.peter.model.MachineCode;

public interface MachineCodeDao {

	public void addMachineCode(MachineCode machineCode);
	
	public List<MachineCode> getMachineCodes();
	
	public MachineCode getMachineCode(int machineCodeId);
	
	public void deleteMachineCode(MachineCode machineCode);
}
