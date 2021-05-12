package xyz.drena.view.tools;

import xyz.drena.maze.transducer.GroundType;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;

public class Constants {

    private static final String APPDATA_PATH = System.getProperty("user.home") + "/AppData/Roaming/";

    private static final String DATA_DIRECTORY_PATH = APPDATA_PATH + "MazeGenerator/";
    public static final File DATA_DIRECTORY = new File(DATA_DIRECTORY_PATH);

    private static final String DEFAULTS_DIRECTORY_PATH = DATA_DIRECTORY_PATH + "defaults/";
    public static final File DEFAULTS_DIRECTORY = new File(DEFAULTS_DIRECTORY_PATH);

    private static final String DEFAULTS_EXTENSION = "";
    private static final String DEFAULT_ROWS_FILE_PATH = DEFAULTS_DIRECTORY_PATH + "rows" + DEFAULTS_EXTENSION;
    private static final String DEFAULT_COLUMNS_FILE_PATH = DEFAULTS_DIRECTORY_PATH + "columns" + DEFAULTS_EXTENSION;
    public static final File DEFAULT_ROWS_FILE = new File(DEFAULT_ROWS_FILE_PATH);
    public static final File DEFAULT_COLUMNS_FILE = new File(DEFAULT_COLUMNS_FILE_PATH);

    public static final double ALGORITHM_LAB_DEFAULT_ROWS = 14;
    public static final double ALGORITHM_LAB_DEFAULT_COLUMNS = 11;

    public static final double GENERATOR_LAB_ROWS = ALGORITHM_LAB_DEFAULT_ROWS * 2 + 1;
    public static final double GENERATOR_LAB_COLUMNS = ALGORITHM_LAB_DEFAULT_COLUMNS * 2 + 1;

    public static final int VIEWER_DEFAULT_UNIT_SIZE = 25;
    public static final int VIEWER_PADDING = 10;
    public static final int VIEWER_MAXIMUM_HEIGHT = 1080 - 90*2;

    public static final int RANDOMIZER_TOTAL_SEEDS = 16000000;
    public static final int RANDOMIZER_DEFAULT_SEED = 69*69; // in a file
    public static final boolean RANDOMIZER_USE_DEFAULT_SEED = true;

    public static final String FILES_PATH = "src/main/resources/";

    public static final String FILES_MAZES_IMAGES_PATH = FILES_PATH + "mazes_images/";
    public static final String EXPORT_IMAGE_EXTENSION = ".png";

    public static final String EXPORT_SEED_EXTENSION = ".seed";

    public static final String EXPORT_JSON_ROW_OBJECT = "Row";
    public static final String EXPORT_JSON_COLUMN_OBJECT = "Column";
    public static final String EXPORT_JSON_GROUND_TYPE_OBJECT = "GroundType";
    public static final String EXPORT_JSON_EXTENSION = ".json";

    public static final String DIRECTORY_MAZES_EXPORT_PATH = FILES_PATH + "mazes/";
    public static final File DIRECTORY_MAZES_EXPORT = new File(DIRECTORY_MAZES_EXPORT_PATH);
    public static final String EXPORT_LAB_EXTENSION = ".lab";

    public static final int EXPORT_VIEW_UNIT_SIZE = 60;

    public static final HashSet<GroundType> GROUND_TYPE_HASH_SET = new HashSet<>(Arrays.asList(GroundType.FLOOR, GroundType.WALL));
}
