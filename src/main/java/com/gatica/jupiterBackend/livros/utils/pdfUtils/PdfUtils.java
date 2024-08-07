package com.gatica.jupiterBackend.livros.utils.pdfUtils;

import com.gatica.jupiterBackend.livros.model.livro.Livro;
import lombok.AllArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class PdfUtils {

    private PDFRenderer pdfRenderer;
    private PDDocument pdDocument;

    public PdfUtils(String path) throws IOException {
        this.pdDocument = PDDocument.load(new File(path));
        this.pdfRenderer = new PDFRenderer(this.pdDocument);
    }

    public String gerarCapa() throws IOException {
        BufferedImage bim = pdfRenderer.renderImageWithDPI(0, 30, ImageType.RGB);

        return gerarBase64(bim);
    }

    private String gerarBase64(BufferedImage image) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            byte[] imageBytes = baos.toByteArray();
            return Base64.getEncoder().encodeToString(imageBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
}
