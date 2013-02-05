/*
 * IndiceMassaCorporea.java
 *
 * Created on 12 de Janeiro de 2006, 15:07
 */

package br.com.leonardo.imc;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 *
 * @author Leonardo
 */
public class IndiceMassaCorporea extends MIDlet implements javax.microedition.lcdui.CommandListener {
    private String resultado = "";
    
    /** Creates a new instance of IndiceMassaCorporea */
    public IndiceMassaCorporea() {
    }
    
    private Form frmFormulario;//GEN-BEGIN:MVDFields
    private Command cmdSair;
    private Image imgLeo;
    private TextField txtPeso;
    private TextField txtAltura;
    private Command cmdCalcular;
    private Form frmResultado;
    private Command cmdVoltar;
    private Command cmdSair1;
    private StringItem lblResultado;//GEN-END:MVDFields

//GEN-LINE:MVDMethods

    /** This method initializes UI of the application.//GEN-BEGIN:MVDInitBegin
     */
    private void initialize() {//GEN-END:MVDInitBegin
        TelaSplash splash = new TelaSplash();
        this.getDisplay().setCurrent(splash);
        splash.mostrarTela();
        
        while (!splash.mostrouSplash) { }
        this.getDisplay().setCurrent(this.get_frmFormulario());
//GEN-LINE:MVDInitInit
        // Insert post-init code here
    }//GEN-LINE:MVDInitEnd

    /**
     * This method should return an instance of the display.
     */
    public Display getDisplay () {//GEN-FIRST:MVDGetDisplay
        return Display.getDisplay (this);
    }//GEN-LAST:MVDGetDisplay

    /**
     * This method should exit the midlet.
     */
    public void exitMIDlet () {//GEN-FIRST:MVDExitMidlet
        getDisplay ().setCurrent (null);
        destroyApp (true);
        notifyDestroyed ();
    }//GEN-LAST:MVDExitMidlet

