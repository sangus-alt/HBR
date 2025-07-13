package com.hbr.controller;

import com.hbr.impression.PdfGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/impression")
@RequiredArgsConstructor
public class ImpressionController {

    private final PdfGeneratorService pdfService;

    // 📄 FACTURE
    @GetMapping("/facture/{id}")
    public ResponseEntity<byte[]> facture(@PathVariable Long id) {
        byte[] pdf = pdfService.generateFacturePDF(id);
        return buildPdfResponse(pdf, "facture-" + id + ".pdf");
    }

    // 🎟️ TICKET DE CAISSE / PDV
    @GetMapping("/ticket/{id}")
    public ResponseEntity<byte[]> ticket(@PathVariable Long id) {
        byte[] pdf = pdfService.generateTicketPDV(id);
        return buildPdfResponse(pdf, "ticket-" + id + ".pdf");
    }

    // 🧾 REÇU DE PAIEMENT
    @GetMapping("/recu/{id}")
    public ResponseEntity<byte[]> recu(@PathVariable Long id) {
        byte[] pdf = pdfService.generateRecuPDF(id);
        return buildPdfResponse(pdf, "recu-" + id + ".pdf");
    }

    // 📃 PRO-FORMA
    @GetMapping("/proforma/{id}")
    public ResponseEntity<byte[]> proforma(@PathVariable Long id) {
        byte[] pdf = pdfService.generateProformaPDF(id);
        return buildPdfResponse(pdf, "proforma-" + id + ".pdf");
    }

    // 📝 BON DE COMMANDE
    @GetMapping("/commande/{id}")
    public ResponseEntity<byte[]> commande(@PathVariable Long id) {
        byte[] pdf = pdfService.generateBonCommandePDF(id);
        return buildPdfResponse(pdf, "commande-" + id + ".pdf");
    }

    // 🔒 Méthode utilitaire
    private ResponseEntity<byte[]> buildPdfResponse(byte[] data, String filename) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + filename)
                .body(data);
    }
}
