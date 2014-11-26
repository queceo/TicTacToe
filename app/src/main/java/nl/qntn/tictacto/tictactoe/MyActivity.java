package nl.qntn.tictacto.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;


public class MyActivity extends Activity {

    Button clickedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

    }

        //button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                clickedButton = (Button) findViewById(v.getId());

                // Perform action on click
                switch (v.getId()) {
                    case R.id.button1:
                        clickedButton.setText("x");
                        break;
                    case R.id.button2:
                        clickedButton.setText("x");
                        break;
                    case R.id.button3:
                        clickedButton.setText("x");
                        break;
                    case R.id.button4:
                        clickedButton.setText("x");
                        break;
                    case R.id.button5:
                        clickedButton.setText("x");
                        break;
                    case R.id.button6:
                        clickedButton.setText("x");
                        break;
                    case R.id.button7:
                        clickedButton.setText("x");
                        break;
                    case R.id.button8:
                        clickedButton.setText("x");
                        break;
                    case R.id.button9:
                        clickedButton.setText("x");
                        break;
                }
            }
        //}

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
