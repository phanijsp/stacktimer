package org.deltaverse.stacktimer.beans;

import android.graphics.Color;

import java.io.Serializable;

public class CardObject implements Serializable {

    private String cardTitle;
    private String cardCaption;
    private String cardAddedDate;
    private String cardEndDate;
    private int cardColor;

    public CardObject(String cardTitle, String cardCaption, String cardAddedDate, String cardEndDate, int cardColor) {
        this.cardTitle = cardTitle;
        this.cardCaption = cardCaption;
        this.cardAddedDate = cardAddedDate;
        this.cardEndDate = cardEndDate;
        this.cardColor = cardColor;
    }

    public int getCardColor() {
        return cardColor;
    }

    public String getCardTitle() {
        return cardTitle;
    }

    public void setCardTitle(String cardTitle) {
        this.cardTitle = cardTitle;
    }

    public String getCardCaption() {
        return cardCaption;
    }

    public void setCardCaption(String cardCaption) {
        this.cardCaption = cardCaption;
    }

    public String getCardAddedDate() {
        return cardAddedDate;
    }

    public void setCardAddedDate(String cardAddedDate) {
        this.cardAddedDate = cardAddedDate;
    }

    public String getCardEndDate() {
        return cardEndDate;
    }

    public void setCardEndDate(String cardEndDate) {
        this.cardEndDate = cardEndDate;
    }
}
