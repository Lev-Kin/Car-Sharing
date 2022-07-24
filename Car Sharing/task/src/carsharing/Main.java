package carsharing;

import carsharing.dao.CompanyDaoH2Impl;
import carsharing.dao.ControllerH2;

public class Main {

    public static void main(String[] args) {

        ControllerH2 controllerH2 = new ControllerH2(getDbName(args));
        CompanyDaoH2Impl companyDaoH2 = new CompanyDaoH2Impl(controllerH2.getConnection());

        while (true) {
            Menu.mainMenu();
            switch (Menu.userChoice()) {
                case 1:
                    Menu.managementMenu(companyDaoH2);
                    break;
                case 0:
                    return;
            }
        }
    }


    private static String getDbName(String[] args) {
        if (args.length >= 2 && args[0].equals("-databaseFileName")) {
            return args[1];
        } else {
            return "carsharing";
        }
    }
}

