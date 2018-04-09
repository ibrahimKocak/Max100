package com.example.ibrah.max100;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends Activity {

    TextView textView;
    Button btn_again;

    ButtonList bList;
    ArrayList<Integer> clickableList;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        btn_again = findViewById(R.id.btn_again);

        bList = new ButtonList(this);
        clickableList = new ArrayList<>();
        game();
    }

    public void game()
    {
        for(i=0;i<bList.b.size();i++)
        {
            bList.setClickable(i);
            bList.b.get(i).getButton().setText("  ");
        }
        btn_again.setEnabled(false);

        score = 0;
        textView.setText(String.valueOf(score));
    }

    int score;
    public void button_onClick(View view) {

        if(bList.b.get(bList.indexOf((Button) view)).getStatus() == 1)
        {
            score++;

            ((Button) view).setText(String.valueOf(score));
            textView.setText(String.valueOf(score));

            for(i=0;i<clickableList.size();i++)
                bList.setUnclickable(clickableList.get(i));

            clickableList.clear();

            if(score == 1)
                firstClick();

            bList.setClicked(bList.indexOf((Button) view));

            clickable(bList.indexOf((Button) view));
        }

        if(clickableList.size() == 0)
            btn_again.setEnabled(true);
    }

    public void again_onClick(View view) {
        game();
    }
    public void firstClick()
    {
        for(i=0;i<bList.b.size();i++)
            bList.setUnclickable(i);
    }


    private void clickable(int index) {

        if(index >= 30 && bList.b.get(index-30).getStatus() != 2)  clickableList.add(index-30);
        if(index%10 <= 6 && bList.b.get(index+3).getStatus() != 2)    clickableList.add(index+3);
        if(index < 70 && bList.b.get(index+30).getStatus() != 2)   clickableList.add(index+30);
        if(index%10 >= 3 && bList.b.get(index-3).getStatus() != 2)    clickableList.add(index-3);

        if(index%10 <= 7)
        {
            if(index >= 20 && bList.b.get(index-18).getStatus() != 2)
                clickableList.add(index-18);
            if(index < 80 && bList.b.get(index+22).getStatus() != 2)
                clickableList.add(index+22);
        }
        if(index%10 >= 2)
        {
            if(index < 80 && bList.b.get(index+18).getStatus() != 2)
                clickableList.add(index+18);
            if(index >= 20 && bList.b.get(index-22).getStatus() != 2)
                clickableList.add(index-22);
        }

        for(i=0;i<clickableList.size();i++)
            bList.setClickable(clickableList.get(i));

    }
}
