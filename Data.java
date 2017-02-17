import java.io.IOException;
import java.io.DataInput;
import java.io.DataOutput;

import com.gemstone.gemfire.DataSerializable;
import com.gemstone.gemfire.DataSerializer;

public class Data implements DataSerializable {
    private int id;
    private String value;
    private int price;

    public Data()     {
    }

    public Data(int i, String s, int p)
    {
        id = i;
        value = s;
        price =p;
    }
    public void setId(int i)
    {
        id=i;
    }

    public int getId()
    {
        return id;
    }

    public void setValue(String s)
    {
        value = s;
    }

    public String getValue()
    {
        return value;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int p)
    {
        price=p;
    }

    public void fromData(DataInput in) throws IOException, ClassNotFoundException
    {
        try {
            id = DataSerializer.readPrimitiveInt ( in );
            value = DataSerializer.readString(in);
            price = DataSerializer.readPrimitiveInt(in);
        } catch ( Exception e ) {
            System.out.println ( "Deserialize Error: " + e );
            e.printStackTrace();
        }
    }

    public void toData(DataOutput out) throws IOException
    {
        DataSerializer.writePrimitiveInt(id, out);
        DataSerializer.writeString(value, out);
        DataSerializer.writePrimitiveInt(price, out);
    }
}
