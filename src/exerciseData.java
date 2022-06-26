import javafx.scene.control.SelectionModel;

public class exerciseData {
    
    //Date of workout
    private String dow;
    //Exercise
    private String e;
    //Sets and reps
    private String sar;
    //Weight
    private String w;

    public exerciseData(String dow, String e, String sar, String w){
        this.dow = dow;
        this.e = e;
        this.sar = sar;
        this.w = w;
    }

    //Get/set date 
    public String getDow() {
        return dow;
    }

    public void setDow(String dow){
        this.dow = dow;
    }

    //Get/set exercise
    public String getE() {
        return e;
    }

    public void setE(String e){
        this.e = e;
    }

    //Get/set sets and reps 
    public String getSar() {
        return sar;
    }

    public void setSar(String sar){
        this.sar = sar;
    }

    //Get/set weight
    public String getW() {
        return w;
    }

    public void setW(String w){
        this.w = w;
    }

    @Override
    public String toString(){
        return "exerciseData{"+
                "dow=" + dow +
                ", e='" + e + '\''+
                ", sar='" + sar + '\'' +
                ", w='" + w + '\'' +
                '}';
    }

    public static SelectionModel<exerciseData> getSelectionModel() {
        return null;
    }

}

