package pl.projectE.inject;

import org.testng.annotations.Test;
import pl.projectE.inject.qualifiers.CountriesNames;

import javax.inject.Named;

import static org.testng.Assert.*;

public class ContainerKeyTest {
    @Test(groups = "fast")
    public void checkKeyWithNamedAnnotation() throws Exception {
        ContainerKey expectedKey = new ContainerKey(NamedClass.class);
        expectedKey.addName(NamedClass.class.getAnnotation(Named.class));
        ContainerKey factoryKey = ContainerKey.getKey(NamedClass.class);
        assertEquals(factoryKey, expectedKey);
    }

    @Test
    public void checkKeyWithQualifiers() throws Exception {
        ContainerKey expectedKey = new ContainerKey(QualifiedClass.class);
        expectedKey.addQualifier(CountriesNames.class);
        ContainerKey factoryKey = ContainerKey.getKey(QualifiedClass.class);
        assertEquals(factoryKey, expectedKey);
    }

    @SuppressWarnings("WeakerAccess")
    @Named("qualified")
    static class NamedClass {}
    @SuppressWarnings("WeakerAccess")
    @CountriesNames
    static class QualifiedClass{}
}