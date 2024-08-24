package net.neoforged.neodev;

import net.neoforged.srgutils.IMappingFile;
import org.gradle.api.DefaultTask;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.tasks.InputFile;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.TaskAction;

import javax.inject.Inject;
import java.io.IOException;

abstract class InvertMappingFile extends DefaultTask {
    @Inject
    public InvertMappingFile() {}

    @InputFile
    abstract RegularFileProperty getInputFile();

    @OutputFile
    abstract RegularFileProperty getOutputFile();

    @TaskAction
    public void invertMappings() throws IOException {
        var file = IMappingFile.load(getInputFile().get().getAsFile());
        file.write(getOutputFile().get().getAsFile().toPath(), IMappingFile.Format.TSRG2, true);
    }
}
