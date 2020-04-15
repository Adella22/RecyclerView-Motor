package com.tugas2.tgs6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

        private RecyclerView motor;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            rvmotor = findViewById(R.id.rv_motor);
            rvmotor.setHasFixedSize(true);
        }
    }
    private void showRecyclerGrid(){
        rvmotor.setLayoutManager(new GridLayoutManager(this, 2));
        grid_Adapter_motor gridHeroAdapter = new grid_Adapter_motor(list);
        rvmotor.setAdapter(grid_Adapter_motor);
    }
    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_list:
                showRecyclerList();
                break;

            case R.id.action_grid:
                showRecyclerGrid();
                break;

            case R.id.action_cardview:

                break;
        }
        private void showSelectedHero(motor motor ) {
            Toast.makeText(this, "Kamu memilih " + motor.getName(), Toast.LENGTH_SHORT).show();
        }
    }