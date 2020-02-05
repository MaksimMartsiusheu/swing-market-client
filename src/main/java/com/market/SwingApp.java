package com.market;

import com.market.gui.MainMenu;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SwingApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext =
                new SpringApplicationBuilder(SwingApp.class)
                        .headless(false)
                        .run(args);

        MainMenu mainMenu = applicationContext.getBean(MainMenu.class);
        mainMenu.showGUI();
    }


}
