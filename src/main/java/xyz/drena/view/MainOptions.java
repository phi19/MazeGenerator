package xyz.drena.view;

public enum MainOptions {

    SET_ROWS(1, Messages.VIEW_MAIN_SET_ROWS),

    SET_COLUMNS(2, Messages.VIEW_MAIN_SET_COLUMNS),

    SET_SEED(3, Messages.VIEW_MAIN_SET_SEED),

    GENERATE_MAZE(4, Messages.VIEW_MAIN_GENERATE_MAZE);

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
