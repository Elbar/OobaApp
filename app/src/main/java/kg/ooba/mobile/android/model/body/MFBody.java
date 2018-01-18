package kg.ooba.mobile.android.model.body;

/**
 * Created by aizhan on 9/8/17.
 */

public class MFBody{

    private String trackNumber;
    private String type;

    public MFBody(String trackNumber, String type) {
        this.trackNumber = trackNumber;
        this.type = type;
    }

    public String getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(String trackNumber) {
        this.trackNumber = trackNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
