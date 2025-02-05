package tech.biuldrun.spotify.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriesWrapper {

    private List<Categories> items;

    public List<Categories> getItems() {
        return items;
    }

}
