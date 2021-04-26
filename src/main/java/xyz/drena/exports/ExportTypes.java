package xyz.drena.exports;

public enum ExportTypes {
    TO_JSON(new ExportToJson()),
    TO_SEED(new ExportToSeed()),
    TO_IMAGE(new ExportToImage()),
    TO_VIEW(new ExportToView());

    private final Exportable exportable;

    ExportTypes(Exportable exportable) {
        this.exportable = exportable;
    }

    public Exportable getExportable() {
        return exportable;
    }
}
