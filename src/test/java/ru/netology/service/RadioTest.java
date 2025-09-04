package ru.netology.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {
    Radio radio = new Radio();

    @Test
    void shouldSetValidRadioStation() {
        radio.setCurrentRadioStation(5);
        int expected = 5;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldNotSetRadioStationBelowMin() {
        radio.setCurrentRadioStation(5);
        radio.setCurrentRadioStation(-1);
        int expected = 5;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldNotSetRadioStationAboveMax() {
        radio.setCurrentRadioStation(5);
        radio.setCurrentRadioStation(10);
        int expected = 5;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldSetMinRadioStation() {
        radio.setCurrentRadioStation(0);
        int expected = 0;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldSetMaxRadioStation() {
        radio.setCurrentRadioStation(9);
        int expected = 9;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldSetValidVolume() {
        radio.setCurrentVolume(5);
        int expected = 5;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldNotSetVolumeBelowMin() {
        radio.setCurrentVolume(5);
        radio.setCurrentVolume(-1);
        int expected = 5;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldNotSetVolumeAboveMax() {
        radio.setCurrentVolume(5);
        radio.setCurrentVolume(11);
        int expected = 5;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldSetMinVolume() {
        radio.setCurrentVolume(0);
        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldSetMaxVolume() {
        radio.setCurrentVolume(10);
        int expected = 10;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldIncreaseVolume() {
        radio.setCurrentVolume(5);
        radio.volumeUp();
        int expected = 6;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldNotIncreaseVolumeAtMax() {
        radio.setCurrentVolume(10);
        radio.volumeUp();
        int expected = 10;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldDecreaseVolume() {
        radio.setCurrentVolume(5);
        radio.volumeDown();
        int expected = 4;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldNotDecreaseVolumeAtMin() {
        radio.setCurrentVolume(0);
        radio.volumeDown();
        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldGoToNextStation() {
        radio.setCurrentRadioStation(5);
        radio.nextStation();
        int expected = 6;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldWrapToFirstStationFromLast() {
        radio.setCurrentRadioStation(9);
        radio.nextStation();
        int expected = 0;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldGoToPrevStation() {
        radio.setCurrentRadioStation(5);
        radio.prevStation();
        int expected = 4;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldWrapToLastStationFromFirst() {
        radio.setCurrentRadioStation(0);
        radio.prevStation();
        int expected = 9;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldHandleVolumeAtBoundaries() {
        radio.setCurrentVolume(0);
        radio.volumeDown();
        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);

        radio.setCurrentVolume(10);
        radio.volumeUp();
        expected = 10;
        actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldHandleStationAtBoundaries() {
        radio.setCurrentRadioStation(0);
        radio.prevStation();
        int expected = 9;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);

        radio.setCurrentRadioStation(9);
        radio.nextStation();
        expected = 0;
        actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }
}


