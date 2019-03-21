package ru.sigmait.trayapp;

import java.awt.*;
import java.awt.event.MouseAdapter;

/**
 * Интерфейс работы приложения через системный трей
 */
public interface ApplicationTrayable {
    /**
     * Метод, проверающий, поддерживает ли целевая система работу с системным треем
     * @return true - приложение может использовать системный трей; false - приложение не может использовать
     * системный трей
     */
    boolean isTrayAppModeSupported();

    /**
     * Метод конфигурирует иконку приложения в системном трее
     */
    void createTrayIcon(TrayIconParams params) throws IllegalArgumentException;

    /**
     * Метод добавляет иконку в системный трей
     */
    void addTrayIconToSystemTray() throws AWTException;

    /**
     * Метод удаляет иконку из системного трея
     */
    void removeTrayIconFromSystemTray();

    /**
     * Метод добавляет обработчик событий мыши на иконке
     * @param mouseAdapter Обработчик события мыши на иконке приложения в системном трее
     */
    void addMouseListener(MouseAdapter mouseAdapter);

}
