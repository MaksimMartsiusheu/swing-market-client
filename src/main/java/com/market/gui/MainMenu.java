package com.market.gui;

import com.market.gui.panel.CategoryEntityPanel;
import com.market.gui.panel.ProductEntityPanel;
import com.market.service.impl.ProductServiceImpl;
import com.market.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Component
public class MainMenu extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JPanel categoryPanel;
    private JPanel productPanel;

    @Autowired
    public MainMenu(CategoryServiceImpl categoryEntityService, ProductServiceImpl productEntityService) {
        super("Swing Market Client");
        this.cardLayout = new CardLayout();
        this.mainPanel = new JPanel(this.cardLayout);

        this.categoryPanel = new CategoryEntityPanel(categoryEntityService);
        this.categoryPanel.setBackground(Color.BLACK);
        this.productPanel = new ProductEntityPanel(productEntityService);
        this.productPanel.setBackground(Color.RED);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createEntityMenu());

        this.setSize(1280, 720);
        this.setExtendedState(JFrame.NORMAL);
        this.setResizable(true);
        this.setJMenuBar(menuBar);

        this.mainPanel.add(this.categoryPanel, "categoryPanel");
        this.mainPanel.add(this.productPanel, "productPanel");
        this.add(this.mainPanel);

    }

    private JMenu createEntityMenu() {

        JMenu jEntityMenu = new JMenu("Category & Products");

        JMenuItem jCategoriesMenuItem = new JMenuItem("Categories");

        jCategoriesMenuItem.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                    MainMenu.this.cardLayout.show(MainMenu.this.mainPanel, "categoryPanel");
                }
            }
        });

        JMenuItem jProductsMenuItem = new JMenuItem("Products");

        jProductsMenuItem.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                    MainMenu.this.cardLayout.show(MainMenu.this.mainPanel, "productPanel");
                }
            }
        });
        jEntityMenu.add(jCategoriesMenuItem);
        jEntityMenu.add(jProductsMenuItem);

        return jEntityMenu;
    }

    public void showGUI() {
        this.setVisible(true);
    }
}
