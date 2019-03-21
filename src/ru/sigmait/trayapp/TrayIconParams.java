package ru.sigmait.trayapp;

import java.awt.*;

/**
 * Класс, представляющий собой параметры, требуемые для инициализации TrayIcon
 */
public class TrayIconParams {
    //Изображение иконки в трее
    private Image image;
    //Текст всплывающей подсказки
    private String tooltip;
    //Контекстное меню
    private PopupMenu popupMenu;

    /**
     * Аксессор для текста всплывающей подсказки
     * @return Текст всплывающей подсказки
     */
    public String getTooltip() {
        return tooltip;
    }

    /**
     * Мутатор для текста всплывающей подсказки
     * @param tooltip Текст всплывающей подсказки
     */
    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    /**
     * Аксессор для изображения иконки
     * @return Изображение иконки
     */
    public Image getImage() {
        return image;
    }

    /**
     * Мутатор для изображения иконки
     * @param image Изображение иконки
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * Аксессор для контекстного меню
     * @return Контекстное меню
     */
    public PopupMenu getPopupMenu() {
        return popupMenu;
    }

    /**
     * Мутатор для контекстного меню
     * @param popupMenu Контекстное меню
     */
    public void setPopupMenu(PopupMenu popupMenu) {
        this.popupMenu = popupMenu;
    }
}
