package com.example;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class TelaRestaurantes implements Initializable{
    @FXML private Pane telaToda;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        acaoBotaoPagar();
    }

    public void acaoBotaoPagar(){
        Set<Node> produtos = telaToda.lookupAll("#produto");

        for(Node produto : produtos){
            Label botaoPagar = (Label)produto.lookup("#botao-pagar");
            botaoPagar.setOnMouseEntered(e ->{
                ScaleTransition aumentar = new ScaleTransition(javafx.util.Duration.seconds(0.2), botaoPagar);
                aumentar.setToX(1.1);
                aumentar.setToY(1.1);
                aumentar.play();
                botaoPagar.setCursor(Cursor.OPEN_HAND);
            });
            botaoPagar.setOnMouseExited(e ->{
                ScaleTransition diminuir = new ScaleTransition(javafx.util.Duration.seconds(0.2), botaoPagar);
                diminuir.setToX(1);
                diminuir.setToY(1);
                diminuir.play();
                botaoPagar.setCursor(Cursor.DEFAULT);
            });
            botaoPagar.setOnMouseClicked(e ->{
                ScaleTransition clicou = new ScaleTransition(javafx.util.Duration.seconds(0.2), botaoPagar);
                ScaleTransition voltou = new ScaleTransition(javafx.util.Duration.seconds(0.2), botaoPagar);
                clicou.setToX(1);
                clicou.setToY(1);
                clicou.play();
                botaoPagar.setCursor(Cursor.CLOSED_HAND);
                clicou.setOnFinished( ev ->{
                    voltou.setToX(1.1);
                    voltou.setToY(1.1);
                    voltou.play();
                    botaoPagar.setCursor(Cursor.OPEN_HAND);
                });
            });
            
        }

    }
    
}
