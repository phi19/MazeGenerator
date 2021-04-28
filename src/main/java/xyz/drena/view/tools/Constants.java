package xyz.drena.view.tools;

import xyz.drena.exports.ExportTypes;

public class Constants {

    public static final int ALGORITHM_LAB_DEFAULT_ROWS = 14; // in a file
    public static final int ALGORITHM_LAB_DEFAULT_COLUMNS = 11; // in a file

    public static final int GENERATOR_LAB_ROWS = ALGORITHM_LAB_DEFAULT_ROWS * 2 + 1;
    public static final int GENERATOR_LAB_COLUMNS = ALGORITHM_LAB_DEFAULT_COLUMNS * 2 + 1;

    public static final int VIEWER_DEFAULT_UNIT_SIZE = 25;
    public static final int VIEWER_PADDING = 10;
    public static final int VIEWER_MAXIMUM_HEIGHT = 1080 - 90*2;

    public static final int RANDOMIZER_TOTAL_SEEDS = 16000000;
    public static final int RANDOMIZER_DEFAULT_SEED = 69*69;
    public static final boolean RANDOMIZER_USE_DEFAULT_SEED = true;

    public static final String FILES_PATH = "src/main/resources/";

    public static final String FILES_DEFAULTS_PATH = FILES_PATH + "defaults/";
    public static final String FILES_DEFAULTS_ROWS = "rows";
    public static final String FILES_DEFAULTS_COLUMNS = "columns";
    public static final String FILES_DEFAULTS_SEED = "seed";
    public static final String FILES_DEFAULTS_EXTENSION = "";

    public static final String EXPORT_FILE_NAME = "lab";
    public static final int EXPORT_VIEW_UNIT_SIZE = 60;
    public static final String EXPORT_SEED_EXTENSION = ".dat";
    public static final String EXPORT_IMAGE_EXTENSION = ".png";
    public static final String EXPORT_JSON_EXTENSION = ".json";
    public static final ExportTypes EXPORT_TYPE = ExportTypes.TO_VIEW;

}
