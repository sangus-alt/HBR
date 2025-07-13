@GetMapping("/ticket/{id}")
public ResponseEntity<byte[]> ticket(@PathVariable Long id) {
    byte[] pdf = pdfService.generateTicketPDV(id);
    return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF)
            .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=ticket-" + id + ".pdf")
            .body(pdf);
}

@GetMapping("/recu/{id}")
public ResponseEntity<byte[]> recu(@PathVariable Long id) {
    byte[] pdf = pdfService.generateRecuPDF(id);
    return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF)
            .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=recu-" + id + ".pdf")
            .body(pdf);
}

@GetMapping("/proforma/{id}")
public ResponseEntity<byte[]> proforma(@PathVariable Long id) {
    byte[] pdf = pdfService.generateProformaPDF(id);
    return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF)
            .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=proforma-" + id + ".pdf")
            .body(pdf);
}

@GetMapping("/commande/{id}")
public ResponseEntity<byte[]> bonCommande(@PathVariable Long id) {
    byte[] pdf = pdfService.generateBonCommandePDF(id);
    return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF)
            .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=commande-" + id + ".pdf")
            .body(pdf);
}
