package co.com.sofka.utils.service.soap.TempConvert.CelsiusToFahrenheit;

public enum Patch {

    CONVERT(System.getProperty("user.dir")
            + "\\src\\test\\resources\\file\\service\\soap\\tempConvert\\celsiusToFahrenheit\\tempconvert.xml");

    private final String value;

    Patch(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
