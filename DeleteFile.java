import javax.swing.*;
import java.nio.file.*; // Este pacote faz parte da API NIO (New Input/Output) e fornece classes para trabalhar com o sistema de arquivos de maneira mais eficiente e flexível do que a API de E/S tradicional.

public class DeleteFile {
    public static void apagarArquivo() {
        try {
            JFileChooser chooser = new JFileChooser();

            chooser.setDialogTitle("Selecione o arquivo que deseja apagar");
            chooser.setApproveButtonText("Apagar arquivo");
            int returnVal1 = chooser.showOpenDialog(null);
            String fileFullPath = "";
            if(returnVal1 == JFileChooser.APPROVE_OPTION) {
                fileFullPath = chooser.getSelectedFile().getAbsolutePath();
            } else {
                System.out.println("Que pena!");
            }

            Path pathOrigin = Paths.get(fileFullPath);
            Files.delete(pathOrigin);
            System.out.println("Arquivo apagado com sucesso!");
        } catch (Exception e) {
            System.out.println("Não foi possivel apagar o arquivo.");
        }
    }
}
