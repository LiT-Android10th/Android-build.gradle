package com.lifeistech.android.dasshutsu;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean hasKey;
    private boolean isOpened;
    private Button buttonKey;
    private Button buttonDoor;

    //アプリが起動した時に呼ばれるメソッド
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //アプリ起動時に鍵を持っていないようにする
        hasKey = false;
        //ドアが閉まっている
        isOpened = false;

        buttonDoor = (Button) findViewById(R.id.buttonDoor);
        buttonKey = findViewById(R.id.buttonKey);
        //()内はどっちでもいいよ
        //ID(名前)を使って、buttonKeyとbuttonDoorの変数にレイアウトファイルのボタンを関連づけている


    }

    public void clickKey(View v) {
        //Toastを表示
        Toast.makeText(this, "鍵を手に入れたよ！", Toast.LENGTH_SHORT).show();
        //鍵を手に入れたので、hasKeyにtrueを代入する
        hasKey = true;
        //鍵を見えなくする
        buttonKey.setVisibility(View.INVISIBLE);

    }

    public void clickDoor(View v) {
        if (isOpened) { //ドアが開いている
            //画面の移動(インテント)
            Intent intent = new Intent(this, Stage2Activity.class);
            startActivity(intent);
        } else {//ドアが閉まっている

            if (hasKey){ //鍵がある
                //ドアを開ける
                buttonDoor.setBackgroundResource(R.drawable.door2);
                isOpened =true;
                //トーストを表示
                Toast.makeText(this, "ドアが開いたよ！", Toast.LENGTH_SHORT).show();

            } else { //鍵がない
                Toast.makeText(this, "鍵がないよ！", Toast.LENGTH_SHORT).show();


            }

        }


    }

}