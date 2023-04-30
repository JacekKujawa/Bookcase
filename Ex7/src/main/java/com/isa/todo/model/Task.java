import java.time.LocalDate;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

public class Task {

    @NotBlank(message = "Opis nie może być pusty")
    private String opis;

    @NotNull(message = "Kategoria jest wymagana")
    private String kategoria;

    @NotNull(message = "Priorytet jest wymagany")
    private Integer priorytet;

    @NotNull(message = "Termin jest wymagany")
    @FutureOrPresent(message = "Termin nie może być z przeszłości")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate termin;

    public Task() {
    }

    public Task(String opis, String kategoria, Integer priorytet, LocalDate termin) {
        this.opis = opis;
        this.kategoria = kategoria;
        this.priorytet = priorytet;
        this.termin = termin;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public Integer getPriorytet() {
        return priorytet;
    }

    public void setPriorytet(Integer priorytet) {
        this.priorytet = priorytet;
    }

    public LocalDate getTermin() {
        return termin;
    }

    public void setTermin(LocalDate termin) {
        this.termin = termin;
    }

    // dodajemy metody walidacyjne
    public boolean isOpisValid() {
        return opis != null && !opis.trim().isEmpty();
    }

    public boolean isKategoriaValid() {
        return kategoria != null;
    }

    public boolean isPriorytetValid() {
        return priorytet != null && priorytet >= 1 && priorytet <= 5;
    }

    public boolean isTerminValid() {
        return termin != null;
    }
}
