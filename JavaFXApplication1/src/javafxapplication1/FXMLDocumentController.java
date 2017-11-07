/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author jirka
 */
public class FXMLDocumentController implements Initializable {
    
    private boolean debug = true;
    
    @FXML
    private Label label;
    @FXML
    private TextField separatorSentence;
    @FXML
    private TextField userText;
    @FXML
    private TextField separatorWord;
    @FXML
    private Button buttonAnalyze1;
    @FXML
    private Button buttonAnalyze2;
    @FXML
    private Button buttonAnalyze3;
    @FXML
    private Button buttonAnalyze4;
    @FXML
    private Button buttonAnalyze5;
    @FXML
    private Button buttonAnalyze6;
    @FXML
    private Button buttonAnalyze7;
    @FXML
    private Button buttonAnalyze8;
    @FXML
    private Button buttonAnalyze9;
    @FXML
    private Button buttonAnalyze10;
    @FXML
    private Button buttonAnalyze11;
    @FXML
    private Button buttonAnalyze12;
    

    @FXML
    private void handleButtonAnalyze1(ActionEvent event) {
        Analyze(AnalyzeType.CHAR_COUNT);
    }

    @FXML
    private void handleButtonAnalyze2(ActionEvent event) {
        Analyze(AnalyzeType.MIRROR);
    }

    @FXML
    private void handleButtonAnalyze3(ActionEvent event) {
        Analyze(AnalyzeType.RANDOM_INT);
    }

    @FXML
    private void handleButtonAnalyze4(ActionEvent event) {
        Analyze(AnalyzeType.SENTENCE);
    }

    @FXML
    private void handleButtonAnalyze5(ActionEvent event) {
        Analyze(AnalyzeType.SENTENCE_AVG);
    }

    @FXML
    private void handleButtonAnalyze6(ActionEvent event) {
        Analyze(AnalyzeType.WORD_COUNT);
    }

    @FXML
    private void handleButtonAnalyze7(ActionEvent event) {
        Analyze(AnalyzeType.SPACE_COUNT);
    }

    @FXML
    private void handleButtonAnalyze8(ActionEvent event) {
        Analyze(AnalyzeType.DELIMETER_COUNT);
    }

    @FXML
    private void handleButtonAnalyze9(ActionEvent event) {
        Analyze(AnalyzeType.WORD);
    }

    @FXML
    private void handleButtonAnalyze10(ActionEvent event) {
        Analyze(AnalyzeType.WORD_AVR);
    }

    @FXML
    private void handleButtonAnalyze11(ActionEvent event) {
        Analyze(AnalyzeType.MIN_MAX);
    }

    @FXML
    private void handleButtonAnalyze12(ActionEvent event) {
        Analyze(AnalyzeType.CHOKO);
    }

    
    private enum AnalyzeType{
        CHAR_COUNT,
        RANDOM_INT,
        MIRROR,
        SENTENCE,
        SENTENCE_AVG,
        WORD_COUNT,
        SPACE_COUNT,
        DELIMETER_COUNT,
        WORD,
        WORD_AVR,
        MIN_MAX,
        CHOKO
       /* MIN_MAX,
        CONTAINS_CHOK,
        WORD_AVG,
        WORD,
        SPACE_COUNT,
        DELIMITER_COUNT,*/
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(debug){
            buttonAnalyze1.setText(AnalyzeType.CHAR_COUNT.name());
            buttonAnalyze2.setText(AnalyzeType.MIRROR.name());
            buttonAnalyze3.setText(AnalyzeType.RANDOM_INT.name());
            buttonAnalyze4.setText(AnalyzeType.SENTENCE.name());
            buttonAnalyze5.setText(AnalyzeType.SENTENCE_AVG.name());
            buttonAnalyze6.setText(AnalyzeType.WORD_COUNT.name());
            buttonAnalyze7.setText(AnalyzeType.SPACE_COUNT.name());
            buttonAnalyze8.setText(AnalyzeType.DELIMETER_COUNT.name());
            buttonAnalyze9.setText(AnalyzeType.WORD.name());
            buttonAnalyze10.setText(AnalyzeType.WORD_AVR.name());
            buttonAnalyze11.setText(AnalyzeType.MIN_MAX.name());
            buttonAnalyze12.setText(AnalyzeType.CHOKO.name());
            /*buttonAnalyze13.setText(AnalyzeType.WORD_COUNT.name());*/
        }
    }    
    
    private void Analyze(AnalyzeType type){
        AnalyzeCheckSetDefault();
        String userInput = userText.getText();
        String wordLimiter = separatorWord.getText();
        String sentenceLimiter = separatorSentence.getText();
        
        String returnText;
        switch(type){
            case CHAR_COUNT : 
                returnText = Analysis.writeAnalyze(Analysis.analyzeChar(userInput));
                break;
            case MIRROR : 
                returnText = Analysis.writeAnalyze(Analysis.analyzeMirror(userInput));
                break;
            case RANDOM_INT : 
                returnText = Analysis.writeAnalyze(Analysis.analyzeRandomInt());
                break;
            case SENTENCE : 
                returnText = Analysis.writeAnalyze(Analysis.analyzeSentence(sentenceLimiter, userInput));
                break;
            case SENTENCE_AVG : 
                returnText = Analysis.writeAnalyze(Analysis.analyzeSentenceAverage(sentenceLimiter, userInput));
                break;
            case WORD_COUNT : 
                returnText = Analysis.writeAnalyze(Analysis.analyzeWordCount(wordLimiter,sentenceLimiter,userInput));
                break;
            case DELIMETER_COUNT : 
                returnText = Analysis.writeAnalyze(Analysis.analyzeWordDelimiterCount(wordLimiter, userInput));
                break;
            case SPACE_COUNT :
                returnText = Analysis.writeAnalyze(Analysis.analyzeSpaceCount(userInput));
                break;
            case WORD : 
                returnText = Analysis.writeAnalyze(Analysis.analyzeWordsLengthFrequency(userInput, wordLimiter, sentenceLimiter));
                break;
            case WORD_AVR : 
                returnText = Analysis.writeAnalyze(Analysis.analyzeWordsLengthAverage(userInput, wordLimiter, sentenceLimiter));
                break;
            case MIN_MAX : 
                returnText = Analysis.writeAnalyze(Analysis.analyzeDifferenceMinMaxWordLength(userInput, wordLimiter, sentenceLimiter));
                break;
            case CHOKO : 
                returnText = Analysis.writeAnalyze(Analysis.analyzeContainsChockolate(wordLimiter, sentenceLimiter, userInput));
                break;
            default:
                returnText ="Unknown analyse";
        }
        
        label.setText(returnText);
    }
    
    private void AnalyzeCheckSetDefault(){
        if(separatorSentence.getText().equals("")){
            separatorSentence.setText(".");
        }
        
        if(separatorWord.getText().equals("")){
            separatorWord.setText(" ");
        }
    }
}
