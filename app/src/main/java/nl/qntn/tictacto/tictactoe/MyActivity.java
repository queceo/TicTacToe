package nl.qntn.tictacto.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

import java.util.Random;


public class MyActivity extends Activity {

    Button clickedButton;
    Button[] allButtons = new Button[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        final Button button1 = (Button) findViewById(R.id.button1);
        final Button button2 = (Button) findViewById(R.id.button2);
        final Button button3 = (Button) findViewById(R.id.button3);
        final Button button4 = (Button) findViewById(R.id.button4);
        final Button button5 = (Button) findViewById(R.id.button5);
        final Button button6 = (Button) findViewById(R.id.button6);
        final Button button7 = (Button) findViewById(R.id.button7);
        final Button button8 = (Button) findViewById(R.id.button8);
        final Button button9 = (Button) findViewById(R.id.button9);

        allButtons[0] = button1;
        allButtons[1] = button2;
        allButtons[2] = button3;
        allButtons[3] = button4;
        allButtons[4] = button5;
        allButtons[5] = button6;
        allButtons[6] = button7;
        allButtons[7] = button8;
        allButtons[8] = button9;

    }

    //button.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {

        clickedButton = (Button) findViewById(v.getId());

        clickedButton.setText("x");

        if (checkIfWin()) {
            Toast.makeText(getApplicationContext(),"You won! Baas!",Toast.LENGTH_LONG).show();
        } else {
            computersTurn();
        }

    }

public boolean checkIfWin() {

    // links recht check
    if (allButtons[0].getText() == "x" && allButtons[1].getText() == "x" && allButtons[2].getText() == "x" )  {
        return true;
    }
    return false;

}





    // Computer gaat iets doen.
    public void computersTurn() {

        boolean computerZet = true;

        while(computerZet) {
            Random r = new Random();
            int randGetal = r.nextInt(9- 0) + 0;

            if (allButtons[randGetal].getText() != "x" && allButtons[randGetal].getText() != "o") {
                allButtons[randGetal].setText("o");
                computerZet = false;
            }
        }
    }

    // tijdelijk oplossing later natuurlijk beter...
    public void onClickReset(View v){
        finish();
        startActivity(getIntent());

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
