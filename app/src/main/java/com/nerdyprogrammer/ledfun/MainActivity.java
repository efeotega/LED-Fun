package com.nerdyprogrammer.ledfun;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.imageview.ShapeableImageView;


public class MainActivity extends AppCompatActivity {
    private ShapeableImageView lightBulb;
    private int currentColorIndex = 0;
    // Defining an array of colors to cycle through
    private int[] colors = {Color.RED, Color.GREEN, Color.YELLOW, Color.BLUE, Color.CYAN,Color.GRAY,Color.WHITE,Color.MAGENTA};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lightBulb = findViewById(R.id.lightBulb);
        ImageView button = findViewById(R.id.button);
        //setting the initial color
        lightBulb.setBackgroundColor(colors[currentColorIndex]);
        button.setOnClickListener(v -> {
            // Change the light bulb color when the button is tapped
            changeLightBulbColor();
        });
    }

    private void changeLightBulbColor() {
        // Check if we've reached the end of the colors array and reset
        if(currentColorIndex==colors.length-1){
            currentColorIndex=-1;
        }
        // Increment the current color index
        currentColorIndex++;
        // Set the light bulb's color to the next color in the array
        lightBulb.setBackgroundColor(colors[currentColorIndex]);
    }
}