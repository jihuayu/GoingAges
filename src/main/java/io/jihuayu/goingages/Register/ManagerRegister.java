package io.jihuayu.goingages.Register;

import io.jihuayu.goingages.Manager.ManagerDate;
import io.jihuayu.goingages.Manager.ManagerTimeUser;

public class ManagerRegister {
    public static void closed(){
        ManagerTimeUser.manager=null;
        ManagerDate.date=null;
    }
}
