package ru.netology.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {

    @Test
    public void shouldCreateDefaultRadio() {
        Radio radio = new Radio(0, 9, 0, 100);
        assertEquals(0, radio.getMinStation());
        assertEquals(9, radio.getMaxStation());
        assertEquals(0, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void shouldCreateCustomRadio() {
        Radio radio = new Radio(15);
        assertEquals(0, radio.getMinStation());
        assertEquals(15, radio.getMaxStation());
        assertEquals(0, radio.getCurrentRadioStationNumber());
    }


    @Test
    public void shouldSetValidStation() {
        Radio radio = new Radio(0, 9, 0, 100);
        radio.setCurrentRadioStationNumber(5);
        assertEquals(5, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void shouldNotSetStationBelowMin() {
        Radio radio = new Radio(0, 9, 0, 100);
        radio.setCurrentRadioStationNumber(5);
        radio.setCurrentRadioStationNumber(-1);
        assertEquals(5, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void shouldNotSetStationAboveMax() {
        Radio radio = new Radio(0, 9, 0, 100);
        radio.setCurrentRadioStationNumber(5);
        radio.setCurrentRadioStationNumber(15);
        assertEquals(5, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void shouldSetMinStation() {
        Radio radio = new Radio(0, 9, 0, 100);
        radio.setCurrentRadioStationNumber(0);
        assertEquals(0, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void shouldSetMaxStation() {
        Radio radio = new Radio(0, 9, 0, 100);
        radio.setCurrentRadioStationNumber(9);
        assertEquals(9, radio.getCurrentRadioStationNumber());
    }


    @Test
    public void shouldNextFromMiddleStation() {
        Radio radio = new Radio(0, 9, 0, 100);
        radio.setCurrentRadioStationNumber(5);
        radio.next();
        assertEquals(6, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void shouldNextFromMaxStation() {
        Radio radio = new Radio(0, 9, 0, 100);
        radio.setCurrentRadioStationNumber(9);
        radio.next();
        assertEquals(0, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void shouldNextFromMinStation() {
        Radio radio = new Radio(0, 9, 0, 100);
        radio.setCurrentRadioStationNumber(0);
        radio.next();
        assertEquals(1, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void shouldNextMultipleTimes() {
        Radio radio = new Radio(0, 9, 0, 100);
        radio.setCurrentRadioStationNumber(8);
        radio.next();
        radio.next();
        radio.next();
        assertEquals(1, radio.getCurrentRadioStationNumber());
    }


    @Test
    public void shouldPrevFromMiddleStation() {
        Radio radio = new Radio(0, 9, 0, 100);
        radio.setCurrentRadioStationNumber(5);
        radio.prev();
        assertEquals(4, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void shouldPrevFromMinStation() {
        Radio radio = new Radio(0, 9, 0, 100);
        radio.setCurrentRadioStationNumber(0);
        radio.prev();
        assertEquals(9, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void shouldPrevFromMaxStation() {
        Radio radio = new Radio(0, 9, 0, 100);
        radio.setCurrentRadioStationNumber(9);
        radio.prev();
        assertEquals(8, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void shouldPrevMultipleTimes() {
        Radio radio = new Radio(0, 9, 0, 100);
        radio.setCurrentRadioStationNumber(1);
        radio.prev();
        radio.prev();
        radio.prev();
        assertEquals(8, radio.getCurrentRadioStationNumber());
    }


    @Test
    public void shouldHandleCustomRadioBounds() {
        Radio radio = new Radio(5);
        assertEquals(0, radio.getMinStation());
        assertEquals(5, radio.getMaxStation());
    }

    @Test
    public void shouldSetValidStationInCustomRadio() {
        Radio radio = new Radio(5);
        radio.setCurrentRadioStationNumber(3);
        assertEquals(3, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void shouldNotSetInvalidStationInCustomRadio() {
        Radio radio = new Radio(5);
        radio.setCurrentRadioStationNumber(3);
        radio.setCurrentRadioStationNumber(7);
        assertEquals(3, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void shouldNextInCustomRadio() {
        Radio radio = new Radio(5);
        radio.setCurrentRadioStationNumber(4);
        radio.next();
        radio.next();
        assertEquals(0, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void shouldPrevInCustomRadio() {
        Radio radio = new Radio(5);
        radio.setCurrentRadioStationNumber(0);
        radio.prev();
        assertEquals(5, radio.getCurrentRadioStationNumber());
    }


    @Test
    public void shouldHandleSingleStationRadio() {
        Radio radio = new Radio(0);
        assertEquals(0, radio.getMinStation());
        assertEquals(0, radio.getMaxStation());

        radio.next();
        assertEquals(0, radio.getCurrentRadioStationNumber());

        radio.prev();
        assertEquals(0, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void shouldNotChangeOnInvalidSet() {
        Radio radio = new Radio(0, 9, 0, 100);

        radio.setCurrentRadioStationNumber(5);
        radio.setCurrentRadioStationNumber(-5);
        radio.setCurrentRadioStationNumber(20);

        assertEquals(5, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void shouldCycleThroughAllStations() {
        Radio radio = new Radio(0, 9, 0, 100);
        for (int i = 0; i < 10; i++) {
            assertEquals(i % 10, radio.getCurrentRadioStationNumber());
            radio.next();
        }
        assertEquals(0, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void soundVolumeA() {
        Radio radio = new Radio(0, 9, 0, 100);
        radio.setSoundVolume(0);
        int expected = 0;
        int actual = radio.getSoundVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void soundVolumeB() {
        Radio radio = new Radio(0, 9, 0, 100);
        radio.setSoundVolume(1);
        int expected = 1;
        int actual = radio.getSoundVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void soundVolumeC() {
        Radio radio = new Radio(0, 9, 0, 100);
        radio.setSoundVolume(-1);
        int expected = 0;
        int actual = radio.getSoundVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void soundVolumeD() {
        Radio radio = new Radio(0, 9, 0, 100);
        radio.setSoundVolume(100);
        int expected = 100;
        int actual = radio.getSoundVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void soundVolumeE() {
        Radio radio = new Radio(0, 9, 0, 100);
        radio.setSoundVolume(99);
        int expected = 99;
        int actual = radio.getSoundVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void soundVolumeF() {
        Radio radio = new Radio(0, 9, 0, 100);
        radio.setSoundVolume(101);
        int expected = 0;
        int actual = radio.getSoundVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void increaseVolumeA() {
        Radio radio = new Radio(0, 9, 0, 100);
        radio.setSoundVolume(100);
        radio.increaseVolume();
        int expected = 100;
        int actual = radio.getSoundVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void increaseVolumeB() {
        Radio radio = new Radio(0, 9, 0, 100);
        radio.setSoundVolume(99);
        radio.increaseVolume();
        int expected = 100;
        int actual = radio.getSoundVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void increaseVolumeC() {
        Radio radio = new Radio(0, 9, 0, 100);
        radio.setSoundVolume(98);
        radio.increaseVolume();
        int expected = 99;
        int actual = radio.getSoundVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void increaseVolumeD() {
        Radio radio = new Radio(0, 9, 0, 100);
        radio.setSoundVolume(2);
        radio.increaseVolume();
        int expected = 3;
        int actual = radio.getSoundVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void increaseVolumeE() {
        Radio radio = new Radio(0, 9, 0, 100);
        radio.setSoundVolume(1);
        radio.increaseVolume();
        int expected = 2;
        int actual = radio.getSoundVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void increaseVolumeF() {
        Radio radio = new Radio(0, 9, 0, 100);
        radio.setSoundVolume(0);
        radio.increaseVolume();
        int expected = 1;
        int actual = radio.getSoundVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void decreaseVolumeA() {
        Radio radio = new Radio(0, 9, 0, 100);
        radio.setSoundVolume(0);
        radio.decreaseVolume();
        int expected = 0;
        int actual = radio.getSoundVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void decreaseVolumeB() {
        Radio radio = new Radio(0, 9, 0, 100);
        radio.setSoundVolume(1);
        radio.decreaseVolume();
        int expected = 0;
        int actual = radio.getSoundVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void decreaseVolumeC() {
        Radio radio = new Radio(0, 9, 0, 100);
        radio.setSoundVolume(2);
        radio.decreaseVolume();
        int expected = 1;
        int actual = radio.getSoundVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void decreaseVolumeD() {
        Radio radio = new Radio(0, 9, 0, 100);
        radio.setSoundVolume(99);
        radio.decreaseVolume();
        int expected = 98;
        int actual = radio.getSoundVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void decreaseVolumeE() {
        Radio radio = new Radio(0, 9, 0, 100);
        radio.setSoundVolume(100);
        radio.decreaseVolume();
        int expected = 99;
        int actual = radio.getSoundVolume();
        Assertions.assertEquals(expected, actual);
    }

}
