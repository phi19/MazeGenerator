package xyz.drena.view.tools;

import xyz.drena.maze.transducer.GroundType;

import java.util.Arrays;
import java.util.HashSet;

public class Constants {

    private static final String APPDATA_PATH = System.getProperty("user.home") + "/AppData/Roaming/";
    private static final String DATA_PATH = APPDATA_PATH + "MazeGenerator/";

    private static final String DEFAULTS_PATH = DATA_PATH + "defaults/";
    private static final String DEFAULTS_EXTENSION = "";
    public static final String DEFAULT_ROWS_PATH = DEFAULTS_PATH + "rows" + DEFAULTS_EXTENSION;
    public static final String DEFAULT_COLUMNS_PATH = DEFAULTS_PATH + "columns" + DEFAULTS_EXTENSION;

    private static final String EXPORTS_PATH = DATA_PATH + "exports/";

    public static final String EXPORT_IMAGE_PATH = EXPORTS_PATH + "images/";
    public static final String EXPORT_IMAGE_EXTENSION = ".png";
    public static final int EXPORT_IMAGE_UNIT_SIZE = 60;

    public static final String EXPORT_SEED_PATH = EXPORTS_PATH + "seeds/";
    public static final String EXPORT_SEED_EXTENSION = ".seed";
    public static final int RANDOMIZER_TOTAL_SEEDS = 16000000;

    public static final String EXPORT_JSON_PATH = EXPORTS_PATH + "json/";
    public static final String EXPORT_JSON_EXTENSION = ".json";
    public static final String EXPORT_JSON_ROW_OBJECT = "Row";
    public static final String EXPORT_JSON_COLUMN_OBJECT = "Column";
    public static final String EXPORT_JSON_GROUND_TYPE_OBJECT = "GroundType";

    public static final String EXPORT_MAZE_PATH = EXPORTS_PATH + "mazes/";
    public static final String EXPORT_MAZE_EXTENSION = ".maze";

    public static final int GENERATOR_LAB_ROWS = 29;
    public static final int GENERATOR_LAB_COLUMNS = 23;

    public static final int VIEWER_UNIT_SIZE = 25;
    public static final int VIEWER_BORDER_PADDING = 10;
    private static final int VIEWER_WINDOW_PADDING = 90;
    public static final int VIEWER_MAXIMUM_HEIGHT = 1080 - VIEWER_WINDOW_PADDING*2;

    public static final HashSet<GroundType> GROUND_TYPE_HASH_SET = new HashSet<>(Arrays.asList(GroundType.FLOOR, GroundType.WALL));
}
