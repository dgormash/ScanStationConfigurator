package ru.sigmait.trayapp;

import java.awt.*;
import java.awt.event.MouseAdapter;

public class ScanStationConfiguratorTrayApp implements ApplicationTrayable {
    private final SystemTray systemTray = SystemTray.getSystemTray();
    private TrayIcon trayIcon;

    /**
     *
     * @return
     */
    @Override
    public boolean isTrayAppModeSupported() {
        boolean result = false;

        if(SystemTray.isSupported()){
            result = true;
        }

        return result;
    }

    /**
     *
     * @param params
     * @throws IllegalArgumentException
     */
    @Override
    public void createTrayIcon(TrayIconParams params) throws IllegalArgumentException {
        if(params == null)
            throw new IllegalArgumentException();

        if (trayIcon == null) {
            Image image = params.getImage();
            String tooltip = params.getTooltip();
            PopupMenu popupMenu = params.getPopupMenu();
            trayIcon = new TrayIcon(image, tooltip, popupMenu);
            trayIcon.setImageAutoSize(true);
        }
    }

    /**
     *
     * @throws AWTException
     */
    @Override
    public void addTrayIconToSystemTray()throws AWTException {
        try {
            if(trayIcon != null) {
                systemTray.add(trayIcon);
            }
        } catch (AWTException e) {
            throw new AWTException(e.getMessage());
        }
    }

    /**
     *
     */
    @Override
    public void removeTrayIconFromSystemTray() {
        if(trayIcon != null){
            systemTray.remove(trayIcon);
        }
    }

    /**
     *
     * @param mouseAdapter Обработчик события мыши на иконке приложения в системном трее
     */
    private boolean isMouseAdapterSet = false;
    @Override
    public void addMouseListener(MouseAdapter mouseAdapter) {
        if(trayIcon != null && !isMouseAdapterSet){
            trayIcon.addMouseListener(mouseAdapter);
        }
    }
}
