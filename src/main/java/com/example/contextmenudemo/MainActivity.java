package com.example.contextmenudemo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    LinearLayout main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main = findViewById(R.id.main);
        textView = findViewById(R.id.textView);
        registerForContextMenu(textView); // Register context menu on TextView long press
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.contextmenu_list, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Red:
                main.setBackgroundColor(Color.RED);
                Toast.makeText(getApplicationContext(), "Red", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.Blue:
                main.setBackgroundColor(Color.BLUE);
                textView.setBackgroundColor(Color.YELLOW);
                Toast.makeText(getApplicationContext(), "Blue", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.Yellow:
                main.setBackgroundColor(Color.YELLOW);
                Toast.makeText(getApplicationContext(), "Yellow", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }
}