package com.reodinas2.employerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.reodinas2.employerapp.model.Employee;

public class EditActivity extends AppCompatActivity {

    EditText editAge;
    EditText editSalary;
    Button btnSave;
    Employee employee;
    int index;
    public static final int EDIT = 101;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        getSupportActionBar().setTitle("직원 수정");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editAge = findViewById(R.id.editAge);
        editSalary = findViewById(R.id.editSalary);
        btnSave = findViewById(R.id.btnSave);

        employee = (Employee) getIntent().getSerializableExtra("employee");
        index = getIntent().getIntExtra("index", -1);

        editSalary.setText(employee.getSalary()+"");
        editAge.setText(employee.getAge()+"");


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strAge = editAge.getText().toString().trim();
                String strSalary = editSalary.getText().toString().trim();

                if (strAge.isEmpty() || strSalary.isEmpty()){
                    Toast.makeText(EditActivity.this, "필수항목을 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // 숫자로 바꿔서
                // 위에서 받아온 객체에 셋팅해준다!!
                int age = Integer.valueOf(strAge).intValue();
                int salary = Integer.valueOf(strSalary).intValue();

                employee.setAge(age);
                employee.setSalary(salary);

                Intent intent = new Intent();
                intent.putExtra("employee", employee);
                intent.putExtra("index", index);

                setResult(EDIT, intent);

                Toast.makeText(EditActivity.this, "수정이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

}