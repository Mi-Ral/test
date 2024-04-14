import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static com.codeborne.selenide.Selenide.$$;

public class ScreenshotTest {

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = "chrome";
        Configuration.browserBinary = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
    }


    @BeforeEach
    public void setUp() {
        Selenide.open("https://www.avito.ru/avito-care/eco-impact");
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 1","2, 3", "3, 5"})
    void screenTest(int testIndex ,int indexElement) throws IOException {
        ElementsCollection elements = $$(".desktop-impact-item-eeQO3");

        if (indexElement < elements.size()) {
            SelenideElement element = elements.get(indexElement);

            File destFile = new File("output/test_case_" + testIndex + ".png");
            File screenshotFile = element.screenshot();
            Path destPath = Paths.get(destFile.getAbsolutePath());
            Files.copy(screenshotFile.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);
        }
        assertThat(elements).isNotNull();
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}