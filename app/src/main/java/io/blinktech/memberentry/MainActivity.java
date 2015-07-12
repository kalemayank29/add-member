package io.blinktech.memberentry;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Spinner marriageSpinner, familySpinner, educationSpinner, literacySpinner;

    private int mYear, wYear;
    private int mMonth, wMonth;
    private int mDay, wDay;
    static final String TAG = "LOG";

    private TextView mDateDisplay, weddingArrDisplay;
    private Button mPickDate, wPickDate;

    static final int DATE_DIALOG_ID = 0;
    static final int WDATE_DIALOG_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        marriageSpinner = (Spinner) findViewById(R.id.spin_marriage);
        ArrayAdapter marriageAdapter = ArrayAdapter.createFromResource(this,R.array.marriage_array,android.R.layout.simple_spinner_dropdown_item);
        marriageSpinner.setAdapter(marriageAdapter);

        familySpinner = (Spinner) findViewById(R.id.spin_family_plan);
        ArrayAdapter familyAdapter = ArrayAdapter.createFromResource(this,R.array.family_array,android.R.layout.simple_spinner_dropdown_item);
        familySpinner.setAdapter(familyAdapter);

        educationSpinner = (Spinner) findViewById(R.id.spin_education);
        ArrayAdapter educationAdapter = ArrayAdapter.createFromResource(this,R.array.education_array,android.R.layout.simple_spinner_dropdown_item);
        educationSpinner.setAdapter(educationAdapter);

        literacySpinner = (Spinner) findViewById(R.id.spin_literacy);
        ArrayAdapter literacyAdapter = ArrayAdapter.createFromResource(this,R.array.literacy_array,android.R.layout.simple_spinner_dropdown_item);
        literacySpinner.setAdapter(literacyAdapter);

        //********DATE PICKER***********//
        mDateDisplay = (TextView) findViewById(R.id.showMyDate);
        mPickDate = (Button) findViewById(R.id.myDatePickerButton);

        weddingArrDisplay = (TextView) findViewById(R.id.wedding_arr_date);
        wPickDate = (Button) findViewById(R.id.wedding_arr_date_button);

        mPickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DATE_DIALOG_ID);
            }
        });

        wPickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(WDATE_DIALOG_ID);
            }
        });

        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        final Calendar wc = Calendar.getInstance();
        wYear = wc.get(Calendar.YEAR);
        wMonth = wc.get(Calendar.MONTH);
        wDay = wc.get(Calendar.DAY_OF_MONTH);

        updateDisplay(DATE_DIALOG_ID);
        updateDisplay(WDATE_DIALOG_ID);

//        Log.e("Mayank", "kale");
        Log.println(Log.ASSERT, TAG, "This is better");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void updateDisplay(int id){
        switch(id){
            case DATE_DIALOG_ID:
                this.mDateDisplay.setText(
                        new StringBuilder()
                                // Month is 0 based so add 1
                                .append(mMonth + 1).append("-")
                                .append(mDay).append("-")
                                .append(mYear).append(" "));
                break;
            case WDATE_DIALOG_ID:
                this.weddingArrDisplay.setText(
                        new StringBuilder()
                                // Month is 0 based so add 1
                                .append(wMonth + 1).append("-")
                                .append(wDay).append("-")
                                .append(wYear).append(" "));


        }


    }


    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                    mYear = year;
                    mMonth = monthOfYear;
                    mDay = dayOfMonth;
                    updateDisplay(DATE_DIALOG_ID);
                }
            };

    private DatePickerDialog.OnDateSetListener wDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                    wYear = year;
                    wMonth = monthOfYear;
                    wDay = dayOfMonth;
                    updateDisplay(WDATE_DIALOG_ID);
                }
            };

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this,
                        mDateSetListener,
                        mYear, mMonth, mDay);
            case WDATE_DIALOG_ID:
                return new DatePickerDialog(this,
                        wDateSetListener,
                        wYear, wMonth, wDay);
        }
        return null;
    }

}
