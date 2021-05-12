package xyz.drena.exports;

import xyz.drena.view.tools.Messages;

public enum ExportTypes {

    TO_IMAGE(1, Messages.VIEW_EXPORT_IMAGE),
    TO_JSON(2, Messages.VIEW_EXPORT_JSON),
    TO_LAB(3, Messages.VIEW_EXPORT_LAB),
    TO_SEED(4, Messages.VIEW_EXPORT_SEED),
    CANCEL(5, Messages.VIEW_EXPORT_CANCEL);

    private final int option;
    private final String message;

    ExportTypes(int option, String message) {
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

        for (ExportTypes option : values()) {
            messages[option.getOption() - 1] = option.getMessage();
        }

        return messages;
    }
}
