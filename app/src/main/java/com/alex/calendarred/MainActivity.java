package com.alex.calendarred;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.alex.calendarred.model.Orders;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    CompactCalendarView compactCalendar;
    TextView monthName;
    SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMM yyy", Locale.getDefault());
    private ImageButton leftScroll, rightScroll;

    private List<Event> dd;
    private List<Orders> orders;

    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        monthName = (TextView) findViewById(R.id.month_name);
        leftScroll = (ImageButton) findViewById(R.id.img_scroll_left);
        rightScroll = (ImageButton) findViewById(R.id.img_scroll_right);
        compactCalendar = (CompactCalendarView) findViewById(R.id.compactcalendar_view);
        compactCalendar.setUseThreeLetterAbbreviation(true);
        //compactCalendar.scrollLeft();

        monthName.setText(dateFormatMonth.format(compactCalendar.getFirstDayOfCurrentMonth()));

        orders = new ArrayList<>();
        orders.add(new Orders("hfgfhhdgfhfgf"));
        orders.add(new Orders("ererer"));
        orders.add(new Orders("5645646"));



        dd = new ArrayList<>();
        dd.add(new Event(Color.RED, 1553250295000L, orders));
        dd.add(new Event(Color.RED, 1552390730000L, "Some extra data that I want to store."));

        compactCalendar.addEvents(dd);


        leftScroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compactCalendar.scrollLeft();
            }
        });

        rightScroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compactCalendar.scrollRight();
            }
        });


        // define a listener to receive callbacks when certain events happen.
        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {

                Context context = getApplicationContext();
                List<Event> events = compactCalendar.getEvents(dateClicked);

                for (int i = 0; i < events.size(); i++) {
                    str = events.get(i).getData().toString();
                    Log.d("TAG", "Day was clicked: " + dateClicked + " with events " + str);
                }

            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                //Log.d("TAG", "Month was scrolled to: " + firstDayOfNewMonth);
                monthName.setText(dateFormatMonth.format(compactCalendar.getFirstDayOfCurrentMonth()));
            }
        });
    }
}
