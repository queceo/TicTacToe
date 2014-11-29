package nl.qntn.tictacto.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

import java.util.Random;
import java.util.logging.Handler;


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

        if (checkIfLeft()){
            if(clickedButton.getText() != "o") {
               if(clickedButton.getText() != "x") {
                   clickedButton.setText("x");
                   checkIfWin();
                   checkIfLeft();
                   computersTurn();
                   checkIfWinComp();
               }
            }
        }
        if (checkIfLeft() == false){
            Toast.makeText(getApplicationContext(),"Geen plek meer!",Toast.LENGTH_SHORT).show();
        }
        if (checkIfWin()) {
            Toast.makeText(getApplicationContext(), "You won! Baas!", Toast.LENGTH_SHORT).show();
            for (int i = 0; i <9; i++){
                allButtons[i].setEnabled(false);
            }
        }

        if (checkIfWinComp()) {
            Toast.makeText(getApplicationContext(), "You Lose!", Toast.LENGTH_SHORT).show();
            for (int i = 0; i <9; i++){
                allButtons[i].setEnabled(false);
            }
        }

    }

public boolean checkIfLeft(){
    for(int i = 0; i<9 ; i++) {
        if (allButtons[i].getText() == "") {
            return true;
        }
    }
    return false;
}

public boolean checkIfWinComp(){
    int col = -1;
    int row = -1;
    int diag = -1;

    //check de rijen

    for (int j = 0, k = 0; j <3; j++, k+=3) {
        if (allButtons[k].getText() == "o" && allButtons[k+1].getText() == "o" && allButtons[k+2].getText() == "o" )  {
            row = j;
        }
    }

    //check de kolommen

    for (int i = 0; i < 3; i++) {
        for(int k = 0; k<3 ; k++) {
            if (allButtons[k].getText() == "o" && allButtons[k + 3].getText() == "o" && allButtons[k + 6].getText() == "o") {
                col = k;
            }
        }
    }

    //check diagonalen

    if (allButtons[0].getText() == "o" && allButtons[4].getText() == "o" && allButtons[8].getText() == "o") {
        diag = 0;
    } else  if (allButtons[2].getText() == "x" && allButtons[4].getText() == "x" && allButtons[6].getText() == "x") {
        diag = 1;
    }

    //check of computer wint

    if (col != -1 || row != -1 || diag != -1) {
        return true;
    }

    return false;




}

public boolean checkIfWin() {
    int col = -1;
    int row = -1;
    int diag = -1;

    //check de rijen

    for (int j = 0, k = 0; j <3; j++, k+=3) {
            if (allButtons[k].getText() == "x" && allButtons[k+1].getText() == "x" && allButtons[k+2].getText() == "x" )  {
                row = j;
            }
    }

    //check de kolommen

   for (int i = 0; i < 3; i++) {
        for(int k = 0; k<3 ; k++) {
            if (allButtons[k].getText() == "x" && allButtons[k + 3].getText() == "x" && allButtons[k + 6].getText() == "x") {
                col = k;
            }
        }
    }

    //check diagonalen

    if (allButtons[0].getText() == "x" && allButtons[4].getText() == "x" && allButtons[8].getText() == "x") {
        diag = 0;
    } else  if (allButtons[2].getText() == "x" && allButtons[4].getText() == "x" && allButtons[6].getText() == "x") {
        diag = 1;
    }



    //check of speler wint

    if (col != -1 || row != -1 || diag != -1) {
        return true;
    }

    return false;

}





    // Computer gaat iets doen.
    public void computersTurn() {

        boolean computerZet = true;

        if (checkIfLeft()) {
            if(!checkIfWin()) {
                while (computerZet) {
                    Random r = new Random();
                    int randGetal = r.nextInt(9 - 0) + 0;

                    if (allButtons[randGetal].getText() != "x" && allButtons[randGetal].getText() != "o") {
                        allButtons[randGetal].setText("o");
                        computerZet = false;
                    }

                }
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
