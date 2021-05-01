package xyz.drena.view.changeDefaults;

import xyz.drena.view.tools.Messages;

public class ChangeRowsView extends ChangeLengthView {

    @Override
    public void show() {
        askForInput(Messages.VIEW_SET_LENGTH_ROWS);
    }
}
