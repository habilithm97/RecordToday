package com.example.recordtoday.viewmodel;

import com.example.recordtoday.model.MainModel;

import java.util.Calendar;

public class CalendarViewModel {
    MainModel<Calendar> mCalendar = new MainModel<>();

    public void setCalendar(Calendar calendar) {
        this.mCalendar.setValue(calendar);
    }
}
