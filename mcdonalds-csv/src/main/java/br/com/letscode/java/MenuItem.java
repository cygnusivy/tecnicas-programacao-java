package br.com.letscode.java;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

import lombok.Value;

@Value
public class MenuItem {

    String category;
    String name;
    String servingSize;
    Integer calories;
    Double totalFat;
    Integer sodium;
    Integer carbohydrates;
    Integer protein;

    public static MenuItem fromLine(String line) {
        String[] split = line.split(",(?=\\S)");
        return new MenuItem(
            split[0],
            split[1].replace("\"", ""),
            split[2],
            parseInt(split[3]),
            parseDouble(split[5]),
            parseInt(split[12]),
            parseInt(split[14]),
            parseInt(split[19])
        );
    }

    public String toCsv() {
        return this.category + getNameToCsv() + this.servingSize
            + "," + this.calories + "," + this.totalFat + "," + this.sodium
            + "," + this.carbohydrates + "," + this.protein + "\n";
    }

    private String getNameToCsv() {
        if (this.name.contains(" ")) {
            return ",\"" + this.name + "\",";
        } else {
            return "," + this.name + ",";
        }
    }
}
