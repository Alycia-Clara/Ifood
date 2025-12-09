package com.example;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;


public class TelaDeLogin implements Initializable{

    @FXML private Pane telaCriarConta;
    @FXML private Pane telaEntrarConta;

    @FXML private Button bttCriarConta;
    @FXML private TextField textFieldNomeCriar;
    @FXML private TextField textFieldEmailCriar;
    @FXML private TextField textFieldSenhaCriar;
    
    @FXML private Button bttEntrarConta;
    @FXML private TextField textFieldNomeEmailEntrar;
    @FXML private TextField textFieldSenhaEntrar;
    

    @FXML private Label dicaNomeEmailEntrar;
    @FXML private Label dicaSenhaEntrar;
    @FXML private Label dicaNomeCriar;
    @FXML private Label dicaEmailCriar;
    @FXML private Label dicaSenhaCriar;


    @FXML private Label checkCliente;
    @FXML private Label checkDono;
    @FXML private ImageView imagem;
    @FXML private ImageView imagem2;

    private String tipoUsuario;

    private Usuario usuario;
    private UsuarioDataBase usuarioDataBase = new UsuarioDataBase();
    
    private double valorY;
    private double valorX;
    Timeline voltarPosicao = new Timeline();

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        blocoAnimadoFundo();

        textFieldNomeCriar.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 30) {
                dicaNomeCriar.setVisible(true);
                dicaNomeCriar.setText("Máximo de 30 caracteres!");
            }else if(newValue.length() == 0){
                dicaNomeCriar.setVisible(true);
                dicaNomeCriar.setText("Preencha este campo!");
            }else{ 
                dicaNomeCriar.setVisible(false);
            }
        });
        textFieldEmailCriar.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.length() == 0){
                dicaEmailCriar.setVisible(true);
                dicaEmailCriar.setText("Preencha este campo!");
            }else if (!newValue.contains("@gmail.com")) {
                dicaEmailCriar.setVisible(true);
                dicaEmailCriar.setText("coloque um email válido!");
            }else{ 
                dicaEmailCriar.setVisible(false);
            }
        });
        textFieldSenhaCriar.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 15) {
                dicaSenhaCriar.setVisible(true);
                dicaSenhaCriar.setText("Máximo de 15 caracteres!");
            }else if(newValue.length() == 0){
                dicaSenhaCriar.setVisible(true);
                dicaSenhaCriar.setText("Preencha este campo!");
            }else if(newValue.contains(" ")){
                dicaSenhaCriar.setVisible(true);
                dicaSenhaCriar.setText("Não pode conter espaços!");
            }else{ 
                dicaSenhaCriar.setVisible(false);
            }
        });

        textFieldNomeEmailEntrar.textProperty().addListener((observable, oldValue, newValue) -> {
            try {

                dicaNomeEmailEntrar.setVisible(false);
                if (newValue.length() > 30) {
                    dicaNomeEmailEntrar.setVisible(true);
                    dicaNomeEmailEntrar.setText("Máximo de 15 caracteres!");
                }
                else if(newValue.length() == 0 || oldValue.length() == 0){
                    dicaNomeEmailEntrar.setVisible(true);
                    dicaNomeEmailEntrar.setText("Preencha este campo!");
                }
                else if (usuarioDataBase.nomeUsuarioExiste(newValue) || usuarioDataBase.emailExiste(newValue)) {
                    dicaNomeEmailEntrar.setVisible(false);
                    dicaNomeEmailEntrar.setText(" ");
                }
                else{ 
                    dicaNomeEmailEntrar.setVisible(true);
                    dicaNomeEmailEntrar.setText("Nome ou email não encontrado!");
                }

            } catch (Exception e) {
                System.out.println("erro ao verificar nome/email: " + e.getMessage());
            }
            
        });
        textFieldSenhaEntrar.textProperty().addListener((observable, oldValue, newValue) -> {
            Usuario usrTemp = new Usuario(null, null, null, null);
            try{
                usrTemp = usuarioDataBase.verificarLogin(textFieldNomeEmailEntrar.getText(),newValue);
            }catch(SQLException e){

            }
            

            dicaSenhaEntrar.setVisible(false);
            if (newValue.length() > 15) {
                dicaSenhaEntrar.setVisible(true);
                dicaSenhaEntrar.setText("Máximo de 15 caracteres!");
            }
            else if(newValue.length() == 0 || oldValue.length() == 0){
                dicaSenhaEntrar.setVisible(true);
                dicaSenhaEntrar.setText("Preencha este campo!");
            }
            else if (usrTemp == null) {
                dicaSenhaEntrar.setVisible(true);
                dicaSenhaEntrar.setText("SENHA INCORRETA");
            }
            
        });

    }

    public void blocoAnimadoFundo(){
        imagem.setVisible(true);
        imagem2.setVisible(true);
        imagem.toBack();
        imagem2.toBack();
        TranslateTransition mover = new TranslateTransition(javafx.util.Duration.seconds(2), imagem);
        RotateTransition rotate = new RotateTransition(javafx.util.Duration.seconds(2), imagem);
        TranslateTransition mover2 = new TranslateTransition(javafx.util.Duration.seconds(2), imagem2);
        RotateTransition rotate2 = new RotateTransition(javafx.util.Duration.seconds(2), imagem2);


        rotate.setByAngle(1200);    
        mover.setByX(1050);
        
        rotate2.setByAngle(-1225);
        mover2.setByX(-1050);
        
        rotate.play();
        rotate2.play();

        mover.play();
        mover2.play();

        mover.setOnFinished( e->{
            ScaleTransition escala = new ScaleTransition(javafx.util.Duration.seconds(0.1), imagem);
            TranslateTransition moverVolta = new TranslateTransition(javafx.util.Duration.seconds(2), imagem);
            escala.setToX(4);
            escala.setToY(4);
            moverVolta.setByX(-200);
            escala.play();
            moverVolta.play();

            moverVolta.setOnFinished(event->{
                TranslateTransition moverVolta2 = new TranslateTransition(javafx.util.Duration.seconds(3), imagem);
                moverVolta2.setByX(20);
                moverVolta2.setCycleCount(Timeline.INDEFINITE);
                moverVolta2.autoReverseProperty().set(true);
                moverVolta2.play();
            });
        });

        mover2.setOnFinished( e->{
            ScaleTransition escala = new ScaleTransition(javafx.util.Duration.seconds(0.1), imagem2);
            TranslateTransition moverVolta = new TranslateTransition(javafx.util.Duration.seconds(2), imagem2);
            escala.setToX(4);
            escala.setToY(4);
            moverVolta.setByX(200);
            escala.play();
            moverVolta.play();

            moverVolta.setOnFinished(event->{
                TranslateTransition moverVolta2 = new TranslateTransition(javafx.util.Duration.seconds(3), imagem2);
                moverVolta2.setByX(-20);
                moverVolta2.setCycleCount(Timeline.INDEFINITE);
                moverVolta2.autoReverseProperty().set(true);
                moverVolta2.play();
            });
        });
        
        
        imagem.setOnMousePressed(e -> {
            valorX = e.getSceneX() - ((Node)e.getSource()).getLayoutX();
            valorY = e.getSceneY() - ((Node)e.getSource()).getLayoutY();
            voltarPosicao.stop();
        });
        imagem.setOnMouseDragged(e -> {
            ((Node)e.getSource()).setLayoutX(e.getSceneX() - valorX);
            ((Node)e.getSource()).setLayoutY(e.getSceneY() - valorY);
        });
        imagem.setOnMouseReleased(e ->{
            voltarPosicao = new Timeline(
                new KeyFrame(Duration.millis(1000),
                    new KeyValue(imagem.layoutXProperty(), -150),
                    new KeyValue(imagem.layoutYProperty(), 142)
                ) 
            );

            voltarPosicao.play();
        });


        imagem2.setOnMousePressed(e -> {
            valorX = e.getSceneX() - ((Node)e.getSource()).getLayoutX();
            valorY = e.getSceneY() - ((Node)e.getSource()).getLayoutY();
        });
        imagem2.setOnMouseDragged(e -> {
            ((Node)e.getSource()).setLayoutX(e.getSceneX() - valorX);
            ((Node)e.getSource()).setLayoutY(e.getSceneY() - valorY);
            
        });
        imagem2.setOnMouseReleased(e ->{
            voltarPosicao = new Timeline(
                new KeyFrame(Duration.millis(1000),
                    new KeyValue(imagem2.layoutXProperty(), 650),
                    new KeyValue(imagem2.layoutYProperty(), 170)
                ) 
            );

            voltarPosicao.play();
        });

    }

    public void VizualizarCriarConta(){
        textFieldNomeEmailEntrar.clear();
        textFieldSenhaEntrar.clear();
        telaCriarConta.setVisible(true);
        telaEntrarConta.setVisible(false);
    }
    public void VizualizarTelaLogin(){
        textFieldNomeCriar.clear();
        textFieldEmailCriar.clear();
        textFieldSenhaCriar.clear();
        checkCliente.setStyle("-fx-background-color:gray;-fx-background-radius: 8;");
        checkDono.setStyle("-fx-background-color:gray;-fx-background-radius: 8;");
        tipoUsuario = null;
        telaEntrarConta.setVisible(true);
        telaCriarConta.setVisible(false);
    }


    public void escolherTipo(MouseEvent e){
        Label atual = (Label) e.getSource();

        if (atual == checkCliente) {
            checkCliente.setStyle("-fx-background-color:GREEN;-fx-background-radius: 8;");
            checkDono.setStyle("-fx-background-color:gray;-fx-background-radius: 8;");
            tipoUsuario = "cliente";

        } else if (atual == checkDono) {

            checkDono.setStyle("-fx-background-color:GREEN;-fx-background-radius: 8;");
            checkCliente.setStyle("-fx-background-color:gray;-fx-background-radius: 8;");
            tipoUsuario = "dono";
        }

    }

    public void criarConta(){
        usuario = new Usuario(
            textFieldNomeCriar.getText(),
            textFieldSenhaCriar.getText(),
            textFieldEmailCriar.getText(),
            tipoUsuario
        );
        if (usuario.getNome().length() > 0 && usuario.getSenha().length() > 0 && usuario.getEmail().length() > 0 && usuario.getTipo() != null) {
            try {

                usuarioDataBase.inserirUsuario(usuario);    
                System.out.println("CONTA CRIADA COM SUCESSO!");
                App.setRoot("Restaurantes");

            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }else{
            if(dicaNomeCriar.isVisible()){
                vibrarCampo(textFieldNomeCriar);
            }
            if (dicaEmailCriar.isVisible()) {
                vibrarCampo(textFieldEmailCriar);
            }
            if(dicaSenhaCriar.isVisible()){
                vibrarCampo(textFieldSenhaCriar);
            }
            
            System.out.println("PREENCHA TODOS OS CAMPOS!");
        }
    }

    public void entrarConta(){
        String nomeEmail = textFieldNomeEmailEntrar.getText();
        String senha = textFieldSenhaEntrar.getText();

        if (!dicaNomeEmailEntrar.isVisible() && !dicaSenhaEntrar.isVisible()) {
            
            try {
                App.setRoot("Restaurantes");    
            } catch (Exception e) {
            }
    
        }else{
            try {
                usuario = usuarioDataBase.verificarLogin(nomeEmail, senha);
                if (usuario == null) {
                    System.out.println("PREENCHA TODOS OS CAMPOS!");    
                }
                
            } catch (SQLException e) {
                System.out.println("Erro ao verificar login: " + e.getMessage());
            }
            if(dicaNomeEmailEntrar.isVisible()){
                vibrarCampo(textFieldNomeEmailEntrar);
            }
            if (dicaSenhaEntrar.isVisible()) {
                vibrarCampo(textFieldSenhaEntrar);
            }
            
        }
    }
        
    public void vibrarCampo(TextField campo){

        TranslateTransition direita = new TranslateTransition(javafx.util.Duration.seconds(0.07), campo);
        String originial = campo.getStyle();

        ColorAdjust colorAdjust = new ColorAdjust();


        direita.setByX(5);
        direita.autoReverseProperty().set(true);
        direita.setCycleCount(4);
        direita.play();
        direita.setOnFinished(e->{
            campo.setStyle(originial);
        });
    }

}
