import javax.swing.*;
import static java.nio.file.StandardCopyOption.*; // static usado para classes espesificas apenas para classes com acesso restrito
import java.nio.file.*; // Este pacote faz parte da API NIO (New Input/Output) e fornece classes para trabalhar com o sistema de arquivos de maneira mais eficiente e flexível do que a API de E/S tradicional.

public class RenameFile {
    public static void renomearArquivo() {
        try {
            JFileChooser chooser = new JFileChooser();

            chooser.setDialogTitle("Selecione o arquivo que deseja renomear");
            chooser.setApproveButtonText("Selecionar arquivo");
            int returnVal1 = chooser.showOpenDialog(null); // tela de seleção semelhante ao Explorer
            String fileFullPath = "";
            String folderFullPath = "";
            String fileName = "";

            // Na linha abaixo seá definida uma variável com nome de arquivo aleatório
            String fileAleatoryName = "file-" + String.valueOf(Math.random());

            if (returnVal1 == JFileChooser.APPROVE_OPTION) {
                fileFullPath = chooser.getSelectedFile().getAbsolutePath();
                folderFullPath = chooser.getSelectedFile().getParent();
                fileName = chooser.getSelectedFile().getName();
            } else {
                System.out.println("Que pena!");
            }

            String newFileName = JOptionPane.showInputDialog(null, "Digite o novo nome do arquivo", fileName);

            Path pathOrigin = Paths.get(fileFullPath);
            Path pathDestination = Paths.get(folderFullPath + "\\" + newFileName);

            // Na linha abaixo será definido um caminho para ciação do arquivo temporario
            Path pathTemp = Paths.get(folderFullPath + "\\" + fileAleatoryName);

            if (
                fileFullPath.length() > 0 && 
                folderFullPath.length() > 0 && 
                fileName.length() > 0 && 
                newFileName.length() > 0
            ) {

                // 1. Copiar o arquivo original para arquivo com nome aleatório
                Files.copy(pathOrigin, pathTemp, REPLACE_EXISTING);
                // 2. Apagar arquivo original
                Files.delete(pathOrigin);
                // 3. Copiar arquivo com nome aleatório para o novo nome selecionado
                Files.copy(pathTemp, pathDestination, REPLACE_EXISTING);
                // 4. Apagar arquivo com nome aleatório
                Files.delete(pathTemp);
                
                // 5. Verificar se a operação do arquivo renomeado foi realizada com sucesso
                if (Files.exists(pathDestination)) {
                    System.out.println("Arquivo " + chooser.getSelectedFile().getName() + " renomeado com sucesso.");
                } else {
                    System.out.println("Ops! Não foi possível renomear o arquivo. Por favor, verifique e tente novamente mais tarde.");
                }
            } else {
                System.out.println("Ops! Não foi possível renomear o arquivo. Por favor, verifique e tente novamente mais tarde.");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível renomear o arquivo. Erro: " + e);
        }
    }
}