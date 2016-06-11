package pl.projectE.gpm;

import com.google.auto.service.AutoService;
import lombok.NoArgsConstructor;
import pl.projectE.gpm.annot.Setter;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import java.util.HashSet;
import java.util.Set;

@AutoService(Processor.class)
@NoArgsConstructor
public class GPMProcessor extends AbstractProcessor {
    private Types types;
    private Elements elements;
    private Filer filer;
    private Messager messager;
    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        types = processingEnv.getTypeUtils();
        elements = processingEnv.getElementUtils();
        filer = processingEnv.getFiler();
        messager = processingEnv.getMessager();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        return false;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> types = new HashSet<>();
        types.add(Setter.class.getCanonicalName());
        return types;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}
