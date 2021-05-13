package xyz.drena.exports.utils;

import xyz.drena.view.tools.Constants;
import xyz.drena.view.tools.Messages;

public enum ExportTypes {

    TO_IMAGE(1, Messages.VIEW_EXPORT_IMAGE, Constants.EXPORT_IMAGE_PATH, Constants.EXPORT_IMAGE_EXTENSION),
    TO_JSON(2, Messages.VIEW_EXPORT_JSON, Constants.EXPORT_JSON_PATH, Constants.EXPORT_JSON_EXTENSION),
    TO_MAZE(3, Messages.VIEW_EXPORT_MAZE, Constants.EXPORT_MAZE_PATH, Constants.EXPORT_MAZE_EXTENSION),
    TO_SEED(4, Messages.VIEW_EXPORT_SEED, Constants.EXPORT_SEED_PATH, Constants.EXPORT_SEED_EXTENSION),
    CANCEL(5, Messages.VIEW_EXPORT_CANCEL, "", "");

    private final int option;
    private final String message;
    private final String path;
    private final String extension;

    ExportTypes(int option, String message, String path, String extension) {
        this.option = option;
        this.message = message;
        this.path = path;
        this.extension = extension;
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
    private String getMessage() {
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

    public String getPath() {
        return path;
    }

    public String getExtension() {
        return extension;
    }
}
