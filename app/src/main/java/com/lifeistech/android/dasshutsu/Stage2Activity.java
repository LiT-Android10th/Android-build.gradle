package com.lifeistech.android.dasshutsu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class Stage2Activity extends AppCompatActivity {

    private boolean flag1, flag2, flag3, flag4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage2);

        // 初めに 1 ~ 4 の flag をリセットする ( false を代入する)
        resetFlags();
    }

    public void click1(View v) {
        /*
		 * ON が最初に押されたか判定しているよ！ !flag1 っていうのは flag1 == false って意味！
		 * ちなみに条件に flag1 って書くと flag1 == true って意味になるよ！
		 */
        if (!flag1 && !flag2 && !flag3 && !flag4) {
            Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
            flag1 = true;
        } else {
            Toast.makeText(this, "違うよ！", Toast.LENGTH_SHORT).show();
            resetFlags(); //間違えたらやり直し
        }
    }

    public void click2(View v) {
        // TW が2番目に押されたか判定しているよ！
        if (flag1 && !flag2 && !flag3 && !flag4) {
            Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
            flag2 = true;
        } else {
            Toast.makeText(this, "違うよ！", Toast.LENGTH_SHORT).show();
            resetFlags(); //間違えたらやり直し
        }
    }

    public void click3(View v) {
        // TH が3番目に押されたか判定しているよ！
        if (flag1 && flag2 && !flag3 && !flag4) {
            Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
            flag3 = true;
        } else {
            Toast.makeText(this, "違うよ！", Toast.LENGTH_SHORT).show();
            resetFlags(); //間違えたらやり直し
        }
    }

    public void click4(View v) {
        // FO が4番目に押されたか判定しているよ！
        if (flag1 && flag2 && flag3 && !flag4) {
            flag4 = true;
            Toast.makeText(this, "CLEAR!!!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "違うよ！", Toast.LENGTH_SHORT).show();
            flag1 = flag2 = flag3 = flag4 = false;
        }
    }

    public void clickDoor(View v) {
        if (flag1 && flag2 && flag3 && flag4) {
            // クリア画面に移動する
            Intent intent = new Intent(this,ClearActivity.class);
            startActivity(intent);

        } else {
            Toast.makeText(this, "謎を解け！", Toast.LENGTH_SHORT).show();
        }
    }

    private void resetFlags() {
         /*
		 * flag1 = false;
		 * flag2 = false;
		 * flag3 = false;
		 * flag4 = false;
		 * を、まとめて書いているよ！
		 */
        flag1 = flag2 = flag3 = flag4 = false;
    }
}
