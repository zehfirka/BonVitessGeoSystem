package ua.pack.bonvitess;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class aboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
    }

    //декілька обробників натискання на інформаційні картки

    public void onFirstViewCLick(View view) {
        Intent firstView = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/klymenko_ruslana_?igshid=YmMyMTA2M2Y="));
        startActivity(firstView);
    }
    public void onSecondViewClick(View view) {
        Intent secondView = new Intent(Intent.ACTION_VIEW,Uri.parse("https://instagram.com/b0nnechane?igshid=YmMyMTA2M2Y="));
        startActivity(secondView);
    }
    public void onThirdViewClick(View view) {
        Intent thirdView = new Intent(Intent.ACTION_VIEW,Uri.parse("https://instagram.com/zehfirka?igshid=YmMyMTA2M2Y="));
        startActivity(thirdView);
    }
    public void onFourthViewClick(View view) {
        Intent fourthView = new Intent(Intent.ACTION_VIEW,Uri.parse("https://instagram.com/_.roman.roman._?igshid=YmMyMTA2M2Y="));
        startActivity(fourthView);
    }
    public void onFifthViewClick(View view) {
        Intent fifthView = new Intent(Intent.ACTION_VIEW,Uri.parse("https://instagram.com/pnmrnkko?igshid=YmMyMTA2M2Y="));
        startActivity(fifthView);
    }
}