package Pojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kinsley kajiva on 10/16/2016.Zvaganzirwa nakinsley kajiva musiwa 10/16/2016
 */

public class States_Api_Json  implements Parcelable{

    private int AUTO_ID;
    @SerializedName("realtime_start")
    private String realtime_start;
    @SerializedName("realtime_end")
    private String realtime_end;
    @SerializedName("title")
    private String title;
    @SerializedName("observation_start")
    private String observation_start;
    @SerializedName("observation_end")
    private String observation_end;
    @SerializedName("frequency")
    private String frequency;
    @SerializedName("frequency_short")
    private String frequency_short;
    @SerializedName("units")
    private String units;
    @SerializedName("units_short")
    private String units_short;
    @SerializedName("seasonal_adjustment")
    private String seasonal_adjustment;
    @SerializedName("popularity")
    private String popularity;
    @SerializedName("seasonal_adjustment_short")
    private String seasonal_adjustment_short;
    @SerializedName("last_updated")
    private String last_updated;
    @SerializedName("notes")
    private String notes;

    public States_Api_Json(Parcel in) {
        AUTO_ID = in.readInt();
        realtime_start = in.readString();
        realtime_end = in.readString();
        title = in.readString();
        observation_start = in.readString();
        observation_end = in.readString();
        frequency = in.readString();
        frequency_short = in.readString();
        units = in.readString();
        units_short = in.readString();
        seasonal_adjustment = in.readString();
        popularity = in.readString();
        seasonal_adjustment_short = in.readString();
        last_updated = in.readString();
        notes = in.readString();

    }

    public static final Creator<States_Api_Json> CREATOR = new Creator<States_Api_Json>() {
        @Override
        public States_Api_Json createFromParcel(Parcel in) {
            return new States_Api_Json(in);
        }

        @Override
        public States_Api_Json[] newArray(int size) {
            return new States_Api_Json[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(AUTO_ID);
        dest.writeString(realtime_start);
        dest.writeString(realtime_end);
        dest.writeString(title);
        dest.writeString(observation_start);
        dest.writeString(observation_end);
        dest.writeString(frequency);
        dest.writeString(frequency_short);
        dest.writeString(units);
        dest.writeString(units_short);
        dest.writeString(seasonal_adjustment);
        dest.writeString(popularity);
        dest.writeString(seasonal_adjustment_short);
        dest.writeString(last_updated);
        dest.writeString(notes);
    }

    public int getAUTO_ID() {
        return AUTO_ID;
    }

    public void setAUTO_ID(int AUTO_ID) {
        this.AUTO_ID = AUTO_ID;
    }

    public String getRealtime_start() {
        return realtime_start;
    }

    public void setRealtime_start(String realtime_start) {
        this.realtime_start = realtime_start;
    }

    public String getRealtime_end() {
        return realtime_end;
    }

    public void setRealtime_end(String realtime_end) {
        this.realtime_end = realtime_end;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getObservation_start() {
        return observation_start;
    }

    public void setObservation_start(String observation_start) {
        this.observation_start = observation_start;
    }

    public String getObservation_end() {
        return observation_end;
    }

    public void setObservation_end(String observation_end) {
        this.observation_end = observation_end;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getFrequency_short() {
        return frequency_short;
    }

    public void setFrequency_short(String frequency_short) {
        this.frequency_short = frequency_short;
    }

    public String getUnits() {return units; }

    public void setUnits(String units) { this.units = units;}

    public String getUnits_short() { return units_short;  }

    public void setUnits_short(String units_short) { this.units_short = units_short; }

    public String getSeasonal_adjustment() { return seasonal_adjustment; }

    public void setSeasonal_adjustment(String seasonal_adjustment) {this.seasonal_adjustment = seasonal_adjustment;
    }

    public String getPopularity() {  return popularity; }

    public void setPopularity(String popularity) { this.popularity = popularity;  }

    public String getSeasonal_adjustment_short() {  return seasonal_adjustment_short;
    }

    public void setSeasonal_adjustment_short(String seasonal_adjustment_short) {
        this.seasonal_adjustment_short = seasonal_adjustment_short;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public int describeContents() {return 0; }


}
