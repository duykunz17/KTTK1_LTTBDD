package com.example.student.tdd_cau1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity { ;
    Button btnDangNhap, btnThoat;
    CheckBox chkLuu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addControls() {
        chkLuu = findViewById(R.id.chkLuu);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        btnThoat = findViewById(R.id.btnThoat);
    }

    private void addEvents() {
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkLuu.isChecked()){
                    Toast.makeText(MainActivity.this, "Chào mừng bạn đăng nhập hệ thống, thông tin của bạn đã được lưu", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Chào mừng bạn đăng nhập hệ thống, thông tin của bạn không được lưu", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog();
            }
        });
    }

    public void showAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn muốn thoát không?");
        builder.setCancelable(false);
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
