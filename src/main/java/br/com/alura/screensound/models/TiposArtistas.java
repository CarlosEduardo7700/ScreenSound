package br.com.alura.screensound.models;

public enum TiposArtistas {
    SOLO("Solo"),
    DUPLA("Dupla"),
    BANDA("Banda");

    private String tipoInString;

    TiposArtistas (String tipoInString) {
        this.tipoInString = tipoInString;
    }

    public static TiposArtistas fromString(String text) {
        for (TiposArtistas tiposArtistas : TiposArtistas.values()) {
            if (tiposArtistas.tipoInString.equalsIgnoreCase(text)) {
                return tiposArtistas;
            }
        }
        throw new IllegalArgumentException("Nenhum tipo encontrado para a string fornecida: " + text);
    }
}
