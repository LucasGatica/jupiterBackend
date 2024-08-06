package com.gatica.jupiterBackend.livros.utils.pdfUtils;

import com.gatica.jupiterBackend.livros.model.livro.Livro;
import lombok.AllArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import java.io.File;
import java.io.IOException;

public class PdfUtils {

    private PDFRenderer pdfRenderer;
    private PDDocument pdDocument;

    public PdfUtils(String path) throws IOException {
        this.pdDocument = PDDocument.load(new File(path));
        this.pdfRenderer = new PDFRenderer(this.pdDocument);
    }

}
