package hu.dd.varianddbackend;

import hu.dd.varianddbackend.model.Patient;
import hu.dd.varianddbackend.model.TreatmentType;
import hu.dd.varianddbackend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;


@Component
public class AppStartupRunner implements ApplicationRunner {

    @Autowired
    PatientRepository patientRepository;

    @Override
    public void run(ApplicationArguments args) {
        int listSize = patientRepository.findAll().size();
        if (listSize == 0) {
            generateListOfPatients();
        }
    }

    private void generateListOfPatients() {
        LinkedList<String> forNames = new LinkedList<>();
        forNames.add("Charles");
        forNames.add("Myles");
        forNames.add("Anna");
        forNames.add("Peter");
        forNames.add("Lola");
        forNames.add("Lorana");
        forNames.add("Martin");
        forNames.add("Adam");
        forNames.add("Daniel");
        forNames.add("Balage");
        forNames.add("Naomi");
        forNames.add("Hermes");
        forNames.add("Kratos");
        forNames.add("Ezekiel");
        forNames.add("Thomas");
        forNames.add("Violet");
        forNames.add("Gabriel");
        forNames.add("Alexandra");
        forNames.add("Lily");

        List<String> familyNames = List.of(getResourceFileAsString("familynames.csv").split("\n"));
        List<String> cancerTypes = List.of(new String[]{"Brain tumor", "Lung cancer", "Skin cancer", "Carcinoma", "Leukemia", "Melanoma", "Spinal Cord Tumor", "Sarcoma"});

        for (int iteration = 0; iteration < 60; iteration++) {
            Random random = new Random();
            Patient patientToAdd = new Patient();
            patientToAdd.setDoctor("Dr Strange");
            patientToAdd.setCancerType(cancerTypes.get(random.nextInt(cancerTypes.size())));
            String name = forNames.get(random.nextInt(forNames.size())) + " " + familyNames.get(random.nextInt(familyNames.size()));
            patientToAdd.setName(name);
            patientToAdd.setDiagnosisYear(Date.from(Instant.ofEpochSecond(ThreadLocalRandom.current().nextInt())));
            patientToAdd.setEmail(name.replace(" ", "_") + "@gmail.com");
            StringBuilder phoneNumber = new StringBuilder("+36");
            for (int i = 0; i < 6; i++) {
                phoneNumber.append(random.nextInt(9));
            }
            patientToAdd.setPhoneNumber(phoneNumber.toString());
            patientToAdd.setStage(random.nextInt(5));
            List<TreatmentType> treatmentTypes = List.of(new TreatmentType[]{TreatmentType.CHEMOTHERAPY, TreatmentType.SURGICAL, TreatmentType.RADIATION_THERAPY});
            patientToAdd.setTreatmentType(treatmentTypes.get(random.nextInt(treatmentTypes.size())));
            patientRepository.save(patientToAdd);
        }
    }

    public static String getResourceFileAsString(String fileName) {
        InputStream is = getResourceFileAsInputStream(fileName);
        if (is != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        } else {
            throw new RuntimeException("resource not found");
        }
    }

    public static InputStream getResourceFileAsInputStream(String fileName) {
        ClassLoader classLoader = AppStartupRunner.class.getClassLoader();
        return classLoader.getResourceAsStream(fileName);
    }
}