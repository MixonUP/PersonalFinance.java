package personalfinance.gui.menu;

import personalfinance.gui.EnableEditDelete;
import personalfinance.gui.MainFrame;
import personalfinance.gui.Refresh;
import personalfinance.settings.HandlerCode;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MainMenu extends JMenuBar implements Refresh, EnableEditDelete {
    private JMenuItem menuEdit;
    private JMenuItem menuDelete;
    private final MainFrame frame;

    public MainMenu (MainFrame frame) {
        super();
        this.frame = frame;
        init();

    }

    private void init() {
        JMenu file = new JMenu(Text.get("MENU_FILE"));
        JMenu edit = new JMenu(Text.get("MENU_EDIT"));
        JMenu view = new JMenu(Text.get("MENU_VIEW"));
        JMenu help = new JMenu(Text.get("MENU_HELP"));

        file.setIcon(Style.ICON_MENU_FILE);
        edit.setIcon(Style.ICON_MENU_EDIT);
        view.setIcon(Style.ICON_MENU_VIEW);
        help.setIcon(Style.ICON_MENU_HELP);

        add(file);
        add(edit);
        add(view);
        add(help);

        addMenuItem(file, Text.get("MENU_FILE_NEW"), Style.ICON_MENU_FILE_NEW, HandlerCode.MENU_FILE_NEW, KeyEvent.VK_N);
        addMenuItem(file, Text.get("MENU_FILE_OPEN"), Style.ICON_MENU_FILE_OPEN, HandlerCode.MENU_FILE_OPEN, KeyEvent.VK_O);
        addMenuItem(file, Text.get("MENU_FILE_SAVE"), Style.ICON_MENU_FILE_SAVE, HandlerCode.MENU_FILE_SAVE, KeyEvent.VK_S);
        addMenuItem(file, Text.get("MENU_FILE_UPDATE_CURRENCIES"), Style.ICON_MENU_FILE_UPDATE_CURRENCIES, HandlerCode.MENU_FILE_UPDATE_CURRENCIES);
        addMenuItem(file, Text.get("MENU_FILE_NEW"), Style.ICON_MENU_FILE_EXIT, HandlerCode.MENU_FILE_EXIT);

        addMenuItem(edit, Text.get("MENU_EDIT_ADD"), Style.ICON_MENU_EDIT_ADD, HandlerCode.MENU_EDIT_ADD);
        menuEdit = addMenuItem(edit, Text.get("MENU_EDIT_EDIT"), Style.ICON_MENU_EDIT_EDIT, HandlerCode.MENU_EDIT_EDIT);
        menuDelete = addMenuItem(edit, Text.get("MENU_EDIT_DELETE"), Style.ICON_MENU_EDIT_DELETE, HandlerCode.MENU_EDIT_DELETE);
        menuEdit.setEnabled(false);
        menuDelete.setEnabled(false);






        addMenuItem(view, Text.get("MENU_VIEW_OVERVIEW"), Style.ICON_MENU_VIEW_OVERVIEW, HandlerCode.MENU_VIEW_OVERVIEW);
        addMenuItem(view, Text.get("MENU_VIEW_ACCOUNTS"), Style.ICON_MENU_VIEW_ACCOUNTS, HandlerCode.MENU_VIEW_ACCOUNTS);
        addMenuItem(view, Text.get("MENU_VIEW_ARTICLES"), Style.ICON_MENU_VIEW_ARTICLES, HandlerCode.MENU_VIEW_ARTICLES);
        addMenuItem(view, Text.get("MENU_VIEW_TRANSACTIONS"), Style.ICON_MENU_VIEW_TRANSACTIONS, HandlerCode.MENU_VIEW_TRANSACTIONS);
        addMenuItem(view, Text.get("MENU_VIEW_TRANSFERS"), Style.ICON_MENU_VIEW_TRANSFERS, HandlerCode.MENU_VIEW_TRANSFERS);
        addMenuItem(view, Text.get("MENU_VIEW_CURRENCIES"), Style.ICON_MENU_VIEW_CURRENCIES, HandlerCode.MENU_VIEW_CURRENCIES);
        addMenuItem(view, Text.get("MENU_VIEW_STATISTICS"), Style.ICON_MENU_VIEW_STATISTICS, HandlerCode.MENU_VIEW_STATISTICS);

        addMenuItem(help, Text.get("MENU_HELP_ABOUT"), Style.ICON_MENU_HELP_ABOUT, HandlerCode.MENU_HELP_ABOUT);


    }

    private JMenuItem addMenuItem(JMenu menu, String title, ImageIcon icon, String action, int key) {
        JMenuItem item = new JMenuItem(title);
        item.setIcon(icon);
        item.setActionCommand(action);
        if (key != 0) {
            KeyStroke shortKey = KeyStroke.getKeyStroke(key, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
            item.setAccelerator(shortKey);
        }
        menu.add(item);
        return item;
    }

    private JMenuItem addMenuItem(JMenu menu, String title, ImageIcon icon, String action) {
        return addMenuItem(menu, title, icon, action, 0);
    }

    @Override
    public void refresh() {
        removeAll();
        init();
    }

    @Override
    public void setEnableEditDelete(boolean enable) {
        menuEdit.setEnabled(enable);
        menuDelete.setEnabled(enable);
    }

}
