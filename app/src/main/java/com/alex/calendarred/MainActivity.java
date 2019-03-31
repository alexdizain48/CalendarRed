package com.alex.calendarred;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.alex.calendarred.adapters.MyEventAdapter;
import com.alex.calendarred.model.DateEvent;
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
    TextView monthName, yearName;
    SimpleDateFormat dateFormatYear = new SimpleDateFormat("yyyy", Locale.getDefault());
    SimpleDateFormat dateFormatMonth = new SimpleDateFormat("LLLL", Locale.getDefault());

    private ImageButton leftScroll, rightScroll;

    private List<Event> event;
    private List<Orders> orders;
    private List<Orders> orders1;
    private List<DateEvent> dateEvent;
    private DateEvent de;

    private RecyclerView mRecyclerView;
    private MyEventAdapter adapter;

    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        yearName = (TextView) findViewById(R.id.year_name);
        monthName = (TextView) findViewById(R.id.month_name);
        leftScroll = (ImageButton) findViewById(R.id.img_scroll_left);
        rightScroll = (ImageButton) findViewById(R.id.img_scroll_right);
        compactCalendar = (CompactCalendarView) findViewById(R.id.compactcalendar_view);
        compactCalendar.setUseThreeLetterAbbreviation(true);

        yearName.setText(dateFormatYear.format(compactCalendar.getFirstDayOfCurrentMonth()));
        monthName.setText(dateFormatMonth.format(compactCalendar.getFirstDayOfCurrentMonth()));

        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_orders);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        //compactCalendar.getEventsForMonth(1553250295000L);

        addOrders();
        addListEvents();
        addEventsInCalendar();

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

        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                Context context = getApplicationContext();
                List<Event> events = compactCalendar.getEvents(dateClicked);

                Log.d("TAG", "Day was clicked: " + dateClicked + " with events " + events);

                if (events.size() > 0) {
                    adapter = new MyEventAdapter(orders, context);
                    mRecyclerView.setAdapter(adapter);
                } else {
                    mRecyclerView.setAdapter(null);
                    Toast.makeText(context, "No", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                yearName.setText(dateFormatYear.format(compactCalendar.getFirstDayOfCurrentMonth()));
                monthName.setText(dateFormatMonth.format(compactCalendar.getFirstDayOfCurrentMonth()));
            }
        });
    }

    private void addListEvents() {
       //de = new DateEvent(1553250295000L, orders);
    }

    private void addOrders() {
        orders = new ArrayList<>();
        orders.add(new Orders("Криолиполиз", "10:20", "Светлана Орлова"));
        orders.add(new Orders("Чистка лица", "12:40", "Светлана Орлова"));
        orders.add(new Orders("Биожени", "13:00", "Светлана Орлова"));

        orders1 = new ArrayList<>();
        orders1.add(new Orders("Айкун-лазер", "12:20", "Светлана Орлова"));
        orders1.add(new Orders("Покраска", "14:40", "Светлана Орлова"));
        orders1.add(new Orders("Стрижка", "17:00", "Светлана Орлова"));
        orders1.add(new Orders("Консультация", "17:30", "Светлана Орлова"));

    }

    private void addEventsInCalendar() {
        event = new ArrayList<>();
        event.add(new Event(Color.RED, 1553250295000L, orders));
        event.add(new Event(Color.RED, 1552390730000L, orders1));
        compactCalendar.addEvents(event);
    }


}
