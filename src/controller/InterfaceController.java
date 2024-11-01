package controller;

import model.*;
import view.*;

import java.io.*;
import java.util.*;
import javax.swing.*; // Importa todos os componentes do módulo Swing.

public class InterfaceController extends InterfaceView {
    public static final String localViewImgFolder = System.getProperty("user.dir") 
        + "\\" 
        + "src"
        + "\\" 
        + "view"
        + "\\"
        + "img";

    public static final String localViewFolder = System.getProperty("user.dir")
        + "\\" 
        + "src"
        + "\\" 
        + "view";

    public static final Icon imgPadrao = new ImageIcon(InterfaceView.class.getResource("imagem-padrao.jpg"));

    public static void verificarApagarImagensInuteis() {
        final File folder = new File(localViewImgFolder);
        ArrayList<String> strImagens = listFilesForFolder(folder);
        InterfaceModel.validarImagens(strImagens);
    }

    public static ArrayList<String> listFilesForFolder(final File folder) {
        ArrayList<String> strFiles = new ArrayList<String>();
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                strFiles.add(fileEntry.getName());
                System.out.println(fileEntry.getName());
            }
        }
        return strFiles;
    }
}
