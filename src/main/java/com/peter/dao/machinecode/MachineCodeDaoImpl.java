package com.peter.dao.machinecode;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.peter.model.MachineCode;

@Repository("machineCodeDao")
public class MachineCodeDaoImpl implements MachineCodeDao{

		@Autowired
		private SessionFactory sessionFactory;
		
		@Override
		public void addMachineCode(MachineCode machineCode) {
			// TODO Auto-generated method stub
			sessionFactory.getCurrentSession().saveOrUpdate(machineCode);
		}

		@Override
		public List<MachineCode> getMachineCodes() {
			// TODO Auto-generated method stub
			return (List<MachineCode>) sessionFactory.getCurrentSession().createCriteria(MachineCode.class).list();
		}

		@Override
		public MachineCode getMachineCode(int machineCodeId) {
			// TODO Auto-generated method stub
			return (MachineCode) sessionFactory.getCurrentSession().get(MachineCode.class, machineCodeId);
		}

		@Override
		public void deleteMachineCode(MachineCode machineCode) {
			// TODO Auto-generated method stub
			sessionFactory.getCurrentSession().createQuery("DELETE FROM disaster_machinecode WHERE id=" + machineCode.getMachineCodeId()).executeUpdate();
		}
	
}
