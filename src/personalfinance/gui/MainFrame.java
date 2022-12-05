package personalfinance.gui;

import personalfinance.gui.dialog.CurrencyAddEditDialog;
import personalfinance.gui.menu.MainMenu;
import personalfinance.gui.toolbar.MainToolBar;
import personalfinance.saveload.SaveData;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements Refresh{

    private final GridBagConstraints constraints;
    private final MainMenu mb;
    private final MainToolBar tb;

    public MainFrame() {
        super(Text.get("PROGRAMM_NAME"));

        CurrencyAddEditDialog temp = new CurrencyAddEditDialog(this);
        temp.setCommon(SaveData.getInstance().getBaseCurrency());
        temp.showDialog();


        setResizable(false);
        setIconImage(Style.ICON_MAIN.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




        mb = new MainMenu(this);
        setJMenuBar(mb);

        setLayout(new GridBagLayout());

        constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;

        tb = new MainToolBar();
        add(tb, constraints);


// add toolbar
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.NORTH;

        add(new MainDatePicker().getDatePicker(), constraints);
        //add leftpanel

        pack();
        setLocationRelativeTo(null);
    }


    @Override
    public void refresh() {
        SwingUtilities.updateComponentTreeUI(this);
        mb.refresh();
        pack();
    }
}
