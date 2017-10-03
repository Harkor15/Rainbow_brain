package harkor.rainbowbrain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class language extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
    }

    public void wyjdz (View view){
        finish();
        System.exit(0);
    }

    public void pl(View view){
        //code
    }
    public void eng(View view){
        //code
    }


}
