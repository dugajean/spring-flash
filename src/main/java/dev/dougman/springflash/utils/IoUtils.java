package dev.dougman.springflash.utils;

import dev.dougman.springflash.enums.Color;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IoUtils {
    /**
     * Calculates path with file name while ensuring that a `src` folder exists.
     *
     * @param path The path where to the application root. Should reflect the main package.
     * @param target The target (or type) to put this file into, eg.: entities, controllers, etc.
     * @param name The desired file name.
     *
     * @throws IOException Throws this exception if there is no `src` folder in the current path.
     */
    public static Path computePath(String path, String target, String name) throws IOException {
        String currentPath = System.getProperty("user.dir");
        Path sourcePath = Paths.get(currentPath, "src");

        if (!Files.exists(sourcePath)) {
            throw new IOException("Path %s does not exist".formatted(sourcePath.toString()));
        }

        return Paths.get(sourcePath.toString(), "main", "java", path, target, name + ".java");
    }

    /**
     * Creates file at `path` while also creating any missing folders.
     *
     * @param path The full path to write to, including folders.
     * @param content String content to write into the new file.
     */
    public static boolean createFile(Path path, String content) {
        try {
            Files.createDirectories(path.getParent());
            Path createdFilePath = Files.createFile(path);
            Files.writeString(createdFilePath, content);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Prints out a green message of success in the console.
     *
     * @param message The formatted message to print out.
     */
    public static void printSuccess(String message) {
        System.out.print(Color.GREEN_BOLD);
        System.out.println(message);
        System.out.print(Color.RESET);
    }
}
