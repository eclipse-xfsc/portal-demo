package eu.gaia_x.demo.dashboard.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StatisticsResponse {
    @JsonProperty(value = "total", required = true)
    private int total;
    @JsonProperty(value = "date_from", required = true)
    private String dateFrom;
    @JsonProperty(value = "date_to", required = true)
    private String dateTo;
    @JsonProperty(value = "transactions", required = true)
    private List<Transaction> transactions;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Transaction {
        @JsonProperty(value = "id", required = true)
        private int id;
        @JsonProperty(value = "date", required = true)
        private String date;
    }
}
