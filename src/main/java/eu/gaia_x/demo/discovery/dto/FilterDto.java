package eu.gaia_x.demo.discovery.dto;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class FilterDto {
    private String type;
    private List<Category> categories;

    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Accessors(chain = true)
    public static class Category {
        private String name;
        private List<Item> items;
    }

    @ToString
    @AllArgsConstructor
    @Getter
    public static class Item {
        private String name;
        private int qty;
    }
}
