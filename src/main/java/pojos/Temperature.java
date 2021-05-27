
package pojos;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Generated("net.hexar.json2pojo")
@Setter
@Getter
@SuppressWarnings("unused")
public class Temperature {
    @SerializedName("Unit")
    private String unit;
    @SerializedName("UnitType")
    private Integer unitType;
    @SerializedName("Value")
    private Double value;
}
