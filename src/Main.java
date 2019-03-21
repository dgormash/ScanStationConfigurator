import ru.sigmait.trayapp.ApplicationTrayable;
import ru.sigmait.trayapp.ScanStationConfiguratorTrayApp;
import ru.sigmait.trayapp.TrayIconParams;
import ru.sigmait.ui.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class Main {
    private static ConfigurationForm configurationForm;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run() {
                createTrayIconApplication();
            }
        });
    }

    private static void createTrayIconApplication()
    {
        ApplicationTrayable app = new ScanStationConfiguratorTrayApp();

        if(!app.isTrayAppModeSupported())
            System.exit(0);

        URL url = System.class.getResource("/bulb.gif");
        if(url == null){
            JOptionPane.showMessageDialog(null,"Не удаётся найти файл иконки", "Ошибка", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        Image image = Toolkit.getDefaultToolkit().getImage(url);
        String tooltipMessage = "Scan station configurator";
        TrayIconParams params = new TrayIconParams();
        PopupMenu popupMenu = new PopupMenu();
        MenuItem exitItem = new MenuItem("Выход");
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.removeTrayIconFromSystemTray();
                System.exit(0);
            }
        });
        popupMenu.add(exitItem);
        params.setImage(image);
        params.setTooltip(tooltipMessage);
        params.setPopupMenu(popupMenu);
        app.createTrayIcon(params);
        app.addMouseListener(getMouseAdapter());
        try{
            app.addTrayIconToSystemTray();
        }catch (AWTException e){
            JOptionPane.showMessageDialog(null,"Не удалось добавить иконку приложения в системный трей", "Ошибка", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    private static MouseAdapter getMouseAdapter(){
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getButton() == Buttons.LEFT_BUTTON) {
                    ConfigurationForm.getInstance();
                }
            }
        };
    }

    private static class Buttons{
        final static int LEFT_BUTTON = 1;
        final static int  RIGHT_BUTTON = 2;
    }
}
