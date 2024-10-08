package com.gatica.jupiterBackend.livros.utils.pdfUtils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;

public class PdfUtils {

    private final PDFRenderer pdfRenderer;
    private final PDDocument pdDocument;
    private final PDFTextStripper pdfStripper;

    public PdfUtils(String path) throws IOException {
        this.pdDocument = PDDocument.load(new File(path));
        this.pdfRenderer = new PDFRenderer(this.pdDocument);
        this.pdfStripper = new PDFTextStripper();
    }

    public String gerarCapa() throws IOException {
        BufferedImage bim = pdfRenderer.renderImageWithDPI(0, 25, ImageType.RGB);

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


    public String gerarTitulo() {
        return pdDocument.getDocumentInformation().getTitle();
    }

    public String gerarAutor() {
        return pdDocument.getDocumentInformation().getAuthor();
    }

    public int gerarQuantidadePaginas() {
        return pdDocument.getPages().getCount();
    }

    public String gerarKeywords() {
        return pdDocument.getDocumentInformation().getKeywords();
    }

    public String[] gerarTexto() throws IOException {
         String texto = pdfStripper.getText(pdDocument);

         return removeEspaco(texto);
    }

    private String[] removeEspaco(String palavra) {
        String palavrae = palavra.replace("\n", " ");
        String palavraSemEspaco = palavrae.replace("  ", " ");
        return Arrays.stream(palavraSemEspaco.split(" "))
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);
    }


    public void fecharPdf() throws IOException {
        pdDocument.close();
    }
}
