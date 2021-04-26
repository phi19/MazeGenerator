package xyz.drena.exports;

public enum ExportTypes {
    TO_JSON(new ExportToJson()), // este ainda falta fazer
    TO_SEED(new ExportToSeed()), // este é o verdadeiro .dat, que na verdade vai ficar .seed e só vai ficar um ficheiro com uma seed lá dentro
    TO_IMAGE(new ExportToImage()), // este está bacano
    TO_VIEW(new ExportToView()); // este está also bacano

    private final Exportable exportable;

    ExportTypes(Exportable exportable) {
        this.exportable = exportable;
    }

    public Exportable getExportable() {
        return exportable;
    }
}
