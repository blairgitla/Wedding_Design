package com.example.android.weddingdesign;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the confirm button is clicked.
     */
    public void submitConfirm(View view) {
        // Find the user's requirement
        String requirement;
        EditText requirement1 = (EditText) findViewById(R.id.requirement_editText_view);
        requirement = requirement1.getText().toString();

        //Figure out if the user wants flower_filled wedding
        CheckBox flower_filled1 = (CheckBox)findViewById(R.id.flower_filled);
        boolean flower_filled = flower_filled1.isChecked();

        //Figure out if the user wants draped_checkerboard wedding
        CheckBox draped_checkerboard1 = (CheckBox)findViewById(R.id.draped_checkerboard);
        boolean draped_checkerboard = draped_checkerboard1.isChecked();

        //Figure out if the user wants all_white wedding
        CheckBox all_white1 = (CheckBox)findViewById(R.id.all_white);
        boolean all_white = all_white1.isChecked();

        //Figure out if the user wants hanging_garden wedding
        CheckBox hanging_garden1 = (CheckBox)findViewById(R.id.hanging_garden);
        boolean hanging_garden = hanging_garden1.isChecked();

        //Figure out if the user wants open_top wedding
        CheckBox open_top1 = (CheckBox)findViewById(R.id.open_top);
        boolean open_top = open_top1.isChecked();

        //Show the user's preference of wedding style
        String weddingStyle = "Your preference of wedding style is: ";
        if(flower_filled)
            weddingStyle += "A Flower-Filled Dance Floor!";
        if(draped_checkerboard)
            weddingStyle += "A Draped Checkerboard Ceiling!";
        if(all_white)
            weddingStyle += "An All-White Hanging Centerpiece!";
        if(hanging_garden)
            weddingStyle += "A Ceremony With a Hanging Garden!";
        if(open_top)
            weddingStyle += "An Open-Top Tent!" ;

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_TEXT,weddingStyle );
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just confirm your requirement of your dream wedding:\n " + requirement);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
}
