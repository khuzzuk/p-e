package pl.projectE.model.production;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Product {
    public final String name;
    public int price;
    public int employed;
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
    public transient int actualProduction;
}
