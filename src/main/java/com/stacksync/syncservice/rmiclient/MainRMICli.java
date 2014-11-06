package com.stacksync.syncservice.rmiclient;

import java.rmi.*;
import java.util.UUID;

import com.stacksync.commons.models.User;
import com.stacksync.syncservice.rmiserveri.*;

public class MainRMICli {
	public static void main(String args[]) {

		try {
			//DeviceDAORMISer addDeviceServer = (DeviceDAORMISer) Naming.lookup("rmi://0/DeviceServer");
			//ItemDAORMISer addItemServer = (ItemDAORMISer) Naming.lookup("rmi://0/ItemServer");
			//ItemVersionDAORMISer addItemVersionServer = (ItemVersionDAORMISer) Naming.lookup("rmi://0/ItemVersionServer");
			UserDAORMISer addUserServer = (UserDAORMISer) Naming.lookup("rmi://0/UserServer");
			//WorkspaceDAORMISer addWorkspaceServer = (WorkspaceDAORMISer) Naming.lookup("rmi://0/WorkspaceServer");

			UserRMI user = new UserRMI();
			user.setName("Laura");
			user.setId(UUID.randomUUID());
			user.setEmail("laura@jo.com");
			user.setQuotaLimit(2048);
			user.setQuotaUsed(1403);

			addUserServer.add(user);
			
			UserRMI user2 = new UserRMI();
			user2.setName("Pepito");
			user2.setId(UUID.randomUUID());
			user2.setEmail("pepito@el.com");
			user2.setQuotaLimit(4000);
			user2.setQuotaUsed(3500);

			addUserServer.add(user2);
			
			for (UserRMI u: addUserServer.findAll()){
				System.out.println(u.toString());
			}

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
}