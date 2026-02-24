package com.marwadi.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private final String[] Names = {
            "Aarav", "Dhruv", "Vihaan", "Parth", "Ishaan",
            "Harsh", "Yash", "Rohan", "Dev", "Kiaan",
            "Jayesh", "Rahul", "Kartik", "Ved", "Manan",
            "Gaurav", "Hardik", "Hitesh", "Govind", "Keshav"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        NamesAdapter adapter = new NamesAdapter(Names);
        recyclerView.setAdapter(adapter);
    }

    // Inline Adapter class
    private static class NamesAdapter extends RecyclerView.Adapter<NamesAdapter.ViewHolder> {
        private final String[] names;

        NamesAdapter(String[] names) {
            this.names = names;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(android.R.layout.simple_list_item_1, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.textView.setText(names[position]);
            holder.textView.setPadding(32, 32, 32, 32);
            holder.textView.setTextSize(20);
            holder.textView.setTextColor(0xFF2E7D32);  // Green color
        }

        @Override
        public int getItemCount() {
            return names.length;
        }

        static class ViewHolder extends RecyclerView.ViewHolder {
            TextView textView;

            ViewHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView.findViewById(android.R.id.text1);
            }
        }
    }
}
