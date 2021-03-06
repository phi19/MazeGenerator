package xyz.drena.view.menuOptions;

import xyz.drena.view.tools.Messages;

public enum MainOptions {

    CHANGE_DEFAULTS(1, Messages.VIEW_MAIN_CHANGE_DEFAULTS),

    GENERATE_MAZES(2, Messages.VIEW_MAIN_EXPORT_MAZE),

    EDIT_MAZE(3, Messages.VIEW_MAIN_EDIT_MAZE),

    QUIT(4, Messages.VIEW_MAIN_QUIT);

    private final int option;
    private final String message;

    MainOptions(int option, String message) {
        this.option = option;
        this.message = message;
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
    public String getMessage() {
        return message;
    }

    /**
     * Gets the messages for the options the user can perform
     *
     * @return an array containing all the messages
     */
    public static String[] getMessages() {

        String[] messages = new String[values().length];

        for (MainOptions option : values()) {
            messages[option.getOption() - 1] = option.getMessage();
        }

        return messages;
    }
}
