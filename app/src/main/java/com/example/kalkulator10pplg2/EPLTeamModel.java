package com.example.kalkulator10pplg2;

import android.os.Parcel;
import android.os.Parcelable;

public class EPLTeamModel implements Parcelable {
    private String teamName;
    private String stadiun;
    private String strTeamBadge;

    protected EPLTeamModel(Parcel in) {
        teamName = in.readString();
        stadiun = in.readString();
        strTeamBadge = in.readString();
    }

    EPLTeamModel(){

    }

    public static final Creator<EPLTeamModel> CREATOR = new Creator<EPLTeamModel>() {
        @Override
        public EPLTeamModel createFromParcel(Parcel in) {
            return new EPLTeamModel(in);
        }

        @Override
        public EPLTeamModel[] newArray(int size) {
            return new EPLTeamModel[size];
        }
    };

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getStadiun() {
        return stadiun;
    }

    public void setStadiun(String stadiun) {
        this.stadiun = stadiun;
    }

    public String getStrTeamBadge() {
        return strTeamBadge;
    }

    public void setStrTeamBadge(String strTeamBadge) {
        this.strTeamBadge = strTeamBadge;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(teamName);
        parcel.writeString(stadiun);
        parcel.writeString(strTeamBadge);
    }
}
