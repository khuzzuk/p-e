package pl.projectE.model.production;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import lombok.RequiredArgsConstructor;
import pl.projectE.math.DataType;
import pl.projectE.model.Refresh;
import pl.projectE.ui.ValueFormatter;

@RequiredArgsConstructor
@Refresh(sequence = 0)
public class Product {
    public final String name;
    public int price;
    @DataType(type = ValueFormatter.BIG)
    public long employed;
    public int industrialProductivity;
    public int actualTech;
    public long assets;
    public int endProductivity;
    public Object2IntMap<Product> resources;
    public int productionEfficiency;
    public int consumption;
    public int basicConsumption;
    public int army;
    public int administration;
    public int technologyWeight;
    public int priceWeight;
    public transient long actualProduction;
}
