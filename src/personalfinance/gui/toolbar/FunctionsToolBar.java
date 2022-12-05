package personalfinance.gui.toolbar;

import personalfinance.gui.EnableEditDelete;
import personalfinance.gui.MainButton;
import personalfinance.settings.HandlerCode;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

public class FunctionsToolBar extends AbstractToolBar implements EnableEditDelete {

    private MainButton editButton;
    private MainButton deleteButton;

    public FunctionsToolBar() {
        super(Style.BORDER_FUNCTIONS_TOOLBAR);
        init();
    }

    @Override
    public void setEnableEditDelete(boolean enable) {
        editButton.setEnabled(enable);
        deleteButton.setEnabled(enable);
    }

    @Override
    protected void init() {
        addButton(Text.get("ADD"), Style.ICON_ADD, HandlerCode.ADD, false);
        editButton = addButton(Text.get("EDIT"), Style.ICON_EDIT, HandlerCode.EDIT, false);
        editButton = addButton(Text.get("DELETE"), Style.ICON_DELETE, HandlerCode.DELETE, false);
    }
}
