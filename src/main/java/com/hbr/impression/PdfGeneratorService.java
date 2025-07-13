package com.hbr.impression;

import com.hbr.model.Facture;
import com.hbr.repository.FactureRepository;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.*;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.TextAlignment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
@RequiredArgsConstructor
public class PdfGeneratorService {

    private final FactureRepository factureRepository;

    // 🧾 FACTURE
    public byte[] generateFacturePDF(Long factureId) {
        Facture facture = getFacture(factureId);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfDocument pdf = new PdfDocument(new PdfWriter(baos));
        Document doc = new Document(pdf);

        doc.add(new Paragraph("FACTURE N° " + facture.getNumero()).setBold().setFontSize(16));
        doc.add(new Paragraph("Date : " + facture.getDateEmission()));
        doc.add(new Paragraph("Client : " + facture.getClient().getNom()));

        doc.add(new Paragraph("Produits achetés :"));
        for (var ligne : facture.getLignes()) {
            doc.add(new Paragraph(ligne.getProduit().getNom() + " x" + ligne.getQuantite() +
                    " - " + ligne.getPrixUnitaire() + " FCFA"));
        }

        doc.add(new Paragraph("Total TTC : " + facture.getMontantTotal() + " FCFA").setBold());
        doc.close();
        return baos.toByteArray();
    }

    // 🎟️ TICKET PDV
    public byte[] generateTicketPDV(Long venteId) {
        Facture ticket = getFacture(venteId);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfDocument pdf = new PdfDocument(new PdfWriter(baos));
        Document doc = new Document(pdf).setFontSize(10);

        doc.add(new Paragraph("TICKET DE CAISSE").setBold().setTextAlignment(TextAlignment.CENTER));
        doc.add(new Paragraph("Bar RESTO HBR"));
        doc.add(new Paragraph("Date : " + ticket.getDateEmission()));
        doc.add(new Paragraph("Heure : " + ticket.getDateEmission().toLocalTime()));
        doc.add(new Paragraph("-------------------------------"));

        for (var ligne : ticket.getLignes()) {
            doc.add(new Paragraph(
                ligne.getProduit().getNom() + " x" + ligne.getQuantite() +
                " .. " + (ligne.getPrixUnitaire() * ligne.getQuantite()) + " FCFA"));
        }

        doc.add(new Paragraph("-------------------------------"));
        doc.add(new Paragraph("TOTAL : " + ticket.getMontantTotal() + " FCFA").setBold());
        doc.add(new Paragraph("MERCI DE VOTRE VISITE").setTextAlignment(TextAlignment.CENTER));
        doc.close();
        return baos.toByteArray();
    }

    // 🧾 REÇU
    public byte[] generateRecuPDF(Long paiementId) {
        Facture facture = getFacture(paiementId);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfDocument pdf = new PdfDocument(new PdfWriter(baos));
        Document doc = new Document(pdf);

        doc.add(new Paragraph("REÇU DE PAIEMENT").setBold());
        doc.add(new Paragraph("Date : " + facture.getDateEmission()));
        doc.add(new Paragraph("Client : " + facture.getClient().getNom()));
        doc.add(new Paragraph("Montant payé : " + facture.getMontantVerse() + " FCFA"));
        doc.add(new Paragraph("Reste à payer : " + facture.getResteAPayer() + " FCFA"));
        doc.add(new Paragraph("Merci pour votre paiement.").setItalic());

        doc.close();
        return baos.toByteArray();
    }

    // 📄 PRO-FORMA
    public byte[] generateProformaPDF(Long factureId) {
        Facture devis = getFacture(factureId);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfDocument pdf = new PdfDocument(new PdfWriter(baos));
        Document doc = new Document(pdf);

        doc.add(new Paragraph("DEVIS PRO-FORMA").setBold().setFontSize(16));
        doc.add(new Paragraph("Client : " + devis.getClient().getNom()));
        doc.add(new Paragraph("Date : " + devis.getDateEmission()));

        for (var ligne : devis.getLignes()) {
            doc.add(new Paragraph(ligne.getProduit().getNom() + " x" + ligne.getQuantite()
                    + " - " + ligne.getPrixUnitaire() + " FCFA"));
        }

        doc.add(new Paragraph("Total estimé : " + devis.getMontantTotal() + " FCFA").setBold());
        doc.close();
        return baos.toByteArray();
    }

    // 📃 BON DE COMMANDE
    public byte[] generateBonCommandePDF(Long commandeId) {
        Facture commande = getFacture(commandeId);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfDocument pdf = new PdfDocument(new PdfWriter(baos));
        Document doc = new Document(pdf);

        doc.add(new Paragraph("BON DE COMMANDE").setBold());
        doc.add(new Paragraph("N°: " + commande.getNumero()));
        doc.add(new Paragraph("Date : " + commande.getDateEmission()));

        for (var ligne : commande.getLignes()) {
            doc.add(new Paragraph("- " + ligne.getProduit().getNom() +
                    " (" + ligne.getQuantite() + " unités)"));
        }

        doc.add(new Paragraph("Total Commande : " + commande.getMontantTotal() + " FCFA"));
        doc.close();
        return baos.toByteArray();
    }

    // 🔒 Méthode utilitaire privée
    private Facture getFacture(Long id) {
        return factureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Facture introuvable"));
    }
}
