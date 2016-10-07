import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Date;
import java.text.DateFormat;

public class HallOfFame{

  private int id;
  private String name;
  private int turns;
  private Timestamp moment;

  public String getName(){
    return name;
  }

  public int getTurns(){
    return turns;
  }

  public String getMoment(){
    return DateFormat.getDateTimeInstance().format(this.moment).toString();
  }

  public static List<HallOfFame> all(){
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM victors";
      return con.createQuery(sql)
      .throwOnMappingFailure(false)
      .executeAndFetch(HallOfFame.class);
    }
  }

}
