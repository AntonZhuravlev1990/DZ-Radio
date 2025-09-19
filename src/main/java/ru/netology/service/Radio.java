package ru.netology.service;

public class Radio {

    private int minStation = 0;
    private int maxStation = 9;
    private int currentRadioStationNumber;
    private int maxRadioVolume = 100;
    private int minRadioVolume = 0;
    private int soundVolume = minRadioVolume;

    public Radio(int i, int i1, int i2, int i3) {
        this.maxStation = maxStation;
    }

    public int getMaxRadioVolume() {
        return maxRadioVolume;
    }

    public int getMinRadioVolume() {
        return minRadioVolume;
    }

    public Radio(int maxStation) {
        this.maxStation = maxStation;
        this.minStation = 0;
    }

    public int getCurrentRadioStationNumber() {
        return currentRadioStationNumber;
    }

    public int getMaxStation() {
        return maxStation;
    }

    public int getMinStation() {
        return minStation;
    }

    public void setCurrentRadioStationNumber(int newCurrentRadioStationNumber) {
        if (newCurrentRadioStationNumber >= minStation && newCurrentRadioStationNumber <= maxStation) {
            currentRadioStationNumber = newCurrentRadioStationNumber;
        }
    }

    public void next() {
        if (currentRadioStationNumber < maxStation) {
            currentRadioStationNumber = currentRadioStationNumber + 1;
        } else {
            currentRadioStationNumber = minStation;
        }
    }

    public void prev() {
        if (currentRadioStationNumber > minStation) {
            currentRadioStationNumber = currentRadioStationNumber - 1;
        } else {
            currentRadioStationNumber = maxStation;
        }

    }

    public int getSoundVolume() {
        return soundVolume;
    }

    public void setSoundVolume(int soundVolume) {
        if (soundVolume < 0) {
            return;
        }
        if (soundVolume > maxRadioVolume) {
            return;
        }
        this.soundVolume = soundVolume;
    }

    public void increaseVolume() {
        if (soundVolume < maxRadioVolume) {
            soundVolume = soundVolume + 1;
        }
    }

    public void decreaseVolume() {
        if (soundVolume > 0) {
            soundVolume = soundVolume - 1;
        }
    }
}
