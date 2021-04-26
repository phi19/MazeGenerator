package xyz.drena.view;

import xyz.drena.exports.ExportTypes;

public class Constants {

    public static final int ALGORITHM_LAB_ROWS = 14;
    public static final int ALGORITHM_LAB_COLUMNS = 11;

    public static final int GENERATOR_LAB_ROWS = ALGORITHM_LAB_ROWS * 2 + 1;
    public static final int GENERATOR_LAB_COLUMNS = ALGORITHM_LAB_COLUMNS * 2 + 1;

    public static final int VIEWER_UNIT_SIZE = 25;
    public static final int VIEWER_PADDING = 10;

    public static final int RANDOMIZER_TOTAL_SEEDS = 16000000;
    public static final int RANDOMIZER_PREDEFINED_SEED = 69*69;
    public static final boolean RANDOMIZER_USE_PREDEFINED_SEED = true;

    public static final String FILES_EXPORT_PATH = "src/main/resources/";
    public static final String FILE_EXPORT_NAME = "lab";

    public static final int EXPORT_VIEW_UNIT_SIZE = 60;
    public static final String EXPORT_SEED_EXTENSION = ".dat";
    public static final String EXPORT_IMAGE_EXTENSION = ".png";
    public static final String EXPORT_JSON_EXTENSION = ".json";
    public static final ExportTypes EXPORT_TYPE = ExportTypes.TO_VIEW;

}
