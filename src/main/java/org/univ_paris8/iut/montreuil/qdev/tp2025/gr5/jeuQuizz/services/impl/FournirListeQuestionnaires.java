package org.univ_paris8.iut.montreuil.qdev.tp2025.gr5.jeuQuizz.services.impl;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr5.jeuQuizz.entities.dto.QuestionDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr5.jeuQuizz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr5.jeuQuizz.services.interfaces.FournirListeQuestionnairesInterface;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr5.jeuQuizz.utils.enums.Langue;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr5.jeuQuizz.utils.exceptions.fournirListeQuestionnaireExceptions.FichierCorrompuException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr5.jeuQuizz.utils.exceptions.fournirListeQuestionnaireExceptions.FormatFichierInvalideException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr5.jeuQuizz.utils.exceptions.fournirListeQuestionnaireExceptions.FournirQuestionnaireException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FournirListeQuestionnaires implements FournirListeQuestionnairesInterface {

    @Override
    public ArrayList<QuestionnaireDTO> fournirListeQuestionnaires(String cheminFichierCSV) throws FournirQuestionnaireException {
        Map<Integer, QuestionnaireDTO> questionnaireMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(cheminFichierCSV))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] champs = ligne.split(";");
                if (champs.length < 8) continue; // Vérification que la ligne a bien toutes les colonnes attendues

                try {
                    int idQuestionnaire = Integer.parseInt(champs[0]);
                    int numQuestion = Integer.parseInt(champs[1]);
                    Langue langue = Langue.valueOf(champs[2].toUpperCase()); // Assumant que Langue est un Enum
                    String libelle = champs[3];
                    String reponse = champs[4];
                    int difficulte = Integer.parseInt(champs[5]);
                    String explication = champs[6];
                    String reference = champs[7];

                    // Récupérer ou créer le questionnaire correspondant
                    QuestionnaireDTO questionnaire = questionnaireMap.computeIfAbsent(idQuestionnaire, id -> new QuestionnaireDTO("Questionnaire " + id));

                    // Ajouter la question au questionnaire
                    QuestionDTO question = new QuestionDTO(idQuestionnaire, numQuestion, langue, libelle, reponse, difficulte, explication, reference);
                    questionnaire.ajouterQuestion(question);

                } catch (IllegalArgumentException e) {
                    System.err.println("Erreur de format dans le fichier : " + ligne);
                }
            }
        } catch (IOException e) {
            throw new FichierCorrompuException();
        }

        return new ArrayList<>(questionnaireMap.values());
    }
}
