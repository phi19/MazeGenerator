package xyz.drena.view.tools;

public class Messages {

    public static final String SYSTEM_ERROR = "The maze generator is having issues...";
    public static final String MAINTENANCE_ERROR = "This feature is on development...";

    public static final String VIEW_MAIN_MESSAGE = "What do you want to do? ";
    public static final String VIEW_MAIN_ERROR = "You can't do that!";

    public static final String VIEW_MAIN_CHANGE_DEFAULTS = "Change Default Settings";
    public static final String VIEW_MAIN_EXPORT_MAZE = "Generate Maze(s)";
    public static final String VIEW_MAIN_EDIT_MAZE = "Edit Maze";
    public static final String VIEW_MAIN_QUIT = "Quit";

    public static final String VIEW_DEFAULTS_MESSAGE = "What default do you want to change?";
    public static final String VIEW_DEFAULTS_ERROR = "That is not a default";

    public static final String VIEW_DEFAULTS_ROWS = "Set Default Rows";
    public static final String VIEW_DEFAULTS_COLUMNS = "Set Default Columns";
    public static final String VIEW_DEFAULTS_QUIT = "Go back";

    public static final String VIEW_SET_LENGTH_MESSAGE_PREFIX = "\nInsert how many ";
    public static final String VIEW_SET_LENGTH_MESSAGE_SUFFIX = " you want the maze to have: ";
    public static final String VIEW_SET_LENGTH_ROWS = VIEW_SET_LENGTH_MESSAGE_PREFIX + "rows" + VIEW_SET_LENGTH_MESSAGE_SUFFIX;
    public static final String VIEW_SET_LENGTH_COLUMNS = VIEW_SET_LENGTH_MESSAGE_PREFIX + "columns" + VIEW_SET_LENGTH_MESSAGE_SUFFIX;
    public static final String VIEW_SET_LENGTH_ERROR = "That is not a valid number! \nIt has to be a POSITIVE ODD INTEGER.";

    public static final String VIEW_NUMBER_MAZES_MESSAGE = "\nHow many mazes do you want to generate? ";
    public static final String VIEW_NUMBER_MAZES_ERROR = "That is not a valid number!";

    public static final String VIEW_FILENAME_MESSAGE = "\nInsert the name of the file(s): ";
    public static final String VIEW_FILENAME_ERROR = "That is not a valid name!";

    public static final String VIEW_EXPORT_MESSAGE = "To what format do you want to export the mazes? ";
    public static final String VIEW_EXPORT_ERROR = "That export type doesn't exist!";

    public static final String VIEW_EXPORT_JSON = "JSON file";
    public static final String VIEW_EXPORT_IMAGE = "Image file";
    public static final String VIEW_EXPORT_LAB = "Editable file";
    public static final String VIEW_EXPORT_SEED = "Seed number (in a file)";
    public static final String VIEW_EXPORT_CANCEL = "Go back";

}
