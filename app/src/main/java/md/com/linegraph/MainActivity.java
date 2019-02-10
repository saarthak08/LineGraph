package md.com.linegraph;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;

import md.com.linegraph.fragments.MainGraphFragment;

public class MainActivity extends AppCompatActivity {
    public static double a,b,c,d;
    public static double x,y,ay,bya,byb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.frame_layout,new MainGraphFragment()).commit();
        Button button=findViewById(R.id.button);
        Button button2=findViewById(R.id.button2);
        Button button3=findViewById(R.id.button3);
        Button button4=findViewById(R.id.button4);
        set(1,1,1,0);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialDialog.Builder(MainActivity.this).title("Value of a").input("", ""+a, false, new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                        set((Double.parseDouble(String.valueOf(input))),MainActivity.b,MainActivity.c,MainActivity.d);
                        Toast.makeText(MainActivity.this,""+MainActivity.a,Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new MainGraphFragment()).commit();
                    }
                }).inputRange(1,3).inputType(InputType.TYPE_NUMBER_FLAG_DECIMAL).canceledOnTouchOutside(true).show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialDialog.Builder(MainActivity.this).title("Value of b").input("", ""+b, false, new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                        set(MainActivity.a,(Double.parseDouble(String.valueOf(input))),MainActivity.c,MainActivity.d);
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new MainGraphFragment()).commit();
                    }
                }).inputRange(1,3).inputType(InputType.TYPE_NUMBER_FLAG_DECIMAL).canceledOnTouchOutside(true).show();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialDialog.Builder(MainActivity.this).title("Value of c").input("", ""+c, false, new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                        set(MainActivity.a,MainActivity.b,(Double.parseDouble(String.valueOf(input))),MainActivity.d);
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new MainGraphFragment()).commit();
                    }
                }).inputRange(1,3).inputType(InputType.TYPE_NUMBER_FLAG_DECIMAL).canceledOnTouchOutside(true).show();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialDialog.Builder(MainActivity.this).title("Value of d").input("", ""+d, false, new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                        set(MainActivity.a,MainActivity.b,MainActivity.c,(Double.parseDouble(String.valueOf(input))));
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new MainGraphFragment()).commit();
                    }
                }).inputRange(1,3).inputType(InputType.TYPE_NUMBER_FLAG_DECIMAL).canceledOnTouchOutside(true).show();
            }
        });
    }
    public static void set(double w,double x,double y,double z)
    {
        a=w;
        b=x;
        c=y;
        d=z;
    }

}
