package com.example.recordtoday.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.recordtoday.model.MainModel;
import com.example.recordtoday.utils.DateFormat;
import com.example.recordtoday.utils.Keys;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ListVM extends ViewModel {
    MainModel<String> calendarTitle = new MainModel<>();
    MainModel<ArrayList<Object>> mCalendarList = new MainModel<>(new ArrayList<>());

    public void initCalendarList() {
        GregorianCalendar cal = new GregorianCalendar(); // 오늘 날짜
        setCalendarList(cal);
    }

    // 캘린더에 넣을 데이터 추가
    public void setCalendarList(GregorianCalendar cal) {
        setTitle(cal.getTimeInMillis());

        ArrayList<Object> calendarList = new ArrayList<>();

        for (int i = -258; i < 258; i++) {
            try {
                GregorianCalendar calendar = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + i, 1, 0, 0, 0);

                int start = calendar.get(Calendar.DAY_OF_WEEK) - 1;
                int end = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

                for (int j = 0; j < start; j++) {
                    calendarList.add(Keys.EMPTY); // 비어 있는 일자 타입
                }

                for (int j = 1; j <= end; j++) {
                    calendarList.add(new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), j)); // 일자 타입
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        mCalendarList.setValue(calendarList);
    }

    public void setTitle(long time) {
        calendarTitle.setValue(DateFormat.getDate(time, DateFormat.HEADER));
    }
}
