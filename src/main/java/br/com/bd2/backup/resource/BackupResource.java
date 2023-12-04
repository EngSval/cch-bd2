package br.com.bd2.backup.resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/backup")
public class BackupResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String backupDatabase() {

        System.out.println("EFETUANDO BACKUP EFETUANDO BACKUP EFETUANDO BACKUP EFETUANDO BACKUP");

        String username = "postgres";
        String password = "capitu123";

        String backupDirPath = "C:\\Users\\felip\\OneDrive\\Documentos\\backup";
        java.nio.file.Path backupDir = Paths.get(backupDirPath);

        try {
            if (Files.notExists(backupDir)) {
                Files.createDirectories(backupDir);
            }

            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            String backupFileName = "backup_" + timeStamp + ".sql";
            java.nio.file.Path backupFilePath = backupDir.resolve(backupFileName);

            String pgDumpPath = "C:\\PROGRA~1\\PostgreSQL\\16\\bin\\pg_dump.exe";

            String pgDumpCommand = pgDumpPath + " -U " + username + " -h localhost -p 5432 -d trabalho-pratico-bd2 -f "
                    + backupFilePath.toString();

            String[] cmd = { "cmd", "/c", pgDumpCommand };

            ProcessBuilder processBuilder = new ProcessBuilder(cmd);
            processBuilder.environment().put("PGPASSWORD", password);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("Backup realizado com sucesso: " + backupFilePath);
            } else {
                System.err.println("Erro ao realizar backup " + exitCode);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return "Backup concluído!";

    }
}
