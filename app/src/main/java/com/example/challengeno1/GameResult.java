package com.example.challengeno1;

import android.os.Parcel;
import android.os.Parcelable;

public class GameResult implements Parcelable {
    private int miResult;
    private int viResult;

    public GameResult(int miResult, int viResult){
        this.miResult = miResult;
        this.viResult = viResult;
    }

    public int getMiResult() {
        return miResult;
    }

    public int getViResult() {
        return viResult;
    }

    public void setMiResult(int miResult) {
        this.miResult = miResult;
    }

    public void setViResult(int viResult) {
        this.viResult = viResult;
    }

    @Override
    public String toString() {
        return "GameResult{" +
                "miResult=" + miResult +
                ", viResult=" + viResult +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
