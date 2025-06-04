package org.example.app.util;

import org.example.app.controller.AppController;
import org.example.app.service.AppService;
import org.example.app.view.AppView;

public class AppStarter {
    public static void startApp() {
        AppView view = new AppView();
        AppService service = new AppService();
        AppController controller = new AppController(view, service);
        controller.runApp();
    }

}
