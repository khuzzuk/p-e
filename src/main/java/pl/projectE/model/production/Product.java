package pl.projectE.model.production;

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
}
