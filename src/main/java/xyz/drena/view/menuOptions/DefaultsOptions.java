package xyz.drena.view.menuOptions;

import xyz.drena.view.tools.Constants;
import xyz.drena.view.tools.Messages;

public enum DefaultsOptions {

    SET_ROWS(1, Messages.VIEW_DEFAULTS_ROWS),

    SET_COLUMNS(2, Messages.VIEW_DEFAULTS_COLUMNS),

    GO_BACK(3, Messages.VIEW_DEFAULTS_QUIT);

    private final int option;
    private final String menuMessage;

    DefaultsOptions(int option, String menuMessage) {
        this.option = option;
        this.menuMessage = menuMessage;
    }

    /**
     * Gets the user option number
     *
     * @return the option number
     */
    public int getOption() {
        return option;
    }

    /**
     * Gets the message for the user option
     *
     * @return the user option message
     */
    public String getMenuMessage() {
        return menuMessage;
    }

    /**
     * Gets the messages for the options the user can perform
     *
     * @return an array containing all the messages
     */
    public static String[] getMessages() {

        String[] messages = new String[values().length];

        for (DefaultsOptions option : values()) {
            messages[option.getOption() - 1] = option.getMenuMessage();
        }

        return messages;
    }
}