    /** Called by the system to indicate that a command has been invoked on a particular displayable.//GEN-BEGIN:MVDCABegin
     * @param command the Command that ws invoked
     * @param displayable the Displayable on which the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:MVDCABegin
    // Insert global pre-action code here
        if (displayable == frmFormulario) {//GEN-BEGIN:MVDCABody
            if (command == cmdSair) {//GEN-END:MVDCABody
                // Insert pre-action code here
                exitMIDlet();//GEN-LINE:MVDCAAction5
                // Insert post-action code here
            } else if (command == cmdCalcular) {//GEN-LINE:MVDCACase5
                this.lblResultado = null;
                this.frmResultado = null;
                this.atualizaResultado();
                // Do nothing//GEN-LINE:MVDCAAction10
                // Insert post-action code here
            }//GEN-BEGIN:MVDCACase10
        } else if (displayable == frmResultado) {
            if (command == cmdVoltar) {//GEN-END:MVDCACase10
                // Insert pre-action code here
                getDisplay().setCurrent(get_frmFormulario());//GEN-LINE:MVDCAAction21
                // Insert post-action code here
            } else if (command == cmdSair1) {//GEN-LINE:MVDCACase21
                // Insert pre-action code here
                exitMIDlet();//GEN-LINE:MVDCAAction23
                // Insert post-action code here
            }//GEN-BEGIN:MVDCACase23
        }//GEN-END:MVDCACase23
    // Insert global post-action code here
}//GEN-LINE:MVDCAEnd

    /** This method returns instance for frmFormulario component and should be called instead of accessing frmFormulario field directly.//GEN-BEGIN:MVDGetBegin2
     * @return Instance for frmFormulario component
     */
    public Form get_frmFormulario() {
        if (frmFormulario == null) {//GEN-END:MVDGetBegin2
            
            frmFormulario = new Form("IMC - Dados", new Item[] {//GEN-BEGIN:MVDGetInit2
                get_txtPeso(),
                get_txtAltura()
            });
            frmFormulario.addCommand(get_cmdSair());
            frmFormulario.addCommand(get_cmdCalcular());
            frmFormulario.setCommandListener(this);//GEN-END:MVDGetInit2
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd2
        return frmFormulario;
    }//GEN-END:MVDGetEnd2
    /** This method returns instance for cmdSair component and should be called instead of accessing cmdSair field directly.//GEN-BEGIN:MVDGetBegin4
     * @return Instance for cmdSair component
     */
    public Command get_cmdSair() {
        if (cmdSair == null) {//GEN-END:MVDGetBegin4
            // Insert pre-init code here
            cmdSair = new Command("Sair", Command.EXIT, 2);//GEN-LINE:MVDGetInit4
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd4
        return cmdSair;
    }//GEN-END:MVDGetEnd4

    /** This method returns instance for imgLeo component and should be called instead of accessing imgLeo field directly.//GEN-BEGIN:MVDGetBegin6
     * @return Instance for imgLeo component
     */
    public Image get_imgLeo() {
        if (imgLeo == null) {//GEN-END:MVDGetBegin6
            // Insert pre-init code here
            try {//GEN-BEGIN:MVDGetInit6
                imgLeo = Image.createImage("/br/com/leonardo/imc/Leo.png");
            } catch (java.io.IOException exception) {
            }//GEN-END:MVDGetInit6
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd6
        return imgLeo;
    }//GEN-END:MVDGetEnd6

    /** This method returns instance for txtPeso component and should be called instead of accessing txtPeso field directly.//GEN-BEGIN:MVDGetBegin7
     * @return Instance for txtPeso component
     */
    public TextField get_txtPeso() {
        if (txtPeso == null) {//GEN-END:MVDGetBegin7
            // Insert pre-init code here
            txtPeso = new TextField("Peso: (Kg)", "", 8, TextField.DECIMAL);//GEN-LINE:MVDGetInit7
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd7
        return txtPeso;
    }//GEN-END:MVDGetEnd7

    /** This method returns instance for txtAltura component and should be called instead of accessing txtAltura field directly.//GEN-BEGIN:MVDGetBegin8
     * @return Instance for txtAltura component
     */
    public TextField get_txtAltura() {
        if (txtAltura == null) {//GEN-END:MVDGetBegin8
            // Insert pre-init code here
            txtAltura = new TextField("Altura: (metro)", "", 8, TextField.DECIMAL);//GEN-LINE:MVDGetInit8
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd8
        return txtAltura;
    }//GEN-END:MVDGetEnd8

    /** This method returns instance for cmdCalcular component and should be called instead of accessing cmdCalcular field directly.//GEN-BEGIN:MVDGetBegin9
     * @return Instance for cmdCalcular component
     */
    public Command get_cmdCalcular() {
        if (cmdCalcular == null) {//GEN-END:MVDGetBegin9
            // Insert pre-init code here
            cmdCalcular = new Command("Calcular", Command.EXIT, 1);//GEN-LINE:MVDGetInit9
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd9
        return cmdCalcular;
    }//GEN-END:MVDGetEnd9

        /** This method returns instance for frmResultado component and should be called instead of accessing frmResultado field directly.//GEN-BEGIN:MVDGetBegin18
     * @return Instance for frmResultado component
     */
    public Form get_frmResultado() {
        if (frmResultado == null) {//GEN-END:MVDGetBegin18
            // Insert pre-init code here
            frmResultado = new Form("IMC - Resultado", new Item[] {get_lblResultado()});//GEN-BEGIN:MVDGetInit18
            frmResultado.addCommand(get_cmdVoltar());
            frmResultado.addCommand(get_cmdSair1());
            frmResultado.setCommandListener(this);//GEN-END:MVDGetInit18
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd18
        return frmResultado;
    }//GEN-END:MVDGetEnd18
     /** This method returns instance for cmdVoltar component and should be called instead of accessing cmdVoltar field directly.//GEN-BEGIN:MVDGetBegin20
     * @return Instance for cmdVoltar component
     */
    public Command get_cmdVoltar() {
        if (cmdVoltar == null) {//GEN-END:MVDGetBegin20
            // Insert pre-init code here
            cmdVoltar = new Command("Voltar", Command.BACK, 1);//GEN-LINE:MVDGetInit20
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd20
        return cmdVoltar;
    }//GEN-END:MVDGetEnd20

    /** This method returns instance for cmdSair1 component and should be called instead of accessing cmdSair1 field directly.//GEN-BEGIN:MVDGetBegin22
     * @return Instance for cmdSair1 component
     */
    public Command get_cmdSair1() {
        if (cmdSair1 == null) {//GEN-END:MVDGetBegin22
            // Insert pre-init code here
            cmdSair1 = new Command("Sair", Command.EXIT, 1);//GEN-LINE:MVDGetInit22
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd22
        return cmdSair1;
    }//GEN-END:MVDGetEnd22

    /** This method returns instance for lblResultado component and should be called instead of accessing lblResultado field directly.//GEN-BEGIN:MVDGetBegin24
     * @return Instance for lblResultado component
     */
    public StringItem get_lblResultado() {
        if (lblResultado == null) {//GEN-END:MVDGetBegin24
            // Insert pre-init code here
            lblResultado = new StringItem("Resultado", "");//GEN-LINE:MVDGetInit24
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd24
        return lblResultado;
    }//GEN-END:MVDGetEnd24
     
    public void startApp() {
        initialize();
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
    
    private void atualizaResultado() {
        String resultado = "";
        
        boolean pesoInvalido = false;
        boolean alturaInvalida = false;
        
        double peso = 0;
        double altura = 0;
        
        // Tratando do peso digitado pelo usuário
        try {
            peso = Double.parseDouble(this.get_txtPeso().getString());
            if (peso <= 0) {
                pesoInvalido = true;
            }
        } catch (NumberFormatException e1) {
            pesoInvalido = true;
        }
        
        // Tratando da altura digitada pelo usuário
        try {
            altura = Double.parseDouble(this.get_txtAltura().getString());
            if (altura <= 0) {
                alturaInvalida = true;
            }
        } catch (NumberFormatException e2) {
            alturaInvalida = true;
        }
        
        
        if (pesoInvalido == false && alturaInvalida == false) {
            double resultadoNumerico = peso / (altura * altura);
            
            if (resultadoNumerico > 40) {
                resultado = resultadoNumerico + "\n\nOBESIDADE GRAU 3";
            } else if (resultadoNumerico >= 35 && resultadoNumerico <= 40) {
                resultado = resultadoNumerico + "\n\nOBESIDADE GRAU 2";
            } else if (resultadoNumerico >= 30 && resultadoNumerico <= 35) {
                resultado = resultadoNumerico + "\n\nOBESIDADE GRAU 1";
            } else if (resultadoNumerico >= 25 && resultadoNumerico <= 30) {
                resultado = resultadoNumerico + "\n\nSOBREPESO";
            } else if (resultadoNumerico >= 21 && resultadoNumerico <= 25) {
                resultado = resultadoNumerico + "\n\nPESO NORMAL";
            } else {
                resultado = resultadoNumerico + "\n\nABAIXO DO PESO";
            }
            
        } else if (pesoInvalido == true && alturaInvalida == false) {
            //Somente peso inválido
            resultado = "Peso inválido. Favor informar novamente.";
        } else if (pesoInvalido == false && alturaInvalida == true) {
            //Somente altura inválida
            resultado = "Altura inválida. Favor informar novamente.";
        } else {
            //Altura e peso inválidos
            resultado = "Valores informados estão inválidos.";
        }
        
        //this.txtAltura = null;
        //this.txtPeso = null;
        this.resultado = null;
        this.frmResultado = null;
        
        this.get_lblResultado().setText(resultado);
        
        Display.getDisplay(this).setCurrent(this.get_frmResultado());
        
    }
    
}
