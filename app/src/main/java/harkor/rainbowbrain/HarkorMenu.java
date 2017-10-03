package harkor.rainbowbrain;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static harkor.rainbowbrain.R.id.bgraj;

public class HarkorMenu extends AppCompatActivity {
///////////////////////////////////////////////////////////// WERSION 1.1 Beta 22-08-2017
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harkor_menu);

    }


    public void dajgre(View view) {
        Intent intent = new Intent(this, HarkorGame.class);
        startActivity(intent);
    }
    public void wyjdz (View view){
        finish();
        System.exit(0);
    }
    public void bestscore (View view){
        SharedPreferences sharedPref2;
        //SharedPreferences.Editor editor;
        sharedPref2=getSharedPreferences("harkor.rainbowbrain", Context.MODE_PRIVATE);
        //editor=sharedPref2.edit();
        //Context context=getContext();
        //editor.putString("adin",adin);
        int wow=sharedPref2.getInt("score",0);
        //String toast="Best score: "+wow;
        Toast.makeText(HarkorMenu.this,"Best score: "+wow,Toast.LENGTH_SHORT).show();
    }
}
